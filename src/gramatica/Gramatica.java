package gramatica;

import estructura.*;
import clases.Arreglos;
import java.util.ArrayList;
import semantico.Analiza;
//@author leo

public class Gramatica
{

    public static String tablaMadre[][][] = new String[1][][];
    public static int banderaTabla = 0;
    public static ArrayList tablaTablas = new ArrayList();
    //public static ArrayList tablaTablas = new ArrayList();
    public static ArrayList tablaErrores = new ArrayList();
    public static ArrayList tablaClases = new ArrayList();
    public static ArrayList tablaMetodos = new ArrayList();
    public static ArrayList tablaTablasResultado = new ArrayList();
    public static String resultadoString = "";

    public static void limpia()
    {

        tablaMadre = new String[1][][];
        banderaTabla = 0;
        tablaTablas = null;
        //public static ArrayList tablaTablas = new ArrayList();
        tablaErrores = null;
        tablaClases = null;
        tablaMetodos = null;
        tablaTablasResultado = null;
        resultadoString = "";

    }

    public static String[][][] gra(String[][] matriz, String[][] gramatica, String[] programa, String[] valores)
    {
        limpia();
        resultadoString = "";
        tablaTablas = new ArrayList();
        banderaTabla = 0;
        tablaErrores = new ArrayList();
        tablaClases = new ArrayList();
        tablaMetodos = new ArrayList();
        tablaTablasResultado = new ArrayList();

        Cola c = new Cola(programa.length + 1);
        Cola cValor = new Cola(valores.length + 1);

        Pila p = new Pila(1000);
        String[] resultado = null;
        String[] resultado1 = null;
        String[] reValores = null;
        String[] reSemantico = null;
        String sSemantico = "";

        String sSemantico1[] = null;
        String sSemanticoTokens[] = null;

        String rrr = "";
        int nG1[] = null;

        int banderaSemantica = 0;
        int banderaSemantica1 = 0;

        String s = junta(programa);
        String pi = "1";
        int nM = 1;
        int nG = 1;

        p.inserta(1);
        for (int i = 0; i < programa.length; i++)
        {

            c.inserta(programa[i]);
            cValor.inserta(valores[i]);

        }

        resultado = Arreglos.inserta(resultado, cola(c));
        resultado1 = Arreglos.inserta(resultado1, nM + "");
        reValores = Arreglos.inserta(reValores, cola(cValor));

        String token = (String) (c.getenfre() + "");

        do
        {
            if (!comp(token))
            {
                pi = (String) (p.eliminar() + "");
                try
                {

                    nM = Integer.parseInt(pi);
                    nG1 = analiza(matriz, token, nM, banderaSemantica);
                    nG = nG1[0];
                    banderaSemantica = nG1[1];
                    if (nG != -1)
                    {
                        p = insertaPila(p, gramatica[nG]);
                        resultado = Arreglos.inserta(resultado, cola(c));
                        resultado1 = Arreglos.inserta(resultado1, pila(p));

                        reValores = Arreglos.inserta(reValores, cola(cValor));

                    } else
                    {
                        resultado = Arreglos.inserta(resultado, cola(c));
                        resultado1 = Arreglos.inserta(resultado1, pila(p));

                        reValores = Arreglos.inserta(reValores, cola(cValor));

                        if (nG != -1)
                        {
                            resultado = Arreglos.inserta(resultado, "Error");
                            resultado1 = Arreglos.inserta(resultado1, "Error Se esperaba " + nG);
                            break;
                        }

                    }

                } catch (Exception e)
                {

                    if (pi.equals(token))
                    {
                        String auxSeToken = (String) c.eliminar();
                        String auxSe = (String) cValor.eliminar() + " ";
                        if (token.equals("T7"))
                        {
                            banderaSemantica = 0;
                        }
                        if (banderaSemantica == 1 || token.equals("T50"))
                        {

                            sSemantico += auxSe;
                            sSemantico1 = Arreglos.inserta(sSemantico1, auxSe);
                            sSemanticoTokens = Arreglos.inserta(sSemanticoTokens, auxSeToken);

                        }

                        if (c.getenfre() != null)
                        {
                            token = (String) (c.getenfre() + "");
                        }

                        resultado = Arreglos.inserta(resultado, cola(c));
                        resultado1 = Arreglos.inserta(resultado1, pila(p));

                    } else
                    {
                        if (pi.equals("null"))
                        {

                            p.eliminar();
                            token = (String) (c.getenfre() + "");

                        } else
                        {

                            if (p.getTope() != 0)
                            {
                                p.eliminar();
                                resultado = Arreglos.inserta(resultado, "Error No se esperaba " + token);
                                resultado1 = Arreglos.inserta(resultado1, "Lo que se esperaba es un " + pi);
                                break;
                            }
                        }

                    }

                }

            } else
            {
                // p.inserta(pi);
                c.eliminar();
                cValor.eliminar();
                token = (String) (c.getenfre() + "");
                resultado = Arreglos.inserta(resultado, cola(c));
                resultado1 = Arreglos.inserta(resultado1, pila(p));
                reValores = Arreglos.inserta(reValores, cola(cValor));

            }
            if (c.getA() == -1)
            {
                pi = (String) (p.eliminar() + "");
                break;

            }
            if (banderaSemantica == 0 && !sSemantico.equals(""))
            {
                reSemantico = Arreglos.inserta(reSemantico, sSemantico);

                ArrayList anSemantico = Analiza.analizador(sSemantico, sSemantico1, sSemanticoTokens, tablaErrores, tablaTablas, tablaTablasResultado);

                sSemantico = "";
                banderaSemantica = 0;
                sSemantico1 = null;
                sSemanticoTokens = null;

            }

        } while (p.getTope() != -1);
        if (p.getTope() == -1 && c.getA() == -1)
        {
            resultado = Arreglos.inserta(resultado, "Correcto");
            resultado1 = Arreglos.inserta(resultado1, "Correcto");
        } else
        {

            String a = pi;
            if (c.getA() == -1)
            {
                if (a.equals("1" + "") || a.equals("2" + "") || a.equals("3" + ""))
                {
                    resultado = Arreglos.inserta(resultado, "Correcto");
                    resultado1 = Arreglos.inserta(resultado1, "Correcto");

                } else
                {
                    resultado = Arreglos.inserta(resultado, "Error");
                    resultado1 = Arreglos.inserta(resultado1, "Error");

                }
            } else
            {

                resultado = Arreglos.inserta(resultado, "Error");
                resultado1 = Arreglos.inserta(resultado1, "Error");

            }
        }
        String mR[][][] = new String[5][][];

        String matR[][] = arregla(resultado1, resultado);

        mR[0] = matR;
        mR[1] = arregla(reValores, reValores);
        mR[2] = arregla(reSemantico, reSemantico);
        System.out.println("Tabla de tablas");

        String rr = semantico.Mostrar.imprimeEnString(tablaTablas);
        System.out.println(rr);
        System.out.println("*******************");
        System.out.println("Tabla de Errores");

        rr = semantico.Mostrar.imprimeEnStringError(tablaErrores);
        resultadoString += "\n" + "Tabla de errores" + "\n" + rr;

        System.out.println(rr);
        System.out.println("*************");
        System.out.println("Tabla de clases");

        rr = semantico.Mostrar.imprimeEnStringError(tablaClases);
        resultadoString += "\n" + "Tabla de clases" + "\n" + rr;

        System.out.println(rr);
        System.out.println("*********************");
        System.out.println("Tabla de Metodos");

        rr = semantico.Mostrar.imprimeEnStringError(tablaMetodos);
        resultadoString += "\n" + "Tabla de Metodos" + "\n" + rr;

        System.out.println(rr);
        System.out.println("*********************");
        System.out.println("Tabla de Resultados");

        rr = semantico.Mostrar.imprimeEnStringR(tablaTablasResultado);
        System.out.println(rr);
        resultadoString += "\n" + "Tabla de Resultados" + "\n" + rr;

//        mR[3] = tablaVariables;
        //       mR[4] = tablaErrores;
        return mR;

    }

    public static String junta(String[] a)
    {
        String cadena = "";

        for (int i = 0; i < a.length; i++)
        {
            cadena += a[i];

        }
        return cadena;
    }

    public static int[] analiza(String ve[][], String c, int nM, int bandera)
    {
        int nG1[] = new int[2];
        nG1[1] = bandera;
        for (int i = 0; i < ve[0].length; i++)
        {

            if (c.equals(ve[0][i]))
            {
                try
                {
                    int nG = Integer.parseInt(ve[nM][i]);
                    nG1[0] = nG;
                    nG1[1] = 0;

                    return nG1;
                } catch (Exception e)
                {
                    String semantico = ve[nM][i];

                    if ((semantico.substring(0, 2)).equals("xx"))
                    {
                        System.out.println("Algo" + semantico);
                        if (semantico.trim().length() == 3)
                        {
                            nG1[0] = (Integer.parseInt(semantico.substring(2, 3)));
                            nG1[1] = 1;
                            return nG1;
                        } else
                        {

                            nG1[0] = (Integer.parseInt(semantico.substring(2, 4)));
                            nG1[1] = 1;
                            return nG1;
                        }

                    } else
                    {

                        if ((semantico.substring(0, 2)).equals("yy"))
                        {

                            System.out.println("Algo" + semantico);
                            if (semantico.trim().length() == 3)
                            {
                                nG1[0] = (Integer.parseInt(semantico.substring(2, 3)));
                                nG1[1] = 1;

                                Gramatica.tablaTablasResultado.add(Gramatica.tablaTablas.remove(Gramatica.tablaTablas.size() - 1));
                                return nG1;
                            } else
                            {

                                nG1[0] = (Integer.parseInt(semantico.substring(2, 4)));
                                nG1[1] = 1;
                                Gramatica.tablaTablasResultado.add(Gramatica.tablaTablas.remove(Gramatica.tablaTablas.size() - 1));

                                return nG1;
                            }
                        }
                    }

                }
            }

        }
        nG1[0] = -1;
        nG1[1] = 0;

        return nG1;
    }

    public static Pila insertaPila(Pila p, String[] m)
    {
        m = voltea(m);
        if (m != null)
        {
            for (int i = 0; i < m.length; i++)
            {
                if (m[i].length() != 0)
                {
                    p.inserta(m[i]);

                }

            }
        }

        return p;
    }

    public static String[] voltea(String m[])
    {
        String m1[] = null;
        if (!m[0].equals("null"))
        {
            if (m != null)
            {
                m1 = new String[m.length];
                int j = 0;
                for (int i = m.length - 1; i >= 0; i--)
                {
                    m1[j] = m[i];

                    j++;

                }

            }
        }

        return m1;
    }

    public static boolean comp(String token)
    {

        if (token.equals("T32"))
        {

            return true;

        } else
        {

            return false;
        }
    }

    public static String pila(Pila p)
    {
        if (p != null)
        {
            String pil = "";
            Object[] arp = p.getP();
            for (int i = 0; i < p.getTope() + 1; i++)
            {

                pil += arp[i] + " ";

            }

            return pil;

        }

        return null;

    }

    public static String cola(Cola c)
    {
        if (c != null)
        {
            String col = "";
            Object[] arC = c.getC();
            for (int i = 0; i < c.getA() + 1; i++)
            {
                col += arC[i] + " ";
            }

            return col;

        }

        return null;

    }

    public static String[][] arregla(String[] r1, String[] r2)
    {

        if (r1 != null && r2 != null)
        {
            String[][] m = new String[r1.length][2];

            for (int i = 0; i < m.length; i++)
            {
                m[i][0] = r1[i];
                m[i][1] = r2[i];
            }
            return m;

        }

        return null;
    }

}

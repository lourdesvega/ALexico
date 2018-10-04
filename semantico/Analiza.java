package semantico;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author leo
 */
public class Analiza
{
    static String[][] etiquetas = new String[5][5]; 
    static int numEtiqueta = 0;
    
    public static String[][][] analizador(String[][] tablaVarianles, String sSemantica, String[] sSemantica11, String[] sSemantica1Tokens, String[][] tablaErrores)
    {
        String junto[][] = new String[2][];
        junto[0] = sSemantica11;
        junto[1] = sSemantica1Tokens;

        if (compara(sSemantica1Tokens[0]))
        {
            String tipo = sSemantica11[0];
            String ve[] = new String[sSemantica11.length + 1];
            junto[1][0] = "";
            junto[0][0] = "";

            String vector1[] = creaVector(junto[0][1], tipo, "");
            vector1[4] = TablaS.tablaSimbolosDeclara(tablaVarianles, vector1,tablaErrores);
            tablaVarianles = creaTabla(tablaVarianles, vector1);
            Object pilas[] = analizaPos(junto[0], junto[1]);
            if (pilas != null)
            {
                System.out.println(((Stack<String>) pilas[0]).size());
                String tab[][][] = analizaPila(tablaVarianles, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                tablaVarianles = tab[0];
                tablaErrores = tab[1];
            }
           
        } else
        {
            String sent;
            switch (sSemantica1Tokens[0].trim())
            {
                case "T50":
                    Object pilas[] = analizaPos(junto[0], junto[1]);
                    if (pilas != null)
                    {
                        String tab[][][] = analizaPila(tablaVarianles, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                        tablaVarianles = tab[0];
                        tablaErrores = tab[1];
                    }
                    break;
                case "T12":
                    // Código Intermedio.
                    codigoIntermedioSent("T12",etiquetas,numEtiqueta);
                    
                    sent = eliminaSent(sSemantica.replace(" ",""), "Si");
                    System.out.println("Expresión resultante: " + sent);
                    break;
                case "T14":
                    sent = eliminaSent(sSemantica.replace(" ",""), "Para");
                    String res[] = separaExpDeSent(sent);
                    System.out.println("Expresión resultante: ");
                    for (int i = 0; i < res.length; i++) {
                        System.out.println(i+1 + ": " + res[i]);
                    }
                    break;
                case "Mientras":
                    sent = eliminaSent(sSemantica.replace(" ",""), "Mientras");
                    System.out.println("Expresión resultante: " + sent);
                    break;
                case "Sino":
                    break;
                case "Entra":
                    sent = eliminaSent(sSemantica.replace(" ",""), "Entra");
                    System.out.println("Expresión resultante: " + sent);
                    break;
            }
            System.out.println("No entra 2");

        }
        // tablaVarianles = creaTabla(tablaVarianles, sSemantica11);
        String[][][] tabladetablas = new String[3][][];
        tabladetablas[0] = tablaVarianles;
        tabladetablas[1] = tablaErrores;

        return tabladetablas;
    }
    
    public static String[] creaVector(String nuevo, String tipo, String error)
    {
        String tipo1 = "";
        switch (tipo.trim())
        {
            case "Entero":
                tipo1 = "T51";
                break;
            case "Flotante":
                tipo1 = "T52";
                break;

            case "Char":
                break;

        }

        String vector[] =
        {
            nuevo, tipo1, null, "0", error
        };

        return vector;
    }

    public static String[][] creaTabla(String[][] matriz, String[] nuevo)
    {
        if (nuevo != null)
        {
            if (matriz == null)
            {

                String nuevaM[][] = new String[1][];
                nuevaM[0] = nuevo;

                return nuevaM;
            } else
            {
                String nuevaM[][] = new String[matriz.length + 1][];
                for (int i = 0; i < matriz.length; i++)
                {
                    nuevaM[i] = matriz[i];

                }
                nuevaM[matriz.length] = nuevo;

                return nuevaM;

            }
        }
        return matriz;
    }

    public static boolean compara(String a)
    {

        if (a.equals("T1"))
        {

            return true;
        }

        return false;

    }

    public static String[] creaS(String[] a, String[] b)
    {
        String su[] = new String[a.length + 2];
        su[0] = "(";
        su[a.length + 1] = ")";

        String s = "";
        String s2 = "";

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != null)
            {
                su[i + 1] = a[i].trim();
            }
        }

        return su;
    }

    public static Object[] analizaPos(String[] a, String[] b)
    {
        String[] su = creaS(a, b);
        String[] s1 = creaS(b, a);
        Object[] re = new Object[2];

//       System.out.println(s);
        //String p[]=s.split(" ");
        Object r[] = ExpresionAlgebraica_1.posL(su, s1);
        if (r != null)
        {
            Stack< String> st = (Stack< String>) r[0];
            Stack< String> st1 = (Stack< String>) r[1];

            re[0] = st;
            re[1] = st1;
        }
        //ast.add(s)
        System.out.println("hgfghjk");
        //String pila[]=TablaS.separador(s);

        return re;
    }

    public static String[][][] analizaPila(String[][] tablaSimbolos, Stack<String> p1, Stack<String> p2, String[][] tablaErrores)
    {
        if (p1 != null && p2 != null)
        {
            ArrayList re = new ArrayList();
            ArrayList re2 = new ArrayList();

            Stack< String> S = new Stack< String>();
            Stack< String> S1 = new Stack< String>();
//        System.out.println(p1.size());
            int j = p1.size();
            for (int i = 0; i < j; i++)
            {
                S1.push(p1.pop());
                S.push(p2.pop());

            }
            for (int i = 0; i < j; i++)
            {
                re.add(S1.pop());
                re2.add(S.pop());

            }
            re.remove("");
            re2.remove("");

            do
            {

                //re.remove(0);
                //re2.remove(0);
                if (re2.contains("T2"))
                {
                    int a = re2.indexOf("T2");

                    String compra1token = re2.get(a - 1) + "";
                    String compra2token = re2.get(a - 2) + "";
                    String compra1 = re.get(a - 1) + "";
                    String compra2 = re.get(a - 2) + "";
                    String reAdan[];

                    if (compra1token.equals("T50") || compra2token.equals("T50"))
                    {
                        String tokencomp = compra1;
                        String tokencomp2 = compra2;
                        String comp = compra1;
                        String comp2 = compra2;

                        String[] bus1;
                        String[] bus2;

                        if (compra1token.equals("T50"))
                        {
                            bus1 = TablaS.busca(tablaSimbolos, compra1,tablaErrores);

                            tokencomp = bus1[1];
                            comp = bus1[2];

                        }
                        if (compra2token.equals("T50"))
                        {
                            bus2 = TablaS.busca(tablaSimbolos, compra2,tablaErrores);
                            tokencomp2 = bus2[1];
                            comp2 = bus2[2];

                        }
                        reAdan = VariablesYOperadores.tipoDeVariablesYOperador(tokencomp, tokencomp2, re.get(a) + "", comp, comp2);

                    } else
                    {

                        reAdan = VariablesYOperadores.tipoDeVariablesYOperador(compra1token, compra2token, re.get(a) + "",  compra2,compra1);

                    }

                    re.remove(a);
                    re2.remove(a);

                    re2.remove(a - 1);
                    re2.remove(a - 2);
                    re.remove(a - 1);
                    re.remove(a - 2);
                    //agregar el valor real 2+2=4
                    re.add(a - 2, reAdan[1]);
                    re2.add(a - 2, reAdan[0]);
                    System.out.println(re.toString());
                    System.out.println(re2.toString());

                } else
                {
                    if (re.size() == 3)
                    {
                        if (re2.contains("T8"))
                        {
                            String lex = (re.remove(0) + "").trim();
                            String lex2 = (re2.remove(0) + "").trim();
                            String valor = (re.remove(0) + "").trim();
                            String valor2 = (re2.remove(0) + "").trim();
                            String valorReal = valor2.trim();
                            System.out.println(lex);
                            System.out.println(lex2);
                            System.out.println(valor);
                            System.out.println(valor2);
                            System.out.println();
                            String tabladetablas[][][] = TablaS.asignatabla(tablaSimbolos, lex, valorReal, valor, tablaErrores);
                            tablaSimbolos = tabladetablas[0];
                            tablaErrores = tabladetablas[1];
                            System.out.println("jajaja");
                        }

                    }

                    System.out.println(re.toString());
                    System.out.println(re2.toString());

                    break;

                }

            } while (!re.isEmpty());

            System.out.println(S.toString());
            System.out.println(S1.toString());
        }
        String[][][] tab = new String[3][][];
        tab[0] = tablaSimbolos;
        tab[1] = tablaErrores;

        return tab;
    }
    
    public static void codigoIntermedioSent(String token, String[][] etiquetas, int numEtiqueta) {
        switch(token){
            case "T12":
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                etiquetas = verificarEtiq("B.True", etiquetas, numEtiqueta);
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                etiquetas = verificarEtiq("B.False", etiquetas, numEtiqueta);
                mostrarEtiquetas(etiquetas);
                break;
            case "T13":
                
                break;
            case "T14":
                
                break;
            default: System.out.println("Error al entrar código intermedio.");
                break;
        }
    }
    
    public static String[][] verificarEtiq(String etiqueta, String[][] etiquetas, int numEtiqueta) {
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i][0] != null) {
                if (etiquetas[i][0].equals(etiqueta)) {
                    for (int j = 0; j < etiquetas[i].length; j++) {
                        if (etiquetas[i][j] == null) {
                            etiquetas[i][j] = String.valueOf(numEtiqueta);
                            return etiquetas;
                        }
                    }
                }
            } else {
                etiquetas[i][0] = etiqueta;
                etiquetas[i][1] = String.valueOf(numEtiqueta);
                return etiquetas;
            }
        }
        return etiquetas;
    }
    
    public static int nuevaEtiqueta(int actual) {
        actual = actual + 10;
        return actual;
    }
    
    public static void mostrarEtiquetas(String[][] etiquetas) {
        for (int i = 0; i < etiquetas.length; i++) {
            for (int j = 0; j < etiquetas[i].length; j++) {
                System.out.print(etiquetas[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}

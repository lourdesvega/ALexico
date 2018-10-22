/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import java.util.Stack;
import static semantico.Expresion.exp;
import static semantico.Expresion.postfijo;

/**
 *
 * @author leo
 */
public class Analiza
{

    public static ArrayList analizador(String sSemantica, String[] sSemantica11, String[] sSemantica1Tokens, ArrayList tablaErrores, ArrayList tabladetablas, ArrayList tabladetablasresultado)
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
            vector1[4] = TablaS.tablaSimbolosDeclara(tabladetablas, vector1, tablaErrores);
            tabladetablas = creaTabla(tabladetablas, vector1);
            Object pilas[] = analizaPos(junto[0], junto[1]);
            if (pilas != null)
            {
                System.out.println(((Stack<String>) pilas[0]).size());
                ArrayList tab = analizaPila(tabladetablas, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                tabladetablas = (ArrayList) tab.get(0);
                //tablaErrores = (ArrayList) tab.get(1);
            }

        } else
        {
            String sent;
            Object pilas[];
            ArrayList nuevo = new ArrayList();
            switch (sSemantica1Tokens[0].trim())
            {

                case "T50":
                    pilas = analizaPos(junto[0], junto[1]);
                    if (pilas != null)
                    {
//                        System.out.println(((Stack<String>) pilas[0]).size());
                        ArrayList tab = analizaPila(tabladetablas, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                        //tab.add(tabladetablas);
                        //tab.add(tablaErrores);
                    }
                    break;
                case "T12"://SI
                    gramatica.Gramatica.tablaTablas.add(nuevo);
                    String condicionsi[] = new String[sSemantica11.length - 1];
                    String condicionTokensi[] = new String[sSemantica1Tokens.length - 1];
                    System.arraycopy(sSemantica11, 1, condicionsi, 0, condicionsi.length);
                    System.arraycopy(sSemantica1Tokens, 1, condicionTokensi, 0, condicionsi.length);

                    //String[] sSemantica11, String[] sSemantica1Tokens;
                    PilasE[] p1 = postfijo(condicionsi, condicionTokensi);
                    //for()
                    //mostrarPila1(p1);
                    Stack<String> pp = transformar(p1[0]);
                    Stack<String> pp1 = transformar(p1[1]);
                    //System.out.println("jdshd: "+pp);
                    //System.out.println("jdgsd: "+pp1);

                    //pilas = analizaPos(condicion, condicionToken);
                    analizaPila(tabladetablas, (Stack<String>) pp, (Stack<String>) pp1, tablaErrores);

//ArrayList tab = analizaPila(tabladetablas, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);
                    // sent = eliminaSent(sSemantica.replace(" ",""), "Si");
                    //System.out.println("Expresión resultante: " + sent);
                    break;
                case "T14"://PARA
                    gramatica.Gramatica.tablaTablas.add(nuevo);
                    ArrayList pa = para(sSemantica11, sSemantica1Tokens);

                    String asigna1[] = (String[]) pa.get(0);
                    String asigna1Token[] = (String[]) pa.get(1);
                    pilas = analizaPos(asigna1, asigna1Token);
                    analizaPila(tabladetablas, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                    String condicion[] = (String[]) pa.get(2);
                    String condicionToken[] = (String[]) pa.get(3);

                    PilasE[] ppp1 = postfijo(condicion, condicionToken);
                    //mostrarPila1(p1);
                    Stack<String> ppp = transformar(ppp1[0]);
                    Stack<String> pj1 = transformar(ppp1[1]);
                    //System.out.println("jdshd: "+ppp);
                    //System.out.println("jdgsd: "+pj1);

                    //pilas = analizaPos(condicion, condicionToken);
                    analizaPila(tabladetablas, (Stack<String>) ppp, (Stack<String>) pj1, tablaErrores);

                    String asigna2[] = (String[]) pa.get(4);
                    String asigna2Token[] = (String[]) pa.get(5);

                    pilas = analizaPos(asigna2, asigna2Token);
                    analizaPila(tabladetablas, (Stack<String>) pilas[0], (Stack<String>) pilas[1], tablaErrores);

                    break;
                case "T15"://mientras
                    gramatica.Gramatica.tablaTablas.add(nuevo);
                    String condicionmi[] = new String[sSemantica11.length - 1];
                    String condicionTokemi[] = new String[sSemantica1Tokens.length - 1];
                    System.arraycopy(sSemantica11, 1, condicionmi, 0, condicionmi.length);
                    System.arraycopy(sSemantica1Tokens, 1, condicionTokemi, 0, condicionmi.length);

                    PilasE[] pmientras = postfijo(condicionmi, condicionTokemi);
                    //mostrarPila1(p1);
                    Stack<String> pm = transformar(pmientras[0]);
                    Stack<String> pm1 = transformar(pmientras[1]);

                    //pilas = analizaPos(condicion, condicionToken);
                    analizaPila(tabladetablas, (Stack<String>) pm, (Stack<String>) pm1, tablaErrores);

                    break;
                case "T13"://SINO

                    gramatica.Gramatica.tablaTablas.add(nuevo);

                    break;
                case "T17"://ENTRA
                    gramatica.Gramatica.tablaTablas.add(nuevo);

                    //sent = eliminaSent(sSemantica.replace(" ",""), "Entro");
                    //System.out.println("Expresión resultante: " + sent);
                    break;
                case "T20"://CLASE

                    //verificar clase
                    gramatica.Gramatica.tablaTablas.add(nuevo);
                    clases(sSemantica11, sSemantica1Tokens);
                    break;
                case "T18"://caso
                    gramatica.Gramatica.tablaTablas.add(nuevo);

                    break;
                case "T23"://Metodo
                    //verificar metodo

                    metodos(sSemantica11, sSemantica1Tokens);
                    gramatica.Gramatica.tablaTablas.add(nuevo);

                    metodosparametros(sSemantica11, sSemantica1Tokens);

                    break;

            }
            System.out.println("No entra 2");

        }
        // tablaVarianles = creaTabla(tablaVarianles, sSemantica11);

        ArrayList tab = new ArrayList();
        //tab.add(tabladetablas);
        //  tab.add(tablaErrores);

        return tab;
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
            case "Cadena":
                tipo1 = "T53";
                break;
            case "Caracter":
                tipo1 = "T55";
                break;

            case "Char":
                break;

        }

        String vector[] =
        {
            nuevo.trim(), tipo1, null, "0", error
        };

        return vector;
    }

    public static ArrayList creaTabla(ArrayList tablatablas, String[] nuevo)
    {

        if (nuevo != null)
        {

            ArrayList a = (ArrayList) tablatablas.get(tablatablas.size() - 1);
            a.add(nuevo);

        }
        return tablatablas;
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
        // System.out.println("hgfghjk");
        //String pila[]=TablaS.separador(s);

        return re;
    }

    public static ArrayList analizaPila(ArrayList tablaTablas, Stack<String> p1, Stack<String> p2, ArrayList tablaErrores)
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
                if (re2.contains("T2") || re2.contains("T3") || re2.contains("T4"))
                {
                    int a = re2.indexOf("T2");
                    for (int i = 0; i < re2.size(); i++)
                    {
                        if (((String) re2.get(i)).trim().equals("T2"))
                        {
                            a = re2.indexOf("T2");

                            break;
                        }
                        if (((String) re2.get(i)).trim().equals("T3"))
                        {

                            a = re2.indexOf("T3");
                            break;

                        }
                        if (((String) re2.get(i)).trim().equals("T4"))
                        {
                            a = re2.indexOf("T4");
                            break;

                        }

                    }

                    String compra1token = re2.get(a - 1) + "";
                    String compra2token = re2.get(a - 2) + "";
                    String compra1 = re.get(a - 1) + "";
                    String compra2 = re.get(a - 2) + "";
                    String reAdan[];

                    if (compra1token.equals("T50") || compra2token.equals("T50"))
                    {
                        String tokencomp = compra1token;
                        String tokencomp2 = compra2token;
                        String comp = compra1;
                        String comp2 = compra2;

                        String[] bus1;
                        String[] bus2;

                        if (compra1token.equals("T50"))
                        {
                            bus1 = TablaS.buscaArray(tablaTablas, compra1, tablaErrores);

                            tokencomp = bus1[1];
                            comp = bus1[2];

                        }
                        if (compra2token.equals("T50"))
                        {
                            bus2 = TablaS.buscaArray(tablaTablas, compra2, tablaErrores);
                            tokencomp2 = bus2[1];
                            comp2 = bus2[2];

                        }
                        reAdan = VariablesYOperadores.tipoDeVariablesYOperador(tokencomp, tokencomp2, re.get(a) + "", comp, comp2);

                    } else
                    {

                        reAdan = VariablesYOperadores.tipoDeVariablesYOperador(compra1token, compra2token, re.get(a) + "", compra1, compra2);

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
                            if (((String) re2.get(1)).trim().equals("T50"))
                            {

                                String lex = (re.remove(0) + "").trim();
                                String lextoken = (re2.remove(0) + "").trim();
                                String lex2 = (re.remove(0) + "").trim();
                                String lex2token = (re2.remove(0) + "").trim();

                                String[] bus2 = TablaS.buscaArray(tablaTablas, lex2, tablaErrores);
                                String tokencomp2 = bus2[1];
                                String comp2 = bus2[2];

                                ArrayList tab = TablaS.asignatabla(tablaTablas, lex, tokencomp2, comp2, tablaErrores);

                            } else
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
                                ArrayList tab = TablaS.asignatabla(tablaTablas, lex, valorReal, valor, tablaErrores);
                            }
                            System.out.println("jajaja");
                        } else
                        {

                            if (re2.contains("T3"))
                            {

                                if (((String) re2.get(0)).trim().equals("T50") || ((String) re2.get(1)).trim().equals("T50"))
                                {

                                    if (((String) re2.get(0)).trim().equals("T50"))
                                    {

                                        String[] bus2 = TablaS.buscaArray(tablaTablas, (String) re.get(0), tablaErrores);
                                        String tokencomp2 = bus2[1];
                                        String comp2 = bus2[2];

                                    }

                                    if (((String) re2.get(1)).trim().equals("T50"))
                                    {
                                        String[] bus2 = TablaS.buscaArray(tablaTablas, (String) re.get(1), tablaErrores);
                                        String tokencomp2 = bus2[1];
                                        String comp2 = bus2[2];

                                    }

                                }

                            }

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
        ArrayList tab = new ArrayList();
        tab.add(tablaTablas);
        tab.add(tablaErrores);

        return tab;
    }

    public static String eliminaSent(String cad, String sentencia)
    {
        System.out.println("\nELIMINACIÓN DE SENTENCIA: " + sentencia);
        String res[] = cad.split(sentencia);
        String r[] = res[1].split(":");
        return r[0];
    }

    public static String[] separaExpDeSent(String exp)
    {
        String cad = "";
        for (int i = 0; i < exp.codePointCount(0, exp.length()); i++)
        {
            if (i != 0 && i != exp.codePointCount(0, exp.length()) - 1)
            {
                cad += exp.charAt(i);
            }
        }
        System.out.println(cad);
        String r[] = cad.split(";");
        return r;
    }

    public static String clases(String[] valor, String[] token)
    {

        if (gramatica.Gramatica.tablaClases.size() != 0)
        {
            for (int i = 0; i < gramatica.Gramatica.tablaClases.size(); i++)
            {
                String[] vec = (String[]) gramatica.Gramatica.tablaClases.get(i);
                if (vec != null)
                {

                    if (vec[0].trim().equals(valor[1].trim()))
                    {

                        String vectorError[] =
                        {
                            valor[1], "clase", null, "0", "clase duplicada"
                        };
                        gramatica.Gramatica.tablaErrores.add(vectorError);
                        return "";
                    }

                }

            }

        }

        String vectorClase[] =
        {
            valor[1], "Clase", null, "0", ""
        };
        gramatica.Gramatica.tablaClases.add(vectorClase);

        return "";
    }

    public static String metodos(String[] valor, String[] token)
    {
        if (gramatica.Gramatica.tablaMetodos.size() != 0)
        {
            for (int i = 0; i < gramatica.Gramatica.tablaMetodos.size(); i++)
            {
                String[] vec = (String[]) gramatica.Gramatica.tablaMetodos.get(i);
                if (vec != null)
                {

                    if (vec[0].trim().equals(valor[1].trim()) && vec[4].trim().equals(((String[]) gramatica.Gramatica.tablaClases.get(gramatica.Gramatica.tablaClases.size() - 1))[0].trim()))
                    {

                        String vectorError[] =
                        {
                            valor[1], "Metodo", null, "0", "Metodo duplicada"
                        };
                        gramatica.Gramatica.tablaErrores.add(vectorError);
                        return "";
                    }

                }

            }

        }

        String vectorClase[] =
        {
            valor[1], "Metodo", null, "0", ((String[]) gramatica.Gramatica.tablaClases.get(gramatica.Gramatica.tablaClases.size() - 1))[0]
        };
        gramatica.Gramatica.tablaMetodos.add(vectorClase);

        return "";
    }

    public static String metodosparametros(String[] valor, String[] token)
    {

        if (valor.length > 4)
        {
            String[] vec = Analiza.creaVector(valor[4].trim(), valor[3].trim(), "");
            vec[3] = "0";
            TablaS.tablaSimbolosDeclara(gramatica.Gramatica.tablaTablas, vec, gramatica.Gramatica.tablaErrores);
            creaTabla(gramatica.Gramatica.tablaTablas, vec);

            for (int i = 3; i < token.length; i++)
            {

                if (token[i].trim().equals("T10"))
                {
                    vec = Analiza.creaVector(valor[i + 2].trim(), valor[i + 1].trim(), "");
                    vec[3] = "0";
                    vec[4] = TablaS.tablaSimbolosDeclara(gramatica.Gramatica.tablaTablas, vec, gramatica.Gramatica.tablaErrores);
                    creaTabla(gramatica.Gramatica.tablaTablas, vec);
                }

            }

        }

        return "";
    }

    public static ArrayList para(String[] para, String[] tokens)
    {

        String aaa = "";
        String aaatoken = "";

        for (int i = 2; i < para.length - 1; i++)
        {
            if (para[i].trim().equals(";"))
            {
                aaa += para[i].trim() + "";
                aaatoken += tokens[i].trim() + "";
            } else
            {
                aaa += para[i].trim() + " ";
                aaatoken += tokens[i].trim() + " ";

            }
        }
        ArrayList paraArray = new ArrayList();

        String[] p1 = aaa.split(";");
        String[] p2 = aaatoken.split("T9");

        for (int i = 0; i < 3; i++)
        {
            paraArray.add(p1[i].split(" "));
            paraArray.add(p2[i].split(" "));

        }

        return paraArray;
    }

    public static Stack<String> transformar(PilasE p)
    {

        Stack<String> pi1 = new Stack<String>();

        int top = p.getTope();
        for (int i = 0; i < top + 1; i++)
        {
            pi1.add((String) p.eliminar());
        }

        Stack<String> re = new Stack<String>();

        for (int i = 0; i < top + 1; i++)
        {

            re.add(pi1.pop());

        }
        return re;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

import GUI.Interfaz2;
import LulúPost.Postfijo;
import static LulúPost.TablaTemporales.tabla;
import static LulúPost.TablaTemporales.temporal;
import com.sun.org.glassfish.external.statistics.Statistic;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static semantico.Analiza.analizaPila;
import static semantico.Analiza.analizaPos;
import static semantico.Analiza.clases;
import static semantico.Analiza.metodos;
import static semantico.Analiza.metodosparametros;
import static semantico.Analiza.para;
import static semantico.Analiza.transformar;
import static semantico.Expresion.postfijo;
import semantico.PilasE;

/**
 *
 * @author lourd
 */
public class Intermedio
{

    public static int etiqueta = 0;
    static Etiquetas nueva;
    static Etiquetas anterior;
    public static ArrayList ta1 = new ArrayList();

    public static int nuevaE()
    {
        return etiqueta = etiqueta + 10;

    }

    public static void rutina(Stack< String> Pila, Etiquetas principal)
    {
        Stack pila = new Stack();
        pila.push(principal);
        anterior = principal;

        while (!Pila.empty())
        {
            switch (Pila.peek())
            {
                case ("&&"):
                    nueva = new Etiquetas();
                    pila.get(etiqueta);
                    nueva.setE1True(anterior.getNuevaEtiqueta());
                    nueva.setE1false(anterior.getE1false());
                    nueva.setE2True(anterior.getE1True());
                    nueva.setE2false(anterior.getE1false());
                    anterior = nueva;
                    pila.push(nueva);
                    //B.Codigo=B1.Codigo
                    System.out.println(nueva.getE1True());
                    //B2.Codigo
                    Pila.pop();

                    //e.setE1false();
                    break;
            }
        }
    }

    public static int nuevaEtiqueta(int actual)
    {
        actual += 10;
        return actual;
    }

    public static Object[] creacodigo(String[] programa, String[] programaTokens, ArrayList tab, int i, String a, Object[] resul)
    {
        String vector[] = new String[5];

        if (i < programaTokens.length)
        {
            switch (programaTokens[i].trim())
            {
                case "T14":
                    ++i;
                    ++i;
                    String para = "";

                    do
                    {

                        if (!programa[i].equals(";"))
                        {
                            para += programa[i] + ":";

                        } else
                        {

                            para += programa[i];
                        }
                        i = i + 1;
                    } while (!programa[i].equals(":"));
                    String ex1[] = para.split(";");
                    String para1[] = ex1[0].split(":");
                    String para2[] = ex1[1].split(":");
                    String para3[] = (ex1[2].substring(0, ex1[2].length() - 2)).split(":");

                    Etiquetas epara = new Etiquetas();
                    epara.setInicio(nuevaE());
                    epara.setE1True(nuevaE());
                    epara.setE1false(nuevaE());

                    String paraasig[] = Postfijo.postfijo(para1);
                    ArrayList taA1para = tabla(paraasig, tab);
                    ta1 = tab;

                    String vectorparaasig[] = new String[5];
                    vectorparaasig[3] = "";
                    vectorparaasig[0] = (String) taA1para.get(0);
                    vectorparaasig[1] = (String) taA1para.get(1);
                    vectorparaasig[2] = (String) taA1para.get(2);
                    tab.add(vectorparaasig);
                    a = genera("\n" + taA1para.toString(), a);
                    String vectorpara[] = new String[5];
                    vectorpara[0] = "";
                    vectorpara[1] = "";
                    vectorpara[2] = "";
                    vectorpara[3] = epara.getInicio() + ":";
                    tab.add(vectorpara);

                    String condpara[] = Postfijo.postfijo(para2);
                    ArrayList tapara = tabla(condpara, tab);
                    ta1 = tab;
                    a = codigoCondicion(tapara, a, epara);
                    vectorpara = new String[5];
                    vectorpara[0] = "";
                    vectorpara[1] = "";
                    vectorpara[2] = "";
                    vectorpara[3] = epara.getE1True() + ":";
                    tab.add(vectorpara);
                    a = genera("\n" + epara.getE1True() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    String paraasig2[] = Postfijo.postfijo(para3);
                    ArrayList taA1para2 = tabla(paraasig2, tab);
                    ta1 = tab;

                    String vectorparaasig2[] = new String[5];
                    vectorparaasig2[3] = "";
                    vectorparaasig2[0] = (String) taA1para2.get(0);
                    vectorparaasig2[1] = (String) taA1para2.get(1);
                    vectorparaasig2[2] = (String) taA1para2.get(2);
                    tab.add(vectorparaasig2);

                    vectorpara = new String[5];
                    vectorpara[0] = "";
                    vectorpara[1] = "";
                    vectorpara[2] = "";
                    vectorpara[3] = epara.getInicio() + "";
                    tab.add(vectorpara);

                    vectorpara = new String[5];
                    vectorpara[0] = "";
                    vectorpara[1] = "";
                    vectorpara[2] = "";
                    vectorpara[3] = epara.getE1false() + ":";
                    tab.add(vectorpara);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    return resul;
                case "T1":
                    ++i;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    return resul;

                case "T50":
                    String asignacion1 = "";
                    int j1;
                    do
                    {
                        asignacion1 += programa[i] + ";";
                        i = i + 1;
                        j1 = i + 1;

                    } while (!programaTokens[j1].equals("T9") && !programaTokens[i].equals("T12") && !programaTokens[i].equals("T14") && !programaTokens[i].equals("T11") && !programa[i].equals(":") && !programaTokens[i].equals("T1") && !programaTokens[i].equals("T15") && !(programa[i].equals("T50") && programa[j1].equals("T50")) && !(programa[i].equals("T51") && programa[j1].equals("T50")) && !(programa[i].equals("T52") && programa[j1].equals("T50")) && !(programa[i].equals("T6") && programa[j1].equals("T50")));

                    String exprA1[] = asignacion1.split(";");
                    String condA1[] = Postfijo.postfijo(exprA1);
                    ArrayList taA1 = tabla(condA1, tab);
                    ta1 = tab;
                    String vector5[] = new String[5];
                    vector5[3] = "";

                    if (condA1.length == 1)
                    {
                        vector5[0] = (String) taA1.get(0);
                        vector5[1] = "0";
                        vector5[2] = "=";
                        tab.add(vector5);

                    } else
                    {

                        if (condA1.length == 2)
                        {
                            vector5[0] = (String) taA1.get(1);

                            vector5[1] = "";
                            vector5[2] = (String) taA1.get(0);
                            tab.add(vector5);
                        } else
                        {

                            if (condA1[1].trim().equals("Leer"))
                            {
                                vector5[0] = (String) taA1.get(0);
                                vector5[1] = "";
                                vector5[2] = (String) taA1.get(1);
                            tab.add(vector5);
                            } else
                            {
                                vector5[0] = (String) taA1.get(0);
                                vector5[1] = (String) taA1.get(1);
                                vector5[2] = (String) taA1.get(2);
                                //vector5[3] = (String) taA1.get(2);
                                tab.add(vector5);
                            }
                        }
                    }

                    a = genera("\n" + taA1.toString(), a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    return resul;
                case "T12"://SI
                    String vectorSI[] = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = "";
                    Etiquetas e = new Etiquetas();
                    e.setE1True(nuevaE());
                    e.setE1false(nuevaE());
                    e.setSSig(nuevaE());

                    String condicion = "";
                    i = i + 1;
                    do
                    {
                        condicion += programa[i] + ";";
                        i = i + 1;
                    } while (!programa[i].equals(":"));

                    String expr[] = condicion.split(";");
                    String cond[] = Postfijo.postfijo(expr);
                    ArrayList ta = tabla(cond, tab);
                    ta1 = tab;
                    a = codigoCondicion(ta, a, e);
                    //a = genera("goto " + e.getSSig(), a);
                    vectorSI = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = e.getE1True() + ":";
                    tab.add(vectorSI);
                    a = genera("\n" + e.getE1True() + ":", a);

                    i = i + 1;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    vectorSI = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = e.getSSig() + "";
                    tab.add(vectorSI);
                    a = genera("\n go to " + e.getSSig(), a);
                    vectorSI = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = e.getE1false() + ":";
                    tab.add(vectorSI);
                    a = genera("\n" + e.getE1false() + ":", a);
                    if (programaTokens[i + 1].equals("T13"))
                    {
                        resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                        a = (String) resul[0];
                        i = (int) resul[1];
                    }
                    vectorSI = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = "" + e.getSSig();
                    tab.add(vectorSI);
                    a = genera("\n go to " + e.getSSig(), a);
                    vectorSI = new String[5];
                    vectorSI[0] = "";
                    vectorSI[1] = "";
                    vectorSI[2] = "";
                    vectorSI[3] = "" + e.getSSig() + ":";
                    tab.add(vectorSI);
                    a = genera("\n" + e.getSSig() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;

                case "T15"://mientras
                    String vectorMI[] = new String[5];
                    vectorMI[0] = "";
                    vectorMI[1] = "";
                    vectorMI[2] = "";
                    vectorMI[3] = "";

                    Etiquetas emi = new Etiquetas();
                    emi.setInicio(nuevaE());
                    emi.setE1True(nuevaE());
                    emi.setE1false(nuevaE());
                    vectorMI = new String[5];
                    vectorMI[0] = "";
                    vectorMI[1] = "";
                    vectorMI[2] = "";
                    vectorMI[3] = emi.getInicio() + ":";
                    a = genera("\n" + emi.getInicio() + ":", a);

                    vectorMI[3] = emi.getInicio() + ":";
                    tab.add(vectorMI);
                    String condicionmi = "";
                    i = i + 1;
                    do
                    {
                        condicionmi += programa[i] + ";";
                        i = i + 1;
                    } while (!programa[i].equals(":"));
                    String exprmi[] = condicionmi.split(";");
                    String condmi[] = Postfijo.postfijo(exprmi);
                    ArrayList tami = tabla(condmi, tab);
                    ta1 = tab;
                    a = codigoCondicion(tami, a, emi);
                    vectorMI = new String[5];
                    vectorMI[0] = "";
                    vectorMI[1] = "";
                    vectorMI[2] = "";
                    vectorMI[3] = emi.getE1True() + ":";
                    tab.add(vectorMI);
                    a = genera("\n" + emi.getE1True() + ":", a);

                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    vectorMI = new String[5];
                    vectorMI[0] = "";
                    vectorMI[1] = "";
                    vectorMI[2] = "";
                    vectorMI[3] = emi.getInicio() + "";
                    tab.add(vectorMI);
                    a = genera("\n go to" + emi.getInicio(), a);

                    vectorMI = new String[5];
                    vectorMI[0] = "";
                    vectorMI[1] = "";
                    vectorMI[2] = "";
                    vectorMI[3] = emi.getE1false() + ":";
                    tab.add(vectorMI);
                    a = genera("\n" + emi.getE1false() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;
                case "T13"://SINO
                    ++i;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;
                case "T17"://ENTRA

                    break;
                case "T20"://CLASE
                    //verificar clase
                    String vector3[] = new String[5];
                    vector3[0] = programa[i + 1];
                    vector3[1] = "Clase";
                    vector3[2] = "";
                    vector3[3] = "Inicio";
                    tab.add(vector3);
                    a = genera(programa[i] + " " + programa[++i], a);
                    ++i;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    String vector4[] = new String[5];
                    vector4[0] = "";
                    vector4[1] = "Clase";
                    vector4[2] = "";
                    vector4[3] = "Fin";
                    tab.add(vector4);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);

                    a = (String) resul[0] + "fin de clase";
                    i = (int) resul[1];
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);

                    return resul;
                case "T23"://Metodo
                    //verificar metodo
                    String vectorME[] = new String[5];
                    vectorME[0] = programa[++i];
                    vectorME[1] = "Metodo";
                    vectorME[2] = "";
                    vectorME[3] = "Inicio";
                    tab.add(vectorME);
                    String parametrosMe = "";
                    a = genera("\n" + programa[i] + " " + programa[++i], a);
                    do
                    {

                        if (programaTokens[i].trim().equals("T1"))
                        {
                            String[] parametro = new String[4];

                            parametro[0] = vectorME[0];
                            parametro[1] = programa[i];
                            parametro[2] = programa[++i];
                            Interfaz2.parametros.add(parametro);
                        }

                        ++i;
                    } while (!programa[i].equals(":"));

                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    vectorME = new String[5];
                    vectorME[0] = "";
                    vectorME[1] = "Metodo";
                    vectorME[2] = "";
                    vectorME[3] = "Fin";
                    tab.add(vectorME);

                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;
                case "T7":

                    resul[0] = a;
                    resul[1] = i;

                    return resul;
                case "T11":
                    ++i;
                    String imprime = "";
                    int jim;
                    do
                    {
                        imprime += programa[i] + ";";
                        i = i + 1;
                        jim = i + 1;

                    } while (!programaTokens[i].equals("T12") && !programa[i].equals(":") && !programaTokens[i].equals("T1") && !programaTokens[i].equals("T15") && !(programa[i].equals("T50") && programa[jim].equals("T50")) && !(programa[i].equals("T51") && programa[jim].equals("T50")) && !(programa[i].equals("T52") && programa[jim].equals("T50")) && !(programa[i].equals("T6") && programa[jim].equals("T50")));

                    String exprIm[] = imprime.split(";");
                    String condIm[] = Postfijo.postfijo(exprIm);
                    ArrayList taIm = tabla(condIm, tab);
                    ta1 = tab;
                    String vector7[] = new String[5];
                    vector7[2] = "Imprimir";
                    vector7[0] = (String) taIm.get(0);
                    vector7[1] = "";
                    vector7[3] = "";

                    tab.add(vector7);
                    a = genera("\n" + taIm.toString(), a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    return resul;

            }

            // a = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a);
            resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a, resul);

            return resul;

        } else
        {

            return resul;
        }
    }

    public static String genera(String s, String a)
    {
        return a += s + " ";
    }

    public static String codigoCondicion(ArrayList ta, String a, Etiquetas e)
    {
        if (ta.size() == 0)
        {
            return a;
        }
        if (ta.contains("&&") || ta.contains("||"))
        {

            if (ta.size() > 7)
            {
                ArrayList con1 = (ArrayList) ta.clone();

                String or = (String) con1.remove(con1.size() - 1);
                ArrayList con2 = new ArrayList();
                con2.add(0, con1.remove(con1.size() - 1));
                con2.add(0, con1.remove(con1.size() - 1));
                con2.add(0, con1.remove(con1.size() - 1));

                if (or.equals("&&"))
                {
                    String[] vector = new String[5];
                    vector[0] = "";
                    vector[1] = "";
                    vector[2] = "";
                    vector[3] = "";

                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(nuevaE());
                    e1.setE1false(e.getE1false());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);

                    vector[3] = e1.getE1True() + ":";
                    Intermedio.ta1.add(vector);

                    a = genera("\n" + e1.getE1True() + ":", a);

                    a = codigoCondicion(con2, a, e);

                }

                if (or.equals("||"))
                {
                    String[] vector1 = new String[5];
                    vector1[0] = "";
                    vector1[1] = "";
                    vector1[2] = "";
                    vector1[3] = "";
                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(e.getE1True());
                    e1.setE1false(nuevaE());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);

                    vector1[3] = e1.getE1false() + ":";
                    Intermedio.ta1.add(vector1);
                    a = genera("\n" + e1.getE1false() + ":", a);

                    a = codigoCondicion(con2, a, e);

                }
                System.out.println(or);
                System.out.println(con1);
                System.out.println(con2);

            } else
            {
                ArrayList con1 = (ArrayList) ta.clone();
                ArrayList con2 = (ArrayList) ta.clone();
                String or = (String) con1.remove(con1.size() - 1);
                con1.remove(con1.size() - 1);
                con1.remove(con1.size() - 1);
                con1.remove(con1.size() - 1);

                con2.remove(0);
                con2.remove(0);
                con2.remove(0);
                con2.remove(con2.size() - 1);
                if (or.equals("&&"))
                {
                    String[] vector = new String[5];
                    vector[0] = (String) ta.get(0);
                    vector[1] = (String) ta.get(1);
                    vector[2] = (String) ta.get(2);
                    vector[3] = e.getE1True() + "";

                    String[] vector1 = new String[5];
                    vector1[0] = "";
                    vector1[1] = "";
                    vector1[2] = "";
                    vector1[3] = e.getE1false() + "";

                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(nuevaE());
                    e1.setE1false(e.getE1false());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);

                    vector1[3] = e1.getE1True() + ":";
                    Intermedio.ta1.add(vector1);

                    a = genera("\n" + e1.getE1True() + ":", a);
                    a = codigoCondicion(con2, a, e);

                }
                if (or.equals("||"))
                {

                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(e.getE1True());
                    e1.setE1false(nuevaE());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);

                    String[] vector1 = new String[5];
                    vector1[0] = "";
                    vector1[1] = "";
                    vector1[2] = "";
                    vector1[3] = e1.getE1false() + ":";
                    Intermedio.ta1.add(vector1);
                    a = genera("\n" + e1.getE1false() + ":", a);
                    a = codigoCondicion(con2, a, e);

                }
                System.out.println(or);
                System.out.println(con1);
                System.out.println(con2);

            }
        } else
        {
            String[] vector = new String[5];
            vector[0] = (String) ta.get(0);
            vector[1] = (String) ta.get(1);
            vector[2] = (String) ta.get(2);
            vector[3] = e.getE1True() + "";
            String[] vector1 = new String[5];
            vector1[0] = "";
            vector1[1] = "";
            vector1[2] = "";
            vector1[3] = e.getE1false() + "";

            Intermedio.ta1.add(vector);
            Intermedio.ta1.add(vector1);
            a = genera("\n" + "if" + ta.toString() + " go to " + e.getE1True(), a);
            a = genera("\n" + "go to " + e.getE1false(), a);

        }

        return a;
    }
}

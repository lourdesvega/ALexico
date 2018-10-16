/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

import LulúPost.Postfijo;
import static LulúPost.TablaTemporales.tabla;
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
    public static ArrayList ta1;

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

    public static Etiquetas codigoIntermedioSent(String token, String[][] etiquetas, int numEtiqueta)
    {
        Etiquetas sentencia = new Etiquetas();
        int e1True, e1False, sSig, eInicio, eTrue, eFalse;
        switch (token)
        {
            case "T12": // SI
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1True = numEtiqueta;
                sentencia.setE1True(e1True);

                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1False = numEtiqueta;
                sentencia.setE1false(e1False);
                break;
            case "T13": // SINO
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1False = numEtiqueta;
                sentencia.setE1false(e1False);

                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                sSig = numEtiqueta;
                sentencia.setSSig(sSig);
                break;
            case "T14": // PARA
                break;
            case "T15": // MIENTRAS
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eInicio = numEtiqueta;
                sentencia.setInicio(eInicio);

                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eTrue = numEtiqueta;
                sentencia.setE1True(eTrue);

                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eFalse = numEtiqueta;
                sentencia.setE1false(eFalse);
                break;
            default:
                System.out.println("Error al entrar código intermedio de sentencias.");
                break;
        }
        return sentencia;
    }

    public static int nuevaEtiqueta(int actual)
    {
        actual += 10;
        return actual;
    }

    public static Object[] creacodigo(String[] programa, String[] programaTokens, ArrayList tab, int i, String a, Object[] resul)
    {

        if (i < programaTokens.length)
        {
            switch (programaTokens[i].trim())
            {     case "T1":
                System.out.println("si");
                    break;

                case "T50":
                    break;
                case "T12"://SI
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
                    a = genera("\n" + e.getE1True() + ":", a);
                    i = i + 1;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, i, a, resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    a = genera("\n go to " + e.getSSig(), a);
                    a = genera("\n" + e.getE1false() + ":", a);
                    a = genera("\n" + e.getSSig() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    return resul;

                case "T15"://mientras
                    Etiquetas emi = new Etiquetas();
                    emi.setInicio(nuevaE());
                    emi.setE1True(nuevaE());
                    emi.setE1false(nuevaE());
                    a = genera("\n" + emi.getInicio() + ":", a);
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
                    a = genera("\n" + emi.getE1True() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    a = genera("\n go to" + emi.getInicio(), a);
                    a = genera("\n" + emi.getE1false() + ":", a);
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;
                case "T13"://SINO

                    break;

                case "T17"://ENTRA

                    break;
                case "T20"://CLASE
                    //verificar clase

                    a = genera(programa[i] + " " + programa[++i], a);
                    ++i;
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0]+"fin de clase";
                    i = (int) resul[1];

                    return resul;

                case "T18"://caso

                    break;
                case "T23"://Metodo
                    //verificar metodo

                    a = genera("\n" + programa[i] + " " + programa[++i], a);
                    do
                    {
                        ++i;
                    } while (!programa[i].equals(":"));

                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];
                    resul = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a,resul);
                    a = (String) resul[0];
                    i = (int) resul[1];

                    return resul;
                case "T7":
                    
                    
                    resul[0]=a;
                    resul[1]=i;

                    return resul;

            }

            // a = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a);
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

                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(nuevaE());
                    e1.setE1false(e.getE1false());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);
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

                    Etiquetas e1 = new Etiquetas();
                    e1.setE1True(nuevaE());
                    e1.setE1false(e.getE1false());
                    e1.setE2True(e.getE1True());
                    e1.setE2false(e.getE1false());

                    a = codigoCondicion(con1, a, e1);
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
                    a = genera("\n" + e1.getE1false() + ":", a);
                    a = codigoCondicion(con2, a, e);

                }
                System.out.println(or);
                System.out.println(con1);
                System.out.println(con2);

            }
        } else
        {

            a = genera("\n" + "if" + ta.toString() + " go to " + e.getE1True(), a);
            a = genera("\n" + "go to " + e.getE1false(), a);

        }

        return a;
    }
}

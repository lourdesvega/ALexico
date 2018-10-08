/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

import LulúPost.Postfijo;
import static LulúPost.TablaTemporales.tabla;
import com.sun.org.glassfish.external.statistics.Statistic;
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

    static int etiqueta = 0;
    static Etiquetas nueva;
    static Etiquetas anterior;

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

    public static String creacodigo(String[] programa, String[] programaTokens, ArrayList tab, int i, String a)
    {
        if (i < programaTokens.length)
        {
            switch (programaTokens[i].trim())
            {

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
                    List ta = tabla(cond, (ArrayList) tab);

                    a = codigoCondicion(ta, a);
                    a = genera("goto "+e.getSSig(), a);
                    a = genera("\n" + e.getE1True() + ":", a);
                    i = i + 1;
                    a = creacodigo(programa, programaTokens, (ArrayList) tab, i, a);
                    a = genera("\n" + e.getE1false() + ":", a);
                    return a;

                case "T15"://mientras

                    break;
                case "T13"://SINO

                    break;

                case "T17"://ENTRA

                    break;
                case "T20"://CLASE
                    //verificar clase
                    break;

                case "T18"://caso

                    break;
                case "T23"://Metodo
                    //verificar metodo

                    break;

            }

            a = creacodigo(programa, programaTokens, (ArrayList) tab, ++i, a);
            return a;

        } else
        {

            return a;
        }
    }

    private static String genera(String s, String a)
    {
        return a += s + " ";
    }

    private static String codigoCondicion(List ta, String a)
    {
        if (ta.contains("&&") || ta.contains("||"))
        {
            System.out.println("si");
            
            
        } else
        {

            a = genera("\n" + "if" + ta.toString(), a);
        }

        return a;
    }
}

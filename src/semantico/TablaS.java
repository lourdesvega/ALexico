/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static semantico.Analiza.creaTabla;
import static semantico.Analiza.creaVector;

public class TablaS
{

    public static String[] separador(String cadena)
    {
        int cont = 0;
        int espacio = cadena.replaceAll("[^ ]", "").length();
        String arr[] = new String[espacio + 1];

        for (int i = 0; i < cadena.length(); i++)
        {
            if (cadena.contentEquals(" "))
            {
                i = i + 1;

            } else
            {
                arr[cont] = cadena.substring(i);
                cont++;
            }

        }
        return arr;
    }

    public static String[] busca(String tablasim[][], String busca, ArrayList tablaErrores)
    {
        String b = "Variable no definida";
        String valor = "null";
        String tipo = "null";

        String r[] = new String[4];
        for (int i = 0; i < tablasim.length; i++)
        {
            if (tablasim[i][0].trim().equals(busca.trim()))
            {

                b = "";
                tipo = tablasim[i][1];
                valor = tablasim[i][2];
                tablasim[i][3] = "1";
                r[0] = b;
                r[1] = tipo;
                r[2] = valor;
                return r;
            }
        }

        r[0] = busca;
        r[1] = tipo;
        r[2] = valor;
        r[3] = b;
        tablaErrores.add(r);

        return r;
    }

    public static String[] buscaArray(ArrayList tablaTablas, String busca, ArrayList tablaErrores)
    {
        String b = "Variable no declarada";
        String valor = "null";
        String tipo = "null";

        String r[] = new String[4];
        if (tablaTablas != null)
        {
            for (int i = 0; i < tablaTablas.size(); i++)
            {
                ArrayList a = (ArrayList) tablaTablas.get(i);
                for (int j = 0; j < a.size(); j++)
                {
                    String vec[] = (String[]) a.get(j);
                    if (vec[0].trim().equals(busca.trim()))
                    {

                        b = "";
                        tipo = vec[1];
                        valor = vec[2];
                        vec[3] = "1";
                        r[0] = b;
                        r[1] = tipo;
                        r[2] = valor;
                        return r;
                    }

                }

            }
        }

        r[0] = busca;
        r[1] = tipo;
        r[2] = valor;
        r[3] = b;
        tablaErrores.add(r);

        return r;
    }

    public static ArrayList asignatabla(ArrayList tablaTablas, String lex, String valor, String valorReal, ArrayList tablaErrores)
    {

        if (tablaTablas != null)
        {
            for (int i = 0; i < tablaTablas.size(); i++)
            {

                ArrayList a = (ArrayList) tablaTablas.get(i);
                if (a != null)
                {
                    for (int j = 0; j < a.size(); j++)
                    {
                        String vec[] = (String[]) a.get(j);
                        if (vec[0].trim().equals(lex.trim()))
                        {

                            // tablasim[i][1]=valor;
                            if (!vec[1].trim().equals(valor.trim()))
                            {

                                vec[4] = "Error tipo de variable";
                                String vector1[] = creaVector(lex, "null", "Error tipo de variable");
                                gramatica.Gramatica.tablaErrores.add(vector1);

                            }
                            vec[2] = valorReal;

                            ArrayList tab = new ArrayList();
                            tab.add(tablaTablas);
                            //tab.add(tablaErrores);

                            return tab;
                        }
                    }
                }

            }

        }
        String vector1[] = creaVector(lex, "null", "Variable no declarada");
        gramatica.Gramatica.tablaErrores.add(vector1);
        ArrayList tab = new ArrayList();
        tab.add(tablaTablas);
        tab.add(tablaErrores);

        return tab;
    }

    public static String tablaSimbolos(String tablasim[][], String sim[])
    {
        String b = "Variable no definida";
        for (int i = 0; i < tablasim.length; i++)
        {
            if (tablasim[i][0].equals(sim[0]))
            {
                b = "";
            }
        }
        return b;
    }

    public static String tablaSimbolosDeclara(ArrayList tablaTablas, String sim[], ArrayList tablaErrores)
    {
        String b = "";
        if (tablaTablas != null)
        {
            for (int ii = 0; ii < tablaTablas.size(); ii++)
            {
                ArrayList tablasim = (ArrayList) tablaTablas.get(ii);
                for (int i = 0; i < tablasim.size(); i++)
                {

                    String[] vector = (String[]) tablasim.get(i);
                    if (vector != null)
                    {
                        if (vector[0].trim().equals(sim[0].trim()))
                        {

                            b = "Variable duplicada";
                            vector[4] = b;
                            sim[4] = b;
                            gramatica.Gramatica.tablaErrores.add(vector);

                        }
                    }
                }
            }

        }
        return b;
    }

}

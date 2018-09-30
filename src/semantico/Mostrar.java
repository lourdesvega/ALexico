/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;

/**
 *
 * @author leo
 */
public class Mostrar
{

    public static String imprimeEnStringError(ArrayList a)
    {
        String resultado = ""+"\n";
        if (a != null)
        {

            for (int i = 0; i < a.size(); i++)
            {

               
                    String vec[] = (String[]) a.get(i);
                    for (int k = 0; k < vec.length; k++)
                    {
                        resultado += vec[k] + " " + " \t";

                    }
                    resultado += "\n";

                
                //
                resultado += "" + "\n";

            }

        }

        return resultado;

    }

    public static String imprimeEnString(ArrayList a)
    {
        String resultado = "";
        if (a != null)
        {

            for (int i = 0; i < a.size(); i++)
            {

                ArrayList aux = (ArrayList) a.get(i);
                for (int j = 0; j < aux.size(); j++)
                {
                    String vec[] = (String[]) aux.get(j);
                    for (int k = 0; k < vec.length; k++)
                    {
                        resultado += vec[k] + " " + " \t";
                        
                    }
                    resultado += "\n";

                }
                resultado += "" + "\n";

            }

        }

        return resultado;
    }

    public static String imprimeEnStringR(ArrayList a)
    {
        String resultado = "";
        if (a != null)
        {

            for (int i = 0; i < a.size(); i++)
            {

                ArrayList aux = (ArrayList) a.get(i);
                for (int j = 0; j < aux.size(); j++)
                {
                    String vec[] = (String[]) aux.get(j);
                    for (int k = 0; k < vec.length-1; k++)
                    {
                        resultado += vec[k] + " " + " \t";
                        
                    }
                    resultado += "\n";

                }
                resultado += "" + "\n";

            }

        }

        return resultado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author leo
 */
public class SeparaToken
{

    
    public static String[][] cadena(String[][] tabla)
    {
      
        String vec[]=null;
        String vecval[]=null;
        for (int i = 0; i < tabla.length; i++)
        {
            if (tabla[i][1].trim().length() != 0)
            {
                
                vec=Arreglos.inserta(vec, tabla[i][1]);
                vecval=Arreglos.inserta(vecval, tabla[i][0]);

            }
        }
        imprime(vec);
        imprime(vecval);

        String resultado[][]= new String[2][];
        resultado[0]=vec;
        resultado[1]=vecval;

        return resultado;
    }

    public static void imprime(String vec[])
    {

        if (vec != null)
        {
            for (int i = 0; i < vec.length; i++)
            {
                System.out.println(i + ":" + vec[i]);
            }

        }

    }
}

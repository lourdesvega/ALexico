/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author leo
 */
public class LeerArchivos
{

    public static String leer(String ruta)
    {

        String txt = "";
        File arch = new File(ruta);

        try
        {

            BufferedReader leer = new BufferedReader(new FileReader(arch));
            String linea = leer.readLine();

            while (linea != null)
            {
                txt += linea + "\n";
                linea = leer.readLine();
            }
        } catch (FileNotFoundException e)
        {

        } catch (IOException ex)
        {
        }

        return txt;
    }

}

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
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 *
 * @author leo
 */
public class Excel
{
 
    
    public static String[][] cargarExcel(String archivo) // cargar archivo excel de los automatas
    {
    String[][] matriz;

        try {
            //abrir el libro de trabajo "claseExcel/prueba3.xls"
            File file = new File(archivo);
            Workbook workbook = Workbook.getWorkbook(file);
            //tomar la primera hoja de excel    
            jxl.Sheet hoja1 = workbook.getSheet(0);
            // tomar lacelda renglon y columna cero

            matriz = new String[hoja1.getRows()][hoja1.getColumns()];
            
             for (int i = 0; i < hoja1.getRows(); i++) {
                for (int j = 0; j < hoja1.getColumns(); j++) {

                    String t = hoja1.getCell(j, i).getContents();
                    matriz[i][j] = t.trim();
          
                }
               
                System.out.println("");

            }
        
             workbook.close();
        return matriz;
            //////7
            //////
            //llnar tokens de la tabla
            /*
            tokensTabla = new String[hoja1.getRows() - 1];
            for (int i = 0; i < hoja1.getRows() - 1; i++) {
                String t = hoja1.getCell(hoja1.getColumns() - 1, i + 1).getContents();

                tokensTabla[i] = t;
            }
            /////

            // cerrar libro de excel 
            workbook.close();
*/
        } catch (IOException ex) {
            System.out.println("no se encontro el archivo");
        } catch (BiffException ex) {
            System.out.println("celda en blanco");


        
        }
    
    return null;
}


}

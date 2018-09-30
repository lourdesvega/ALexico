/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica;

import clases.Excel;

/**
 *
 * @author leo
 */
public class GramaticaMatriz
{
//aqui van los excel
    public GramaticaMatriz()
    {
   this.gramatica=Excel.cargarExcel("archivosExcel/Gramatica.xls");
    this.tabla=Excel.cargarExcel("archivosExcel/tabla.xls");

    
    }
   

        public  String gramatica[][];
    

    public String tabla[][];

}

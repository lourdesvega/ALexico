/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

import java.util.ArrayList;

/**
 *
 * @author leo
 */
public class NewMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
   String programa[]={"Si","(","n",">","5", ")",":", ":"};
     String programaTokens[]={"T12","T5","T50","T3","T51", "T6","T7", "T7"};
     ArrayList a= new ArrayList();
     Intermedio.creacodigo(programa, programaTokens,a, 0);
      


    }
    
}

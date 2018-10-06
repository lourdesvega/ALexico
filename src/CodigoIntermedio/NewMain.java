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
   String programa[]={"Si","(","n",">","5","+","1", ")",":", ":"};
     String programaTokens[]={"T12","T5","T50","T3","T51","T2","T51", "T6","T7", "T7"};
    
     String letras="";
     letras= Intermedio.creacodigo(programa, programaTokens, 0,letras);
        System.out.println(letras);


    }
    
}

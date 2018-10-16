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
   String programa[]={"a","Si","(","n",">","5","+","4","+","4", ")",":","Si","(","z",">","5","+","4","+","4", ")",":", ":"};
     String programaTokens[]={"a","T12","T5","T50","T3","T51","T2","T51", "T6","T51","T5","T7", "T12","T5","T50","T3","T51","T2","T51", "T6","T51","T5","T7"};
    
     String letras="";
     ArrayList a=new ArrayList();
    // letras= Intermedio.creacodigo(programa, programaTokens,a, 0,letras);
        System.out.println(letras);


    }
    
}

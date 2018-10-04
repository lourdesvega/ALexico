/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

import java.util.Stack;

/**
 *
 * @author lourd
 */
public class Intermedio {
    static int etiqueta=0;

   static Etiquetas e;
    
    
    
    
    public static void rutina(Stack< String> Pila){
       Stack pila =new Stack();
       
       while(!Pila.empty()){
           switch(Pila.peek()){
               case("&&"):
                   e=new Etiquetas();
                   e.setE1True(e.getNuevaEtiqueta());
                   
               break;
           }
       }
    }
    
    
    
    
    
    public static int nuevaEtiqueta(){
        return (etiqueta=etiqueta+10);
    }
    /*public static int bTrue(){
        
    }*/
    
    
    
    
    
}

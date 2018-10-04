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

   static Etiquetas nueva;
   static Etiquetas anterior;
    
    
    
    
    public static void rutina(Stack< String> Pila, Etiquetas principal){
       Stack pila =new Stack();
       pila.push(principal);
       anterior=principal;
       
       while(!Pila.empty()){
           
           switch(Pila.peek()){
               case("&&"):
                   nueva=new Etiquetas();                   pila.get(etiqueta);
                   nueva.setE1True(anterior.getNuevaEtiqueta());
                   nueva.setE1false(anterior.getE1false());
                   nueva.setE2True(anterior.getE1True());
                   nueva.setE2false(anterior.getE1false());
                   anterior=nueva;
                   pila.push(nueva);
                   //B.Codigo=B1.Codigo
                   System.out.println(nueva.getE1True());
                   //B2.Codigo
                   Pila.pop();
                   
                   //e.setE1false();
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

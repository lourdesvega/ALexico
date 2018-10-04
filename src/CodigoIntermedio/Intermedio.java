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
                    nueva=new Etiquetas();
                    pila.get(etiqueta);
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
    
    public static Etiquetas codigoIntermedioSent(String token, String[][] etiquetas, int numEtiqueta) {
        Etiquetas sentencia = new Etiquetas();
        int e1True, e1False, sSig, eInicio, eTrue, eFalse;
        switch(token){
            case "T12": // SI
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1True = numEtiqueta;
                sentencia.setE1True(e1True);
                
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1False = numEtiqueta;
                sentencia.setE1false(e1False);
                break;
            case "T13": // SINO
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                e1False = numEtiqueta;
                sentencia.setE1false(e1False);
                
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                sSig = numEtiqueta;
                sentencia.setSSig(sSig);
                break;
            case "T14": // PARA
                break;
            case "T15": // MIENTRAS
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eInicio = numEtiqueta;
                sentencia.setInicio(eInicio);
                
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eTrue = numEtiqueta;
                sentencia.setE1True(eTrue);
                
                numEtiqueta = nuevaEtiqueta(numEtiqueta);
                eFalse = numEtiqueta;
                sentencia.setE1false(eFalse);
                break;
            default: System.out.println("Error al entrar código intermedio de sentencias.");
                break;
        }
        return sentencia;
    }
    
    public static int nuevaEtiqueta(int actual) {
        return actual + 10;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoIntermedio;

/**
 *
 * @author lourd
 */
public class Etiquetas {
    public Etiquetas(){
        
    }

    public Etiquetas(int nuevaEtiqueta, int inicio, int ETrue, int EFalse, int E1True, int E1false ){
        this.nuevaEtiqueta = nuevaEtiqueta;
        this.inicio = inicio;
        this.ETrue = ETrue;
        this.EFalse = EFalse;
        this.E1True = E1True;
        this.E1false = E1false;
    }

    public int getNuevaEtiqueta() {
        return nuevaEtiqueta+10;
    }

    public void setNuevaEtiqueta(int nuevaEtiqueta) {
        this.nuevaEtiqueta = nuevaEtiqueta;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getETrue() {
        return ETrue;
    }

    public void setETrue(int ETrue) {
        this.ETrue = ETrue;
    }

    public int getEFalse() {
        return EFalse;
    }

    public void setEFalse(int EFalse) {
        this.EFalse = EFalse;
    }

    public int getE1True() {
        return E1True;
    }

    public void setE1True(int E1True) {
        this.E1True = E1True;
    }

    public int getE1false() {
        return E1false;
    }

    public void setE1false(int E1false) {
        this.E1false = E1false;
    }



    private int nuevaEtiqueta=0;
    private int inicio;
    private int ETrue;
    private int EFalse;    
    private int E1True;
    private int E1false;
}

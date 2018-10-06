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

    public Etiquetas(int inicio, int E1True, int E1false, int E2True, int E2false, int sSig) {
        this.inicio = inicio;
        this.E1True = E1True;
        this.E1false = E1false;
        this.E2True = E2True;
        this.E2false = E2false;
        this.sSig = sSig;
    }

    public int getNuevaEtiqueta() {
        return nuevaEtiqueta;
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

    public int getE2True() {
        return E2True;
    }

    public void setE2True(int E2True) {
        this.E2True = E2True;
    }

    public int getE2false() {
        return E2false;
    }

    public void setE2false(int E2false) {
        this.E2false = E2false;
    }
    
    public int getSSig() {
        return sSig;
    }

    public void setSSig(int sSig) {
        this.sSig = sSig;
    }

    private int nuevaEtiqueta;
    private int inicio;  
    private int E1True;
    private int E1false;
    private int E2True;
    private int E2false;
    private int sSig;
}

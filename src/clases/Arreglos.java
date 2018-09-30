/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author leo
 */
public class Arreglos
{

    public static String[] inserta(String[] p, String obj)
    {
        String[] nP = null;
        if (p == null)
        {
            nP = new String[1];
            nP[0] = obj;
        } else
        {
            nP = new String[p.length + 1];
            System.arraycopy(p, 0, nP, 0, p.length);
            nP[p.length] = obj;
        }
        return nP;
    }
}

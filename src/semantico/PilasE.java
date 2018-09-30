/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

/**
 *
 * @author leo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SATELLITE
 */
public class PilasE
{
    private Object p[] = null;
    private int tope = -1;

    public PilasE(int n)
    {
        p = new Object[n];
    }

    /**
     * @return the p
     */
    public Object[] getP()
    {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Object[] p)
    {
        this.p = p;
    }

    /**
     * @return the tope
     */
    public int getTope()
    {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(int tope)
    {
        this.tope = tope;
    }

    public String inserta(Object obj)
    {
        if (tope + 1 == p.length)
        {
            return "Esta lleno";

        } else
        {
            p[++tope] = obj;
            return "insertado";
        }

    }

    public Object eliminar()
    {
        if (tope == -1)
        {
            return null;
        } else
        {
            return p[tope--];
        }
    }
}

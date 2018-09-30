/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

/**
 *
 * @author luisdaniel
 */
public class Cola
{

    private Object[] c = null;
    private int a = -1;

    public Cola(int n)
    {
        c = new Object[n];
    }

    /**
     * @return the c
     */
    public Object[] getC()
    {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Object[] c)
    {
        this.c = c;
    }

    /**
     * @return the a
     */
    public int getA()
    {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a)
    {
        this.a = a;
    }

    public String inserta(Object obj)
    {
        if (a + 1 == c.length)
        {
            return "Esta lleno";

        } else
        {
            c[++a] = obj;
            return "Dato insertado correctamente";
        }

    }

    public Object getenfre()
    {
        if (a != -1)
        {
            return c[0];

        }
        return null;
    }

    public Object eliminar()
    {
        Object obj2;
        if (a == -1)
        {
            return null;
        } else
        {
            obj2 = c[0];
            for (int i = 0; i < a; i++)
            {
                c[i] = c[i + 1];
            }
            a--;
            return obj2;

        }
    }

}

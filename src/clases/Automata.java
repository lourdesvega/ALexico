package clases;

/**
 *
 * @author leo
 */
public class Automata
{

    public static String automata(String matriz[][], String cade)
    {
        char c[] = cade.toCharArray();
        int sn = 1;
        int n = -1;
        int numero_alfa = matriz[0].length;
        String cacep = "";
        for (int i = 0; i < cade.length(); i++)
        {

            n = num(matriz[0], c[i]);
            int[] rsn = estado(sn, matriz[sn], c[i], n);
            sn = rsn[0];
            if (rsn[2] == -1)
            {
                try
                {
                    return matriz[sn][n];
                } catch (Exception e)
                {
                    return "E8";
                }
            } else
            {

                cacep += c[i];
            }

        }
        if (sn != -1 && sn != 0)
        {
            if (matriz[sn][numero_alfa - 2].equals("0"))
            {
                return matriz[sn][numero_alfa - 1];
            } else
            {

                return matriz[sn][numero_alfa - 1];
            }
        } else
        {
            try
            {
                return matriz[sn][n];
            } catch (Exception e)
            {
                return "Quien sabe";
            }

        }
    }

    public static int[] estado(int sn, String ve[], char c, int n)
    {
        int[] resultado = new int[3];
        try
        {
            resultado[0] = Integer.parseInt(ve[n]);
        } catch (Exception e)
        {
            resultado[0] = sn;
            resultado[1] = n;
            resultado[2] = -1;
        }

        return resultado;
    }

    public static int num(String ve[], char c)
    {
        int n = -1;

        for (int i = 0; i < ve.length; i++)
        {
            if (i == 0 || i == 1 || i == 2)
            {
                if (i == 0)
                {
                    if ((int) c >= (int) 'A' && (int) c <= (int) 'z' || (int) c >= 128)
                    {
                        n = i;
                        break;
                    }

                } else
                {
                    if (i==1)
                    {
                        if ((int) c >= 48 && (int) c <= 57)
                        {
                            n = i;
                            break;
                        }
                    }else{
                     if ((int) c !=(int)'#'&&(int) c !=(int)'\"'&&(int) c !=(int)'\''&&(int) c !=(int)'.'&&(int) c !=(int)'_')
                        {
                            n = i;
                            break;
                        }
                    
                    }
                }

            } else
            {

                if (ve[i].equals(c + ""))
                {
                    n = i;
                    break;
                }
            }
        }

        if (n == -1)
        {
            System.out.println("error");
        }

        return n;
    }

    public static char[] com(String ve[])
    {

        char[] ch;
        String ca = "";
        for (int i = 0; i < ve.length; i++)
        {
            ca += ve[i];
        }
        ch = ca.toCharArray();
        return ch;
    }

    public static boolean comprueba(String s)
    {
        char e[] = s.toCharArray();
        if (e[0] == 'E' || e[0] == 'e')
        {

            return false;
        } else
        {
            return true;
        }
    }
}

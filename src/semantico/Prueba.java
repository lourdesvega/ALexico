package semantico;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import java.util.ArrayList;

/**
 *
 * @author leo
 */
public class Prueba
{

    public static void main(String[] args)
    {
        String[] metodo =
        {
            "Metodo", "a", "(", "Entero", "a", ",", "Entero", "b", ")"
        };
        String[] metodo1 =
        {
            "Metodo", "b", "(", ")"
        };
        String[] para =
        {
            "Para", "(", "i", "=", "1", ";", "i", "<", "10", ";", "i", "=", "i", "+", "1"
        };
        String[] para2 =
        {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        };

        String[] metodoCopia =
        {
            "Metodosads", "adasda"
        };

        System.out.println(metodo1.length);

        String a[][] =
        {
            {
                "a", "a"
            },
            {
                "a"
            }
        };

        String rpara[][] = new String[3][];

        int contador1 = 0;
        int contador2 = 0;

        ArrayList paraArray = new ArrayList();
        String aaa = "";
        String aaatoken = "";

        for (int i = 2; i < para.length; i++)
        {
            if (para[i].trim().equals(";"))
            {
                aaa += para[i] + "";
                aaatoken += para2[i] + "";
            }else{
            aaa += para[i] + " ";
                aaatoken += para2[i] + " ";
            
            }
        }

        String[] p1 = aaa.split(";");
        for (int i = 0; i < 3; i++)
        {
            paraArray.add(p1[i].split(" "));

        }

        ArrayList al = new ArrayList();
        ArrayList a2 = new ArrayList();
        al.add(null);
        al.add(null);

        System.out.println(al.size());
        System.out.println(a2.size());
        ArrayList resultado = new ArrayList();
        System.out.println("oh");
        System.out.println(resultado.size());
        //        System.out.println(resultado.get(0));

        System.arraycopy(metodo, 3, metodoCopia, 0, 2);

        for (int i = 3; i < metodo.length; i++)
        {

            if (metodo[i].trim().equals("T2"))
            {

                Analiza.creaVector(metodo[i + 1].trim(), metodo[i].trim(), "");

            }

        }

    }

}

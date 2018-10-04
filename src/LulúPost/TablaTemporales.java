/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LulúPost;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lourd
 */
public class TablaTemporales {
     static int temporal;

    public static void main(String args[]) {
        String expr = "a<(v*6*6-5-3)";
        String[][] tabla1 = tabla(Postfijo.postfijo(expr));
        for (int i = 0; i < tabla1.length; i++) {
            for (int j = 0; j < tabla1[0].length; j++) {
                System.out.print(tabla1[i][j] + "\t");
            }
            System.out.println("");
        }
        expr = "a>(b*7+4-4)";
        tabla1 = tabla(Postfijo.postfijo(expr));
        for (int i = 0; i < tabla1.length; i++) {
            for (int j = 0; j < tabla1[0].length; j++) {
                System.out.print(tabla1[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static String[][] tabla(String exp[]) {

        //int temp
        List<String> Lista = new ArrayList<String>();
        int cont = 0;
        int t;
        String[][] tabla;
        int contT = 0;
        int contO = 0;
        for (int i = 0; i < exp.length; i++) {
            Lista.add(exp[i]);
            if (Postfijo.pref(exp[i]) >= 4 && Postfijo.pref(exp[i]) <= 7) {
                cont++;
            }
        }
        tabla = new String[cont][4];

        while (Lista.size() >= 3 && (contO < Lista.size())) {
            if ((Postfijo.pref(Lista.get(contO)) == 4 || Postfijo.pref(Lista.get(contO)) == 5) && Postfijo.pref(Lista.get(contO - 1)) == 99 && Postfijo.pref(Lista.get(contO - 2)) == 99) {
                tabla[contT][0] = Lista.get(contO - 2);
                tabla[contT][1] = Lista.get(contO - 1);
                tabla[contT][2] = Lista.get(contO);
                tabla[contT][3] = "T" + (t=temporal());

                Lista.remove(contO);
                Lista.remove(contO - 1);
                Lista.set(contO - 2, "T" + (t));

                contO = contO - 2;
                contT++;
            } else {
                if (Postfijo.pref(Lista.get(contO)) == 99 || (Postfijo.pref(Lista.get(contO)) >= 1 && Postfijo.pref(Lista.get(contO)) <= 3)) {
                    contO++;
                }
            }

        }

        System.out.println("Lista: " + Lista);

        return tabla;
    }
    
    public static int temporal (){
        return (temporal=temporal+1);
    }

}

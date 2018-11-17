/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizacion;

import java.util.ArrayList;

/**
 *
 * @author barcl
 */
public class Bloques {

    private static boolean op = false;

    public static void main(String[] args) {
        ArrayList arrl = new ArrayList();
        /* String[][] a = {
            {"a", "Clase", " ", "Inicio"},
            {"b", "Metodo", " ", "Inicio"},
            {"10", "2", "+", "T1"},
            {"T1", "4", "+", "T2"},
            {"T2", "78", "+", "T3"},
            {"T3", "7", "+", "T4"},
            {"4", "5", "+", "T5"},
            {"4", "T5", "+", "T6"},
            {"T6", "8", "+", "T7"},
            {"1", "T7", "+", "T8"},
            {"T8", "8", "+", "T9"},
            {"2", "T9", "+", "T10"},
            {"T10", "7", "+", "T11"},
            {"4", "T11", "+", "T12"},
            {"T12", "7", "+", "T13"},
            {"4", "T13", "+", "T14"},
            {"T14", "7", "+", "T15"},
            {"T4", "T15", "+", "T16"},
            {"num", "T16", "=", " "},
            {"num", "10", "<", "10"},
            {"", "", " ", "20"},
            {"", "", " ", "10:"},
            {"num", "1", "+", "T17"},
            {"num", "T17", "=", " "},
            {"", "", " ", "30"},
            {"", "", " ", "20:"},
            {"num", "1", "-", "T18"},
            {"num", "T18", "=", " "},
            {"", "", " ", "30"},
            {"", "", " ", "30:"},
            {"", "Metodo", " ", "Fin"},
            {"", "Clase", " ", "Fin"},};*/

        String[][] a = {
            // {"88.9", "-2.89", "*", "T1"}, 
            {"4", "2", "-", "T1"},
            {"T1", "2", "/", "T2"},
            {"a", "T2", "*", "T3"},
            {"T3", "T1", "*", "T4"},
            {"T4", "b", "+", "T5"},
            {"T3", "T1", "*", "T6"},
            {"T4", "b", "+", "T7"},
            {"T5", "T7", "*", "c"}};
        String vector[];
        for (int i = 0; i < a.length; i++) {
            vector = new String[4];
            vector[0] = a[i][0];
            vector[1] = a[i][1];
            vector[2] = a[i][2];
            vector[3] = a[i][3];
            arrl.add(vector);
        }
        
        arrl=Optimizar(arrl);
       //arrl = empTemp(arrl);

        for (int i = 0; i < arrl.size(); i++) {

            System.out.println(((String[]) arrl.get(i))[0] + "\t" + ((String[]) arrl.get(i))[1] + "\t" + ((String[]) arrl.get(i))[2] + "\t" + ((String[]) arrl.get(i))[3]);
        }
        // Temporales(arrl);
    }

    public static ArrayList Temporales(ArrayList cuad) {

        System.out.println("Cuadruples Temporales");
        System.out.println("-------------------");
        String vector[];
        ArrayList temp = new ArrayList();
        for (int i = 0; i < cuad.size(); i++) {
            if (((((String[]) cuad.get(i))[3]).charAt(0) + "").equals("T") || ((((String[]) cuad.get(i))[2]).charAt(0) + "").equals("=")) {
                temp.add(cuad.get(i));
                vector = (String[]) cuad.get(i);
                System.out.println(vector[0] + "\t" + vector[1] + "\t" + vector[2] + "\t" + vector[3]);
            } else {
                break;
            }
        }
        expcomunes(cuad);
        return cuad;

    }

    public static ArrayList Optimizar(ArrayList cuad) {
        do {
            op = false;
            cuad = expcomunes(cuad);
            cuad = eExpre(cuad);
            cuad = pCopias(cuad);
            cuad = transAl(cuad);
            cuad = redFuer(cuad);
        } while (op != false);
        return cuad;
    }

    
    /*¿Cómo resolver :c*/
    public static ArrayList expcomunes(ArrayList cuad) {
        //op=false;
        String valoran = "";
        String valornue = "";

        for (int i = 0; i < cuad.size() - 1; i++) {
            for (int j = i + 1; j < cuad.size() - 1; j++) {
                if (((String[]) cuad.get(i))[0].equals(((String[]) cuad.get(j))[0])
                        && ((String[]) cuad.get(i))[1].equals(((String[]) cuad.get(j))[1])
                        && ((String[]) cuad.get(i))[2].equals(((String[]) cuad.get(j))[2])) {
                    valoran = ((String[]) cuad.get(j))[3];
                    valornue = ((String[]) cuad.get(i))[3];
                    cuad.remove(j);
                    sustituir(cuad, valoran, valornue);
                }
            }
        }

        return cuad;
    }

    public static ArrayList sustituir(ArrayList cuad, String valoran, String valornue) {
        String vector[];
        for (int k = 0; k < cuad.size(); k++) {
            if (((String[]) cuad.get(k))[0].equals(valoran)) {
                op = true;
                vector = (String[]) cuad.get(k);
                vector[0] = valornue;
                cuad.set(k, vector);
            }
            if (((String[]) cuad.get(k))[1].equals(valoran)) {
                op = true;
                vector = (String[]) cuad.get(k);
                vector[1] = valornue;
                cuad.set(k, vector);
            }
        }
        return cuad;
    }

    public static ArrayList eExpre(ArrayList cuad) {

        String vector[];
        boolean entero1 = false;
        boolean entero2 = false;
        boolean double1 = false;
        boolean double2 = false;
        double num1Dou = 0;
        double num2Dou = 0;
        int num1Int = 0;
        int num2Int = 0;

        for (int i = 0; i < cuad.size(); i++) {
            // System.out.println("tamaño cuad " + cuad.size());
           // vector = new String[4];
            vector = (String[]) cuad.get(i);

            try {
                num1Int = Integer.parseInt(vector[0]);
                entero1 = true;
                //System.out.println("Número 1 entero");
            } catch (NumberFormatException e) {
                try {
                    num1Dou = Double.parseDouble(vector[0]);
                    entero1 = false;
                    double1 = true;
                    // System.out.println("Número 1 double");
                } catch (NumberFormatException b) {
                    // System.out.println("No num 1");
                    entero1 = false;
                    double1 = false;
                }

            }

            try {
                num2Int = Integer.parseInt(vector[1]);
                entero2 = true;
                //System.out.println("Número 2 entero");
            } catch (NumberFormatException e) {
                try {
                    num2Dou = Double.parseDouble(vector[1]);
                    entero2 = false;
                    double2 = true;
                    // System.out.println("Número 2 double");
                } catch (NumberFormatException b) {
                    entero2 = false;
                    double2 = false;
                    //System.out.println("No num 2");
                }

            }

            if (entero1 == true && entero2 == true) {
                op = true;
                // System.out.println("aqui 4");
                if (vector[2].equals("+")) {
                    num1Int = (num1Int) + (num2Int);
                }
                if (vector[2].equals("-")) {
                    num1Int = (num1Int) - (num2Int);

                }
                if (vector[2].equals("*")) {
                    num1Int = num1Int * num2Int;
                }
                if (vector[2].equals("/")) {
                    num1Int = num1Int / num2Int;
                }
                vector[0] = vector[3];
                vector[1] = num1Int + "";
                vector[2] = "=";
                vector[3] = "";
                cuad.set(i, vector);
            } else {
                if (entero1 == true && double2 == true) {
                    op = true;
                    // System.out.println("aqui 3");
                    if (vector[2].equals("+")) {
                        num2Dou = num1Int + num2Dou;
                    }
                    if (vector[2].equals("-")) {
                        num2Dou = num1Int - num2Dou;

                    }
                    if (vector[2].equals("*")) {
                        num2Dou = num1Int * num2Dou;
                    }
                    if (vector[2].equals("/")) {
                        num2Dou = num1Int / num2Dou;
                    }
                    vector[0] = vector[3];
                    vector[1] = num2Dou + "";
                    vector[2] = "=";
                    vector[3] = "";
                    cuad.set(i, vector);
                } else {
                    if (double1 == true && entero2 == true) {
                        op = true;
                        //  System.out.println("aquí 2");
                        if (vector[2].equals("+")) {
                            num1Dou = num1Dou + num2Int;
                        }
                        if (vector[2].equals("-")) {
                            num1Dou = num1Dou - num2Int;

                        }
                        if (vector[2].equals("*")) {
                            num1Dou = num1Dou * num2Int;
                        }
                        if (vector[2].equals("/")) {
                            num1Dou = num1Dou / num2Int;
                        }
                        vector[0] = vector[3];
                        vector[1] = num1Dou + "";
                        vector[2] = "=";
                        vector[3] = "";
                        cuad.set(i, vector);
                    } else {
                        if (double1 == true && double2 == true) {
                            op = true;
                            // System.out.println("aquí");
                            if (vector[2].equals("+")) {
                                num1Dou = num1Dou + num2Dou;
                            }
                            if (vector[2].equals("-")) {
                                num1Dou = num1Dou - num2Dou;

                            }
                            if (vector[2].equals("*")) {
                                num1Dou = (num1Dou) * (num2Dou);
                                System.out.println("num " + num1Dou);
                            }
                            if (vector[2].equals("/")) {
                                num1Dou = num1Dou / num2Dou;
                            }
                            vector[0] = vector[3];
                            vector[1] = num1Dou + "";
                            vector[2] = "=";
                            vector[3] = "";
                            cuad.set(i, vector);
                        }
                    }
                }
            }
        }
        return cuad;
    }

    public static ArrayList pCopias(ArrayList cuad) {
        String valorn = "";
        String reem = "";
        String vector[];
        for (int i = 0; i < cuad.size(); i++) {
            if (((String[]) cuad.get(i))[3].equals("") && ((String[]) cuad.get(i))[2].equals("=")) {
                valorn = ((String[]) cuad.get(i))[1];
                reem = ((String[]) cuad.get(i))[0];
                cuad.remove(i);
                for (int j = 0; j < cuad.size(); j++) {
                    if (((String[]) cuad.get(j))[1].equals(reem)) {
                        op = true;
                        vector = (String[]) cuad.get(j);
                        vector[1] = valorn;
                        cuad.set(j, vector);
                    }
                    if (((String[]) cuad.get(j))[0].equals(reem)) {
                        op = true;
                        vector = (String[]) cuad.get(j);
                        vector[0] = valorn;
                        cuad.set(j, vector);
                    }
                }
            }
        }
        return cuad;
    }

    public static ArrayList transAl(ArrayList cuad) {
        String vector[];
        for (int i = 0; i < cuad.size(); i++) {
            if ((((String[]) cuad.get(i))[0].equals("0") && ((String[]) cuad.get(i))[2].equals("+"))
                    || (((String[]) cuad.get(i))[0].equals("1") && ((String[]) cuad.get(i))[2].equals("*"))) {
                op = true;
                vector = (String[]) cuad.get(i);
                vector[0] = vector[3];
                vector[2] = "=";
                vector[3] = "";
                cuad.set(i, vector);
            }
            if ((((String[]) cuad.get(i))[1].equals("0") && (((String[]) cuad.get(i))[2].equals("+") || ((String[]) cuad.get(i))[2].equals("-")))
                    || (((String[]) cuad.get(i))[1].equals("1") && ((String[]) cuad.get(i))[2].equals("*"))
                    || (((String[]) cuad.get(i))[1].equals("1") && ((String[]) cuad.get(i))[2].equals("/"))) {
                op = true;
                vector = (String[]) cuad.get(i);
                vector[1] = vector[0];
                vector[0] = vector[3];
                vector[2] = "=";
                vector[3] = "";
                cuad.set(i, vector);
            }
            if ((((String[]) cuad.get(i))[0].equals("0") && ((String[]) cuad.get(i))[2].equals("*")) || (((String[]) cuad.get(i))[1].equals("0") && ((String[]) cuad.get(i))[2].equals("*")) || (((String[]) cuad.get(i))[0].equals("0") && ((String[]) cuad.get(i))[2].equals("/"))) {
                op = true;
                vector = (String[]) cuad.get(i);
                vector[0] = vector[3];
                vector[1] = "0";
                vector[2] = "=";
                vector[3] = "";
                cuad.set(i, vector);
            }
        }
        return cuad;
    }

    public static ArrayList redFuer(ArrayList cuad) {
        // op=false;
        String vector[];
        for (int i = 0; i < cuad.size(); i++) {
            if (((String[]) cuad.get(i))[0].equals("2") && ((String[]) cuad.get(i))[2].equals("*")) {
                op = true;
                vector = (String[]) cuad.get(i);
                vector[0] = vector[1];
                vector[2] = "+";
                cuad.set(i, vector);

            }
            if (((String[]) cuad.get(i))[1].equals("2") && ((String[]) cuad.get(i))[2].equals("*")) {
                op = true;
                vector = (String[]) cuad.get(i);
                vector[1] = vector[0];
                vector[2] = "+";
                cuad.set(i, vector);
            }
        }
        return cuad;
    }

    public static ArrayList empTemp(ArrayList cuad) {
        int numT = 1;
        String temporales = "T" + numT;
        String ant = "";
        String vector[];
        for (int i = 0; i < cuad.size(); i++) {
            if (i == 0) {
                ant = ((String[]) cuad.get(i))[3];
                vector = (String[]) cuad.get(i);
                vector[3] = temporales;
                cuad.set(i, vector);
                
            } else {
                if (((String[]) cuad.get(i))[0].equals(ant) || ((String[]) cuad.get(i))[1].equals(ant)) {
                    if (((String[]) cuad.get(i))[0].equals(ant) && ((String[]) cuad.get(i))[1].equals(ant)) {
                        ant = ((String[]) cuad.get(i))[3];
                        vector = (String[]) cuad.get(i);
                        vector[3] = temporales;
                        vector[1] = temporales;
                        vector[0] = temporales;
                        cuad.set(i, vector);
                    } else {
                        if (((String[]) cuad.get(i))[0].equals(ant)) {
                            ant = ((String[]) cuad.get(i))[3];
                            vector = (String[]) cuad.get(i);
                            vector[3] = temporales;
                            vector[0] = temporales;
                            cuad.set(i, vector);
                        }
                        if (((String[]) cuad.get(i))[1].equals(ant)) {
                            ant = ((String[]) cuad.get(i))[3];
                            vector = (String[]) cuad.get(i);
                            vector[3] = temporales;
                            vector[1] = temporales;
                            cuad.set(i, vector);

                        }
                    }
                }
            }
        }

        return cuad;
    }

}

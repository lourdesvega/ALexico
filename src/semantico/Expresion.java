/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;


//*************************************POSTFIJO************************
/**
 *
 * @author barcl
 */
public class Expresion {

    static String[][] prioridades = {
        {"1", "("}, // 1
        {"1", ")"}, // 2
        {"2", "*"}, // 3
        {"2", "/"}, // 4
        {"3", "+"}, // 5 
        {"3", "-"}, // 6
        {"4", "<"}, // 7
        {"4", ">"}, // 8
        {"4", "<="}, // 9
        {"4", ">="}, // 10
        {"4", "=="}, // 11
        {"4", "!="}, // 12
        {"5", "&&"}, // 13
        {"5", "||"}, // 14
        {"6", "="}, // 15
    };
    
    static String[] exp = {"z", "=", "a", ">", "b", "&&", "b", "<", "(", "5", "+", "4", "*", "c", "/", "d", ")"};
    static String[] expT = {"z1", "T15", "a1", "T8", "b1", "T13", "b1", "T7", "(1", "51", "T5", "41", "T3", "c1", "T4" , "d1", ")1"};

    public static void main(String[] args) {
        PilasE p1[] = postfijo(exp, expT);
        mostrarPila1(p1[0]);
        System.out.println("**************************");
        mostrarPila1(p1[1]);
    }

    public static PilasE[] postfijo(String exp[], String expT[]) {
        int num = exp.length;
        PilasE pila1 = new PilasE(num);
        PilasE pila2 = new PilasE(num);
        PilasE pilaT1 = new PilasE(num);
        PilasE pilaT2 = new PilasE(num);
        // R E C O R R E R . A R R E G L O
        for (int i = 0; i < exp.length; i++) {
            // O M I T I R . E S P A C I O S
            if (!(exp[i].equals(" "))) {
                // S I M B O L O S
                if (validar(exp[i])) {
                    String valorExp = valorDePrioridad(exp[i]);
                    int numPrioridad = numeroDePrioridad(exp[i]);
                    System.out.println("");
                    System.out.println("Simbolo " + valorExp + " con prioridad " + numPrioridad);
                    // P I L A . 2 . V A C Í A
                    if (valorExp.equals(")")) {
                        parentesis(pila1, pila2, pilaT1, pilaT2);
                    } else if (pila2.getTope() != -1) {
                        // P R I O R I D A D E S . D E . S Í M B O L O S
                        for (int j = 0; j < pila2.getTope(); j++) {
                            pila2Prio(pila1, pila2, numPrioridad, valorExp, pilaT1, pilaT2);
                        }
                        // S E . I N S E R T A . D E . P I L A . 2
                        System.out.println(valorExp + " " + pila2.inserta(valorExp) + " y " + expT[i] + " " + pilaT2.inserta(expT[i]) + " en pila 2.");
                    } else {
                        // S E . I N S E R T A . D E . P I L A . 2
                        System.out.println(valorExp + " " + pila2.inserta(valorExp) + " y " + expT[i] + " " + pilaT2.inserta(expT[i]) + " en pila 2.");
                    }
                }
                // V A R I A B L E S
                else {
                    System.out.println("");
                    System.out.println(exp[i] + " " + pila1.inserta(exp[i]) + " y " + expT[i] + " " + pilaT1.inserta(expT[i]) + " en pila 1.");
                }
            }
        }
        System.out.println("\nR E S U L T A D O");
        vaciarPila2aPila1(pila2, pila1);
        vaciarPila2aPila1(pilaT2, pilaT1);
        PilasE pilaR[] = new PilasE[2];
        pilaR[0] = pila1;
        pilaR[1] = pilaT1;
        System.out.println("------------------------------------------Expresionhsdkjdfsjhjdfssafsdfhahjhjdfshsdfffffffahjdfshjdfs");
        for(int i=0;i<exp.length;i++){
            System.out.print(exp[i]);
        }
        
        return pilaR;
    }

    public static void parentesis(PilasE pila1, PilasE pila2, PilasE pilaT1, PilasE pilaT2) {
        int tope = pila2.getTope();
        for (int i = 0; i <= tope; i++) {
            Object simbolo = pila2.eliminar();
            Object simboloT = pilaT2.eliminar();
            System.out.println(simbolo + " y " + simboloT + " se sacó de pila 2");
            if (simbolo.equals(")")) {
                break;
            } else {
                System.out.println(simbolo + " " + pila1.inserta(simbolo) + " y " + simboloT + " " + pilaT1.inserta(simboloT) + " se insertó en pila 1");
            }
        }
    }

    public static int numeroDePrioridad(String operador) {
        int prioridad = 0;
        for (int i = 0; i < prioridades.length; i++) {
            if (operador.equals(prioridades[i][1])) {
                prioridad = Integer.parseInt(prioridades[i][0]);
                break;
            }
        }
        return prioridad;
    }

    public static String valorDePrioridad(String operador) {
        String prioridad = "";
        for (int i = 0; i < prioridades.length; i++) {
            if (operador.equals(prioridades[i][1])) {
                prioridad = prioridades[i][1];
                break;
            }
        }
        return prioridad;
    }

    public static boolean validar(String operador) {
        boolean band = false;
        for (int i = 0; i < prioridades.length; i++) {
            if (prioridades[i][1].equals(operador)) {
                band = true;
                break;
            }
        }
        return band;
    }

    public static void pila2Prio(PilasE pila1, PilasE pila2, int numPrioridad, String valorExp, PilasE pilaT1, PilasE pilaT2) {
        Object[] valorPila = pila2.getP();
        String valPrioPila = valorPila[pila2.getTope()].toString();
        int numPrioPila = numeroDePrioridad(valPrioPila);
        System.out.println("Pila 2 tiene " + valPrioPila + " con prioridad " + numPrioPila);
        if (numPrioridad >= numPrioPila) {
            // S E . S A C A . D E . P I L A . 2
            Object eliminado = pila2.eliminar();
            Object eliminadoT = pilaT2.eliminar();
            System.out.println(eliminado + " y " + eliminadoT + " se saca de pila 2.");
            if( !(eliminado.equals("(")) ) {
                // S E . I N S E R T A . E N . P I L A . 1
                System.out.println(eliminado + " " + pila1.inserta(eliminado) + " y " + eliminadoT + " " + pilaT1.inserta(eliminadoT) + " en pila 1.");
            }
        }
    }

    public static void vaciarPila2aPila1(PilasE pila2, PilasE pila1) {
        int tope = pila2.getTope();
        for (int i = 0; i <= tope; i++) {
            Object eliminado = pila2.eliminar();
            System.out.println(eliminado + " sacado de Pila 2");
            if( !(eliminado.equals("(")) ) {
                System.out.println(eliminado + " " + pila1.inserta(eliminado) + " en Pila 1");
            }
        }
    }

    public static void mostrarPila1(PilasE pila1) {
        int tope = pila1.getTope();
        for (int i = 0; i <= tope; i++) {
            System.out.println(pila1.eliminar());
        }
    }
}
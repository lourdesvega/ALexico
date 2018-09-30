/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

/**
 *
 * @author barcl
 */
public class VariablesYOperadores {

   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    public static String tipoOperadores[][]
            = {
                //OPERADORES ARITMETICOS
                {"+", "aritmetico"},
                {"-", "aritmetico"},
                {"*", "aritmetico"},
                {"/", "aritmetico"},
                //{"%", "aritmetico"},
                //{"**", "aritmetico"},

                //OPERADORES LÓGICOS
                {"&&", "logico"},
                {"||", "logico"},
                //OPERADORES RELACIONALES
                {">", "relacional"},
                {"<", "relacional"},
                {">=", "relacional"},
                {"<=", "relacional"},
                {"!=", "relacional"},
                {"==", "relacional"},
                //ASIGNACIÓN
                {"=", "asignacion"}
            };

    public static String asigna_entero[][] = {
                {"Entero", "T51", "Correcto"},
                {"Entero", "T52", "Error", "Tipos incompatibles en '=' (Flotante a un Entero)"},
                {"Entero", "T53", "Error", "Tipos incompatibles en '=' (Cadena a un Entero)"},
                {"Entero", "Booleano", "Error", "Tipos incompatibles en '=' (Booleano a un Entero)"},
                {"Entero", "T55", "Error", "Tipos incompatibles en '=' (Caracter a Entero)"}
            };

    public static String asigna_flotante[][] = {
                {"Flotante", "T51", "Correcto"},
                {"Flotante", "T52", "Correcto"},
                {"Flotante", "T53", "Error", "Tipos incompatibles en '=' (Cadena a un Flotante)"},
                {"Flotante", "Booleano", "Error", "Tipos incompatibles en '=' (Booleano a un Flotante)"},
                {"Flotante", "T55", "Error", "Tipos incompatibles en '=' (Caracter a un Flotante)"}
            };

    public static String asigna_cadena[][] = {
                {"Cadena", "T51", "Error", "Tipos incompatibles en '=' (Entero a una Cadena)"},
                {"Cadena", "T52", "Error", "Tipos incompatibles en '=' (Flotante a una Cadena)"},
                {"Cadena", "T53", "Correcto"},
                {"Cadena", "Booleano", "Error", "Tipos incompatibles en '=' (Booleano a una Cadena)"},
                {"Cadena", "T55", "Error", "Tipos incompatibles en '=' (Caracter a una Cadena)"}
            };

    public static String asigna_booleano[][] = {
                {"Booleano", "T51", "Error", "Tipos incompatibles en '=' (Entero a un Booleano)"},
                {"Booleano", "T52", "Error", "Tipos incompatibles en '=' (Flotante a un Booleano)"},
                {"Booleano", "T53", "Error", "Tipos incompatibles en '=' (Cadena a un Booleano)"},
                {"Booleano", "Booleano", "Correcto"},
                {"Booleano", "T55", "Error", "Tipos incompatibles en '=' (Caracter a un Booleano)"}
            };

    public static String asigna_caracter[][] = {
                {"Caracter", "T51", "Error", "Tipos incompatibles en '=' (Entero a un Caracter)"},
                {"Caracter", "T52", "Error", "Tipos incompatibles en '=' (Flotante a un Caracter)"},
                {"Caracter", "T53", "Error", "Tipos incompatibles en '=' (Cadena a un Caracter)"},
                {"Caracter", "Booleano", "Error", "Tipos incompatibles en '=' (Booleano a un Caracter)"},
                {"Caracter", "T55", "Correcto"}
            };

    public static void main(String[] args) {
        // Valores entrantes.
        String variable1 = "T51", variable2 = "T51", operador = "=", v1 = "3", v2 = "2";
        // Categorizar operador entrante.
        String a[]=tipoDeVariablesYOperador(variable1, variable2, operador, v1, v2);
        System.out.println(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        
        for (int i = 0; i < 10; i++)
        {
           
            for (int j = 0; j < 10; j++)
            {
                int aaa;
                
            }
             int aaa;
            
        }
    

    }

    public static String[] tipoDeVariablesYOperador(String variable1, String variable2, String operador, String v1, String v2) {
        //TIPO DE OPERADOR
        String tpd = "";
        for (int i = 0; i < tipoOperadores.length; i++) {
            if (tipoOperadores[i][0].equals(operador)) {
                tpd = tipoOperadores[i][1];
                break;
            } else {
                tpd = "Error";
            }
        }
        //EXPRESIÓN
        String resultado[] = new String[3];
         resultado[2] ="";
        if (!(tpd.equals("Error"))) {
            resultado = expresion(variable1, variable2, tpd, operador, v1, v2);
            System.out.println(resultado[0]);
            System.out.println(resultado[1]);
        } else {
            resultado[0] = "Error";
            resultado[1] = "Error de filtro por tipo de operador";
            resultado[2] = "Error de tipo";

            System.out.println(resultado[0]);
            System.out.println(resultado[1]);
        }
        return resultado;
    }

    public static String[] expresion(String variable1, String variable2, String tipoOperador, String operador, String v1, String v2) {
        String ret[];
        switch (tipoOperador) {
            case "aritmetico":
                switch (variable1) {
                    case "T51":
                        ret = EnteroOA(operador, variable2, v1, v2);
                        break;
                    case "T52":
                       ret = FlotanteOA(operador, variable2, v1, v2);
                        break;
                    case "T53":
                        ret = CadenaOA(operador, variable2, v1, v2);
                        break;
                    case "Booleano":
                        ret = BooleanoOA(operador, variable2, v1, v2);
                        break;
                    case "T55":
                       ret = CaracterOA(operador, variable2, v1, v2);
                        break;
                    default:
                        ret = new String[2];
                        ret[0] = "Error";
                        ret[1] = "Tipo de variable no encontrado (" + variable1 + ")";
                        break;
                }
                break;
            case "logico":
                switch (variable1) {
                    case "T51":
                        ret = EnteroOL(operador, variable2, v1, v2);
                        break;
                    case "T52":
                        ret = FlotanteOL(operador, variable2, v1, v2);
                        break;
                    case "T53":
                        ret = CadenaOL(operador, variable2, v1, v2);
                        break;
                    case "Booleano":
                        ret = BooleanoOL(operador, variable2, v1, v2);
                        break;
                    case "T55":
                       ret = CaracterOL(operador, variable2, v1, v2);
                        break;
                    default:
                        ret = new String[2];
                        ret[0] = "Error";
                        ret[1] = "Tipo de variable no encontrado (" + variable1 + ")";
                        break;
                }
                break;
            case "relacional":
                switch (variable1) {
                    case "T51":
                        ret = EnteroOR(operador, variable2, v1, v2);
                        break;
                    case "T52":
                       ret = FlotanteOR(operador, variable2, v1, v2);
                        break;
                    case "T53":
                       ret = CadenaOR(operador, variable2, v1, v2);
                        break;
                    case "Booleano":
                       ret = BooleanoOR(operador, variable2, v1, v2);
                        break;
                    case "T55":
                        ret = CaracterOR(operador, variable2, v1, v2);
                        break;
                    default:
                        ret = new String[2];
                        ret[0] = "Error";
                        ret[1] = "Tipo de variable no encontrado (" + variable1 + ")";
                        break;
                }
                break;
            case "asignacion":
                ret = new String[2];
                switch (variable1) {
                    case "T51":
                        for (int i = 0; i < asigna_entero.length; i++) {
                            if (asigna_entero[i][1].equals(variable2)) {
                                ret[0] = asigna_entero[i][2];
                                if (ret[0].equals("Error")) {
                                    ret[1] = asigna_entero[i][3];
                                } else {
                                    ret[1] = v2;
                                }
                                break;
                            }
                        }
                        break;
                    case "T52":
                        for (int i = 0; i < asigna_flotante.length; i++) {
                            if (asigna_flotante[i][1].equals(variable2)) {
                                ret[0] = asigna_flotante[i][2];
                                if (ret[0].equals("Error")) {
                                    ret[1] = asigna_flotante[i][3];
                                } else {
                                    ret[1] = v2;
                                }
                                break;
                            }
                        }
                        break;
                    case "T53":
                        for (int i = 0; i < asigna_cadena.length; i++) {
                            if (asigna_cadena[i][1].equals(variable2)) {
                                ret[0] = asigna_cadena[i][2];
                                if (ret[0].equals("Error")) {
                                    ret[1] = asigna_cadena[i][3];
                                } else {
                                    ret[1] = v2;
                                }
                                break;
                            }
                        }
                        break;
                    case "Booleano":
                        for (int i = 0; i < asigna_booleano.length; i++) {
                            if (asigna_booleano[i][1].equals(variable2)) {
                                ret[0] = asigna_booleano[i][2];
                                if (ret[0].equals("Error")) {
                                    ret[1] = asigna_booleano[i][3];
                                } else {
                                    ret[1] = v2;
                                }
                                break;
                            }
                        }
                        break;
                    case "T55":
                        for (int i = 0; i < asigna_caracter.length; i++) {
                            if (asigna_caracter[i][1].equals(variable2)) {
                                ret[0] = asigna_caracter[i][2];
                                if (ret[0].equals("Error")) {
                                    ret[1] = asigna_caracter[i][3];
                                } else {
                                    ret[1] = v2;
                                }
                                break;
                            }
                        }
                        break;
                    default:
                        ret = new String[2];
                        ret[0] = "Error";
                        ret[1] = "Tipo de variable no encontrado (" + variable1 + ")";
                        break;
                }
                break;
            default:
                ret = new String[2];
                ret[0] = "Error";
                ret[1] = "Tipo de perador no encontrado (" + tipoOperador + ")";
                break;
        }
        return ret;
    }

    // ***************** OPERADORES ARITMETICOS ******************************//
    // ***************** OPERADORES ARITMETICOS ******************************//
    // ***************** OPERADORES ARITMETICOS ******************************//
    public static String[] EnteroOA(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("+"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T51";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) + (Integer.parseInt(v2)));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "";// + ((Integer.parseInt(v1)) + (Float.parseFloat(v2)));
                        break;
                    case ("T53"):
                        result[0] = "T53";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) + v2);
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("-"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T51";
                        result[1] = "";// + ((Integer.parseInt(v1)) - (Integer.parseInt(v2)));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) - (Float.parseFloat(v2)));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("*"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T51";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) * (Integer.parseInt(v2)));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) * (Float.parseFloat(v2)));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("/"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T52";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) / (Integer.parseInt(v2)));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" ;//+ ((Integer.parseInt(v1)) / (Float.parseFloat(v2)));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] FlotanteOA(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("+"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T52";
                        result[1] = "";// + (Float.parseFloat(v1) + Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" + (Float.parseFloat(v1) + Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("-"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T52";
                        result[1] = "" + (Float.parseFloat(v1) - Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" + (Float.parseFloat(v1) - Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Flotante y Cadena)";;
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("*"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T52";
                        result[1] = "";// + (Float.parseFloat(v1) * Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "";// + (Float.parseFloat(v1) * Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("/"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T52";
                        result[1] = "" + (Float.parseFloat(v1) / Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "T52";
                        result[1] = "" + (Float.parseFloat(v1) / Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CadenaOA(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("+"):
                switch (val) {
                    case ("T51"):
                        result[0] = "T53";
                        result[1] = "";// + (v1 + Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "T53";
                        result[1] = "";// + (v1 + Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "T53";
                        result[1] = "";// + (v1 + v2);
                        break;
                    case ("Booleano"):
                        result[0] = "T53";
                        result[1] = "";// + (v1 + v2);
                        break;
                    case ("T55"):
                        result[0] = "T51";
                        result[1] = "";// + (v1 + v2);
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("-"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("*"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("/"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] BooleanoOA(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("+"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("-"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("*"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("/"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CaracterOA(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("+"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "T53";
                        result[1] = "" + (v1 + v2);
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '+' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "T55";
                        result[1] = ""  ;//(v1.codePointAt(0) + v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("-"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '-' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "T55";
                        result[1] = "" ;//+ (v1.codePointAt(0) + v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("*"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '*' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "T55";
                        result[1] = "" ;//+ (v1.codePointAt(0) + v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("/"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '/' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "T55";
                        result[1] = "";// + (v1.codePointAt(0) + v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    // ******************* OPERADORES LÓGICOS ********************************//
    // ******************* OPERADORES LÓGICOS ********************************//
    // ******************* OPERADORES LÓGICOS ********************************//
    public static String[] EnteroOL(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("&&"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Entero y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Entero y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("||"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Entero y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Entero y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Entero y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error de Operador";
                break;
        }
        return result;
    }

    public static String[] FlotanteOL(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("&&"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Flotante y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Flotante y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("||"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Flotante y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Flotante y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Flotante y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CadenaOL(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("&&"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("||"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] BooleanoOL(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("&&"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Booleano";
                        if (v1.equals("true") && v2.equals("true")) {
                            result[1] = "true";
                        } else {
                            result[1] = "false";
                        }
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("||"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Booleano";
                        if (v1.equals("true") || v2.equals("true")) {
                            result[1] = "true";
                        } else {
                            result[1] = "false";
                        }
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CaracterOL(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("&&"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '&&' (Caracter y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("||"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Caracter y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Caracter y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '||' (Caracter y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    // ****************** OPERADORES RELACIONALES ****************************//
    // ****************** OPERADORES RELACIONALES ****************************//
    // ****************** OPERADORES RELACIONALES ****************************//
    public static String[] EnteroOR(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("<"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = ""  ;//(Integer.parseInt(v1) < Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) < Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) < v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) > Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) > Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) > v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("<="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) <= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) <= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) <= v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) >= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) >= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) >= v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("!="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) != Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) != Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) != v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("=="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Integer.parseInt(v1) == Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) == Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Entero y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Entero y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Integer.parseInt(v1) == v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] FlotanteOR(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("<"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) < Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Float.parseFloat(v1) < Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) < v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) > Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) > Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) > v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("<="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) <= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) <= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Float.parseFloat(v1) < v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) >= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) >= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) >= v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("!="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) != Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Float.parseFloat(v1) != Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) != v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("=="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (Float.parseFloat(v1) == Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) == Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Flotante y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Flotante y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (Float.parseFloat(v1) == v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CadenaOR(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("<"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("<="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("!="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("=="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Cadena y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Cadena y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Cadena y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Cadena y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Cadena y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] BooleanoOR(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("<"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("<="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Booleano y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("!="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Booleano";
                        result[1] = "" + (v1.equals(v2));
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("=="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Booleano y Entero)";
                        break;
                    case ("T52"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Booleano y Flotante)";
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Booleano y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Booleano";
                        result[1] = "" + (v1.equals(v2));
                        break;
                    case ("T55"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Booleano y Caracter)";
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }

    public static String[] CaracterOR(String ope, String val, String v1, String v2) {
        String result[] = new String[2];
        switch (ope) {
            case ("<"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "" ;// (v1.codePointAt(0) < Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (v1.codePointAt(0) < Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "" ;//+ (v1.codePointAt(0) < v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">"):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) > Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) > Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) < v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("<="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) <= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) <= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '<=' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) <= v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case (">="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) >= Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) >= Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '>=' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) >= v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("!="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) != Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) != Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '!=' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) != v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            case ("=="):
                switch (val) {
                    case ("T51"):
                        result[0] = "Booleano";
                        result[1] = "";//+ (v1.codePointAt(0) == Integer.parseInt(v2));
                        break;
                    case ("T52"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) == Float.parseFloat(v2));
                        break;
                    case ("T53"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Caracter y Cadena)";
                        break;
                    case ("Booleano"):
                        result[0] = "Error";
                        result[1] = "Tipo de operando incorrecto para '==' (Caracter y Booleano)";
                        break;
                    case ("T55"):
                        result[0] = "Booleano";
                        result[1] = "";// + (v1.codePointAt(0) == v2.codePointAt(0));
                        break;
                    default:
                        result[0] = "Error";
                        result[1] = "Tipo de variable no encontrado (" + val + ")";
                        break;
                }
                break;
            default:
                result[0] = "Error";
                result[1] = "Operador no encontrado (" + ope + ")";
                break;
        }
        return result;
    }
} 


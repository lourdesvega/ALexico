/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JTextArea;

/**
 *
 * @author leo
 */
public class Matriz
{

    public Matriz()
    {
  
        this.matrizcompleta=Excel.cargarExcel("archivosExcel/matrizCompleta.xls");


        
    }
  
    public String matrizcompleta[][] =
    {

        {
            "l", "d", "ce", "_", ".", "\"", "#", "'", "Esdo", "Token"
        },
        {
            2 + "", 4 + "", "T106", "T106", "T106", 7 + "", 9 + "", 11 + "", 0 + "", "T106"
        },
        {
            2 + "", 2 + "", "T100", 3 + "", "T100", "T100", "T100", "T100", 1 + "", "T50"
        },
        {
            2 + "", 2 + "", "T100", "T100", "T100", "T100", "T100", "T100", 1 + "", "T50"
        },
        {
            "T101", 4 + "", "T101", "T101", 5 + "", "T101", "T101", "T101", 1 + "", "T51"
        },
        {
            "T102", 6 + "", "T102", "T102", "T102", "T102", "T102", "T102", 0 + "", "T102"
        },
        {
            "T102", 6 + "", "T102", "T102", "T102", "T102", "T102", "T102", 1 + "", "T52"
        },
        {
            7 + "", 7 + "", 7 + "", "T103", "T103", 8 + "", "T103", "T103", 0 + "", "T103"
        },
        {
            "T103", "T103", "T103", "T103", "T103", "T103", "T103", "T103", 1 + "", "T53"
        },
        {
            9 + "", 9 + "", "T104", "T104", "T104", "T104", 10 + "", "T104", 0 + "", "T104"
        },
        {
            "T104", "T104", "T104", "T104", "T104", "T104", "T104", "T104", 1 + "", "T54"
        },
        {
            12 + "", 12 + "", "T105", "T105", "T105", "T105", "T105", "T105", 0 + "", "T32"
        },
        {
            "T105", "T105", "T105", "T105", "T105", "T105", "T105", 13 + "", 0 + "", "T105"
        },
        {
            "105", "T105", "T105", "T105", "T105", "T105", "T105", "T105", 1 + "", "T55"
        }
    };

    public String matriz_tipos_datos[][] =
    {
        {
            "T1", "Entero"
        },
        {
            "T1", "Flotante"
        },
        {
            "T1", "Cadena"
        },
        {
            "T1", "Booleano"
        },
        {
            "T1", "Caracter"
        }
    };
    public  String matriz_palabras_r[][] =
    {
        {
            "T11", "Imprimir"
        },
        {
            "T12", "Si"
        },
        {
            "T13", "Sino"
        },
        {
            "T14", "Para"
        },
        {
            "T15", "Mientras"
        },
        {
            "T16", "Llamar"
        },
        {
            "T17", "Entrada"
        },
        {
            "T18", "Caso"
        },
        {
            "T19", "Romper"
        },
        {
            "T20", "Clase"
        },
        {
            "T21", "Mayus"
        },
        {
            "T22", "Minus"
        },
        {
            "T23", "Metodo"
        }
//        {
//            "T24", "Minus"
//        },
//        {
//            "T25", "Metodo"
//        },
//        {
//            "T26", "Chr"
//        },
//        {
//            "T27", "Nuevo"
//        }

    };
    public String matriz_operadores_aritmeticos[][] =
    {
        {
            "T2", "+"
        },
        {
            "T2", "-"
        },
        {
            "T2", "*"
        },
        {
            "T2", "/"
        },
//        {
//            "T106", "%"
//        },
        {
            "T106", "**"
        }
    };
    public  String matriz_operadores_relacionales[][] =
    {
        {
            "T3", ">="
        },
        {
            "T3", "<="
        },
        {
            "T8", "="
        },
        {
            "T3", ">"
        },
        {
            "T3", "<"
        },
        {
            "T3", "!="
        },
        {
            "T3", "=="
        },
        {
            "T3", "+="
        },
        {
            "T25", "++"
        },
        {
            "T26", "--"
        }

    };
    public  String matriz_caracteres_especiales[][] =
    {
        {
            "T10", ","
        },
        {
            "T9", ";"
        },
        {
            "T24", "["
        },
        {
            "T24", "]"
        },
        {
            "T24", "@"
        },
        {
            "T24", "{"
        },
        {
            "T24", "}"
        },
        {
            "T24", "_"
        },
        {
            "T24", "&"
        },
        {
            "T24", "!"
        },
        {
            "T24", "$"
        },
        {
            "T24", "%"
        },
        {
            "T24", "¿"
        },
        {
            "T24", "?"
        },
        {
            "T24", "|"
        }

    };
    public  String matriz_operadores_logicos[][] =
    {

        {
            "T4", "&&"
        },
        {
            "T4", "||"
        },
        {
            "T106", "¬"
        },
        {
            "T106", "__"
        }

    };

    public  String matrizSeparadores[][] =
    {
        {
            " ", " "
        },
        {
            " ", "\t"
        },
        {
            " ", "\n"
        },
        {
            " ", "\r"
        },
        {
            "T5", "("
        },
        {
            "T6", ")"
        },
        {
            "T24", "["
        },
        {
            "T24", "]"
        },
        {
            "T7", ":"
        },        
        {
            "T8", "="
        },
        {
            "T2", "-"
        },
        {
            "T2", "*"
        },
        {
            "T2", "/"
        },
        {
            "T24", "%"
        },
        {
            "T9", ";"
        },
        {
            "T3", ">"
        },
        {
            "T3", "<"
        },
        {
            "T24", "!"
        },
        {
            "T24", "&"
        },
        {
            "T24", "|"
        },
        {
            "T2", "+"
        },
        {
            "T10", ","
        }
    };

    public  String[] crea(JTextArea a)
    {

        String texto = a.getText()+"\n"+"\n"+"\n";
        String cadena = "";

        if (texto.length() != 0)
        {

            int contador = texto.length();
            String tabla[] = null;
            char textoseparado[] = texto.toCharArray();
            String dato = "";
            for (int i = 0; i < contador; i++)
            {
                if (!("\"").equals(textoseparado[i] + "") && !("#").equals(textoseparado[i] + ""))
                {

                    if (separadores(textoseparado[i]))
                    {
//                        if(gdffashfdsghjf){
//                        
//                        //separador doble
//                        //inserta dato
//                        //inserta separador
//                    }

                        if (i != contador - 1)
                        {
                            cadena = "" + textoseparado[i] + textoseparado[i + 1];

                            switch (cadena)
                            {
                                case ("**"):

                                    i = i + 1;
                                    break;
                                case (">="):

                                    i = i + 1;
                                    break;
                                case ("<="):

                                    i = i + 1;
                                    break;
                                case ("!="):

                                    i = i + 1;
                                    break;
                                case ("=="):

                                    i = i + 1;
                                    break;
                                case ("&&"):

                                    i = i + 1;
                                    break;
                                case ("||"):

                                    i = i + 1;
                                    break;
                                case ("+="):

                                    i = i + 1;
                                    break;
                                    case ("++"):

                                    i = i + 1;
                                    break;
                                    case ("--"):

                                    i = i + 1;
                                    break;
                                default:
                                    cadena = textoseparado[i] + "";
                                    break;
                            }
                        }

                        if (!dato.equals(""))
                        {
                            tabla = Arreglos.inserta(tabla, dato);
                        }

                        if ((int) textoseparado[i] != (int) ' ')
                        {
                            tabla = Arreglos.inserta(tabla, cadena + "");
                        }
                        dato = "";

                    } else
                    {

                        dato += textoseparado[i];

                    }

                } else if (("\"").equals(textoseparado[i] + ""))
                {
                    try
                    {
                        dato += textoseparado[i];
                        do
                        {
                            i++;
                            dato += textoseparado[i];
                        } while (!("\"").equals(textoseparado[i] + "") && !("\n").equals(textoseparado[i] + ""));
                        tabla = Arreglos.inserta(tabla, dato);
                        dato = "";
                    } catch (Exception e)
                    {
                        tabla = Arreglos.inserta(tabla, dato);;
                        return tabla;
                    }
                } else if (("#").equals(textoseparado[i] + ""))
                {
                    try
                    {
                        dato += textoseparado[i];
                        do
                        {
                            i++;
                            dato += textoseparado[i];
                        } while (!("#").equals(textoseparado[i] + "") && !("\n").equals(textoseparado[i] + ""));
                        tabla = Arreglos.inserta(tabla, dato);
                        dato = "";
                    } catch (Exception e)
                    {
                        tabla = Arreglos.inserta(tabla, dato);
                        return tabla;
                    }

                }
            }

            return tabla;

        } else
        {

            return null;
        }

    }

    public  boolean separadores(char c)
    {
        boolean bandera = false;
        for (int i = 0; i < matrizSeparadores.length; i++)
        {

            if (matrizSeparadores[i][1].equals(c + ""))
            {
                bandera = true;
                break;
            }

        }

        return bandera;
    }

    public  String[][] token(String m[][])
    {

        for (int i = 0; i < m.length; i++)
        {
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matrizSeparadores, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matriz_caracteres_especiales, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matriz_operadores_aritmeticos, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matriz_operadores_logicos, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matriz_operadores_relacionales, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = comprueba(matriz_tipos_datos, m[i][0]);
            }
            if (m[i][1] == null)
            {

                m[i][1] = comprueba(matriz_palabras_r, m[i][0]);
            }
            if (m[i][1] == null)
            {
                m[i][1] = Automata.automata(matrizcompleta, m[i][0]);
            }

        }

        return m;
    }

    public  String comprueba(String ma[][], String cadena)
    {
        for (int i = 0; i < ma.length; i++)
        {
            if (cadena.equals(ma[i][1]))
            {
                return ma[i][0];
            }
        }
        return null;
    }

    public  boolean separadoresdobles(char c[], int a
    )
    {
        return false;
    }

    public  String[][] a(String t[][])
    {

        if (t != null)
        {

            for (int i = 0; i < t.length; i++)
            {

                if (t[i][1].equals("T28"))
                {

                    if (t[i][0].length() >= 15)
                    {

                        t[i][1] = "E1";

                    }
                    {

                    }

                }
                if (t[i][1].equals("T29"))
                {

                    if (t[i][0].length() >= 15)
                    {

                        t[i][1] = "E2";

                    }

                }

                if (t[i][1].equals("T30"))
                {

                    if (t[i][0].length() >= 30)
                    {

                        t[i][1] = "E2";

                    }

                }

                if (t[i][1].equals("T31"))
                {

                    if (t[i][0].length() >= 500)
                    {

                        t[i][1] = "E5";

                    }
                }

            }

        }

        return t;
    }
}

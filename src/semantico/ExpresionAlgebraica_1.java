/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author barcl
 */
public class ExpresionAlgebraica_1
{

    public static Object[] posL(String[] expr1, String[] expr12)
    {
        //Depurar la expresion algebraica

        depurar1(expr1, "");

        String[] arrayInfix = expr1;
        String[] arrayInfix2 = expr12;

        //Declaración de las pilas
        Stack< String> E = new Stack< String>(); //Pila entrada
        Stack< String> P = new Stack< String>(); //Pila temporal para operadores
        Stack< String> S = new Stack< String>(); //Pila salida

        Stack< String> E1 = new Stack< String>(); //Pila entrada
        Stack< String> P1 = new Stack< String>(); //Pila temporal para operadores
        Stack< String> S1 = new Stack< String>(); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--)
        {
            E.push(arrayInfix[i]);
            E1.push(arrayInfix2[i]);
        }

        try
        {
            //Algoritmo Infijo a Postfijo
            while (!E.isEmpty())
            {
                switch (pref(E.peek()))
                {
                    case 1:
                        P.push(E.pop());
                        P1.push(E1.pop());
                        break;

                    case 3:

                    case 4:
                        while (pref(P.peek()) >= pref(E.peek()))
                        {
                            S.push(P.pop());
                            S1.push(P1.pop());
                        }
                        P.push(E.pop());
                        P1.push(E1.pop());
                        break;

                    case 2:
                        while (!P.peek().equals("("))
                        {
                            S.push(P.pop());
                            S1.push(P1.pop());
                        }
                        P.pop();
                        P1.pop();
                        E.pop();
                        E1.pop();
                        break;

                    default:
                        S.push(E.pop());
                        S1.push(E1.pop());
                }
            }

            //Eliminacion de `impurezas´ en la expresiones algebraicas
            //String infix = expr.replace(" ", "");
            System.out.println(S.toString());
            System.out.println(S1.toString());

            String postfix = S.toString().replaceAll("[\\]\\[,]", "");
            String postfix1 = S1.toString().replaceAll("[\\]\\[,]", "");
         

            System.out.println(postfix);
            System.out.println(postfix1);
            Object resul[]= new Object[2];
            resul[0]=S;
            resul[1]=S1;


            return resul;
            //Mostrar resultados:
            //   System.out.println("Expresion Infija: " + infix);

        } catch (Exception ex)
        {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }
        return null;

    }

    public static String pos(String expr1, String expr12)
    {
        
          //System.out.println("------------------------------------------Expresionhsdkjdfsjhjdfssafsdfhahjhjdfshsdfffffffahjdfshjdfs");
        //System.out.println(expr1);
        //Depurar la expresion algebraica
        String expr = depurar(expr1, expr12);
        String expr11 = depurar(expr12, expr12);

        String[] arrayInfix = expr.split(" ");

        //Declaración de las pilas
        Stack< String> E = new Stack< String>(); //Pila entrada
        Stack< String> P = new Stack< String>(); //Pila temporal para operadores
        Stack< String> S = new Stack< String>(); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--)
        {
            E.push(arrayInfix[i]);
        }

        try
        {
            //Algoritmo Infijo a Postfijo
            while (!E.isEmpty())
            {
                switch (pref(E.peek()))
                {
                    case 1:
                        P.push(E.pop());
                        break;

                    case 3:

                    case 4:
                        while (pref(P.peek()) >= pref(E.peek()))
                        {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;

                    case 2:
                        while (!P.peek().equals("("))
                        {
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;

                    default:
                        S.push(E.pop());
                }
            }

            //Eliminacion de `impurezas´ en la expresiones algebraicas
            String infix = expr.replace(" ", "");
            System.out.println(S.toString());
            String postfix = S.toString().replaceAll("[\\]\\[,]", "");

            //Mostrar resultados:
            System.out.println("Expresion Infija: " + infix);
            System.out.println("Expresion Postfija: " + postfix);
            
            
            
            
            return postfix;
        } catch (Exception ex)
        {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }
        return null;

    }

    public static void main(String[] args)
    {
        //Entrada de datos
//        System.out.println(pos("a=a*9+(a-5)"));
        System.out.println("*Escribe una expresión algebraica: ");
        Scanner leer = new Scanner(System.in);

        //Depurar la expresion algebraica
        String expr = depurar(leer.nextLine(), "jaja");
        String[] arrayInfix = expr.split(" ");

        //Declaración de las pilas
        Stack< String> E = new Stack< String>(); //Pila entrada
        Stack< String> P = new Stack< String>(); //Pila temporal para operadores
        Stack< String> S = new Stack< String>(); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--)
        {
            E.push(arrayInfix[i]);
        }

        try
        {
            //Algoritmo Infijo a Postfijo
            while (!E.isEmpty())
            {
                switch (pref(E.peek()))
                {
                    case 1:
                        P.push(E.pop());
                        break;

                    case 3:

                    case 4:
                        while (pref(P.peek()) >= pref(E.peek()))
                        {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;

                    case 2:
                        while (!P.peek().equals("("))
                        {
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;

                    default:
                        S.push(E.pop());
                }
            }

            //Eliminacion de `impurezas´ en la expresiones algebraicas
            String infix = expr.replace(" ", "");
            String postfix = S.toString().replaceAll("[\\]\\[,]", "");

            //Mostrar resultados:
            System.out.println("Expresion Infija: " + infix);
            System.out.println("Expresion Postfija: " + postfix);

        } catch (Exception ex)
        {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }

        String s1[] =
        {
            "(", "", "a", "=", "1", "+", "5", ")"
        };
        depurar1(s1, expr);
        posL(s1, s1);
    }

    //Depurar expresión algebraica
    private static String depurar(String s, String s2)
    {
        s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        s = "(" + s + ")";
        String simbols = "+-*/()";
        String str = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++)
        {
            if (simbols.contains("" + s.charAt(i)))
            {

                str += " " + s.charAt(i) + " ";

            } else
            {
                str += s.charAt(i);
            }
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    private static String depurar1(String[] s, String s2)
    {
        // s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        //s = "(" + s + ")";
        String simbols = "+-*/()=";
        String str = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length; i++)
        {
            if (simbols.contains(s[i]))
            {

                str += " " + s[i] + " ";

            } else
            {
                str += s[i];
            }
        }
        return str;
    }

    //Jerarquia de los operadores
    private static int pref(String op)
    {
        int prf = 99;
        if (op.equals("^"))
        {
            prf = 5;
        }
        if (op.equals("*") || op.equals("/"))
        {
            prf = 4;
        }
        if (op.equals("+") || op.equals("-"))
        {
            prf = 3;
        }
        if (op.equals(")"))
        {
            prf = 2;
        }
        if (op.equals("("))
        {
            prf = 1;
        }
        if (op.equals("="))
        {
            prf = 1;
        }

        return prf;
    }

}

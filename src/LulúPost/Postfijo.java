/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LulúPost;

import CodigoIntermedio.Etiquetas;
import CodigoIntermedio.Intermedio;
import static LulúPost.TablaTemporales.tabla;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author lourd
 */
public class Postfijo
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        //Depurar la expresion algebraica
        //String expr = "((((a   *  b   *    c  /  d  +  a ) > ( b - c - d  ) ||( a -5 *3 ) > ( b -d * f) && b > f )))";
        //String expr="z=a+b/c-d*b+a-5.4*3";
        String expr[] =
        {
            "x", ">", "a", "||", "b", "<", "a"
        };
//String expr="z=a>b||b>c)||b<(5+4*c/d)";
        System.out.println(expr.length);
        //int a=1,b=2,c=3,d=4;
        //boolean z=((a>b||b>c)||b<(5+4*c/d));
        //System.out.println("valor de z :"+z); if(a<a||z<q)
        String[] post = postfijo(expr);
        ArrayList tab = new ArrayList();
        ArrayList ta = TablaTemporales.tabla(post, tab);
        String a = "";
        Etiquetas e=new Etiquetas();
        Intermedio.codigoCondicion(ta, a,e);

    }

    public static String[] postfijo(String[] expr)
    {
        String post[];
        //expr = "(" + expr + ")";
        //expr = depurar(expr);

        // Depurar la expresion algebraica
        String nuevo[] = new String[expr.length + 2];

        nuevo[0] = "(";
        nuevo[nuevo.length - 1] = ")";
        System.arraycopy(expr, 0, nuevo, 1, expr.length);

        String[] arrayInfix = nuevo;

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
                if (pref(E.peek()) == 7)
                {
                    P.push(E.pop());
                } else if (pref(E.peek()) == 6)
                {

                    while (!P.peek().equals("("))
                    {
                        S.push(P.pop());
                    }
                    P.pop();
                    E.pop();
                    if (P.empty() && !E.empty())
                    {
                        P.push(E.pop());
                    }

                } else if (pref(E.peek()) == 99)
                {
                    S.push(E.pop());
                } else
                {
                    if (pref(E.peek()) >= 1 && pref(E.peek()) <= 5)
                    {
                        if (P.peek().equals("("))
                        {
                            P.push(E.pop());
                        } else
                        {
                            while ((pref(E.peek()) <= pref(P.peek())) && !P.peek().equals("("))
                            {
                                S.push(P.pop());
                            }
                            P.push(E.pop());
                        }
                    }
                }

            }
            //Eliminacion de `impurezas´ en la expresiones algebraicas
            String infix = expr.toString();
            String postfix = S.toString().replaceAll("[\\]\\[,]", "");

            //Mostrar resultados:
            System.out.println("Expresion Infija: " + infix);
            System.out.println("Expresion Postfija: " + postfix);

        } catch (Exception ex)
        {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }
        post = new String[S.size()];
        for (int i = 0; i < S.size(); i++)
        {
            post[i] = S.get(i);
        }
        return post;
    }

    static String depurar(String s)
    {
        s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco        
        String[] simbolos
                =// "+-*/()&><=|";
                {
                    "(", ")", "*", "/", "+", "-", ">=", "<=", "==", ">", "<", "!=", "&&", "||", "="
                };
        String str = "";
        String simbolo;
        String simbols = "+-*/()|<>=&!";
        String caracter, caracteres = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++)
        {
            caracter = s.charAt(i) + "";
            if (i < s.length() - 1)
            {
                caracteres = s.charAt(i) + "" + s.charAt(i + 1) + "";
            }
            for (int j = 0; j < simbolos.length; j++)
            {
                simbolo = simbolos[j];
                if (simbols.contains("" + s.charAt(i)))
                {
                    if ((i < s.length() - 1) && (simbolo.equals(caracteres)))
                    {
                        str += " " + caracteres + " ";
                        i = i + 1;
                        j = simbolos.length;
                    } else
                    {
                        if (simbolo.equals(caracter))
                        {
                            str += " " + s.charAt(i) + " ";
                            j = simbolos.length;
                        }
                    }
                } else
                {
                    str += s.charAt(i);
                    j = simbolos.length;
                }
            }
        }
        //System.out.println(str);
        return str.replaceAll("\\s+", " ").trim();
    }

    public static int pref(String op)
    {
        int prf = 99;
        if (op.equals("="))
        {
            prf = 1;
        }
        if (op.equals("&&") || op.equals("||"))
        {
            prf = 2;
        }
        if (op.equals(">") || op.equals("<") || op.equals(">=") || op.equals("<=") || op.equals("==") || op.equals("1="))
        {
            prf = 3;
        }
        if (op.equals("+") || op.equals("-"))
        {
            prf = 4;
        }
        if (op.equals("*") || op.equals("/"))
        {
            prf = 5;
        }
        if (op.equals(")"))
        {
            prf = 6;
        }
        if (op.equals("("))
        {
            prf = 7;
        }
        return prf;
    }

}

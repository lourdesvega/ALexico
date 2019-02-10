/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensamblador;

import GUI.Interfaz;
import GUI.Interfaz2;
import java.security.Principal;
import java.util.ArrayList;

/**
 *
 * @author leo
 */
public class Ensamblador
{

    public static void main(String[] args)
    {
        String a = "Leo";

        if (a.contains("k"))
        {
            System.out.println("si");
        } else
        {
            System.out.println("no");
        }
    }

    public static String ensamblador(ArrayList codigoOP)
    {
        int ms = 0;
        ArrayList variables = new ArrayList();
        String mensajers = "";
        boolean sal = false;

        boolean mas = false;
        boolean menos = false;
        boolean multi = false;
        boolean dive = false;

        String macros = "";
        String salida = "salidax macro msg \n"
                + "mov ah,09h\n"
                + "lea dx,msg\n"
                + "int 21h  \n"
                + "endm salidax \n";
        String sumam = "sumax macro a,b\n"
                + "mov ax,a   \n"
                + "mov cx,b\n"
                + "add ax,cx \n"
                + "endm sumax \n";
        String restam = "restax macro a,b\n"
                + "mov ax,a   \n"
                + "mov cx,b\n"
                + "sub ax,cx \n"
                + "endm restax \n ";

        String dividem = "divix macro a,b\n"
                + "MOV AX,a \n"
                + "MOV BX,b \n"
                + "div bl \n"
                + "MOV ah,0 \n"                
                + "endm \n";
                       
        String multim = "multix macro a,b\n"
                + "MOV AX,a \n"
                +"MOV BX,b \n"
                + "MUL BX \n	"
                + "endm  \n ";

        String inclu = "org 100h\n"
                + "\n"
                + "include \"emu8086.inc\"\n"
                + "DEFINE_PRINT_STRING\n"
                + "DEFINE_PRINT_NUM\n"
                + "DEFINE_PRINT_NUM_UNS  \n"
                + "DEFINE_SCAN_NUM\n"
                + "\n"
                + " TITLE codigo\n"
                + "	\n"
                + ".STACK 64 \n ";
        String ensamblador = ".code \n";
        for (int i = 0; i < codigoOP.size(); i++)
        {
            String vector[] = (String[]) (codigoOP.get(i));

            try
            {
                int go = Integer.parseInt(vector[3].trim());

                switch (vector[2].trim())
                {
                    case "<":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP  AX, " + vector[1] + "\n";
                        ensamblador += "JNGE etiqueta" + go + "\n";
                        break;
                    case ">":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP AX, " + vector[1] + "\n";
                        ensamblador += "JNLE etiqueta" + go + "\n";
                        break;
                    case "==":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP  AX, " + vector[1] + "\n";
                        ensamblador += "JE etiqueta" + go + "\n";
                        break;
                    case "!=":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP  AX, " + vector[1] + "\n";
                        ensamblador += "JNE etiqueta" + go + "\n";
                        break;
                    case "<=":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP  AX, " + vector[1] + "\n";
                        ensamblador += "JNG etiqueta" + go + "\n";
                        break;
                    case ">=":
                        ensamblador += "MOV AX, " + vector[0] + "\n";
                        ensamblador += "CMP  AX, " + vector[1] + "\n";
                        ensamblador += "JNL etiqueta" + go + "\n";

                        break;
                    default:
                        ensamblador += "JMP etiqueta" + go + "\n";
                        break;

                }

            } catch (Exception e)
            {

                switch (vector[2].trim())
                {
                    case "Imprimir":

                        if (vector[0].contains("\""))
                        {
                            sal = true;

                            mensajers += "msgx" + (++ms) + " db 10,13," + vector[0] + ", '$' \n";
                            ensamblador += "salidax msgx" + ms + "\n";
                        } else
                        {
                            ensamblador += "salidax msgx0 \n "
                                    + " lea dx,saltoLN\n"
                                    + "mov ah,09h\n"
                                    + "int 21h  \n"+ "MOV ax, " + vector[0] + "\n" + "call PRINT_NUM\n";

                            char[] arTo = vector[0].trim().toCharArray();
                            boolean bandera = false;
                            if (arTo[0] == 'T')
                            {

                                for (int j = 1; j < arTo.length; j++)
                                {

                                    if (arTo[j] < 58 && arTo[j] > 47)
                                    {

                                    } else
                                    {

                                        bandera = false;
                                        break;
                                    }

                                }
                                bandera = true;
                            } else
                            {
                                bandera = false;
                            }

                        }

                        break;
                    case "Leer":
                        ensamblador += "call SCAN_NUM" + "\n";
                        ensamblador += "MOV " + vector[0] + " , CX" + "\n";
                        variables = insertarVariable(variables, vector[0]);
                        ensamblador += "LEA DX, saltoLN" + "\n";
                        ensamblador += "MOV AH,09H" + "\n";
                        ensamblador += "INT 21h" + "\n";

                        break;
                    case "+":
                        ensamblador += "sumax " + vector[0] + ", " + vector[1] + "\n";
                        ensamblador += "MOV " + vector[3] + ", AX \n";
                        variables = insertarVariable(variables, vector[3]);
                        mas = true;

                        break;
                    case "-":
                        ensamblador += "restax " + vector[0] + ", " + vector[1] + "\n";
                        ensamblador += "MOV " + vector[3] + ", AX \n";
                        variables = insertarVariable(variables, vector[3]);

                        menos = true;
                        break;
                    case "*":

                        ensamblador += "multix " + vector[0] + ", " + vector[1] + "\n";
                        ensamblador += "MOV " + vector[3] + ", AX \n";
                        variables = insertarVariable(variables, vector[3]);
                multi=true;

                        break;
                    case "/":
                        ensamblador += "divix " + vector[0] + ", " + vector[1] + "\n";
                        ensamblador += "MOV " + vector[3] + ", AX \n";
                        variables = insertarVariable(variables, vector[3]);
  dive=true;
                        break;
                    case "=":

                        ensamblador += "MOV AX, " + vector[1] + "\n";
                        ensamblador += "MOV " + vector[0] + ", AX \n";
                        variables = insertarVariable(variables, vector[0]);

                        break;
                    default:

                        if (vector[0].trim().length() == 0 && vector[1].trim().length() == 0 && vector[2].trim().length() == 0)
                        {

                            ensamblador += "etiqueta" + vector[3] + "\n";
                        }

                        break;

                }

            }

            if (vector[3].trim().equals("Inicio"))
            {
                if (vector[1].trim().equals("Metodo"))
                {
                    String param = "";
                    for (int j = 0; j < Interfaz2.parametros.size(); j++)
                    {
                        if (vector[0].trim().equals(((String[]) Interfaz2.parametros.get(i))[0]))
                        {

                            param += ((String[]) Interfaz2.parametros.get(i))[2];
                        }
                    }

                    // ensamblador += vector[0] + " macro " + param + "\n";
                }
            }

        }

        String var = ".data \n"
                + "msgx0 db 10,13,\"\", '$'\n"
                + " saltoLN db 0D,0AH,\"$\" \n";
        for (int i = 0; i < variables.size(); i++)
        {
            var += variables.get(i) + " dw ? \n";

        }
        var += mensajers;

        if (mas)
        {
            macros += sumam;

        }
        if (menos)
        {
            macros += restam;
        }
        if (multi)
        {
 macros +=multim;
        }
        if (dive)
        {
             macros += dividem;
        }
        if (sal)
        {

            macros += salida;
        }

        System.out.println(macros + inclu + ensamblador);

        return macros + inclu + var + ensamblador + "\n .exit";
    }

    private static ArrayList insertarVariable(ArrayList variables, String variable)
    {

        if (variables != null)
        {
            if (!variables.contains(variable))
            {
                variables.add(variable);
            }

        }

        return variables;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author barcl
 */
public class Valida
{

    JComboBox[][] combos;
    JTextField caracte;
    JLabel estado;

    public static boolean VacioAlfabeto(JTextField caracter, JTextField[] alfabeto, int indice, int pos)
    {
        boolean bandera = false;
        String valor = caracter.getText();
        if (valor.length() == 1)
        {
            char v = valor.charAt(0);
            if (v >= 32 && v <= 126)
            {
                System.out.println("Correcto");
                bandera = RepetirAlfabeto(valor, alfabeto, indice, pos);
            } else
            {
                System.out.println("Valor o símbolo no válido");
                return true;
            }
        } else
        {
            System.out.println("No contiene un sólo caracter");
            return true;
        }
        return bandera;
    }

    public static boolean RepetirAlfabeto(String valor, JTextField[] alfabeto, int indice, int pos)
    {
        boolean bandera = false;
        for (int j = 0; j < indice; j++)
        {
            System.out.println("I:" + pos + "\tJ: " + j);
            if (pos != j)
            {
                if (alfabeto[j] != null)
                {
                    if (valor.equals(alfabeto[j].getText()) == true)
                    {
                        System.out.println("Se repite el alfabeto");
                        return true;
                    }
                } else
                {
                    return true;
                }
            }
        }
        return bandera;
    }
}

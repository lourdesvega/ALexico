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
    
    public static void main(String[] args) {
        ArrayList arrl = new ArrayList();
        String[][] a = {
            {"a","Clase"," ","Inicio"},
            {"b","Metodo"," ","Inicio"},
            {"10","2","+","T1"},
            {"T1","4","+","T2"},
            {"T2","78","+","T3"},
            {"T3","7","+","T4"},
            {"4","5","+","T5"},
            {"4","T5","+","T6"},
            {"T6","8","+","T7"},
            {"1","T7","+","T8"},
            {"T8","8","+","T9"},
            {"2","T9","+","T10"},
            {"T10","7","+","T11"},
            {"4","T11","+","T12"},
            {"T12","7","+","T13"},
            {"4","T13","+","T14"},
            {"T14","7","+","T15"},
            {"T4","T15","+","T16"},
            {"num","T16","="," "},
            {"num","10","<","10"},
            {"",""," ","20"},
            {"",""," ","10:"},
            {"num","1","+","T17"},
            {"num","T17","="," "},
            {"",""," ","30"},
            {"",""," ","20:"},
            {"num","1","-","T18"},
            {"num","T18","="," "},
            {"",""," ","30"},
            {"",""," ","30:"},
            {"","Metodo"," ","Fin"},
            {"","Clase"," ","Fin"},
        };
        String vector[];
        for (int i = 0; i < a.length; i++) {
            vector=new String[4];
            vector[0]=a[i][0];
            vector[1]=a[i][1];
            vector[2]=a[i][2];
            vector[3]=a[i][3];
            arrl.add(vector);
            //System.out.println(((String[])arrl.get(i))[0]);
            
        }
        
        for (int i = 0; i < 32; i++) {
            
        //vector=(String[]) arrl.get(i);
        System.out.println(((String[])arrl.get(i))[0]+"\t"+((String[])arrl.get(i))[1]+"\t"+((String[])arrl.get(i))[2]+"\t"+((String[])arrl.get(i))[3]);
       // System.out.println(((String[])arrl.get())[0]);
        }
        Temporales(arrl);
    }
    
    public static void Temporales(ArrayList cuadruples) {
        
        System.out.println("Nuevo");
        System.out.println("-------------------");
        int inicio, fnal;
        String vector[];
        ArrayList temp = new ArrayList();
        for (int i = 2; i < cuadruples.size(); i++) {
            if(((((String[])cuadruples.get(i))[3]).charAt(0)+"").equals("T") || ((((String[])cuadruples.get(i))[2]).charAt(0)+"").equals("=")){
                temp.add(cuadruples.get(i));
                //System.out.println(temp.get(i));
                vector=(String[]) cuadruples.get(i);
                System.out.println(vector[0]+"\t"+vector[1]+"\t"+vector[2]+"\t"+vector[3]);
            } else {
                break;
            }
        }
        
    }
}

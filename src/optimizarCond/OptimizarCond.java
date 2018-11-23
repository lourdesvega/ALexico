/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizarCond;

import static Optimizacion.Bloques.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author barcl
 */
public class OptimizarCond
{

    public static void main(String[] args)
    {
        
        String a="10.0";
        String b="3.2";
        
        
        if(Double.parseDouble(a)<Double.parseDouble(b)){
            System.out.println("menor");
        }
        
        //System.out.println(Double.parseDouble(a));
       // System.out.println(Double.parseDouble("1.1"));

        
        
        /*
        ArrayList arrl = new ArrayList();
        String[][] a =
        {
            {
                "a", "Clase", "", "Inicio"
            },
            {
                "b", "Metodo", "", "Inicio"
            },
            {
                "162", "5", ">", "10"
            },
            {
                "", "", "", "20"
            },
            {
                "", "", "", "10:"
            },
            {
                "", "", "", "30"
            },
            {
                "", "", "", "20:"
            },
            {
                "", "", "", "30"
            },
            {
                "", "", "", "30:"
            },
            {
                "", "Metodo", "", "Fin"
            },
            {
                "null", "Clase", "", "Fin"
            }
        };
        String vector[];
        for (int i = 0; i < a.length; i++)
        {
            vector = new String[4];
            vector[0] = a[i][0];
            vector[1] = a[i][1];
            vector[2] = a[i][2];
            vector[3] = a[i][3];
            arrl.add(vector);
        }

        arrl = Condiciones(arrl);
        //arrl=Optimizar(arrl);
        System.out.println("\n");

        for (int i = 0; i < arrl.size(); i++)
        {
            System.out.println(((String[]) arrl.get(i))[0] + "\t" + ((String[]) arrl.get(i))[1] + "\t" + ((String[]) arrl.get(i))[2] + "\t" + ((String[]) arrl.get(i))[3]);
        }
        */
    }

    public static ArrayList Condiciones(ArrayList arrl)
    {
        String vector[], vector2[], opr, n1 = "", n2 = "";
        boolean band;
        for (int i = 0; i < arrl.size(); i++)
        {
            vector = (String[]) arrl.get(i);
            opr = vector[2];
            if (opr.equals("<") || opr.equals(">") || opr.equals("==")
                    || opr.equals("<=") || opr.equals(">=") || opr.equals("!=") /*|| opr.equals("&&") || opr.equals("||")*/)
            {
                band = true;
                n1 = vector[0];
                n2 = vector[1];
                System.out.print("\nCON cond en renglon " + (i) + " : ");
            } else
            {
                band = false;
            }
            if (band == true)
            {
                if (n1.charAt(0) >= 48 && n1.charAt(0) <= 57)
                {
                    System.out.print(n1 + " es número");
                    if (n2.charAt(0) >= 48 && n2.charAt(0) <= 57)
                    {
                        System.out.print(" y " + n2 + " también");
                        // Aquí identifico la etiqueta correcta e incorrecta
                        boolean op = operacionLogica(n1, n2, opr);
                        // vector2 = (String[]) arrl.get(i+1);
                        if (op == true)
                        {
                            System.out.print("Etiqueta verdadera.");
                            // Aquí mando etiqueta correcta o la incorrecta (vector,vector2)
                            //arrl = optimizarEtiqueta(arrl, i, Integer.parseInt(vector[3]), Integer.parseInt(vector2[3]));
                        } else
                        {
                            System.out.print("Etiqueta falsa.");
                            // Aquí mando etiqueta correcta o la incorrecta (vector,vector2)
                            arrl = optimizarEtiqueta(arrl, i, Integer.parseInt(vector[3]), Integer.parseInt(vector[3]));
                        }
                    } else
                    {
                        System.out.print(", pero '" + vector[1] + "' no.");
                    }
                } else
                {
                    System.out.println("'" + vector[0] + "' no es número");
                }
                band = false;
            } else
            {

            }
        }
        return arrl;
    }

    public static ArrayList optimizarEtiqueta(ArrayList arrl, int inicio, int etiqCorr, int etiqInc)
    {
        System.out.print("\n\tV-" + etiqInc + ":F-" + etiqCorr + "\n");
        String vector[], aux[];
        int count = inicio;
        // Cambia a etiqueta correcta ya agrega a tabla
        aux = (String[]) arrl.get(inicio);
        aux[0] = String.valueOf("''");
        aux[1] = String.valueOf("''");
        aux[2] = String.valueOf("''");
        aux[3] = String.valueOf(etiqCorr);
        arrl.set(inicio, aux);

        count = count + 1;
        arrl.remove(count);
//        do {
//            vector = (String[]) arrl.get(count);
//            if (vector[3].equals(etiqInc + ":")) {
//                int ax = count; 
//                arrl.remove(ax);
//                for (int i = ax; i < arrl.size(); i++) {
//                    if (((String[])arrl.get(i))[3].equals(etiqCorr)) {
//                        break;
//                    } else {
//                        arrl.remove(i);
//                    }
//                }
//                //count++;
//            } else if (vector[3].equals(etiqCorr + ":")) {
//                count++;
//            } else {
//                count++;
//            }
//        } while(count < arrl.size());
        return arrl;
    }

    public static boolean operacionLogica(String op1, String op2, String oper)
    {
        boolean band = true;
        boolean num[] = validarTipoDeNum(op1, op2);
        if (num[0] == true)
        {
            if (num[1] == true)
            {
                band = enteroEntero(op1, op2, oper);
            } else
            {
                band = enteroDouble(op1, op2, oper);
            }
        } else
        {
            if (num[1] == true)
            {
                band = doubleEntero(op1, op2, oper);
            } else
            {
                band = doubleDouble(op1, op2, oper);
            }
        }
        return band;
    }

    public static boolean[] validarTipoDeNum(String op1, String op2)
    {
        boolean num[] = new boolean[2], n1, n2;
        try
        {
            Integer.parseInt(op1);
            num[0] = true;
            try
            {
                Integer.parseInt(op2);
                num[1] = true;
            } catch (NumberFormatException ne2)
            {
                num[1] = false;
            }
        } catch (NumberFormatException ne1)
        {
            num[0] = false;
            try
            {
                Integer.parseInt(op2);
                num[1] = true;
            } catch (NumberFormatException ne3)
            {
                num[1] = false;
            }
        }
        return num;
    }

    public static boolean enteroEntero(String op1, String op2, String oper)
    {
        boolean band = true;
        switch (oper)
        {
            case "<":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) < Integer.parseInt(op2);
                break;
            case ">":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) > Integer.parseInt(op2);
                break;
            case "==":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) == Integer.parseInt(op2);
                break;
            case "<=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) <= Integer.parseInt(op2);
                break;
            case ">=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) >= Integer.parseInt(op2);
                break;
            case "!=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) != Integer.parseInt(op2);
                break;
        }
        return band;
    }

    public static boolean enteroDouble(String op1, String op2, String oper)
    {
        boolean band = true;
        switch (oper)
        {
            case "<":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) < Double.parseDouble(op2);
                break;
            case ">":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) > Double.parseDouble(op2);
                break;
            case "==":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) == Double.parseDouble(op2);
                break;
            case "<=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) <= Double.parseDouble(op2);
                break;
            case ">=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) >= Double.parseDouble(op2);
                break;
            case "!=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) != Double.parseDouble(op2);
                break;
        }
        return band;
    }

    public static boolean doubleDouble(String op1, String op2, String oper)
    {
        boolean band = true;
        switch (oper)
        {
            case "<":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) < Double.parseDouble(op2);
                break;
            case ">":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) > Double.parseDouble(op2);
                break;
            case "==":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) == Double.parseDouble(op2);
                break;
            case "<=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) <= Double.parseDouble(op2);
                break;
            case ">=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) >= Double.parseDouble(op2);
                break;
            case "!=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) != Double.parseDouble(op2);
                break;
        }
        return band;
    }

    public static boolean doubleEntero(String op1, String op2, String oper)
    {
        boolean band = true;
        switch (oper)
        {
            case "<":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) < Integer.parseInt(op2);
                break;
            case ">":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) > Integer.parseInt(op2);
                break;
            case "==":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) == Integer.parseInt(op2);
                break;
            case "<=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) <= Integer.parseInt(op2);
                break;
            case ">=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) >= Integer.parseInt(op2);
                break;
            case "!=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Double.parseDouble(op1) != Integer.parseInt(op2);
                break;
        }
        return band;
    }

    public static boolean opCond(String op1, String op2, String oper)
    {
        boolean band = true;
        switch (oper)
        {
            case "<":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) < Integer.parseInt(op2);
                break;
            case ">":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) > Integer.parseInt(op2);
                break;
            case "==":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) == Integer.parseInt(op2);
                break;
            case "<=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) <= Integer.parseInt(op2);
                break;
            case ">=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) >= Integer.parseInt(op2);
                break;
            case "!=":
                System.out.print(" : " + op1 + oper + op2 + " : ");
                band = Integer.parseInt(op1) != Integer.parseInt(op2);
                break;
        }
        return band;
    }

    public static ArrayList elimBloqEtiq(ArrayList arrl, int inicio, int etiqCorr, int etiqInc)
    {
        System.out.print("\n\tV-" + etiqInc + ":F-" + etiqCorr + "\n");
        String vector[], aux[];
        int count = inicio;
        // Cambia a etiqueta correcta ya agrega a tabla
        aux = (String[]) arrl.get(inicio);
        aux[0] = String.valueOf("");
        aux[1] = String.valueOf("");
        aux[2] = String.valueOf("");
        aux[3] = String.valueOf(etiqCorr);
        arrl.set(inicio, aux);

//        count=count+1;
//        arrl.remove(count);
//        do {
//            vector = (String[]) arrl.get(count);
//            if (vector[3].equals(etiqInc + ":")) {
//                int ax = count; 
//                arrl.remove(ax);
//                for (int i = ax; i < arrl.size(); i++) {
//                    if (((String[])arrl.get(i))[3].equals(etiqCorr)) {
//                        break;
//                    } else {
//                        arrl.remove(i);
//                    }
//                }
//                //count++;
//            } else if (vector[3].equals(etiqCorr + ":")) {
//                count++;
//            } else {
//                count++;
//            }
//        } while(count < arrl.size());
        return arrl;
    }

    public static ArrayList condicionL(ArrayList a)
    {

        for (int i = 0; i < a.size(); i++)
        {
            if (((String[]) a.get(i))[2].trim().equals("<") || ((String[]) a.get(i))[2].trim().equals("<=") || ((String[]) a.get(i))[2].trim().equals(">") || ((String[]) a.get(i))[2].trim().equals(">=") || ((String[]) a.get(i))[2].trim().equals("!=") || ((String[]) a.get(i))[2].trim().equals("=="))
            {
               switch (((String[]) a.get(i))[2].trim()){
               
                   
                   case "<":
                    if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())<Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    }
                        
                    }  
                                    
                       break;
                       
                   case ">":
                          if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())>Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    } 
                        
                    }
                       break;
                   case "<=":
                       
                       
                                 if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())<=Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    } 
                        
                    }
                       break;
                   case ">=":
                       
                                 if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())>=Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    } 
                        
                    }
                       break;
                   case "==":
                       
                                 if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())==Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    }
                        
                    } 
                       break;
                       
                   case "!=":
                                 if(validar(((String[]) a.get(i))[0].trim())&&validar(((String[]) a.get(i))[1].trim())){
                    
                        if(Double.parseDouble(((String[]) a.get(i))[0].trim())!=Double.parseDouble(((String[]) a.get(i))[1].trim())){
                        
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";

                        }else{
                    
                        ((String[]) a.get(i))[0]="";
                        ((String[]) a.get(i))[1]="";
                        ((String[]) a.get(i))[2]="";
                        ((String[]) a.get(i))[3]="";

                    
                    
                    }
                        
                    } 
                       break;
               
               
               }
                
                
            }

        }

        return a;

    }

    
    public static boolean validar(String j){
    char ch[]=j.trim().toCharArray();
    
        for (int i = 0; i < ch.length; i++)
        {
            if((ch[i]>=48&&ch[i]<=57)||ch[i]==46){
            
            }else{
            
            return false;
            }
        }
        
        
        
        
        return true;
    }
}

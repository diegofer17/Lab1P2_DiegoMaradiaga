package lab1p2_diegomaradiaga;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab1P2_DiegoMaradiaga {
    static Scanner leer = new Scanner (System.in); 
    public static void main(String[] args) throws ParseException {
    int opcion;
        do {
            System.out.println("-------------------------------------------");
            System.out.println(">>>>>>>            MENU             <<<<<<<");
            System.out.println("");
            System.out.println("1. Torres de Hanoi  ");
            System.out.println("2. Buscador de fechas ");
            System.out.println("3. Pi                 ");
            System.out.println("4. Salir ");
            System.out.print("Ingrese su opcion: ");
            opcion = leer.nextInt();
            System.out.println("");
            
            switch (opcion){
                case 1:
                    int origen = 1;
                    int auxiliar = 2;
                    int destino = 3;
                    
                    System.out.println("Ingrese la cantidad de discos: ");
                    int CDiscos = leer.nextInt(); 
                    
                    DiscosHanoi(CDiscos,origen, auxiliar, destino );
                break;
                case 2:
                    System.out.println("Ingrese cualquier cadena: ");
                    String cadena = leer.next();
                    
                    Extractor(cadena);
                    
                    
                    
                break;
                case 3:
                    System.out.println("Ingrese el limite de la serie: ");
                    Double k = leer.nextDouble();
                    Double n = 0.0;
                    
                    System.out.println(Pi(k,n,0.0));
                break;
                default:
                    System.out.println("Saliendo...");
                break;
                
            }
        } while (opcion != 4);
        
    }//Fin main
    
    public static void DiscosHanoi (int nDiscos, int  origen, int auxiliar, int destino){
        if (nDiscos == 1){             
            System.out.println("Mover disco "+nDiscos+" de "+origen+" a "+ destino);
            
        }else{
            DiscosHanoi (nDiscos-1, origen, destino, auxiliar);
            System.out.println("Mover disco "+nDiscos+" de "+origen+" a "+destino);
            DiscosHanoi (nDiscos-1, auxiliar, origen, destino);
        }
    }
    
    public static void Extractor(String cadena) throws ParseException {
        String C[] = cadena.split(",");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        for (int i = 0; i < C.length; i++) {
            if (C[i].charAt(2) == '/') {

                Date Fecha = df.parse(C[i]);
                System.out.println(Fecha);
            }
            else if (C[i].charAt(2) == '-') {
                Date Fecha = df.parse(C[i]);
                System.out.println(Fecha);
            }/*No da, pero se intento*/
        }

    }//Fin metodo 
    
    public static Double Pi (Double k, Double n, Double Sumatoria){
        
        if (n==k-1){
            return Sumatoria*4;
        }else{
            Sumatoria += (Math.pow(-1, n))/(2*n)+1;
            
            return Pi(k,n+1,Sumatoria);
        }
    }
    
}//Fin clase

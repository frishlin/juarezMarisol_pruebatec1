
package com.hackaboss.sistemaempleados;

import java.util.Scanner;

public class SistemaEmpleados {
    
    static int opcion;
    static boolean volverMenu = true;
    
    static Scanner teclado = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        System.out.println("");
        String menu = """
                              MENÚ PRINCIPAL
        1) ALTA
        2) BAJA
        3) CONSULTA
        4) MODIFICACIONES
        5) SALIR
        """;
        
        while(volverMenu){
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
        
            while(opcion < 1 || opcion > 5){
                System.out.println("Solo puede elegir números del 1 al 5.");
                System.out.print("Seleccione una opción: ");
                opcion = teclado.nextInt();     
            }
            
            switch(opcion){
                case 1: System.out.println("Ingresaste a la alta de empleados."); break;
                case 2: System.out.println("Ingresaste a la baja de empleados."); break; 
                case 3: System.out.println("Ingresaste a la consulta de empleados."); break;
                case 4: System.out.println("Ingresaste a la modificación de empleados."); break;
                case 5: System.out.println("Salida del sistema"); volverMenu = false; break;
                default: System.out.println("¡Opción incorrecta!");
           
            }
            
            if(volverMenu) {
                System.out.println("Presione ENTER para volver al menú...");
                teclado.nextLine();
                teclado.nextLine();
            }
        }  
    }
}


package com.hackaboss.sistemaempleados;

import java.time.LocalDate;
import java.util.Scanner;
import logica.Empleado;
import persistencia.ControladoraPersistencia;

public class SistemaEmpleados {

    public static void main(String[] args) {
        
        int opcion;
        boolean volverMenu = true;
    
        Scanner teclado = new Scanner(System.in);
    
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        
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
            
            System.out.println("");
            
            switch(opcion){
                case 1:                     
                    System.out.println("ALTA DE EMPLEADOS");
                    teclado.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = teclado.nextLine();
                    System.out.print("Ingrese el cargo: ");
                    String cargo = teclado.nextLine();
                    System.out.print("Ingrese el salario: ");
                    double salario = teclado.nextDouble();
                    System.out.print("Ingrese la fecha de inicio con el formato (aaaa-mm-dd): ");
                    LocalDate fechaInicio = LocalDate.parse(teclado.next());
                    Empleado altaEmpleado = new Empleado(0, nombre, apellido, cargo, salario, fechaInicio);
                    controlPersis.crearEmpleado(altaEmpleado);
                    System.out.println("");
                    break;
                case 2: 
                    System.out.println("BAJA DE EMPLEADOS"); 
                    System.out.print("Ingrese el número de ID del empleado que desea dar de baja: ");
                    int eliminarId = teclado.nextInt();
                    controlPersis.borrarEmpleado(eliminarId);
                    System.out.println("\n¡El empleado número " + eliminarId + " fue eliminado exitosamente!\n");
                    break; 
                case 3: System.out.println("Ingresaste a la consulta de empleados."); break;
                case 4: System.out.println("Ingresaste a la modificación de empleados."); break;
                case 5: System.out.println("¡Gracias por usar el sistema, vuelva pronto!"); volverMenu = false; break;
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

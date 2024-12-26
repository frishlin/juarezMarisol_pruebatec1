package com.hackaboss.sistemaempleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                    String nombre = teclado.next();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = teclado.next();
                    System.out.print("Ingrese el cargo: ");
                    String cargo = teclado.next();
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
                    List<Empleado> eliminarEmpleado = controlPersis.traerEmpleados();
                    if(eliminarEmpleado.isEmpty()) {
                        System.out.println("¡No existen empleados registrados!");
                    } else {
                        System.out.printf("%-5s %-15s %-15s%n", 
                          "ID", 
                          "NOMBRE", 
                          "APELLIDO");
                        System.out.println("---------------------------------------");
                        for(Empleado emp : eliminarEmpleado) {
                            System.out.printf("%-5d %-15s %-15s%n", 
                              emp.getId(), 
                              emp.getNombre(), 
                              emp.getApellido());
                        }
                        
                        System.out.print("\nIngrese el número de ID del empleado que desea dar de baja: ");
                        int eliminarId = teclado.nextInt();
                  
                        Empleado empleadoEliminar = controlPersis.traerEmpleado(eliminarId);
                        if(empleadoEliminar == null) {
                            System.out.println("\n¡El ID ingresado no existe!");
                        } else {
                            controlPersis.borrarEmpleado(eliminarId);
                            System.out.println("\n¡El empleado número " + eliminarId + " fue eliminado exitosamente!\n");
                        }
                    }
                  
                    break; 
                    
                case 3: 
                    System.out.println("CONSULTAR EMPLEADOS");
                    System.out.println("1) Listar todos");
                    System.out.println("2) Filtrar por cargo");
                    System.out.print("\nSeleccione una opción: ");
                    int opcionConsultar = teclado.nextInt();
                
                    switch (opcionConsultar) {
                        case 1: // Listar todos los empleados
                            System.out.printf("%-5s %-15s %-15s %-15s %-10s %-12s%n", 
                            "ID", 
                            "NOMBRE", 
                            "APELLIDO", 
                            "CARGO", 
                            "SALARIO", 
                            "FECHA INICIO");
                            System.out.println("-----------------------------------------------------------------------------");
                            List<Empleado> empleados = controlPersis.traerEmpleados();
                            if (empleados.isEmpty()) {
                                System.out.println("\n¡Aún no existen empleados registrados!\n");
                            } else {
                                for (Empleado emp : empleados) {
                                    System.out.printf("%-5d %-15s %-15s %-15s %-10.2f %-12s%n", 
                                    emp.getId(), 
                                    emp.getNombre(), 
                                    emp.getApellido(), 
                                    emp.getCargo(), 
                                    emp.getSalario(), 
                                    emp.getFechaInicio());
                                }
                            }
                            break;

                        case 2: // Filtrar por cargo
                            System.out.println("\nCONSULTAR EMPLEADOS POR CARGO");
                            List<Empleado> filtroEmpleados = controlPersis.traerEmpleados();
                            if (filtroEmpleados.isEmpty()) {
                                System.out.println("\n¡Aún no existen empleados registrados!\n");
                            } else {
                                // Obtener cargos
                                List<String> filtroCargos = new ArrayList<>();
                                for(Empleado emp :filtroEmpleados){
                                    if(!filtroCargos.contains(emp.getCargo())){
                                        filtroCargos.add(emp.getCargo());
                                    }
                                }
                                for(int i = 0; i < filtroCargos.size(); i++) {
                                    System.out.println((i + 1) + ") " + filtroCargos.get(i));
                                }
                                System.out.print("\nSeleccione el número de cargo que desea filtrar: ");
                                int seleccionCargo = teclado.nextInt();
                                if(seleccionCargo < 1 || seleccionCargo > filtroCargos.size()) {
                                    System.out.println("\n¡El número seleccionado es inválido!");
                                } else {
                                    String cargoSeleccionado = filtroCargos.get(seleccionCargo - 1);
                                    System.out.println("\nEMPLEADOS CON CARGO: " + cargoSeleccionado);
                                    System.out.printf("%-5s %-15s %-15s %-10s %-12s%n", 
                                    "ID", 
                                    "NOMBRE", 
                                    "APELLIDO",  
                                    "SALARIO", 
                                    "FECHA INICIO");
                                    System.out.println("-----------------------------------------------------------------------------");
                                    for(Empleado emp : filtroEmpleados) {
                                        if(emp.getCargo().equals(cargoSeleccionado)) {
                                            System.out.printf("%-5d %-15s %-15s %-10.2f %-12s%n", 
                                        emp.getId(), 
                                        emp.getNombre(), 
                                        emp.getApellido(),
                                        emp.getSalario(), 
                                        emp.getFechaInicio());
                                        }
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("\n¡El número seleccionado es inválido!");
                            break;
                    }
                    break;
                
                case 4: 
                    System.out.println("MODIFICAR DATOS DEL EMPLEADO"); 
                    System.out.print("Ingrese el ID del empleado a modificar: ");
                    int modificarId = teclado.nextInt();
                    Empleado emp = controlPersis.traerEmpleado(modificarId);
                    if(emp == null) {
                        System.out.println("El empleado con ID " + modificarId + " no existe");
                    } else {
                        boolean modificarDatos = true;
                        System.out.println("\nIngresa el número que corresponde al dato que desea modificar: ");
                        String menuModificar = """
                            ¿Qué dato desea modificar?
                            1) Nombre
                            2) Apellido
                            3) Cargo
                            4) Salario
                            5) Fecha de Inicio
                            6) Salir 
                            """;
                        while(modificarDatos) {
                            System.out.println(menuModificar);
                            System.out.print("Seleccione una opción: ");
                            int opcionModificar = teclado.nextInt();
                            switch(opcionModificar) {
                                case 1:
                                    System.out.print("Ingrese el nombre: ");
                                    emp.setNombre(teclado.next());
                                    controlPersis.modificarEmpleado(emp);
                                    System.out.println("\n¡Modificación realizada exitosamente!\n");
                                    break;
                                    
                                case 2:
                                    System.out.print("Ingrese el apellido: ");
                                    emp.setApellido(teclado.next());
                                    controlPersis.modificarEmpleado(emp);
                                    System.out.println("\n¡Modificación realizada exitosamente!\n");
                                    break;
                                    
                                case 3:
                                    System.out.print("Ingrese el cargo: ");
                                    emp.setCargo(teclado.next());
                                    controlPersis.modificarEmpleado(emp);
                                    System.out.println("\n¡Modificación realizada exitosamente!\n");
                                    break;
                                    
                                case 4:
                                    System.out.print("Ingrese el salario: ");
                                    emp.setSalario(teclado.nextDouble());
                                    controlPersis.modificarEmpleado(emp);
                                    System.out.println("\n¡Modificación realizada exitosamente!\n");
                                    break;
                                    
                                case 5:
                                    System.out.print("Ingrese la fecha de inicio: ");
                                    emp.setFechaInicio(LocalDate.parse(teclado.next()));
                                    controlPersis.modificarEmpleado(emp);
                                    System.out.println("\n¡Modificación realizada exitosamente!\n");
                                    break;
                                case 6:
                                    modificarDatos = false;
                                    break;
                                        
                                default:
                                    System.out.println("¡Opción incorrecta!");
                                }
                                
                                if (modificarDatos) {
                                    System.out.print("¿Desea modificar otro dato? (Presione S para confirmar o cualquier tecla para volver al menú): ");
                                    String respuesta = teclado.next();
                                    if (!respuesta.equalsIgnoreCase("S")) {
                                        modificarDatos = false;
                                    }
                                }
                                
                            }
                            
                    }
                    break;
                
                case 5: 
                    System.out.println("¡Gracias por usar el sistema, vuelva pronto!"); volverMenu = false; 
                    break;
                
                default: 
                    System.out.println("¡Opción incorrecta!");
           
            }
            
            if(volverMenu) {
                System.out.println("\nPresione ENTER para volver al menú...\n");
                teclado.nextLine();
                teclado.nextLine();
            }
        }  
    }
}

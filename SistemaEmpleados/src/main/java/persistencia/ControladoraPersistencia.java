
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    EmpleadoJpaController empJpa = new EmpleadoJpaController();    
    
    //Crear empleado (C)
    public void crearEmpleado(Empleado emp) {
        empJpa.create(emp);
    }
      
    //Buscar a un empleado (R)    
    public Empleado traerEmpleado(int id) {
        return empJpa.findEmpleado(id);
    }
    
    
    //Traer a todos los empleados (R)
    public List<Empleado> traerEmpleados() {
        return empJpa.findEmpleadoEntities();
    }
    
    //Modificar empleado (U)
    public void modificarEmpleado(Empleado emp) {
        try {
            empJpa.edit(emp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Borrar empleado (D)
    public void borrarEmpleado(int id) {
        try {
            empJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

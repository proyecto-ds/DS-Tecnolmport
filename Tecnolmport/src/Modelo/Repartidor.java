/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author bryan
 */
public class Repartidor extends Empleado{
    protected boolean disponibilidad;

    public Repartidor() {
    }
    
    
    public Repartidor(boolean disponibilidad, String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        super(identificacion, nombre, apellido, telefono, direccion, email, local, activo);
        this.disponibilidad = disponibilidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}

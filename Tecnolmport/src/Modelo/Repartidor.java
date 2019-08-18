/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Producto.CONNECTION;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Repartidor extends Empleado{
    protected boolean disponibilidad;
    
    private final String consultar = "{call obtenerRepartidorDisponible()}";
    protected static final Logger LOGGER = Logger.getLogger("Repartidor Logger");
    
    public Repartidor() {
    }
    
    public Repartidor(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Repartidor(String id, String nombre, String apellido, String rol, int salario, String direccion, String email, String telefono, String local, boolean activo) {
        super(id, nombre, apellido, rol, salario, direccion, email, telefono, local, activo);
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public LinkedList<String> obtenerRepartidorDisponible(){
        LinkedList<String> nombre = new LinkedList<>();
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consultar);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                nombre.add( resultado.getString("nombre"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return nombre;
    }
}

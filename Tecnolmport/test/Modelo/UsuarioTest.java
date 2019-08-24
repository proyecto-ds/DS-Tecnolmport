/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rogencio
 */
public class UsuarioTest {
    
    Usuario user = new Usuario("rogera", "123", "0912345678", "Roger", "Aviles", "vendedor", 0, "Cuenca", "r@.com", "456215", "bodega", true);
    Usuario repartidor = new Usuario(null, null, "0909082010", "Thanos", "Celestial", "repartidor", 0, "Titan", "thunas@gmail.com", "09841254008", "3", true);
    Usuario vendedor = new Usuario("pat49", "4mor", null, "Patty", null, "vendedor", 0, "Pastaza 5524 y la A", "pat@hotmail.com", "0987452", "1", true);
    
    /**
     * Comprueba que el Usuario ingresado sea igual al rol a comparar.
     * Usado para actualizar la vista correspondiente al rol.
     */
    @Test
    public void testLoginRol() {
        String log = user.login();
        assertEquals("jefe",log);
    }
    
    /**
     * Comprueba que el Usuario ingresado sea distinto al rol a comparar.
     * Usado para actualizar la vista correspondiente al rol.
     */
    @Test
    public void testLoginNotRol() {
        String log = user.login();
        assertNotSame("vendedor",log);
    }
    
    /**
     * No agrega al empleado en caso de existir en la base.
     */
    @Test
    public void testIngresarEmpleadoExistente() {
        assertFalse(repartidor.ingresarEmpleado());
    }
    
    /**
     * No agrega al empleado en caso de no escribir datos de vital importancia.
     */
    @Test
    public void testIngresarEmpleadoIncompleto() {
        assertFalse(vendedor.ingresarEmpleado());
    }
    
}

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
    
    Usuario user = new Usuario("rogera", "123", "1", "Roger", "Aviles", "vendedor", 0, "Cuenca", "r@.com", "456215", "bodega", true);
    
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
    
}

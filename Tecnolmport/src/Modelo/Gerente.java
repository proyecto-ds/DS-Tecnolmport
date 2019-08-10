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
public class Gerente extends Usuario{

    public Gerente() {
    }

    public Gerente(String usuario, String contraseña, String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        super(usuario, contraseña, identificacion, nombre, apellido, telefono, direccion, email, local, activo);
    }
    
}

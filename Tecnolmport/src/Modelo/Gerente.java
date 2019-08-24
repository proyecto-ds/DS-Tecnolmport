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

    public Gerente(String usuario, String contrasena, String id, String nombre, String apellido, String rol, int salario, String direccion, String email, String telefono, String local, boolean activo) {
        super(usuario, contrasena, id, nombre, apellido, rol, salario, direccion, email, telefono, local, activo);
    }

    
    
}

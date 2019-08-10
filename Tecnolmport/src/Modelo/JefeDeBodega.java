/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Queue;

/**
 *
 * @author bryan
 */
public class JefeDeBodega extends Usuario{
    protected Queue<Repartidor> repartidor;

    public JefeDeBodega() {
    }

    public JefeDeBodega(String usuario, String contraseña, String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        super(usuario, contraseña, identificacion, nombre, apellido, telefono, direccion, email, local, activo);
    }
    
    
}

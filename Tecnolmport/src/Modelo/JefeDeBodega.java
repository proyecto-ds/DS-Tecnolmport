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

    public JefeDeBodega(String usuario, String contraseña, String id, String nombre, String apellido, String rol, int salario, String direccion, String email, String telefono, String local, boolean activo) {
        super(usuario, contraseña, id, nombre, apellido, rol, salario, direccion, email, telefono, local, activo);
    }

    
    
}

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
public class Usuario extends Empleado{
    
    protected String usuario;
    protected String contraseña;

    public Usuario() {
    }
    
    public Usuario(String usuario, String contraseña, String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        super(identificacion, nombre, apellido, telefono, direccion, email, local, activo);
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public boolean login(){
        String usuario = "bryan";
        String contraseña = "123";
        if(this.usuario.equals(usuario)&& this.contraseña.equals(contraseña)){
            return true;
        }
        return false;
    }
    
    
    public boolean logout(){
        
        return false;
    }
    
    public String obtenerRol(){
        return "jefedebodega";
    }
}

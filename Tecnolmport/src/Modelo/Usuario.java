/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Singleton.DBConnection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Usuario extends Empleado{
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    protected String usuario;
    protected String contraseña;

    public Usuario() {
    }
    
    public Usuario(String usuario, String contraseña, String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        super(identificacion, nombre, apellido, telefono, direccion, email, local, activo);
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    
    public List<Empleado> ConsultarEmpleados(){
        return null;
    }
    
    public void ActualizarEmpleado(String usuario){
        
    }
    
    public void RegistrarEmpleado(String usuario){
        
    }
    
    public List<Producto> ConsultarProductos(){
        return null;
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
    public String login(){
        try {
            CONNECTION.conectar();
            String consulta = "{call  login (?,?,?)}";
            CallableStatement sp = CONNECTION.getConnection().prepareCall(consulta);
            sp.setString(1, this.getUsuario());
            sp.setString(2, this.getContraseña());
            System.out.println("888888888888888");
            sp.registerOutParameter(3, Types.VARCHAR);
            sp.execute();
            System.out.println("999999999999999999999999");
            String rol = sp.getString(3);
            System.out.println(rol);
            sp.close();
            return rol;
        } catch (SQLException ex) {
           Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            CONNECTION.desconectar();
        }
    }
    
    
    public boolean logout(){
        
        return false;
    }
    
    public String obtenerRol(){
        return "jefedebodega";
    }
}

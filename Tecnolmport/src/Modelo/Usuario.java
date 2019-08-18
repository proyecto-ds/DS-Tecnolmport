/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Singleton.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bryan
 */
public class Usuario extends Empleado{
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    private final String actualizar = "{call  actualizarEmpleado (?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String ingresar = "{call   ingresarEmpleado (?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String eliminar = "{call   eliminarEmpleado (?)}";
    protected String usuario;
    protected String contraseña;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, String id, String nombre, String apellido, String rol, int salario, String direccion, String email, String telefono, String local, boolean activo) {
        super(id, nombre, apellido, rol, salario, direccion, email, telefono, local, activo);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    public String login(){
        try {
            CONNECTION.conectar();
            String consulta = "{call  login (?,?,?)}";
            CallableStatement sp = CONNECTION.getConnection().prepareCall(consulta);
            sp.setString(1, this.getUsuario());
            sp.setString(2, this.getContraseña());
            sp.registerOutParameter(3, Types.VARCHAR);
            sp.execute();
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
    
    
    
    public ObservableList<Usuario> llenarTableEmpleado(){
        ObservableList <Usuario> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call  obtenerEmpleados ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Usuario(
                                resultado.getString("usuario"),
                                resultado.getString("clave"),
                                resultado.getString("idEmpleado"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido"),
                                resultado.getString("rol"),
                                resultado.getInt("salario"),
                                resultado.getString("direccion"),
                                resultado.getString("email"),
                                resultado.getString("telefono"),
                                resultado.getString("tipo"),
                               resultado.getBoolean("estado")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    
      public ObservableList<Usuario> llenarTableEmpleadoPAdmin(){
        ObservableList <Usuario> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call  obtenerEmpleados ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                if(!resultado.getString("rol").equals("repartidor") ){
                lista.add(
                        new Usuario(
                                resultado.getString("usuario"),
                                resultado.getString("clave"),
                                resultado.getString("idEmpleado"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido"),
                                resultado.getString("rol"),
                                resultado.getInt("salario"),
                                resultado.getString("direccion"),
                                resultado.getString("email"),
                                resultado.getString("telefono"),
                                resultado.getString("tipo"),
                               resultado.getBoolean("estado")));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    
    
    
    
    
    
    
    
    
    
    public boolean actualizarEmpleado(){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizar);
            sp.setString(1, this.getId());
            sp.setString(2, this.getNombre());
            sp.setString(3, this.getApellido());
            sp.setString(4, this.getUsuario());
            sp.setString(5, this.getContraseña());
            sp.setString(6, this.getRol());
            sp.setInt(7, this.getSalario());
            sp.setString(8, this.getDireccion());
            sp.setString(9, this.getEmail());
            sp.setString(10, this.getTelefono());
            sp.setBoolean(11, this.isActivo());
            sp.setString(12, this.getLocal());
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    public boolean ingresarEmpleado(){
        try {
            CONNECTION.conectar();
            PreparedStatement sp = CONNECTION.getConnection().prepareStatement(ingresar);
            sp.setString(1, this.getId());
            sp.setString(2, this.getNombre());
            sp.setString(3, this.getApellido());
            sp.setString(4, this.getUsuario());
            sp.setString(5, this.getContraseña());
            sp.setString(6, this.getRol());
            sp.setInt(7, this.getSalario());
            sp.setString(8, this.getDireccion());
            sp.setString(9, this.getEmail());
            sp.setString(10, this.getTelefono());
            sp.setBoolean(11, this.isActivo());
            sp.setString(12, this.getLocal());
            sp.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    public boolean eliminarEmpleado(){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(eliminar);
            sp.setString(1, this.getId());
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.actualizar, other.actualizar)) {
            return false;
        }
        if (!Objects.equals(this.ingresar, other.ingresar)) {
            return false;
        }
        if (!Objects.equals(this.eliminar, other.eliminar)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "actualizar=" + actualizar + ", ingresar=" + ingresar + ", eliminar=" + eliminar + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    
    
    public boolean logout(){
        
        return false;
    }
    
    public String obtenerRol(){
        return "jefedebodega";
    }
}

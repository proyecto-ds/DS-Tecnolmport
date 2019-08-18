/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorLogin;
import static Controlador.ControladorLogin.user;
import Singleton.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bryan
 */
public class Inventario {
    protected String id;
    protected ObservableList <Producto> producto;
    protected String idEmpleado;
    protected String idLocal;
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    private Producto modeloProducto;
    private final String actualizar = "{call  actualizarInventario (?,?,?,?,?)}";
    private final String ingresar = "{call   ingresarInventario(?,?,?,?,?)}";
    private final String eliminar = "{call   eliminarInventario (?)}";

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }
    
    
    public ObservableList<Producto> llenarTableInventario(){
        producto = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call  obtenerInventarioLocal (?)}";
            CallableStatement sp = CONNECTION.getConnection().prepareCall(consulta);
            sp.setString(1, this.getIdLocal());
            ResultSet resultado = sp.executeQuery();
            while (resultado.next()) {
                producto.add(new Producto(resultado.getString("idInventario"),
                                resultado.getString("idProducto"),
                                resultado.getString("nombre"),
                                resultado.getFloat("precio"),
                                resultado.getString("categoria"),
                                resultado.getString("descripcion"),
                                resultado.getString("proveedor"),
                                resultado.getBoolean("estado"),
                                resultado.getInt("stock")));
            }
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return producto;
    }
    
    public boolean ingresarInventario(Producto modeloP){
        try {
            CONNECTION.conectar();
            PreparedStatement sp = CONNECTION.getConnection().prepareStatement(ingresar);
            sp.setString(1, modeloP.getIdI());
            sp.setString(2, modeloP.getId());
            sp.setString(3, this.getIdLocal());
            sp.setInt(4, modeloP.getStock());
            sp.setBoolean(5, modeloP.isEstado());
            sp.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    public boolean actualizarInventario(Producto modeloP){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizar);
            sp.setString(1, modeloP.getIdI());
            sp.setString(2, modeloP.getId());
            sp.setString(3, this.getIdLocal());
            sp.setInt(4, modeloP.getStock());
            sp.setBoolean(5, modeloP.isEstado());
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
    
    public boolean eliminarInventario(Producto modeloP){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(eliminar);
            sp.setString(1, modeloP.getIdI());
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
    
    
}

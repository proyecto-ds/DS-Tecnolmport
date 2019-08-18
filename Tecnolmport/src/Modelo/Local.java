/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Singleton.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bryan
 */
public class Local {
    
    
    protected String id;
    protected String nombre;
    protected String direccion;
    protected TipoLocal tipoLocal;
    protected String tipo;
    protected Inventario inventario;
    
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    
    public Local() {
    }

    public Local(String id, String nombre, String direccion, String tipoLocal) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipoLocal;
    }
    
    public Local(String id, String nombre, String direccion, TipoLocal tipoLocal, Inventario inventario) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoLocal = tipoLocal;
        this.inventario = inventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public ObservableList<Local> obtenerLocales(){
        ObservableList<Local> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call  obtenerLocales ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Local(
                                resultado.getString("idLocal"),
                                resultado.getString("nombre"),
                                resultado.getString("direccion"),
                                resultado.getString("tipo")));
            }
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Local other = (Local) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (this.tipoLocal != other.tipoLocal) {
            return false;
        }
        if (!Objects.equals(this.inventario, other.inventario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Local{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tipoLocal=" + tipoLocal + ", tipo=" + tipo + ", inventario=" + inventario + '}';
    }

    
    
}

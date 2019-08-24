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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanjimenez
 */
public class Ruta {
    
    protected String idRuta;
    protected String zona;
    protected Repartidor repartidor;
    protected String nombreRepartidor;
    protected String apellidoRepartidor;
    
    protected String idEntrega;
    protected String fecha;
    protected String direccion;
    protected String estado;
    
    protected static final Logger LOGGER = Logger.getLogger("Ruta Logger");
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    

    public Ruta(String idRuta, String zona,String nombreRepartidor, String apellidoRepartidor) {
        this.idRuta = idRuta;
        this.zona = zona;
        this.nombreRepartidor=nombreRepartidor;
        this.apellidoRepartidor= apellidoRepartidor;
    }
    
    public Ruta(){ }
    
    public Ruta(String idEntrega, String fecha, String direccion, String estado, String idRuta){
        this.idEntrega = idEntrega;
        this.fecha = fecha;
        this.direccion=direccion;
        this.estado= estado;    
        this.idRuta= idRuta;    
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public String getApellidoRepartidor() {
        return apellidoRepartidor;
    }

    public void setApellidoRepartidor(String apellidoRepartidor) {
        this.apellidoRepartidor = apellidoRepartidor;
    }
    
    
    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getEntregas() {
        return zona;
    }

    public void setEntregas(String entregas) {
        this.zona = entregas;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }
    
    public ObservableList<Ruta> cargarRuta(){
        ObservableList <Ruta> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta ="{call  obtenerRutaEntrega()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery(); 
            while (resultado.next()) {
                lista.add(
                        new Ruta(
                                resultado.getString("idRuta"),
                                resultado.getString("Zona"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido")
                        )); 
            }
        } catch (SQLException  ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    
    public ObservableList<Ruta> cargarDatosRutaEntrega(){
        ObservableList <Ruta> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consultaRuta ="{call datosRutaEntrega1()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consultaRuta);
            ResultSet resultado = ingreso.executeQuery(); 
            while (resultado.next()) {
                lista.add(
                        new Ruta(
                                resultado.getString("idEntrega"),
                                resultado.getString("fecha"),
                                resultado.getString("direccion"),
                                resultado.getString("estado"),
                                resultado.getString("idRuta")
                        ));
            }
        } catch (SQLException  ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}

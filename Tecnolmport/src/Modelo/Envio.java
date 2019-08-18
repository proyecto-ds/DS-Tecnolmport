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
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Modelo.Venta;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author juanjimenez
 */
public class Envio {
    protected String id;
    protected String vent;
    protected String direccion;
    protected String descripcion;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected String estado;
    protected String idEntregaV;
    

    
    
    protected static final Logger LOGGER = Logger.getLogger("Envio Logger");
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    
    
    private final String actualizar = "{call actualizarEntregaEnvioNovedad (? , ?)}";
    private final String actualizarRuta = "{call nullRutaRepartidor ( ? )}";

    public Envio(String id, String vent, String direccion, String descripcion, 
            LocalDate fechaInicio, LocalDate fechaFin, String estado, String idEntregaV) {
        this.id = id;
        this.vent = vent;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.idEntregaV=idEntregaV;
    }

    
    public Envio() {
    }

    public String getIdEntregaV() {
        return idEntregaV;
    }

    public void setIdEntregaV(String idEntregaV) {
        this.idEntregaV = idEntregaV;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVent() {
        return vent;
    }

    public void setVenta(String vent) {
        this.vent = vent;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
            
  
    public ObservableList<Envio> cargarEnvio(String estado){
        ObservableList <Envio> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerEnvioEstado (?)}";
            CallableStatement ingreso = CONNECTION.getConnection().prepareCall(consulta);
            ingreso.setString(1,estado);
            ResultSet resultado = ingreso.executeQuery(); 
            System.out.println("holA");
            while (resultado.next()) {                
                LocalDate sqlDateI = LocalDate.parse(resultado.getString("fechaInicio"));                
                LocalDate sqlDateF = LocalDate.parse(resultado.getString("fechaFin"));
                lista.add(
                        new Envio(
                                resultado.getString("idEnvio"),
                                resultado.getString("id_Venta"),
                                resultado.getString("direccion"),
                                resultado.getString("descripcion"),
                                sqlDateI,
                                sqlDateF,
                                resultado.getString("estado"),
                                resultado.getString("id_Entrega")
                        ));
                System.out.println(sqlDateI+resultado.getString("estado"));
            }
        } catch (SQLException  ex) {
            //LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    
    public boolean registrarNovedadEnvio(String idEnvio,String novedad){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizar);
            sp.setString(1, idEnvio);
            sp.setString(2, novedad);
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException  ex) {
            //LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    /**
     * Actualiza el campo repartidor.Ruta a null en caso que haya una sola
     * Ruta perteneciente a una sola entrega
     * @param ruta Ruta a verificar y modificar
     */
    public void actualizarCampoRepartidorRuta(String ruta){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizarRuta);
            sp.setString(1, ruta);
            sp.execute();
            sp.close();
        } catch (SQLException  ex) {
            //LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
    }
    
    /**
     * Obtenemos una ruta Especifica segun el IdEntrega
     * @param idEntrega
     * @return String Ruta
     */
    public String selectRutaEspecifica(String idEntrega){
        String ruta="";
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerRutaEspecifica (?)}";
            CallableStatement ingreso = CONNECTION.getConnection().prepareCall(consulta);
            ingreso.setString(1,idEntrega);
            ResultSet resultado = ingreso.executeQuery(); 
            ruta = resultado.getString("idRuta");
            System.out.println(ruta);
            
        } catch (SQLException  ex) {
            //LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return ruta;
    }
            
}

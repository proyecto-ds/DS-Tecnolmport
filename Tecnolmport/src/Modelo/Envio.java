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
    protected Venta venta;
    protected String direccion;
    protected String descripcion;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected String estado;
    
    protected static final Logger LOGGER = Logger.getLogger("Envio Logger");
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    
    public Envio(String id, Venta venta, String direccion, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.id = id;
        this.venta = venta;
        this.direccion=direccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Envio() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
            
    public ObservableList<Envio> cargarPedido(){
        ObservableList <Envio> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "select * from envio where estado=3";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery(); 
            
            while (resultado.next()) {                
                LocalDate sqlDateI = LocalDate.parse(resultado.getString("fechaInicio"));                
                LocalDate sqlDateF = LocalDate.parse(resultado.getString("fechaFin"));
                
                Venta venta = new Venta();
                venta.setId(resultado.getString("id_Venta"));
                System.out.println(resultado.getString("idEnvio"));
                lista.add(
                        new Envio(
                                resultado.getString("idEnvio"),
                                venta,
                                resultado.getString("direccion"),
                                resultado.getString("descripcion"),
                                sqlDateI,
                                sqlDateF,
                                resultado.getString("estado")
                        ));
            }
        } catch (SQLException  ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    
    
            
}

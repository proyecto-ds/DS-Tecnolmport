/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Envio.CONNECTION;
import Singleton.DBConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanjimenez
 */
public class Entrega {
    
    protected String id;
    protected String idEnvio;
    protected  List<Envio> envios;
    protected LocalDate date;
    protected String direccion;
    protected List<Pedido> pedidos;
    protected int cantidad;
    protected String descripcion;
    
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Entrega Logger");

    public Entrega(String id, List<Envio> envios, LocalDate date, List<Pedido> pedidos, int cantidad, String descripcion) {
        this.id = id;
        this.envios = envios;
        this.date = date;
        this.pedidos = pedidos;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Entrega(String id, String idEnvio, LocalDate date, String direccion, String descripcion) {
        this.id = id;
        this.idEnvio = idEnvio;
        this.date = date;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public Entrega() {
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObservableList<Entrega> cargarEntrega(){
        ObservableList <Entrega> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerEntrega()}";
            CallableStatement ingreso = CONNECTION.getConnection().prepareCall(consulta);
            ResultSet resultado = ingreso.executeQuery(); 
            while (resultado.next()) {                
                LocalDate sqlDateF = LocalDate.parse(resultado.getString("fecha"));       
                lista.add(
                        new Entrega(
                                resultado.getString("idEntrega"),
                                resultado.getString("idEnvio"),
                                sqlDateF,
                                resultado.getString("e.direccion"),
                                resultado.getString("descripcion")
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

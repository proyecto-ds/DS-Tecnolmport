/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Envio.CONNECTION;
import static Modelo.Producto.LOGGER;
import Modelo.Strategy.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanjimenez
 */
public class Venta {
    
    protected  String id;
    protected Date date;
    protected String descripcion;
    protected int esCotizacion ;
    protected  String local;
    protected  Pago formaPago;
    protected  float subtotal;
    protected  float iva;
    protected float total;
    protected String producto;
    protected String vendedor;
    protected Cliente cliente;
    protected Envio envio = null ;

    public Venta() {
    }

    public Venta(String id, Date date, String descripcion, int esCotizacion, String local, float total, String producto, String vendedor) {
        this.id = id;
        this.date = date;
        this.descripcion = descripcion;
        this.esCotizacion = esCotizacion;
        this.local = local;
        this.total = total;
        this.producto = producto;
        this.vendedor = vendedor;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int isEsCotizacion() {
        return esCotizacion;
    }

    public void setEsCotizacion(int esCotizacion) {
        this.esCotizacion = esCotizacion;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", descripcion=" + descripcion + ", esCotizacion=" + esCotizacion + ", local=" + local + ", formaPago=" + formaPago + ", total=" + total + '}';
    }
    
    public ObservableList<Venta> cargarVenta(){
       ObservableList <Venta> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerVentas ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery(); 
            
            while (resultado.next()) {                
                lista.add(new Venta(
                            resultado.getString("idVenta"),
                            resultado.getDate("fechaVenta"),
                            resultado.getString("DireccionEnvio"),
                            resultado.getInt("esCotizacion"),
                            resultado.getString("Local"),
                            resultado.getFloat("total"),
                            resultado.getString("Producto"),
                            resultado.getString("Vendedor")));
            }
        } catch (SQLException  ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
            
    
    
    
}

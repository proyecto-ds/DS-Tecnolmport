/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Strategy.Pago;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author juanjimenez
 */
public class Venta {
    
    protected  String id;
    protected LocalTime date;
    protected String descripcion;
    protected boolean esCotizacion ;
    protected  Local local;
    protected  Pago formaPago;
    protected  float subtotal;
    protected  float iva;
    protected float total;
    protected  List<Producto> productos;
    protected Vendedor vendedor;
    protected Cliente cliente;
    protected Envio envio = null ;

    public Venta() {
    }

    
    public Venta(String id, LocalTime date, String descripcion, boolean esCotizacion, Local local, float subtotal, float iva, float total, List<Producto> productos, Vendedor vendedor, Cliente cliente, Envio envio) {
        this.id = id;
        this.date = date;
        this.descripcion = descripcion;
        this.esCotizacion = esCotizacion;
        this.local = local;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.productos = productos;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.envio = envio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsCotizacion() {
        return esCotizacion;
    }

    public void setEsCotizacion(boolean esCotizacion) {
        this.esCotizacion = esCotizacion;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
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
    
            
    
    
    
}

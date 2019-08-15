/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author juanjimenez
 */
public class Factura extends Documento{ 
    
    protected String idFactura;
    
    public Factura(String idFactura, String id, Date fechaDocumento, String descripcion, boolean estado, Date fechaExpredicion, Venta venta) {
        super(id, fechaDocumento, descripcion, estado, fechaExpredicion, venta);
        this.idFactura= idFactura;
    }
    
    
    

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaExpredicion() {
        return fechaExpredicion;
    }

    public void setFechaExpredicion(Date fechaExpredicion) {
        this.fechaExpredicion = fechaExpredicion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
}

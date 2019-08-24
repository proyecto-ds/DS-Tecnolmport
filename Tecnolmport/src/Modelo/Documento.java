/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author bryan
 */
public abstract class Documento {
    
    protected String id;
    protected Date fechaDocumento;
    protected String descripcion;
    protected boolean estado;
    protected Date fechaExpredicion;
    protected Venta venta;

    public Documento(String id, Date fechaDocumento, String descripcion, boolean estado, Date fechaExpredicion, Venta venta) {
        this.id = id;
        this.fechaDocumento = fechaDocumento;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaExpredicion = fechaExpredicion;
        this.venta = venta;
    }

    
}

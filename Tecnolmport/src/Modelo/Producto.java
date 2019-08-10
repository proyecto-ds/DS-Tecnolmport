/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author bryan
 */
public class Producto {
    protected String id;
    protected String nombre;
    protected float precio;
    protected String dexcripcion;
    protected String categoria;
    protected String proveedor;
    protected boolean estado;
    
    
    public Producto(String id, String nombre, float precio, String dexcripcion, String categoria, String proveedor, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.dexcripcion = dexcripcion;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.estado = estado;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDexcripcion() {
        return dexcripcion;
    }

    public void setDexcripcion(String dexcripcion) {
        this.dexcripcion = dexcripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

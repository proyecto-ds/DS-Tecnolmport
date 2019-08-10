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
public class Local {
    protected String id;
    protected String nombre;
    protected String direccion;
    protected TipoLocal tipoLocal;
    protected Inventario inventario;
    
    public Local() {
    }
    public Local(String id, String nombre, String direccion, TipoLocal tipoLocal, Inventario inventario) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoLocal = tipoLocal;
        this.inventario = inventario;
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

    

    
    
}

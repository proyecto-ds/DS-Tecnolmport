/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author juanjimenez
 */
class Pedido {
    
    protected String id;
    protected LocalTime fechaPeido;
    protected String descripcion;
    protected boolean estado;
    protected Local local;
    protected List<Producto> productos;
    protected Gerente gerente;

    public Pedido(String id, LocalTime fechaPeido, String descripcion, boolean estado, Local local, List<Producto> productos, Gerente gerente) {
        this.id = id;
        this.fechaPeido = fechaPeido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.local = local;
        this.productos = productos;
        this.gerente = gerente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getFechaPeido() {
        return fechaPeido;
    }

    public void setFechaPeido(LocalTime fechaPeido) {
        this.fechaPeido = fechaPeido;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    
    
    
}

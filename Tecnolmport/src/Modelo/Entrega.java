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
public class Entrega {
    
    protected String id;
    protected  List<Envio> envios;
    protected LocalTime date;
    protected List<Pedido> pedidos;
    protected int cantidad;
    protected String descripcion;

    public Entrega(String id, List<Envio> envios, LocalTime date, List<Pedido> pedidos, int cantidad, String descripcion) {
        this.id = id;
        this.envios = envios;
        this.date = date;
        this.pedidos = pedidos;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
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

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
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


    
}

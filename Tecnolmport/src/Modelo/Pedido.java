/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author juanjimenez
 */
public class Pedido {
    
    protected String id;
    protected LocalTime fechaPeido;
    protected String descripcion;
    protected boolean estado;
    protected Local local;
    protected List<Producto> productos;
    protected Gerente gerente;
    
    
    protected Button botonP;

   
    

    public Pedido(String id, LocalTime fechaPeido, String descripcion, boolean estado, Local local, List<Producto> productos, Gerente gerente) {
        this.id = id;
        this.fechaPeido = fechaPeido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.local = local;
        this.productos = productos;
        this.gerente = gerente;
    }
    
     public Pedido(String id, LocalTime fechaPeido, String descripcion, boolean estado, Local local, List<Producto> productos, Gerente gerente,Button btProducto) {
        this.id = id;
        this.fechaPeido = fechaPeido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.local = local;
        this.productos = productos;
        this.gerente = gerente;
        this.botonP = btProducto;
    }

    public Pedido() {
        
    }
    
    public Pedido(String id, LocalTime fechaPedido, boolean estado, String GerenteNom, Button verProductos) {
        
        
    }
    
    
    
    
//    protected String id;
//    protected String nombre;
//    protected float precio;
//    protected String descripcion;
//    protected String categoria;
//    protected String proveedor;
//    protected boolean estado;
//    
    
    
      public ObservableList <Pedido> llenarTablePedido(TableView tablePedido){
        ObservableList <Pedido> lista = FXCollections.observableArrayList ();
        
        Producto p = new Producto("b","macbook", (float) 34.5,"Nada","sinCat","noHay",true);
        
        List<Producto> productos = new ArrayList<>();
        productos.add(p);
        
        lista.add(new Pedido("0926522703",LocalTime.now(),"tutiven",true,new Local(), productos,new Gerente(),new Button("Ver Productos")));
        tablePedido.getItems().addAll(lista);
        
        return lista;
    }

    

    
     public Button getBotonP() {
        return botonP;
    }

    public void setBotonP(Button botonP) {
        this.botonP = botonP;
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

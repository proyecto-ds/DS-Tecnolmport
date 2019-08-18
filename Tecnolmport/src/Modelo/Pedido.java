/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Producto.CONNECTION;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
    protected LocalTime fechaPedido;
    protected String descripcion;
    protected boolean estado;
    protected Local local;
    protected List<Producto> productos;
    protected String producto;
    protected String gerent;
    protected String loca;
    
    
    protected Gerente gerente;
   

   
    

    public Pedido(String id, LocalTime fechaPedido, String descripcion, boolean estado, Local local, List<Producto> productos, Gerente gerente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.local = local;
        this.productos = productos;
        this.gerente = gerente;
    }
    
     

    public Pedido() {
        
    }

    public Pedido(String id, LocalTime fechaPedido, boolean estado, String producto, String gerent, String loca) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.producto = producto;
        this.gerent = gerent;
        this.loca = loca;
    }

    

    

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getGerent() {
        return gerent;
    }

    public void setGerent(String gerent) {
        this.gerent = gerent;
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
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerPedidos ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Pedido(
                                resultado.getString("idPedido"),
                                LocalTime.parse((CharSequence) resultado.getDate("fechaPedido")),
                                resultado.getBoolean("estado"),
                                resultado.getString("Producto"),
                                resultado.getString("Gerente"),
                                resultado.getString("Local")));
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
      
      
      
      
    
      
      

    

    
    
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPeido(LocalTime fechaPedido) {
        this.fechaPedido = fechaPedido;
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

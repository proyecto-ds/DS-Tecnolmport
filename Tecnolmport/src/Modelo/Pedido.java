/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Producto.CONNECTION;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanjimenez
 */
public class Pedido {
    
    protected String id;
    protected Date fechaPedido;
    protected String descripcion;
    protected boolean estado;
    protected Local local;
    protected List<Producto> productos;
    protected String producto;
    protected String gerent;
    protected String loc;
    protected String observaciones;
    protected int esta;
    protected String idEntrega;
    
    private final String guardarPedido = "{call   ingresarPedido (?,?,?,?,?)}";
    private final String guardarDPedido = "{call  ingresarDetallePedido (?,?,?)}";
    private final String actualizarNegarPedido = "{call actualizarNegarPedido ( ? )}";
    protected Gerente gerente;

    public Pedido() {
        
    }

    public Pedido(String id, Date fechaPedido, String descripcion, boolean estado, Local local, List<Producto> productos, String gerente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.local = local;
        this.productos = productos;
        this.gerent = gerente;
    }

    
    
    public Pedido(String id, Date fechaPedido, boolean estado, String producto, String gerent, String observaciones, String loca) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.producto = producto;
        this.gerent = gerent;
        this.observaciones = observaciones;
        this.loc = loca;
    }
    
    public Pedido(String id, Date fechaPedido, int esta, String producto, String gerent, String observaciones, String loca, String idEntrega) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.esta = esta;
        this.producto = producto;
        this.gerent = gerent;
        this.observaciones = observaciones;
        this.loc = loca;
        this.idEntrega=idEntrega; 
    }
    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }
    
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    
  
      public ObservableList <Pedido> llenarTablePedido(){
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
                                resultado.getDate("fechaPedido"),
                                resultado.getBoolean("estado"),
                                resultado.getString("Producto"),
                                resultado.getString("Gerente"),
                                resultado.getString("observaciones"),
                                String.valueOf(resultado.getString("Local")
                                )));
            }
        } catch (SQLException e) {
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
      
      public ObservableList <Pedido> llenarTablePedidoNovedades(String estado){
        ObservableList <Pedido> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call obtenerPedidosNovedad(?)}";
            CallableStatement ingreso = CONNECTION.getConnection().prepareCall(consulta);
            ingreso.setString(1,estado);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Pedido(
                                resultado.getString("idPedido"),
                                resultado.getDate("fechaPedido"),
                                resultado.getInt("estado"),
                                resultado.getString("Producto"),
                                resultado.getString("Gerente"),
                                resultado.getString("observaciones"),
                                String.valueOf(resultado.getString("Local")),
                                resultado.getString("idEntrega")
                        ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    public boolean registroPedido(Pedido p){
        if (guardarPedido(p)){
            return gDetallePedido(p);
        }
        else{
            return false;
        }  
    }
      public boolean guardarPedido(Pedido p){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(guardarPedido);
            sp.setString(1, p.getId());
            sp.setString(2, p.getDescripcion());
            sp.setDate(3, p.getFechaPedido());
            sp.setString(4, p.getGerent());
            sp.registerOutParameter(5, Types.VARCHAR);
            sp.execute();
            this.setId(sp.getString(5));
            sp.close();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
      
     public boolean gDetallePedido(Pedido p){
         try {
            CONNECTION.conectar();
            for(Producto listp : p.getProductos()){
                CallableStatement sp = CONNECTION.getConnection().prepareCall(guardarDPedido);
                sp.setString(1, this.getId());
                sp.setString(2, listp.getId());
                sp.setInt(3, listp.getStock());
                sp.execute();
                sp.close();
            }
            
            return true;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            CONNECTION.desconectar();
        }
         return false;
     }
     
     public void actualizarNegarPedido(String idPedido){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizarNegarPedido);
            sp.setString(1, idPedido);
            sp.execute();
            sp.close();
        } catch (SQLException  ex) {
            ex.getMessage();
        } finally {
            CONNECTION.desconectar();
        }
    }
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPeido(Date fechaPedido) {
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

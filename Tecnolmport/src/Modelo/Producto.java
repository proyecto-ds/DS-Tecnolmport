
package Modelo;

import Singleton.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bryan
 */
public class Producto {
    protected String idI;
    protected String id;
    protected String nombre;
    protected float precio;
    protected String descripcion;
    protected String categoria;
    protected String proveedor;
    protected boolean estado;
    protected int stock;
    
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    private final String actualizar = "{call  actualizarProducto (?,?,?,?,?,?,?)}";
    private final String ingresar = "{call   ingresarProducto(?,?,?,?,?,?,?)}";
    private final String eliminar = "{call   eliminarProducto (?)}";

    public Producto() {
    }

    public Producto(String idI, String id, String nombre, float precio, String descripcion, String categoria, String proveedor, boolean estado, int stock) {
        this.idI = idI;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.estado = estado;
        this.stock = stock;
    }
    
    
    public Producto(String id, String nombre, float precio, String descripcion, String categoria, String proveedor, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.estado = estado;
    }

    public String getIdI() {
        return idI;
    }

    public void setIdI(String idI) {
        this.idI = idI;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    public ObservableList<Producto> llenarTableProducto(){
        ObservableList <Producto> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta = "{call  obtenerProductos ()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Producto(
                                resultado.getString("idProducto"),
                                resultado.getString("nombre"),
                                resultado.getFloat("precio"),
                                resultado.getString("categoria"),
                                resultado.getString("descripcion"),
                                resultado.getString("proveedor"),
                                resultado.getBoolean("estado")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    public boolean ingresarProducto(){
        try {
            CONNECTION.conectar();
            PreparedStatement sp = CONNECTION.getConnection().prepareStatement(ingresar);
            sp.setString(1, this.getId());
            sp.setString(2, this.getNombre());
            sp.setFloat(3, this.getPrecio());
            sp.setString(4, this.getCategoria());
            sp.setString(5, this.getDescripcion());
            sp.setString(6, this.getProveedor());
            sp.setBoolean(7, this.isEstado());
            sp.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    public boolean actualizarProducto(){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(actualizar);
            sp.setString(1, this.getId());
            sp.setString(2, this.getNombre());
            sp.setFloat(3, this.getPrecio());
            sp.setString(4, this.getCategoria());
            sp.setString(5, this.getDescripcion());
            sp.setString(6, this.getProveedor());
            sp.setBoolean(7, this.isEstado());
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Producto{" + "idI=" + idI + ", id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", categoria=" + categoria + ", proveedor=" + proveedor + ", estado=" + estado + ", stock=" + stock + '}';
    }
    
    public boolean eliminarProducto(){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(eliminar);
            sp.setString(1, this.getId());
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    /**
     * Para JUnitTest 
     * @param lista Tipo Producto
     * @param nombre Nombre Producto
     * @return True si el Producto existe.
     */
    public boolean buscarExistenciaProducto(List<Producto> lista, String nombre){
        for(Producto p: lista)
            if(p.getNombre().equals(id))
                return true;
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Envio.CONNECTION;
import Singleton.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author juanjimenez
 */
public class Ruta {
    
    protected String idRuta;
    protected String zona;
    protected Repartidor repartidor;
    protected String nombreRepartidor;
    protected String apellidoRepartidor;
    
    protected static final Logger LOGGER = Logger.getLogger("Ruta Logger");
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected final String consultaRuta= "select r.idRuta, r.zona, e.nombre, e.apellido from ruta r, empleado e where r.id__Empleado = e.idEmpleado";
    

    public Ruta(String idRuta, String zona,String nombreRepartidor, String apellidoRepartidor) {
        this.idRuta = idRuta;
        this.zona = zona;
        this.nombreRepartidor=nombreRepartidor;
        this.apellidoRepartidor= apellidoRepartidor;
    }
    
    public Ruta(){}

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public String getApellidoRepartidor() {
        return apellidoRepartidor;
    }

    public void setApellidoRepartidor(String apellidoRepartidor) {
        this.apellidoRepartidor = apellidoRepartidor;
    }
    
    
    public String ObtenerDirecciones(Entrega e){
        return "rutas";
        
    }
    
    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getEntregas() {
        return zona;
    }

    public void setEntregas(String entregas) {
        this.zona = entregas;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }
    
    public ObservableList<Ruta> cargarRuta(){
        ObservableList <Ruta> lista = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            String consulta ="{call  obtenerRutaEntrega()}";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ResultSet resultado = ingreso.executeQuery(); 
            while (resultado.next()) {
                lista.add(
                        new Ruta(
                                resultado.getString("idRuta"),
                                resultado.getString("Zona"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido")
                        ));
            System.out.println(resultado.getString("zona")+" "+resultado.getString("nombre")+" "+resultado.getString("apellido"));
                
            }
        } catch (SQLException  ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return lista;
    }
    

}

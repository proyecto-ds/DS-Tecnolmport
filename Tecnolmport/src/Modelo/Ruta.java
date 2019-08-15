/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author juanjimenez
 */
public class Ruta {
    
    protected String idRuta;
    protected List<Entrega> entregas;
    protected Repartidor repartidor;

    public Ruta(String idRuta, List<Entrega> entregas, Repartidor repartidor) {
        this.idRuta = idRuta;
        this.entregas = entregas;
        this.repartidor = repartidor;
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

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }
    

}

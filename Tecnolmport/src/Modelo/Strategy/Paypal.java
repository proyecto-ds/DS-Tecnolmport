/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Strategy;

/**
 *
 * @author juanjimenez
 */
public class Paypal implements Pago{

    protected String usuario;
    protected String clave ;
    protected double dinero;

    public Paypal(String usuario, String clave, double dinero) {
        this.usuario = usuario;
        this.clave = clave;
        this.dinero = dinero;
    }
    
     
    @Override
    public boolean pagar(String idCliente) {
        return  true;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    
    
   
    
}

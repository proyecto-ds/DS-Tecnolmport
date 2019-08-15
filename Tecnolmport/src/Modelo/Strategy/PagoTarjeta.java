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
public class PagoTarjeta implements Pago{
    
    protected int numTarjeta;
    protected boolean hasCredit;
    protected double dinero;

    public PagoTarjeta(int numTarjeta, boolean hasCredit, double dinero) {
        this.numTarjeta = numTarjeta;
        this.hasCredit = hasCredit;
        this.dinero = dinero;
    }

    
    
    
    @Override
    public boolean pagar(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public boolean isHasCredit() {
        return hasCredit;
    }

    public void setHasCredit(boolean hasCredit) {
        this.hasCredit = hasCredit;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
            
    

    
}

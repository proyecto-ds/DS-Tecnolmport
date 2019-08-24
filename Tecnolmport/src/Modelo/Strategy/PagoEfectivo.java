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
public class PagoEfectivo implements Pago{

    protected int cantdBilletes;
    protected double denominacion;

    public PagoEfectivo(int cantdBilletes, double denominacion) {
        this.cantdBilletes = cantdBilletes;
        this.denominacion = denominacion;
    }
    
    
    @Override
    public boolean pagar(String idCliente) {
         return true;
    }

    public int getCantdBilletes() {
        return cantdBilletes;
    }

    public void setCantdBilletes(int cantdBilletes) {
        this.cantdBilletes = cantdBilletes;
    }

    public double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(double denominacion) {
        this.denominacion = denominacion;
    }
    
    
    
    
    
}

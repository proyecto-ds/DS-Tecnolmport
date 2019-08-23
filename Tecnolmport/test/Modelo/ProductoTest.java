/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rogencio
 */
public class ProductoTest {
    Producto producto = new Producto("007", "cargador", 0, "Muy bueno", "Smartphone", "Panasonic", true);
    Producto pPrueba = new Producto("008", "cargador", 0, "Muy bueno", "Smartphone", "Panasonic", true);
    
    Producto producto2 = new Producto("008", "cargador", 0, "Muy bueno", "Smartphone", "Panasonic", true);
    
    /**
     * No agrega el producto en caso que exista.
     */
    @Test
    public void testProductoExistente() {
        boolean agregadoProducto=producto.ingresarProducto();
        assertFalse(agregadoProducto && producto.buscarExistenciaProducto(producto.llenarTableProducto(), pPrueba.getNombre()));
    }
    
    /**
     * Agrega el nuevo producto en caso que no exista.
     * (Ejecutar una sola vez porque la funcion agrega a la base el producto una vez ejecutado)
     */
    @Test
    public void testAgregarProducto() {
        boolean agregadoProducto=producto2.ingresarProducto();
        assertTrue(agregadoProducto && !producto.buscarExistenciaProducto(producto.llenarTableProducto(), producto2.getNombre()));
    }
    
}

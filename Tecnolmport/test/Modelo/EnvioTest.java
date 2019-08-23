/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rogencio
 */
public class EnvioTest {
    Envio instance = new Envio("0001","0001","Samborondon y la 22","Casa amarilla con techo rojo",LocalDate.parse("2019-08-14"),
                LocalDate.parse("2019-09-14"),"1","0001");   
    Envio instance2 = new Envio("0002","0002","Guayacan y la 22","Casa azul con techo rojo",LocalDate.parse("2019-08-14"),
                LocalDate.parse("2019-09-15"),"1","0001"); 
    List<Envio> envios = new LinkedList<>();
    
    /**
     * Comprueba que se haya registrado la novedad con un idExistente.
     */
    @Test
    public void testRegistrarNovedadEnvio() {
        envios.add(instance);
        boolean bExistencia = instance.buscarExistenciaEnvio(envios, "0001");
        boolean result = instance.registrarNovedadEnvio("0001", "Entrega finalizada con éxito");
        assertTrue(result && bExistencia);
    }
    
    /**
     * Comprueba que no se haya registrado la novedad con un idInexistente.
     */
    @Test
    public void testNoRegistrarNovedadEnvio() {
        envios.add(instance);
        boolean bExistencia = instance.buscarExistenciaEnvio(envios, "0002");
        boolean result = instance.registrarNovedadEnvio("0002", "Entrega sin recibir");
        assertFalse(result && bExistencia);
    }

    /**
     * No actualiza el estado del envio en caso que no exista el envío.
     */
    @Test
    public void testNotActualizarNegarEnvio() {
        envios.add(instance2);
        boolean bExistencia = instance.buscarExistenciaEnvio(envios, "0008");
        boolean result =instance.actualizarNegarEnvio("0008");
        assertFalse(result && bExistencia);
    }
    
    /**
     * Actualiza el estado del envio en caso que exista el envío.
     */
    @Test
    public void testActualizarNegarEnvio() {
        envios.add(instance2);
        boolean bExistencia = instance.buscarExistenciaEnvio(envios, "0002");
        boolean result =instance.actualizarNegarEnvio("0002");
        assertTrue(result && bExistencia);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import Modelo.Repartidor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBAsignarRuta implements Initializable {

    @FXML private JFXComboBox<String> cb_repartidor;
    @FXML private JFXButton btn_asignarRuta;
    @FXML private TableView<?> tbl_rutaEntrega;
    protected Repartidor repartidor = new Repartidor();
    @FXML
    private JFXComboBox<String> cb_FiltrarRuta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LinkedList<String> nombre =repartidor.obtenerRepartidorDisponible();
        cb_FiltrarRuta.getItems().addAll("Norte","Sur","Centro","Este","Oeste");
        if(!comprobarNulidad(nombre))
            cb_repartidor.getItems().addAll(nombre);
    }    
    
    /**
     * Comprueba que la lista pasada no este vacia
     * @param lista Lista
     * @return True si esta llena
     */
    private boolean comprobarNulidad(List lista){
        return lista.isEmpty();
    }
            

    @FXML
    private void seleccionarRepartidor(ActionEvent event) {
        
    }

    @FXML
    private void asignarRuta(ActionEvent event) {
    }

    @FXML
    private void seleccionarRuta(ActionEvent event) {
    }
    
}

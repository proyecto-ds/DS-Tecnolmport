/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
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
public class ControladorJefeAsignarRuta implements Initializable {

    @FXML
    private JFXComboBox<String> cb_repartidor;
    @FXML
    private JFXButton btn_asignarRuta;
    @FXML
    private TableView<?> tbl_rutaEntrega;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_repartidor.getItems().addAll("Jhonny","Scarlett","Steve");
    }    

    @FXML
    private void seleccionarRepartidor(ActionEvent event) {
    }

    @FXML
    private void asignarRuta(ActionEvent event) {
    }
    
}

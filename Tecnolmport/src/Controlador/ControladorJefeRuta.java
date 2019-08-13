/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class ControladorJefeRuta implements Initializable {

    @FXML
    private JFXTextField txtf_escribirRuta;
    @FXML
    private JFXButton btn_agregarRuta;
    @FXML
    private ListView<?> lv_entregas;
    @FXML
    private JFXComboBox<?> cb_repartidor;
    @FXML
    private ListView<?> lv_rutasCreadas;
    @FXML
    private JFXButton btn_guardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void seleccionarRepartidor(ActionEvent event) {
    }
    
}

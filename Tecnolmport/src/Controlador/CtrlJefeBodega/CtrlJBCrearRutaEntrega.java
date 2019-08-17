/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBCrearRutaEntrega implements Initializable {

    @FXML private JFXComboBox<String> cb_seleccionarRuta;
    @FXML private TableView<?> tbl_rutaEntrega;
    @FXML private TableColumn<?, ?> tbl_entrega;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_seleccionarRuta.getItems().addAll("Norte","Sur","Centro","Este","Oeste");
    }    

    @FXML
    private void seleccionarRuta(ActionEvent event) {
    }
    
}

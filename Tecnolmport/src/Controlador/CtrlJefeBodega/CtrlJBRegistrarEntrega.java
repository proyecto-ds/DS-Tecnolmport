/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import com.jfoenix.controls.JFXButton;
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
public class CtrlJBRegistrarEntrega implements Initializable {

    @FXML
    private TableView<?> tbl_pedido;
    @FXML
    private TableView<?> tbl_envio;
    @FXML
    private JFXButton btn_registrarPedido;
    @FXML
    private JFXButton btn_negarPedido;
    @FXML
    private JFXButton btn_registrarEnvio;
    @FXML
    private JFXButton btn_negarEnvio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_registrarPedido(ActionEvent event) {
    }

    @FXML
    private void act_negarPedido(ActionEvent event) {
    }

    @FXML
    private void act_registrarEnvio(ActionEvent event) {
    }

    @FXML
    private void act_negarEnvio(ActionEvent event) {
    }
    
}

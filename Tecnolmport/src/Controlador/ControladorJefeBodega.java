/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class ControladorJefeBodega implements Initializable {

    @FXML
    private JFXButton btn_consultarEntrega;
    @FXML
    private JFXButton btn_registrarEntregas;
    @FXML
    private JFXButton btn_registrarNovedades;
    @FXML
    private AnchorPane root1;
    @FXML
    private JFXButton btn_crearAsignarRuta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearAsignarRuta(ActionEvent event) throws IOException {
        AnchorPane user = FXMLLoader.load(getClass().getResource(("/Vista/VistaJefeRuta.fxml")));
        root1.getChildren().setAll(user);
    }

    @FXML
    private void consultarEntrega(ActionEvent event) {
    }

    @FXML
    private void registrarEntregas(ActionEvent event) {
    }


    @FXML
    private void registrarNovedades(ActionEvent event) {
    }

    
    
}

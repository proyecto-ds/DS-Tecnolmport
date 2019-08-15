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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class ControladorJefeBodega implements Initializable {


    @FXML private JFXButton btnCerrarSesion;
    @FXML private JFXButton btnAdmin;
    @FXML private Pane parentRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearAsignarRuta(ActionEvent event) throws IOException {
        AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaJefeRuta.fxml")));
        parentRoot.getChildren().setAll(vistaCARuta);
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cargarMenuAdmin(ActionEvent event) throws IOException {
        AnchorPane vistaAdmin = FXMLLoader.load(getClass().getResource(("/Vista/vistaMenuAdministrador.fxml")));
        parentRoot.getChildren().setAll(vistaAdmin);
    }


    
    
}

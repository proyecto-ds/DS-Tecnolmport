/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import static Controlador.ControladorLogin.permi;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML private JFXButton btn_crearRuta;
    @FXML private JFXButton btn_asignarRuta;
    @FXML private JFXButton btn_mostrarRutas;
    @FXML private JFXButton btn_registrarEntrega;
    @FXML private JFXButton btn_registrarNovedad;
    @FXML private JFXButton btn_consultarArticulo;
    //private String permis = " ";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(permi == null){
            btnAdmin.setDisable(true);
        }
        else if(permi.equals("admin")){
            btnAdmin.setDisable(false);
        }
        else if(permi.equals("null")){
            btnAdmin.setDisable(true);
        }
        else{
            btnAdmin.setDisable(true);
        }
    }    

    @FXML
    private void crearRuta(ActionEvent event) throws IOException {
        AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/JefeB/VistaJBCrearRuta.fxml")));
        parentRoot.getChildren().setAll(vistaCARuta);
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cargarMenuAdmin(ActionEvent event) throws IOException {
        AnchorPane vistaAdmin = FXMLLoader.load(getClass().getResource(("/Vista/vistaMenuAdministrador.fxml")));
        parentRoot.getChildren().setAll(vistaAdmin);
    }
    

    @FXML
    private void AsignarRuta(ActionEvent event) throws IOException {
        AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/JefeB/VistaJBAsignarRuta.fxml")));
        parentRoot.getChildren().setAll(vistaCARuta);
    }

    @FXML
    private void mostrarRuta(ActionEvent event) throws IOException {      
        AnchorPane vistaMostrarRuta = FXMLLoader.load(getClass().getResource(("/Vista/JefeB/VistaJBMostrarRuta.fxml")));
        parentRoot.getChildren().setAll(vistaMostrarRuta);
        //Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    }

    @FXML
    private void registrarEntrega(ActionEvent event) throws IOException {
        AnchorPane vistaMostrarRuta = FXMLLoader.load(getClass().getResource(("/Vista/JefeB/VistaJBRegistrarEntrega.fxml")));
        parentRoot.getChildren().setAll(vistaMostrarRuta);
    }


    @FXML
    private void registrarNovedad(ActionEvent event) throws IOException {
        AnchorPane vistaMostrarRuta = FXMLLoader.load(getClass().getResource(("/Vista/JefeB/VistaJBRegistrarNovedad.fxml")));
        parentRoot.getChildren().setAll(vistaMostrarRuta);
    }

    @FXML
    private void act_consultarArticulo(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaBusquedaArticulo.fxml")));
        parentRoot.getChildren().setAll(vistaBA);
    }


    
    
}

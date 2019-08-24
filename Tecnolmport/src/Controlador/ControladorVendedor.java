/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorVendedor implements Initializable {

    
    @FXML private JFXComboBox<String> cbxConsultar;
    @FXML private JFXComboBox<String> cbxRegistrar;
    @FXML private JFXComboBox<String> cbxActualizar;
    @FXML private Label labelVendedor;
    @FXML private JFXButton btnCerrarSesion;
    @FXML private Pane parent;
    private final String cliente="Cliente",venta ="Venta", cotizacion="Cotizacion";
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxConsultar.getItems().addAll(cliente,cotizacion,"EnvioDomicilio","Producto",venta,"NotaDeCredito");
        cbxRegistrar.getItems().addAll(cliente,cotizacion,venta,"NotaDeCredito");
        cbxActualizar.getItems().addAll(cliente,venta);
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
    private void consultarItem(ActionEvent event) throws IOException {
        String tipoConsulta = cbxConsultar.getValue();
        if(tipoConsulta.equalsIgnoreCase("producto")){
            AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaBusquedaArticulo.fxml")));
            parent.getChildren().setAll(vistaBA);
        }
    }
    
}

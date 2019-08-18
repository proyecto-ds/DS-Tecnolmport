/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Empleado;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxConsultar.getItems().addAll("Cliente","Cotizacion","EnvioDomicilio","Producto","Venta","NotaDeCredito");
        cbxRegistrar.getItems().addAll("Cliente","Cotizacion","Venta","NotaDeCredito");
        cbxActualizar.getItems().addAll("Cliente","Venta");
    }   
    void consultarEmpleado(ActionEvent event) {
        
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}

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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorVendedor implements Initializable {

    
    @FXML private Label labelGerente;
    @FXML private JFXComboBox<String> cbxConsultar;
    @FXML private JFXComboBox<String> cbxRegistrar;
    @FXML private JFXComboBox<String> cbxActualizar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxConsultar.getItems().addAll("Cliente","Cotizacion","EnvioDomicilio","Venta","NotaDeCredito");
        cbxRegistrar.getItems().addAll("Cliente","Cotizacion","Venta","NotaDeCredito");
        cbxActualizar.getItems().addAll("Cliente","Venta");
    }   
    void consultarEmpleado(ActionEvent event) {
        
    }
    
}

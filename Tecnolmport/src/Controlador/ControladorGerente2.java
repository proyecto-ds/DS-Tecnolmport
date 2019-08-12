/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Empleado;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerente2 implements Initializable {

    
    @FXML private Label labelGerente;
    @FXML private JFXButton btnEmpleado;
    
    private ObservableList <Empleado> lista = FXCollections.observableArrayList ();
    private Empleado modeloEmpleado;
    private ObservableList<Empleado> listaEmpleado;
    @FXML private AnchorPane root;
    @FXML
    private Label labelNameG1;
    @FXML
    private Label labelNameG12;
    @FXML
    private Label labelNameG121;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    void consultarEmpleado(ActionEvent event) throws IOException {
        AnchorPane user = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerente_1.fxml")));
        root.getChildren().setAll(user);
    }

    @FXML
    private void presentarNombre(ActionEvent event) throws IOException {
        AnchorPane user = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerente_3.fxml")));
        root.getChildren().setAll(user);
    }
    
}

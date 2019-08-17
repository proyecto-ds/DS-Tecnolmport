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
public class ControladorGerente1 implements Initializable {

    
    @FXML private Label labelGerente;
    @FXML private TableView<Empleado> tableEmpleado;
    @FXML private JFXButton btnEmpleado;
    @FXML private TableColumn<Empleado, String> cid;
    @FXML private TableColumn<Empleado, String> cnombre;
    @FXML private TableColumn<Empleado, String> capellido;
    @FXML private TableColumn<Empleado, String> ctelefono;
    @FXML private TableColumn<Empleado, String> cdireccion;
    @FXML private TableColumn<Empleado, String> cemail;
    @FXML private TableColumn<Empleado, String> clocal;
    
    private ObservableList <Empleado> lista = FXCollections.observableArrayList ();
    private Empleado modeloEmpleado;
    private ObservableList<Empleado> listaEmpleado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cid.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        cnombre.setCellValueFactory(new PropertyValueFactory<Empleado,String>("nombre"));
        capellido.setCellValueFactory(new PropertyValueFactory<Empleado,String>("apellido"));
        ctelefono.setCellValueFactory(new PropertyValueFactory<Empleado,String>("telefono"));
        cdireccion.setCellValueFactory(new PropertyValueFactory<Empleado,String>("direccion"));
        cemail.setCellValueFactory(new PropertyValueFactory<Empleado,String>("email"));
        clocal.setCellValueFactory(new PropertyValueFactory<Empleado,String>("local"));
        Empleado e = new Empleado();
        //e.llenarTableEmpleado(tableEmpleado);
    }
    @FXML
    void consultarEmpleado(ActionEvent event) {
        //tableEmpleado.setVisible(true);
        
    }
    
}

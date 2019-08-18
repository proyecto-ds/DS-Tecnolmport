/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Empleado;
import Modelo.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerenteEmpleados implements Initializable {

   
    
    
     @FXML
    private TableView<Usuario> table_empleado;
    
  
    @FXML private TableColumn<Usuario, String> table_id;
    @FXML private TableColumn<Usuario, String> table_nombre;
    @FXML private TableColumn<Usuario, String> table_apel;
    @FXML private TableColumn<Usuario, String> table_email;
    @FXML private TableColumn<Usuario, String> table_local;
    @FXML private TableColumn<Usuario, String> table_user;
    @FXML private TableColumn<Usuario, String> table_rol;
    @FXML private TableColumn<Usuario, String> table_tel;
    @FXML private TableColumn<Usuario, String> table_estado;
    @FXML private TableColumn<Usuario, String> table_salario;
    
   // private ObservableList <Empleado> lista = FXCollections.observableArrayList ();
    //private Empleado modeloEmpleado;
      private ObservableList<Usuario> list = null;
    
    private Usuario modeloUsuario = new Usuario();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table_apel.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        table_tel.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        table_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table_local.setCellValueFactory(new PropertyValueFactory<>("local"));
        table_rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        table_user.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        table_estado.setCellValueFactory(new PropertyValueFactory<>("activo"));
        table_salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
         llenarTable();
      
    }
    
    
      public void llenarTable(){
        if(list == null){
            list = modeloUsuario.llenarTableEmpleado();
            table_empleado.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloUsuario.llenarTableEmpleado();
            table_empleado.setItems(list);
        }
        
    }

    @FXML
    private void seleccionarEmpleado(MouseEvent event) {
    }

    
}

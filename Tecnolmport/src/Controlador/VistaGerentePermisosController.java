/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author juanjimenez
 */
public class VistaGerentePermisosController implements Initializable {

    @FXML
    private Label lblTitutlo;
    @FXML
    private TableView<Usuario> table_empleado;
    @FXML
    private TableColumn<Usuario, String> table_id;
    @FXML
    private TableColumn<Usuario, String> table_nombre;
    @FXML
    private TableColumn<Usuario, String> table_apel;
    @FXML
    private TableColumn<Usuario, String> table_user;
    @FXML
    private TableColumn<Usuario, String> table_rol;
    @FXML
    private TableColumn<Usuario, String> table_email;
    @FXML
    private TableColumn<Usuario, String> table_tel;
    @FXML
    private TableColumn<Usuario, String> table_local;
    @FXML
    private TableColumn<Usuario, String> table_estado;
    @FXML
    private Button btnAsigPermisos;
    
    private Usuario modeloUsuario = new Usuario();
    private ObservableList<Usuario> list = null;

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
       
        llenarTable();
    }    

      public void llenarTable(){
        if(list == null){
            list = modeloUsuario.llenarTableEmpleadoPAdmin();
            //System.out.println(list.toString());
            table_empleado.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloUsuario.llenarTableEmpleadoPAdmin();
            table_empleado.setItems(list);
        }
        
    }

    @FXML
    private void ObtenerUsuario(ActionEvent event) {
        
         Usuario us =  table_empleado.getSelectionModel().getSelectedItem();
        
        System.out.println(us.toString());
        
        
    }

    
    
   
    

  

    
}

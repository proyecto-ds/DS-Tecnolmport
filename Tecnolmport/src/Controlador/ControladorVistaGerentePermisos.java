
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
public class ControladorVistaGerentePermisos implements Initializable {

    @FXML private Label lblTitutlo;
    @FXML private TableView<Usuario> tableEmpleado;
    @FXML private TableColumn<Usuario, String> tableId;
    @FXML private TableColumn<Usuario, String> tableNombre;
    @FXML private TableColumn<Usuario, String> tableApel;
    @FXML private TableColumn<Usuario, String> tableUser;
    @FXML private TableColumn<Usuario, String> tableRol;
    @FXML private TableColumn<Usuario, String> tableEmail;
    @FXML private TableColumn<Usuario, String> tableTel;
    @FXML private TableColumn<Usuario, String> tableLocal;
    @FXML private TableColumn<Usuario, String> tableEstado;
    @FXML private TableColumn<Usuario, String> tablePermiso;
    @FXML private Button btnAsigPermisos;
    
    private final Usuario modeloUsuario = new Usuario();
    private ObservableList<Usuario> list = null;
    @FXML
    private Button btnQuitarPerm;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableApel.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        tableRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tableUser.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tableEstado.setCellValueFactory(new PropertyValueFactory<>("activo"));
        tablePermiso.setCellValueFactory(new PropertyValueFactory<>("permisoAdmin"));
       
        llenarTable();
    }    

      public void llenarTable(){
        if(list == null){
            list = modeloUsuario.llenarTableEmpleadoPAdmin();
            tableEmpleado.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloUsuario.llenarTableEmpleadoPAdmin();
            tableEmpleado.setItems(list);
        }
    }

    @FXML
    private void seleccionarAdmin(MouseEvent event) {
        Usuario us =  tableEmpleado.getSelectionModel().getSelectedItem();
        modeloUsuario.setId(us.getId());
    }

    @FXML
    private void asingarPermi(ActionEvent event) {
        modeloUsuario.setPermisoAdmin("admin");
        modeloUsuario.actualizarPermiso();
        llenarTable();
    }

    @FXML
    private void quitarPermi(ActionEvent event) {
        modeloUsuario.setPermisoAdmin("null");
        modeloUsuario.actualizarPermiso();
        llenarTable();
    }

    
    
   
    

  

    
}

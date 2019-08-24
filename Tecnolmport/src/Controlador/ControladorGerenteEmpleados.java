
package Controlador;


import Modelo.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerenteEmpleados implements Initializable {

    @FXML private TableView<Usuario> tableEmpleado;
    @FXML private TableColumn<Usuario, String> tableId;
    @FXML private TableColumn<Usuario, String> tableNombre;
    @FXML private TableColumn<Usuario, String> tableApel;
    @FXML private TableColumn<Usuario, String> tableEmail;
    @FXML private TableColumn<Usuario, String> tableLocal;
    @FXML private TableColumn<Usuario, String> tableUser;
    @FXML private TableColumn<Usuario, String> tableRol;
    @FXML private TableColumn<Usuario, String> tableTel;
    @FXML private TableColumn<Usuario, String> tableEstado;
    @FXML private TableColumn<Usuario, String> tableSalario;
    private ObservableList<Usuario> list = null;
    private final Usuario modeloUsuario = new Usuario();
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
        tableSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
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
}


package Controlador;

import Modelo.TipoLocal;
import Modelo.Usuario;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGestionarEmpleado implements Initializable {

    @FXML private JFXTextField idEmpleado;
    @FXML private JFXTextField nomEmpleado;
    @FXML private JFXTextField apeEmpleado;
    @FXML private JFXTextField teleEmpleado;
    @FXML private JFXTextField dirEmpelado;
    @FXML private JFXTextField emailEmpleado;
    @FXML private JFXTextField localEmpleado;
    @FXML private JFXTextField usuario;
    @FXML private JFXTextField clave;
    @FXML private JFXTextField rol;
    @FXML private JFXTextField estado;
    @FXML private JFXTextField salario;
    
    @FXML private TableView<Usuario> tableEmpleado;
    @FXML private TableColumn<Usuario, String> tableId;
    @FXML private TableColumn<Usuario, String> tableNombre;
    @FXML private TableColumn<Usuario, String> tableApel;
    @FXML private TableColumn<Usuario, String> tableDir;
    @FXML private TableColumn<Usuario, String> tableEmail;
    @FXML private TableColumn<Usuario, String> tableLocal;
    @FXML private TableColumn<Usuario, String> tableUser;
    @FXML private TableColumn<Usuario, String> tableClave;
    @FXML private TableColumn<Usuario, String> tableRol;
    @FXML private TableColumn<Usuario, String> tableTel;
    @FXML private TableColumn<Usuario, String> tableEstado;
    @FXML private TableColumn<Usuario, String> tableSalario;
    @FXML private JFXComboBox<String> cbxRol;
    @FXML private JFXComboBox<TipoLocal> cbxLocal;
    @FXML private JFXComboBox<Boolean> cbxEstado;
    private final Usuario modeloUsuario = new Usuario();
    private final ControladorValidar validar =  new ControladorValidar();
    private ObservableList<Usuario> list = null;
    private Usuario user = null;
    
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
        tableDir.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        tableUser.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tableClave.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        tableRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tableTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableEstado.setCellValueFactory(new PropertyValueFactory<>("activo"));
        tableSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        cbxLocal.getItems().addAll(TipoLocal.bodega,TipoLocal.matriz,TipoLocal.sucursal);
        cbxRol.getItems().addAll("Gerentre","Vendedor","Jefe","Repartidor");
        cbxEstado.getItems().addAll(true,false);
        llenarTable();
    }
    
    
    
    public void llenarTable(){
        if(list == null){
            list = modeloUsuario.llenarTableEmpleado();
            tableEmpleado.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloUsuario.llenarTableEmpleado();
            tableEmpleado.setItems(list);
        }
        
    }

    @FXML
    private void ingresarEmpelado(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloUsuario.ingresarEmpleado();
        if (resultado){
            validar.mensajeIngresadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeIngresadoIncorrecto();
          
    }

    @FXML
    private void actualizarEmpleado(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloUsuario.actualizarEmpleado();
        if (resultado){
            validar.mensajeActualizadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeActualizadoIncorrecto();
            
            
    }

    @FXML
    private void eliminarEmpleado(ActionEvent event) {
        modeloUsuario.setId(idEmpleado.getText());
        boolean resultado = modeloUsuario.eliminarEmpleado();
        if (resultado){
            validar.mensajeEliminadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeEliminadoIncorrecto();
    }

    @FXML
    private void seleccionarEmpleado(MouseEvent event) {
        user = (Usuario)tableEmpleado.getSelectionModel().getSelectedItem();
        idEmpleado.setText(user.getId());
        nomEmpleado.setText(user.getNombre());
        apeEmpleado.setText(user.getApellido());
        teleEmpleado.setText(user.getTelefono());
        dirEmpelado.setText(user.getDireccion());
        emailEmpleado.setText(user.getEmail());
        localEmpleado.setText(user.getLocal());
        usuario.setText(user.getUsuario());
        clave.setText(user.getContrasena());
        rol.setText(user.getRol());
        estado.setText(String.valueOf(user.isActivo()));
        salario.setText(String.valueOf(user.getSalario()));
    }
    
    public void obtenerDatos(){
        boolean validarCampo = nomEmpleado.equals("") && apeEmpleado.equals("") &&teleEmpleado.equals("") &&dirEmpelado.equals("") &&emailEmpleado.equals("")  &&usuario.equals("") &&clave.equals("");
        boolean validarSalario = validar.validarNumeros(salario);
        if(!validarCampo && !validarSalario){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();
        }
        else{
            modeloUsuario.setId(idEmpleado.getText());
            modeloUsuario.setNombre(nomEmpleado.getText());
            modeloUsuario.setApellido(apeEmpleado.getText());
            modeloUsuario.setUsuario(usuario.getText());
            modeloUsuario.setContrasena(clave.getText());
            modeloUsuario.setRol(rol.getText());
            modeloUsuario.setSalario(Integer.parseInt(salario.getText()));
            modeloUsuario.setDireccion(dirEmpelado.getText());
            modeloUsuario.setEmail(emailEmpleado.getText());
            modeloUsuario.setTelefono(teleEmpleado.getText());
            modeloUsuario.setActivo(Boolean.parseBoolean(estado.getText()));
            modeloUsuario.setLocal(localEmpleado.getText());
            
        }
        
    }

    @FXML
    private void obtenerRol(ActionEvent event) {
        String seleccion = cbxRol.getValue();
        rol.setText(seleccion.toLowerCase());
        if(seleccion.equalsIgnoreCase("repartidor")){
            clave.setText("null");
            usuario.setText("null");
            clave.setEditable(false);
            usuario.setEditable(false);
        }
        else{
            clave.setEditable(true);
            usuario.setEditable(true);
        }
    }

    @FXML
    private void obtenerLocal(ActionEvent event) {
        String seleccion = String.valueOf(cbxLocal.getValue());
         
        if(seleccion.equalsIgnoreCase("matriz"))
            localEmpleado.setText("1");
        else if(seleccion.equalsIgnoreCase("sucursal"))
            localEmpleado.setText("2");
        else if(seleccion.equalsIgnoreCase("bodega"))
            localEmpleado.setText("3");
            
    }

    @FXML
    private void obtenerEstado(ActionEvent event) {
        String seleccion = String.valueOf(cbxEstado.getValue());
        estado.setText(seleccion.toLowerCase()); 
    }
    
    
}

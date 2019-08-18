/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGestionarEmpleado implements Initializable {

    @FXML private JFXTextField txt_idEmpleado;
    @FXML private JFXTextField txt_nomEmpleado;
    @FXML private JFXTextField txt_apeEmpleado;
    @FXML private JFXTextField txt_teleEmpleado;
    @FXML private JFXTextField txt_dirEmpelado;
    @FXML private JFXTextField txt_emailEmpleado;
    @FXML private JFXTextField txt_localEmpleado;
    @FXML private JFXTextField txt_usuario;
    @FXML private JFXTextField txt_clave;
    @FXML private JFXTextField txt_rol;
    @FXML private JFXTextField txt_estado;
    @FXML private JFXTextField txt_salario;
    
    @FXML private TableView<Usuario> table_empleado;
    @FXML private TableColumn<Usuario, String> table_id;
    @FXML private TableColumn<Usuario, String> table_nombre;
    @FXML private TableColumn<Usuario, String> table_apel;
    @FXML private TableColumn<Usuario, String> table_dir;
    @FXML private TableColumn<Usuario, String> table_email;
    @FXML private TableColumn<Usuario, String> table_local;
    @FXML private TableColumn<Usuario, String> table_user;
    @FXML private TableColumn<Usuario, String> table_clave;
    @FXML private TableColumn<Usuario, String> table_rol;
    @FXML private TableColumn<Usuario, String> table_tel;
    @FXML private TableColumn<Usuario, String> table_estado;
    @FXML private TableColumn<Usuario, String> table_salario;
    @FXML private JFXComboBox<String> cbxRol;
    @FXML private JFXComboBox<TipoLocal> cbxLocal;
    @FXML private JFXComboBox<Boolean> cbxEstado;
    private Usuario modeloUsuario = new Usuario();
    private ControladorValidar validar =  new ControladorValidar();
    private ObservableList<Usuario> list = null;
    private Usuario user;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table_apel.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        table_dir.setCellValueFactory(new PropertyValueFactory<>("rol"));
        table_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table_local.setCellValueFactory(new PropertyValueFactory<>("local"));
        table_user.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        table_clave.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        table_rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        table_tel.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        table_estado.setCellValueFactory(new PropertyValueFactory<>("activo"));
        table_salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        cbxLocal.getItems().addAll(TipoLocal.bodega,TipoLocal.matriz,TipoLocal.sucursal);
        cbxRol.getItems().addAll("Gerentre","Vendedor","Jefe","Repartidor");
        cbxEstado.getItems().addAll(true,false);
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
        modeloUsuario.setId(txt_idEmpleado.getText());
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
        user = (Usuario)table_empleado.getSelectionModel().getSelectedItem();
        txt_idEmpleado.setText(user.getId());
        txt_nomEmpleado.setText(user.getNombre());
        txt_apeEmpleado.setText(user.getApellido());
        txt_teleEmpleado.setText(user.getTelefono());
        txt_dirEmpelado.setText(user.getDireccion());
        txt_emailEmpleado.setText(user.getEmail());
        txt_localEmpleado.setText(user.getLocal());
        txt_usuario.setText(user.getUsuario());
        txt_clave.setText(user.getContraseña());
        txt_rol.setText(user.getRol());
        txt_estado.setText(String.valueOf(user.isActivo()));
        txt_salario.setText(String.valueOf(user.getSalario()));
    }
    
    public void obtenerDatos(){
        boolean validarCampo = txt_nomEmpleado.equals("") && txt_apeEmpleado.equals("") &&txt_teleEmpleado.equals("") &&txt_dirEmpelado.equals("") &&txt_emailEmpleado.equals("")  &&txt_usuario.equals("") &&txt_clave.equals("");
        boolean validarSalario = validar.validarNumeros(txt_salario);
        if(!validarCampo && !validarSalario){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();
        }
        else{
            modeloUsuario.setId(txt_idEmpleado.getText());
            modeloUsuario.setNombre(txt_nomEmpleado.getText());
            modeloUsuario.setApellido(txt_apeEmpleado.getText());
            modeloUsuario.setUsuario(txt_usuario.getText());
            modeloUsuario.setContraseña(txt_clave.getText());
            modeloUsuario.setRol(txt_rol.getText());
            modeloUsuario.setSalario(Integer.parseInt(txt_salario.getText()));
            modeloUsuario.setDireccion(txt_dirEmpelado.getText());
            modeloUsuario.setEmail(txt_emailEmpleado.getText());
            modeloUsuario.setTelefono(txt_teleEmpleado.getText());
            modeloUsuario.setActivo(Boolean.parseBoolean(txt_estado.getText()));
            modeloUsuario.setLocal(txt_localEmpleado.getText());
            
        }
        
    }

    @FXML
    private void obtenerRol(ActionEvent event) {
        String seleccion = cbxRol.getValue();
        txt_rol.setText(seleccion.toLowerCase());
        if(seleccion.toLowerCase().equals("repartidor")){
            txt_clave.setText("null");
            txt_usuario.setText("null");
            txt_clave.setEditable(false);
            txt_usuario.setEditable(false);
        }
        else{
            txt_clave.setEditable(true);
            txt_usuario.setEditable(true);
        }
    }

    @FXML
    private void obtenerLocal(ActionEvent event) {
        String seleccion = String.valueOf(cbxLocal.getValue());
         
        if(seleccion.toLowerCase().equals("matriz"))
            txt_localEmpleado.setText("1");
        else if(seleccion.toLowerCase().equals("sucursal"))
            txt_localEmpleado.setText("2");
        else if(seleccion.toLowerCase().equals("bodega"))
            txt_localEmpleado.setText("3");
            
    }

    @FXML
    private void obtenerEstado(ActionEvent event) {
        String seleccion = String.valueOf(cbxEstado.getValue());
        txt_estado.setText(seleccion.toLowerCase()); 
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGestionarEmpleado implements Initializable {

    @FXML private JFXTextField txt_idEmpelado;
    @FXML private JFXTextField txt_nomEmpleaado;
    @FXML private JFXTextField txt_apeEmpleaado;
    @FXML private JFXTextField txt_teleEmpleado;
    @FXML private JFXTextField txt_dirEmpelado;
    @FXML private JFXTextField txt_emailEmpleado;
    @FXML private JFXTextField txt_localEmpleado;
    @FXML private TableView<Empleado> table_empleado;
    @FXML private TableColumn<Empleado, String> table_id;
    @FXML private TableColumn<Empleado, String> table_nombre;
    @FXML private TableColumn<Empleado, String> table_apel;
    @FXML private TableColumn<Empleado, String> table_dir;
    @FXML private TableColumn<Empleado, String> table_email;
    @FXML private TableColumn<Empleado, String> table_local;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresarEmpelado(ActionEvent event) {
    }

    @FXML
    private void actualizarEmpleado(ActionEvent event) {
    }

    @FXML
    private void eliminarEmpleado(ActionEvent event) {
    }
    
}

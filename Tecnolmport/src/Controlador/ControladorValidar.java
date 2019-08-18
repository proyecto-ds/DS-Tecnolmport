/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;

/**
 *
 * @author bryan
 */
public class ControladorValidar {
    public void mensajeEliminadoCorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText(null);
            alert.setContentText("Item Eliminado!");
            alert.showAndWait();
    }
    public void mensajeEliminadoIncorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText(null);
            alert.setContentText("Item No Eliminado!");
            alert.showAndWait();
    }
    public void mensajeIngresadoCorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingresar");
            alert.setHeaderText(null);
            alert.setContentText("Item Ingresado!");
            alert.showAndWait();
    }
    public void mensajeIngresadoIncorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ingresar");
            alert.setHeaderText(null);
            alert.setContentText("Item No Ingresado!");
            alert.showAndWait();
    }
    public void mensajeActualizadoCorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualizar");
            alert.setHeaderText(null);
            alert.setContentText("Item Actualizado!");
            alert.showAndWait();
    }
    public void mensajeActualizadoIncorrecto(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualizar");
            alert.setHeaderText(null);
            alert.setContentText("Item No Actualizado!");
            alert.showAndWait();
    }
    
    public void mensajeSeleccionarCampos(String mensaje){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
    }
    
    public void mensajeRegistroExitosoNovedad(String mensaje){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Selección");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
    }
    
    public boolean validarCampoVacio(JFXTextField txt) {
        if (txt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();

            return false;
        }
        return true;
    }
    public boolean ValidarUsuarioContrasena(String txtU, String txtC) {
        if (txtU.isEmpty() || txtC.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Usuario y contraseña requerida");
            alert.showAndWait();
        }
        return true;
    }
    public boolean validarNumeros(JFXTextField txt) {
        if (txt.getText().matches("[0-9]+")) {

            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Tipo de dato invalido..!");
            alert.showAndWait();

            return false;
        }
    }
    
    public boolean validarFloat(JFXTextField txt){
        boolean isValid = true;
        try {
            Double.parseDouble(txt.getText());
        } catch(NumberFormatException nfe) {
            isValid = false;
        }
        if (isValid) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Tipo de dato invalido..!");
            alert.showAndWait();

            return false;
        }
    }
    
    
}

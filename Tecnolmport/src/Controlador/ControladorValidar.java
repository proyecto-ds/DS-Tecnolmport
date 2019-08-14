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
    public boolean validarCampoVacio(JFXTextField txt) {
        if (txt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos");
            alert.setHeaderText(null);
            alert.setContentText("Campos vacios!");
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
}

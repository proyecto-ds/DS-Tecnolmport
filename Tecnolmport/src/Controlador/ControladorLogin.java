/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author bryan
 */
public class ControladorLogin implements Initializable {
    
    
    @FXML
    private AnchorPane parent;
    @FXML
    private JFXTextField text_usuario;
    @FXML
    private JFXPasswordField text_contraseña;
    @FXML
    private JFXButton btn_login;
    
    private ControladorValidar controladorValidar = new ControladorValidar();
    private Usuario modeloUsuario = new Usuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        String usuario = text_usuario.getText();
        String contraseña = text_contraseña.getText();
        if(controladorValidar.ValidarUsuarioContrasena(usuario, contraseña)){
            modeloUsuario.setUsuario(usuario);
            modeloUsuario.setContraseña(contraseña);
            if(modeloUsuario.login()){
                asignarVistaRol(modeloUsuario.obtenerRol(), event);
            }
                
        }
            
             
    }
    
    public void asignarVistaRol(String rol, ActionEvent event) throws IOException{
        if(rol.toLowerCase().equals("gerente")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaGerente.fxml"));
            Scene sceneGerente = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneGerente);
            stage.show();
        }
        else if(rol.toLowerCase().equals("jefedebodega")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaJefeBodega.fxml"));
            Scene sceneJefe = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneJefe);
            stage.show();
        }
        else if(rol.toLowerCase().equals("vendedor")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaJefeBodega.fxml"));
            Scene sceneVendedor = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneVendedor);
            stage.show();
            
        }
    
    
    }
}

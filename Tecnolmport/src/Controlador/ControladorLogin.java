
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author bryan
 */
public class ControladorLogin implements Initializable {
    
    
    @FXML private AnchorPane parent;
    @FXML private JFXTextField textUsuario;
    @FXML private JFXPasswordField textContrasena;
    
    public static String user;
    public static String permi;
    private ControladorValidar controladorValidar = new ControladorValidar();
    private Usuario modeloUsuario = new Usuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user=null;
        permi = null;
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        String usuario = textUsuario.getText();
        String contrasena = textContrasena.getText();
        if(controladorValidar.validarUsuarioContrasena(usuario, contrasena)){
            modeloUsuario.setUsuario(usuario);
            modeloUsuario.setContrasena(contrasena);
            String rol = modeloUsuario.login();
            if(rol !=null){
                user = usuario;
                if(modeloUsuario.getPermisoAdmin()!=null)
                    permi = modeloUsuario.getPermisoAdmin();
                asignarVistaRol(rol, event);
            }
                
        }
            
             
    }
    
    public void asignarVistaRol(String rol, ActionEvent event) throws IOException{
        if(rol.equalsIgnoreCase("gerente")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaGerente.fxml"));
            Scene sceneGerente = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneGerente);
            stage.show();
        }
        else if(rol.equalsIgnoreCase("jefe")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/JefeB/VistaJB.fxml"));
            Scene sceneJefe = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneJefe);
            stage.show();
        }
        else if(rol.equalsIgnoreCase("vendedor")){
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaVendedor.fxml"));
            Scene sceneVendedor = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sceneVendedor);
            stage.show();
            
        }
    
    
    }
}

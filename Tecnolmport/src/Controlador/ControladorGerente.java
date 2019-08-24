
package Controlador;



import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerente implements Initializable {

    
    @FXML private Label labelGerente;
    @FXML private JFXButton btnEmpleado;
    @FXML private JFXButton btnCerrarSesion;
    @FXML private Pane parent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void consultarEmpleado(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerenteEmpleados.fxml")));
        parent.getChildren().setAll(vistaBA);
        
        
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void buscarArticulo(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaBusquedaArticulo.fxml")));
        parent.getChildren().setAll(vistaBA);
    }
    
     @FXML
    private void consultarPedido(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerentePedido.fxml")));
        parent.getChildren().setAll(vistaBA);
    }
    
    
      @FXML
    private void consultarVenta(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerenteVenta.fxml")));
        parent.getChildren().setAll(vistaBA);
    }
    
     @FXML
    private void realizarPedido(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerenteGPedido.fxml")));
        parent.getChildren().setAll(vistaBA);
    }

    @FXML
    private void darPermisos(ActionEvent event) throws IOException {
        AnchorPane vistaBA = FXMLLoader.load(getClass().getResource(("/Vista/VistaGerentePermisos.fxml")));
       parent.getChildren().setAll(vistaBA);
    }
    
   
    
}

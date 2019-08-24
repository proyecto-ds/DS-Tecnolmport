
package Controlador.CtrlJefeBodega;

import Modelo.Entrega;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBCrearRutaEntrega implements Initializable {

    @FXML private JFXComboBox<String> cbseleccionarRuta;
    @FXML private TableView<Entrega> tblrutaEntrega;
    @FXML 
    private TableColumn<Entrega, String> cIdEntrega;
    @FXML
    private TableColumn<Entrega, String> cIdEnvio;
    @FXML
    private TableColumn<Entrega, String> cFecha;
    @FXML
    private TableColumn<Entrega, String> cDireccion;
    @FXML
    private TableColumn<Entrega, String> cDescripcion;
    
    protected ObservableList<Entrega> entregaObs =null;
    private Entrega entregaModelo = new Entrega();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cIdEntrega.setCellValueFactory(new PropertyValueFactory<>("id"));
        cIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        cFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
        cDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        llenarTableEntrega();
        cbseleccionarRuta.getItems().addAll("Norte","Sur","Centro","Este","Oeste");
    }    

    private void llenarTableEntrega(){
        if(entregaObs == null){
            entregaObs = entregaModelo.cargarEntrega();
            tblrutaEntrega.setItems(entregaObs);
        }
    }
    
    
}

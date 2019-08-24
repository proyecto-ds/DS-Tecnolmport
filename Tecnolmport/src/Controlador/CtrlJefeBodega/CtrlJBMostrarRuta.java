
package Controlador.CtrlJefeBodega;

import Modelo.Ruta;
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
 * @author Rogencio
 */
public class CtrlJBMostrarRuta implements Initializable {

    @FXML
    private TableView<Ruta> tblruta;
    @FXML
    private TableColumn<Ruta, String> cidRuta;
    @FXML
    private TableColumn<Ruta, String> cZona;
    @FXML
    private TableColumn<Ruta, String> cNombre;
    @FXML
    private TableColumn<Ruta, String> cApellido;
    
    @FXML private TableView<Ruta> tblentrega;
    @FXML private TableColumn<Ruta, String> cIdEntrega;
    @FXML private TableColumn<Ruta, String> cFecha;
    @FXML private TableColumn<Ruta, String> cDireccion;
    @FXML  private TableColumn<Ruta, String> cEstado;
    @FXML private TableColumn<Ruta, String> cIdRutaE;
    
    private ObservableList<Ruta> rutaObs =null;
    private ObservableList<Ruta> rutaEntrega1 =null;
    protected Ruta modeloRuta = new Ruta();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cidRuta.setCellValueFactory(new PropertyValueFactory<>("idRuta"));
        cZona.setCellValueFactory(new PropertyValueFactory<>("zona"));
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombreRepartidor"));
        cApellido.setCellValueFactory(new PropertyValueFactory<>("apellidoRepartidor"));
        
        cIdEntrega.setCellValueFactory(new PropertyValueFactory<>("idEntrega"));
        cFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        cDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cIdRutaE.setCellValueFactory(new PropertyValueFactory<>("idRuta"));
        
        llenarTableRuta();
        llenarTableRutaEntrega();
    }    
    
    private void llenarTableRuta(){
        if(rutaObs == null){
            rutaObs = modeloRuta.cargarRuta();
            tblruta.setItems(rutaObs);
        }
        else{
            rutaObs.removeAll(rutaObs);
            rutaObs = modeloRuta.cargarRuta();
            tblruta.setItems(rutaObs);
        }
    }
    
    private void llenarTableRutaEntrega(){
        if(rutaEntrega1 == null){
            rutaEntrega1 = modeloRuta.cargarDatosRutaEntrega();
            tblentrega.setItems(rutaEntrega1);
        }
        else{
            rutaEntrega1.removeAll(rutaEntrega1);
            rutaEntrega1 = modeloRuta.cargarDatosRutaEntrega();
            tblentrega.setItems(rutaEntrega1);
        }
    }
    
}

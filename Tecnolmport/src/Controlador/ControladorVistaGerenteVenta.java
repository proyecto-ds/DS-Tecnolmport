
package Controlador;

import Modelo.Venta;
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
 * @author juanjimenez
 */
public class ControladorVistaGerenteVenta implements Initializable {

    @FXML
    private TableColumn<Venta, String> cidVenta;
    @FXML
    private TableColumn<Venta, String> cFechaVenta;
    @FXML
    private TableColumn<Venta, String> cCotizacion;
    @FXML
    private TableColumn<Venta, String> cLocal;
    @FXML
    private TableColumn<Venta, String> cTotal;
    @FXML
    private TableColumn<Venta, String> cVendedor;
    @FXML
    private TableColumn<Venta, String> cidEnvio;
    @FXML
    private TableColumn<Venta, String> cProductos;
    private ObservableList<Venta> list = null;
    private final Venta modeloVenta = new Venta();
    @FXML
    private TableView<Venta> tableVenta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cidVenta.setCellValueFactory(new PropertyValueFactory<>("id"));
        cFechaVenta.setCellValueFactory(new PropertyValueFactory<>("date"));
        cCotizacion.setCellValueFactory(new PropertyValueFactory<>("esCotizacion"));
        cLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        cTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        cVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        cProductos.setCellValueFactory(new PropertyValueFactory<>("producto"));
        cidEnvio.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        llenarTable();
    }
    public void llenarTable(){
        if(list == null){
            list = modeloVenta.cargarVenta();
            tableVenta.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloVenta.cargarVenta();
            tableVenta.setItems(list);
        }
        
    }
    
}

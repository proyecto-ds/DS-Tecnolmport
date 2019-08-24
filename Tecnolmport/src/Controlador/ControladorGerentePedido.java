
package Controlador;


import Modelo.Pedido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerentePedido implements Initializable {

    @FXML private TableColumn<Pedido, String> cId;
    @FXML private TableColumn<Pedido, String> cFecha;
    @FXML private TableColumn<Pedido, String> cEstado;
    @FXML private TableColumn<Pedido, String> cLocal;
    @FXML private TableColumn<Pedido, String> cGerente;
    @FXML private TableColumn<Pedido, Button> cProductos;
    @FXML private TableView<Pedido> tablePedido;
    @FXML private Label lblTitulo;
    private final Pedido modeloPedido = new Pedido();
    private ObservableList<Pedido> list = null;
    
    /**
     * Initializes the controller class.
     * @param url 
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        cEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cLocal.setCellValueFactory(new PropertyValueFactory<>("loc"));
        cGerente.setCellValueFactory(new PropertyValueFactory<>("gerent"));
        cProductos.setCellValueFactory(new PropertyValueFactory<>("producto"));
       llenarTable(); 
    }
    public void llenarTable(){
        if(list == null){
            list = modeloPedido.llenarTablePedido();
            tablePedido.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloPedido.llenarTablePedido();
            tablePedido.setItems(list);
        }  
    }    
}
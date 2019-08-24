
package Controlador.CtrlJefeBodega;

import Controlador.ControladorValidar;
import Modelo.Envio;
import Modelo.Pedido;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
public class CtrlJBRegistrarNovedad implements Initializable {

    @FXML private JFXTextField txtingresarNovedad;
    
    @FXML private TableView<Pedido> tblpedido;
    @FXML private TableColumn<Pedido, String> cIdPedido;
    @FXML private TableColumn<Pedido, String> cFechaPedido;
    @FXML private TableColumn<Pedido, String> cDescripcionPedido;
    @FXML private TableColumn<Pedido, String> cEstadoPedido;
    @FXML private TableColumn<Pedido, String> cLocalPedido;
    @FXML private TableColumn<Pedido, String> cPProducto;
    @FXML private TableColumn<Pedido, String> cGerentePedido;
    @FXML private TableColumn<Pedido, String> cIdEntregaP;
    
    @FXML
    private TableView<Envio> tblenvio;
    @FXML
    private TableColumn<Envio, String> cIdEnvio;
    @FXML
    private TableColumn<Envio, String> cVenta;
    @FXML
    private TableColumn<Envio, String> cDireccion;
    @FXML
    private TableColumn<Envio, String> cDescripcion;
    @FXML
    private TableColumn<Envio, String> cFechaInicio;
    @FXML
    private TableColumn<Envio, String> cFechaFin;
    @FXML
    private TableColumn<Envio, String> cEstado;
    @FXML
    private TableColumn<Envio, String> cIdEntregaE;
    private final ControladorValidar control= new ControladorValidar();
    private ObservableList<Envio> enviosObs =null;
    private Envio e = new Envio();
    private ObservableList<Pedido> pedidosObs =null;
    private Pedido modeloPedido = new Pedido();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cIdEnvio.setCellValueFactory(new PropertyValueFactory<>("id"));
        cVenta.setCellValueFactory(new PropertyValueFactory<>("vent"));
        cDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        cFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        cEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cIdEntregaE.setCellValueFactory(new PropertyValueFactory<>("idEntregaV"));
        llenarTableEnvio();
        
        cIdPedido.setCellValueFactory(new PropertyValueFactory<>("id"));
        cFechaPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("fechaPedido"));
        cEstadoPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("esta"));
        cLocalPedido.setCellValueFactory(new PropertyValueFactory<>("loc"));
        cPProducto.setCellValueFactory(new PropertyValueFactory<Pedido,String>("producto"));
        cGerentePedido.setCellValueFactory(new PropertyValueFactory<>("gerent"));
        cDescripcionPedido.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        cIdEntregaP.setCellValueFactory(new PropertyValueFactory<>("idEntrega"));
        llenarTablePedido();
    }    
    private void llenarTableEnvio(){
        if(enviosObs == null){
            enviosObs = e.cargarEnvio("1");
            tblenvio.setItems(enviosObs);
        }
        else{
            enviosObs.removeAll(enviosObs);
            enviosObs = e.cargarEnvio("1");
            tblenvio.setItems(enviosObs);
        }
    }

     public void llenarTablePedido(){
        if(pedidosObs == null){
            pedidosObs = modeloPedido.llenarTablePedidoNovedades("1");
            tblpedido.setItems(pedidosObs);
        }
        else{
            pedidosObs.removeAll(pedidosObs);
            pedidosObs = modeloPedido.llenarTablePedidoNovedades("1");
            tblpedido.setItems(pedidosObs);
        }
    }
    @FXML
    private void validarseleccion(ActionEvent event) {
        Envio envio = tblenvio.getSelectionModel().getSelectedItem();
        String txt = txtingresarNovedad.getText();
        if(envio==null || txt==null)
            control.mensajeSeleccionarCampos("Falta seleccionar una entrega o\nllenar el campo Novedad");
        else if(e.registrarNovedadEnvio(envio.getId(), txt)){
            String r = e.selectRutaEspecifica(envio.getIdEntregaV());
            e.actualizarCampoRepartidorRuta(r);
            control.mensajeRegistroExitosoNovedad("Actualizado novedad y Entrega-Envio con éxito!");
            llenarTableEnvio();
        }else{
            control.mensajeSeleccionarCampos("Error en DB o query");
        }
    }

    @FXML
    private void validarseleccionPedido(ActionEvent event) {
        Pedido pedido = tblpedido.getSelectionModel().getSelectedItem();
        String txt = txtingresarNovedad.getText();
        if(pedido==null || txt==null)
            control.mensajeSeleccionarCampos("Falta seleccionar una entrega o\nllenar el campo Novedad");
    }
}

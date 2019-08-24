/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import Controlador.ControladorValidar;
import Modelo.Envio;
import Modelo.Pedido;
import Modelo.Venta;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBRegistrarEntrega implements Initializable {

    @FXML
    private TableView<Pedido> tblpedido;
    @FXML
    private TableView<Envio> tblenvio;
    @FXML
    private JFXButton btnregistrarPedido;
    @FXML
    private JFXButton btnnegarPedido;
    @FXML
    private JFXButton btnregistrarEnvio;
    @FXML
    private JFXButton btnnegarEnvio;
    @FXML private TableColumn<Pedido, String> cIdPedido;
    @FXML private TableColumn<Pedido, String> cFechaPedido;
    @FXML private TableColumn<Pedido, String> cDescripcionPedido;
    @FXML private TableColumn<Pedido, String> cEstadoPedido;
    @FXML private TableColumn<Pedido, String> cLocalPedido;
    @FXML private TableColumn<Pedido, String> cPProducto;
    @FXML private TableColumn<Pedido, String> cGerentePedido;
    @FXML private TableColumn<Pedido, String> cIdEntregaP;
    
    @FXML private TableColumn<Envio, String> cIdEnvio;
    @FXML private TableColumn<Envio, Venta> cVenta;
    @FXML private TableColumn<Envio, String> cDireccion;
    @FXML private TableColumn<Envio, String> cDescripcion;
    @FXML private TableColumn<Envio, String> cFechaInicio;
    @FXML private TableColumn<Envio, String> cFechaFin;
    @FXML private TableColumn<Envio, String> cEstado;
    @FXML private TableColumn<Envio, String> cIdEntrega;
    private ObservableList<Envio> enviosObs =null;
    private ObservableList<Pedido> pedidosObs =null;
    private final Envio modeloEnvio = new Envio();
    private final Pedido modeloPedido = new Pedido();
    private final ControladorValidar control= new ControladorValidar();
    
    
    
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
        cIdEntrega.setCellValueFactory(new PropertyValueFactory<>("idEntregaV"));
        llenarTableEnvio();
        
        cIdPedido.setCellValueFactory(new PropertyValueFactory<>("id"));
        cFechaPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("fechaPedido"));
        cEstadoPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("esta"));
        cLocalPedido.setCellValueFactory(new PropertyValueFactory<>("loc"));
        cPProducto.setCellValueFactory(new PropertyValueFactory<Pedido,String>("gerent"));
        cGerentePedido.setCellValueFactory(new PropertyValueFactory<>("producto"));
        cDescripcionPedido.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        cIdEntregaP.setCellValueFactory(new PropertyValueFactory<>("idEntrega"));
        llenarTablePedido();
    }    

    public void llenarTableEnvio(){
        if(enviosObs == null){
            enviosObs = modeloEnvio.cargarEnvio("3");
            tblenvio.setItems(enviosObs);
        }
        else{
            enviosObs.removeAll(enviosObs);
            enviosObs = modeloEnvio.cargarEnvio("3");
            tblenvio.setItems(enviosObs);
        }
    }
    
    public void llenarTablePedido(){
        if(pedidosObs == null){
            pedidosObs = modeloPedido.llenarTablePedidoNovedades("3");
            tblpedido.setItems(pedidosObs);
        }
        else{
            pedidosObs.removeAll(pedidosObs);
            pedidosObs = modeloPedido.llenarTablePedidoNovedades("3");
            tblpedido.setItems(pedidosObs);
        }
    }
    
    @FXML
    private void actregistrarPedido(ActionEvent event) {
        if(mensajeErrorPedido(tblpedido,"Falta seleccionar un Pedido"));
    }

    @FXML
    private void actnegarPedido(ActionEvent event) {
        if(mensajeErrorPedido(tblpedido,"Falta seleccionar un Pedido"));
        else{
            negarPedido();
            control.mensajeRegistroExitosoNovedad("Negado Pedido Exitoso"); 
        }
    }

    @FXML
    private void actregistrarEnvio(ActionEvent event) {
        if(mensajeError(tblenvio,"Falta seleccionar un Envio"));
    }

    @FXML
    private void actnegarEnvio(ActionEvent event) {
        if(mensajeError(tblenvio,"Falta seleccionar un Envio"));
        else{
            negarEnvio();
            control.mensajeRegistroExitosoNovedad("Negado Envio Exitoso"); 
        }
        
    }
    private void negarEnvio(){
        Envio envio= tblenvio.getSelectionModel().getSelectedItem();
        modeloEnvio.actualizarNegarEnvio(envio.getId());
        llenarTableEnvio();
    }
    
    private void negarPedido(){
        Pedido pedido= tblpedido.getSelectionModel().getSelectedItem();
        modeloPedido.actualizarNegarPedido(pedido.getId());
        llenarTablePedido();
    }
    
    private boolean mensajeError(TableView<Envio> tblenvio, String mensaje){
        Envio envio= tblenvio.getSelectionModel().getSelectedItem();
        if(envio==null){
            control.mensajeSeleccionarCampos(mensaje);
            return true;
        }
        return false;
    }
    
    
    
    private boolean mensajeErrorPedido(TableView<Pedido> tblpedido, String mensaje){
        Pedido envio= tblpedido.getSelectionModel().getSelectedItem();
        if(envio==null){
            control.mensajeSeleccionarCampos(mensaje);
            return true;
        }
        return false;
    }
    
}

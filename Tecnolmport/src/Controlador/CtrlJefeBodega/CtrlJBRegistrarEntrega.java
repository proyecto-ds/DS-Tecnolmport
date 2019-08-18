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
    private TableView<Pedido> tbl_pedido;
    @FXML
    private TableView<Envio> tbl_envio;
    @FXML
    private JFXButton btn_registrarPedido;
    @FXML
    private JFXButton btn_negarPedido;
    @FXML
    private JFXButton btn_registrarEnvio;
    @FXML
    private JFXButton btn_negarEnvio;
    @FXML private TableColumn<Pedido, String> CIdPedido;
    @FXML private TableColumn<Pedido, String> CFechaPedido;
    @FXML private TableColumn<Pedido, String> CDescripcionPedido;
    @FXML private TableColumn<Pedido, String> CEstadoPedido;
    @FXML private TableColumn<Pedido, String> CLocalPedido;
    @FXML private TableColumn<Pedido, String> CPProducto;
    @FXML private TableColumn<Pedido, String> CGerentePedido;
    @FXML private TableColumn<Envio, String> CIdEnvio;
    @FXML private TableColumn<Envio, Venta> CVenta;
    @FXML private TableColumn<Envio, String> CDireccion;
    @FXML private TableColumn<Envio, String> CDescripcion;
    @FXML private TableColumn<Envio, String> CFechaInicio;
    @FXML private TableColumn<Envio, String> CFechaFin;
    @FXML private TableColumn<Envio, String> CEstado;
    
    private ObservableList<Envio> enviosObs =null;
    private ObservableList<Pedido> pedidosObs =null;
    private Envio modeloEnvio = new Envio();
    private Pedido modeloPedido = new Pedido();
    private ControladorValidar control= new ControladorValidar();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CIdEnvio.setCellValueFactory(new PropertyValueFactory<>("id"));
        CVenta.setCellValueFactory(new PropertyValueFactory<>("vent"));
        CDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        CDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        CFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        CFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        CEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        llenarTableEnvio();
        
        CIdPedido.setCellValueFactory(new PropertyValueFactory<>("id"));
        CFechaPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("fechaPedido"));
        CEstadoPedido.setCellValueFactory(new PropertyValueFactory<Pedido,String>("esta"));
        CLocalPedido.setCellValueFactory(new PropertyValueFactory<>("loc"));
        CPProducto.setCellValueFactory(new PropertyValueFactory<Pedido,String>("gerent"));
        CGerentePedido.setCellValueFactory(new PropertyValueFactory<>("producto"));
        CDescripcionPedido.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        llenarTablePedido();
    }    

    public void llenarTableEnvio(){
        if(enviosObs == null){
            enviosObs = modeloEnvio.cargarEnvio("3");
            tbl_envio.setItems(enviosObs);
        }
        /*else{
            enviosObs.removeAll(enviosObs);
            enviosObs = modeloEnvio.cargarEnvio();
            tbl_envio.setItems(enviosObs);
        }*/
    }
    
    public void llenarTablePedido(){
        if(pedidosObs == null){
            pedidosObs = modeloPedido.llenarTablePedidoNovedades();
            tbl_pedido.setItems(pedidosObs);
        }
        else{
            pedidosObs.removeAll(pedidosObs);
            pedidosObs = modeloPedido.llenarTablePedidoNovedades();
            tbl_pedido.setItems(pedidosObs);
        }
    }
    
    @FXML
    private void act_registrarPedido(ActionEvent event) {
        if(mensajeErrorPedido(tbl_pedido,"Falta seleccionar un Pedido"));
    }

    @FXML
    private void act_negarPedido(ActionEvent event) {
        if(mensajeErrorPedido(tbl_pedido,"Falta seleccionar un Pedido"));
        
    }

    @FXML
    private void act_registrarEnvio(ActionEvent event) {
        if(mensajeError(tbl_envio,"Falta seleccionar un Envio"));
    }

    @FXML
    private void act_negarEnvio(ActionEvent event) {
        if(mensajeError(tbl_envio,"Falta seleccionar un Envio"));
    }
    
    private boolean mensajeError(TableView<Envio> tbl_envio, String mensaje){
        Envio envio= tbl_envio.getSelectionModel().getSelectedItem();
        if(envio==null){
            control.mensajeSeleccionarCampos(mensaje);
            return true;
        }
        return false;
    }
    
    private boolean mensajeErrorPedido(TableView<Pedido> tbl_pedido, String mensaje){
        Pedido envio= tbl_pedido.getSelectionModel().getSelectedItem();
        if(envio==null){
            control.mensajeSeleccionarCampos(mensaje);
            return true;
        }
        return false;
    }

    @FXML
    private void seleccionardato(MouseEvent event) {
    }
    
}

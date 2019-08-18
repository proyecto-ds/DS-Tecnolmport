/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @FXML private JFXTextField txt_ingresarNovedad;
    @FXML private JFXButton btn_guardarNovedad;
    
    @FXML private TableView<Pedido> tbl_pedido;
    @FXML private TableColumn<Pedido, String> CIdPedido;
    @FXML private TableColumn<Pedido, String> CFechaPedido;
    @FXML private TableColumn<Pedido, String> CDescripcionPedido;
    @FXML private TableColumn<Pedido, String> CEstadoPedido;
    @FXML private TableColumn<Pedido, String> CLocalPedido;
    @FXML private TableColumn<Pedido, String> CPProducto;
    @FXML private TableColumn<Pedido, String> CGerentePedido;
    
    @FXML
    private TableView<Envio> tbl_envio;
    @FXML
    private TableColumn<Envio, String> CIdEnvio;
    @FXML
    private TableColumn<Envio, String> CVenta;
    @FXML
    private TableColumn<Envio, String> CDireccion;
    @FXML
    private TableColumn<Envio, String> CDescripcion;
    @FXML
    private TableColumn<Envio, String> CFechaInicio;
    @FXML
    private TableColumn<Envio, String> CFechaFin;
    @FXML
    private TableColumn<Envio, String> CEstado;
    
    private ControladorValidar control= new ControladorValidar();
    private ObservableList<Envio> enviosObs =null;
    private Envio e = new Envio();
    private ObservableList<Pedido> pedidosObs =null;
    private Pedido modeloPedido = new Pedido();
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
        CPProducto.setCellValueFactory(new PropertyValueFactory<Pedido,String>("producto"));
        CGerentePedido.setCellValueFactory(new PropertyValueFactory<>("gerent"));
        CDescripcionPedido.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        llenarTablePedido();
    }    
    private void llenarTableEnvio(){
        if(enviosObs == null){
            enviosObs = e.cargarEnvio("1");
            tbl_envio.setItems(enviosObs);
        }
        else{
            enviosObs.removeAll(enviosObs);
            enviosObs = e.cargarEnvio("1");
            tbl_envio.setItems(enviosObs);
        }
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
    private void validar_seleccion(ActionEvent event) {
        Envio envio = tbl_envio.getSelectionModel().getSelectedItem();
        String txt = txt_ingresarNovedad.getText();
        if(envio==null || txt==null)
            control.mensajeSeleccionarCampos("Falta seleccionar una entrega o\nllenar el campo Novedad");
        System.out.println(txt);
    }
}

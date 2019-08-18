/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import Controlador.ControladorValidar;
import Modelo.Envio;
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
    
    @FXML private TableView<?> tbl_pedido;
    @FXML private TableColumn<?, ?> CIdPedido;
    @FXML private TableColumn<?, ?> CFechaPedido;
    @FXML private TableColumn<?, ?> CDescripcionPedido;
    @FXML private TableColumn<?, ?> CEstadoPedido;
    @FXML private TableColumn<?, ?> CLocalPedido;
    @FXML private TableColumn<?, ?> CPProducto;
    @FXML private TableColumn<?, ?> CGerentePedido;
    
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
    protected ObservableList<Envio> enviosObs =null;
    protected Envio e = new Envio();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        CVenta.setCellValueFactory(new PropertyValueFactory<>("id_Venta"));
        CDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        CDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        CFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        CFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        CEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        llenarTableEnvio();
    }    
    private void llenarTableEnvio(){
        if(enviosObs == null){
            enviosObs = e.cargarPedido();
            tbl_envio.setItems(enviosObs);
        }
        else{
            enviosObs.removeAll(enviosObs);
            enviosObs = e.cargarPedido();
            tbl_envio.setItems(enviosObs);
        }
    }

    @FXML
    private void validar_seleccion(ActionEvent event) {
        Envio envio = tbl_envio.getSelectionModel().getSelectedItem();
        String txt = txt_ingresarNovedad.getText();
        if(envio==null || txt==null)
            control.mensajeSeleccionarCampos("Falta seleccionar una entrega o\nllenar el campo Novedad");
    }
}

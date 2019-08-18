/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import Modelo.Entrega;
import Modelo.Envio;
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

    @FXML private JFXComboBox<String> cb_seleccionarRuta;
    @FXML private TableView<Entrega> tbl_rutaEntrega;
    @FXML 
    private TableColumn<Entrega, String> CIdEntrega;
    @FXML
    private TableColumn<Entrega, String> CIdEnvio;
    @FXML
    private TableColumn<Entrega, String> CFecha;
    @FXML
    private TableColumn<Entrega, String> CDireccion;
    @FXML
    private TableColumn<Entrega, String> CDescripcion;
    
    protected ObservableList<Entrega> entregaObs =null;
    private Entrega entregaModelo = new Entrega();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CIdEntrega.setCellValueFactory(new PropertyValueFactory<>("id"));
        CIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        CFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
        CDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        CDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        llenarTableEntrega();
        cb_seleccionarRuta.getItems().addAll("Norte","Sur","Centro","Este","Oeste");
    }    

    private void llenarTableEntrega(){
        if(entregaObs == null){
            entregaObs = entregaModelo.cargarEntrega();
            tbl_rutaEntrega.setItems(entregaObs);
        }
    }
    
    @FXML
    private void seleccionarRuta(ActionEvent event) {
    }
    
}

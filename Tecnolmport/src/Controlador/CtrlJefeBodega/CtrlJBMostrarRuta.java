/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private TableView<Ruta> tbl_ruta;
    @FXML
    private TableColumn<Ruta, String> CidRuta;
    @FXML
    private TableColumn<Ruta, String> CZona;
    @FXML
    private TableColumn<Ruta, String> CNombre;
    @FXML
    private TableColumn<Ruta, String> CApellido;
    
    @FXML private TableView<Ruta> tbl_entrega;
    @FXML private TableColumn<Ruta, String> CIdEntrega;
    @FXML private TableColumn<Ruta, String> CFecha;
    @FXML private TableColumn<Ruta, String> CDireccion;
    @FXML  private TableColumn<Ruta, String> CEstado;
    @FXML private TableColumn<Ruta, String> CIdRutaE;
    
    private ObservableList<Ruta> rutaObs =null;
    private ObservableList<Ruta> rutaEntrega1 =null;
    protected Ruta modeloRuta = new Ruta();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CidRuta.setCellValueFactory(new PropertyValueFactory<>("idRuta"));
        CZona.setCellValueFactory(new PropertyValueFactory<>("zona"));
        CNombre.setCellValueFactory(new PropertyValueFactory<>("nombreRepartidor"));
        CApellido.setCellValueFactory(new PropertyValueFactory<>("apellidoRepartidor"));
        
        CIdEntrega.setCellValueFactory(new PropertyValueFactory<>("idEntrega"));
        CFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        CDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        CEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        CIdRutaE.setCellValueFactory(new PropertyValueFactory<>("idRuta"));
        
        llenarTableRuta();
        llenarTableRutaEntrega();
    }    
    
    private void llenarTableRuta(){
        if(rutaObs == null){
            rutaObs = modeloRuta.cargarRuta();
            tbl_ruta.setItems(rutaObs);
        }
        else{
            rutaObs.removeAll(rutaObs);
            rutaObs = modeloRuta.cargarRuta();
            tbl_ruta.setItems(rutaObs);
        }
    }
    
    private void llenarTableRutaEntrega(){
        if(rutaEntrega1 == null){
            rutaEntrega1 = modeloRuta.cargarDatosRutaEntrega();
            tbl_entrega.setItems(rutaEntrega1);
        }
        else{
            rutaEntrega1.removeAll(rutaEntrega1);
            rutaEntrega1 = modeloRuta.cargarDatosRutaEntrega();
            tbl_entrega.setItems(rutaEntrega1);
        }
    }
    
}

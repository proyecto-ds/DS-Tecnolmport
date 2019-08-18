/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import Modelo.Envio;
import Modelo.Repartidor;
import Modelo.Ruta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
    
    @FXML
    private TableView<?> tbl_entrega;
    @FXML
    private TableColumn<?, ?> CIdEntrega;
    @FXML
    private TableColumn<?, ?> CFecha;
    @FXML
    private TableColumn<?, ?> CDireccion;
    @FXML
    private TableColumn<?, ?> CIdRuta;
    
    protected ObservableList<Ruta> rutaObs =null;
    protected Ruta ruta = new Ruta();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CidRuta.setCellValueFactory(new PropertyValueFactory<>("idRuta"));
        CZona.setCellValueFactory(new PropertyValueFactory<>("zona"));
        CNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        CApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        llenarTableRuta();
    }    
    
    private void llenarTableRuta(){
        if(rutaObs == null){
            rutaObs = ruta.cargarRuta();
            tbl_ruta.setItems(rutaObs);
        }
        else{
            rutaObs.removeAll(rutaObs);
            rutaObs = ruta.cargarRuta();
            tbl_ruta.setItems(rutaObs);
        }
    }
    
}

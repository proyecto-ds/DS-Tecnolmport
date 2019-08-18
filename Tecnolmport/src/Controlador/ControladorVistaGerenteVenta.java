/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private TableColumn<Venta, String> CidVenta;
    @FXML
    private TableColumn<Venta, String> CFechaVenta;
    @FXML
    private TableColumn<Venta, String> CCotizacion;
    @FXML
    private TableColumn<Venta, String> CLocal;
    @FXML
    private TableColumn<Venta, String> CTotal;
    @FXML
    private TableColumn<Venta, String> CVendedor;
    @FXML
    private TableColumn<Venta, String> CidEnvio;
    @FXML
    private TableColumn<Venta, String> CProductos;
    private ObservableList<Venta> list = null;
    private Venta modeloVenta = new Venta();
    @FXML
    private TableView<Venta> tableVenta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CidVenta.setCellValueFactory(new PropertyValueFactory<>("id"));
        CFechaVenta.setCellValueFactory(new PropertyValueFactory<>("date"));
        CCotizacion.setCellValueFactory(new PropertyValueFactory<>("esCotizacion"));
        CLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        CTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        CVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        CProductos.setCellValueFactory(new PropertyValueFactory<>("producto"));
        CidEnvio.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
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

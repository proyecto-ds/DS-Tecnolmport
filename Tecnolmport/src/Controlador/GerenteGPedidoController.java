/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pedido;
import Modelo.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author juanjimenez
 */
public class GerenteGPedidoController implements Initializable {

    @FXML private TextArea Descripcion;
    @FXML private Label lblDescripcion;
    @FXML private Label lblLocal;
    @FXML private TextArea textDireccion;
    @FXML private TableView<Producto> TableProductos;
    @FXML private TableColumn<Producto, String> CId;
    @FXML private TableColumn<Producto, String> CnombreProd;
    @FXML private TableColumn<Producto, String> CdescripProd;
    @FXML private TableColumn<Producto, String> CcategoProd;
    @FXML private Button btnAnadir;
    @FXML private Label lblCantidadPro;
    @FXML private TextField textCantidadProd;
    @FXML private Button btnFinalizar;
    @FXML private DatePicker FechaPedido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CId.setCellValueFactory(new PropertyValueFactory<>("id"));
        CnombreProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        CdescripProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("descripcion"));
        CcategoProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("categoria"));
    }   
    
    
    @FXML
    public void getDireccion(){
        
        
    }
    
    public void finalzar(ActionEvent event){
        
        textCantidadProd.clear();
        textDireccion.clear();
        
        
        
    }
    
}

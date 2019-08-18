/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inventario;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
    @FXML
    private TableColumn<Producto, String> CPrecio;
    
      private ObservableList<Producto> list = null;
      
    private Inventario modeloInventario = new Inventario();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CId.setCellValueFactory(new PropertyValueFactory<>("id"));
        CnombreProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        CPrecio.setCellValueFactory(new PropertyValueFactory<Producto,String>("precio"));
        CdescripProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("descripcion"));
        CcategoProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("categoria"));
        llenarTable();
    }   
    
    
    
    
     public void llenarTable(){
         modeloInventario.setIdLocal("3");
        if(list == null){
            list = modeloInventario.llenarTableInventario();
            TableProductos.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloInventario.llenarTableInventario();
            TableProductos.setItems(list);
        }
        
    }

    
    public void getDireccion(){
        
        
    }
    
    public void finalzar(ActionEvent event){
        
        
        
        Pedido pedido = new Pedido();
        
//        protected String id;
      Date fechaPedido =   java.sql.Date.valueOf(FechaPedido.getValue());
       String descripcion =Descripcion.getText();   
       boolean estado =false;
//    protected Local local;
//    protected List<Producto> productos;
//    protected Gerente gerent;

        
        
        
        textCantidadProd.clear();
        
        
        
        
    }
    
}

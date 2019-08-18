/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorLogin.user;
import Modelo.Inventario;
import Modelo.Local;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    private List<Producto> productos = new ArrayList<>();
    
    private Usuario usuariomodel = new Usuario();
    private Local localmodel =  new Local();
    
    
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
        System.out.println(user);
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

    
    public void  ObtenerUsuario(){
        
       for(Usuario us : usuariomodel.llenarTableEmpleado()){
           //System.out.println(us.getUsuario());
          if(user.equals(us.getUsuario())){
              usuariomodel = us;
              System.out.println(us.toString());
           }
               
       }               
    }
    
     public void  ObtenerLocal(){
        
       for(Local us : localmodel.obtenerLocales()){
           if(usuariomodel.getLocal().equals(us)){
               localmodel =us;
               System.out.println(us.toString());
           }
               
       }               
    }
    
    
    
    public void finalzar(ActionEvent event){
       
    //protected Gerente gerent; llenarTableEmpleado -> da una lista de empleados de donde sacas al gerente acutal 
    // protected String id;llenarTablePedido-> da lista de pedidos saco el ultimo y obtengo su id para aumentarle 1
        ObtenerUsuario();
        ObtenerLocal();
        
     Pedido pedido = new Pedido(); 
     
     System.out.println(productos.toString());
     
     if(FechaPedido.getValue()!=null){
         Date fechaPedido = java.sql.Date.valueOf(FechaPedido.getValue());
     }
      
      String descripcion = Descripcion.getText();   
      boolean estado =false;
      

//    protected Local local;


        
        System.out.println(productos.toString() + textCantidadProd.getText());
        
        
        
        
    }

    @FXML
    private void AddProduct(ActionEvent event) {
        lblCantidadPro.setVisible(true);
        textCantidadProd.setVisible(true);
        productos.add(TableProductos.getSelectionModel().getSelectedItem());
        list.remove(TableProductos.getSelectionModel().getSelectedItem());
        TableProductos.setItems(list);
        
    }
    
}

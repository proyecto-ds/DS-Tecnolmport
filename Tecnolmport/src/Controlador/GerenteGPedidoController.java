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

    @FXML private TextArea descripcionTf;
    @FXML private Label lblDescripcion;
    
    @FXML private TableView<Producto> tableProductos;
    @FXML private TableColumn<Producto, String> cId;
    @FXML private TableColumn<Producto, String> cnombreProd;
    @FXML private TableColumn<Producto, String> cdescripProd;
    @FXML private TableColumn<Producto, String> ccategoProd;
    @FXML private Button btnAnadir;
    @FXML private Label lblCantidadPro;
    @FXML private TextField textCantidadProd;
    @FXML private Button btnFinalizar;
    @FXML private DatePicker fechapedido;
    @FXML
    private TableColumn<Producto, String> cPrecio;
    private ObservableList<Producto> list = null;
  
    private Inventario modeloInventario = new Inventario();
    private List<Producto> productos = new ArrayList<>();
    private Usuario usuariomodel = new Usuario();
    private Local localmodel =  new Local();
    private final ControladorValidar validar = new ControladorValidar();
    private final Pedido  pedidomodel= new Pedido();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cnombreProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("nombre"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<Producto,String>("precio"));
        cdescripProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("descripcion"));
        ccategoProd.setCellValueFactory(new PropertyValueFactory<Producto,String>("categoria"));
        llenarTable();
    }   
    
    
    
    
     public void llenarTable(){
         modeloInventario.setIdLocal("3");
        if(list == null){
            list = modeloInventario.llenarTableInventario();
            tableProductos.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloInventario.llenarTableInventario();
            tableProductos.setItems(list);
        }
        
    }

    
    public void  ObtenerUsuario(){
        
       for(Usuario us : usuariomodel.llenarTableEmpleado()){
          if(user.equals(us.getUsuario())){
              usuariomodel = us;
           }
               
       }               
    }
    
     public void  ObtenerLocal(){
        
       for(Local us : localmodel.obtenerLocales()){
           if(usuariomodel.getLocal().equals(us)){
               localmodel =us;
           }
               
       }               
    }
    
    
    public void finalzar(ActionEvent event){
 
        ObtenerUsuario();
        ObtenerLocal();
        //ObteneridPedido();
        
       String descripcion = descripcionTf.getText();  
     
     System.out.println(productos.toString());
     
     if(fechapedido.getValue()!=null){
         Date fechaPedido = java.sql.Date.valueOf(fechapedido.getValue());
         
          Pedido pedido = new Pedido("0", (java.sql.Date) fechaPedido,descripcion,true,localmodel,productos,usuariomodel.getUsuario()); 
          
          System.out.println(pedido.toString());
          boolean valid = pedidomodel.registroPedido(pedido);
          if(valid==true){
              validar.mensajeIngresadoCorrecto();
              pedido = null;
          }
          else{
              validar.mensajeIngresadoIncorrecto();
          }
          
     }

    }

    @FXML
    private void addProduct(ActionEvent event) {
        lblCantidadPro.setVisible(true);
        textCantidadProd.setVisible(true);
        
        if(!textCantidadProd.getText().isEmpty()){
           int cantidad =  Integer.valueOf( textCantidadProd.getText());
           Producto p = tableProductos.getSelectionModel().getSelectedItem();
                 p .setStock(cantidad);
                productos.add(p);
        list.remove(tableProductos.getSelectionModel().getSelectedItem());
        tableProductos.setItems(list);
        textCantidadProd.clear();
            
        }
    }
    
}

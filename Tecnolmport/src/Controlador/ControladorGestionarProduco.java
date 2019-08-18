/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Producto;
import Modelo.Usuario;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGestionarProduco implements Initializable {

    
    @FXML private JFXTextField txt_estado;
    @FXML private JFXTextField txt_id;
    @FXML private JFXTextField txt_nom;
    @FXML private JFXTextField txt_precioProd;
    @FXML private JFXTextField txt_categ;
    @FXML private JFXTextField txt_descrip;
    @FXML private JFXTextField txt_prove;
    @FXML private TableColumn<Producto, String> table_id;
    @FXML private TableColumn<Producto, String> table_nombre;
    @FXML private TableColumn<Producto, String> table_estado;
    @FXML private TableColumn<Producto, String> table_precio;
    @FXML private TableColumn<Producto, String> table_categoria;
    @FXML private TableColumn<Producto, String> table_descrip;
    @FXML private TableColumn<Producto, String> table_prov;
    @FXML private TableView<Producto> table_producto;
    @FXML private JFXComboBox<Boolean> cbxEstado;
    private Producto modeloProducto = new Producto();
    private ControladorValidar validar =  new ControladorValidar();
    private ObservableList<Producto> list = null;
    private Producto producto;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        table_categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        table_descrip.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        table_prov.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
        table_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cbxEstado.getItems().addAll(true,false);
        llenarTable();
    }
    
    
    
    public void llenarTable(){
        if(list == null){
            list = modeloProducto.llenarTableProducto();
            table_producto.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloProducto.llenarTableProducto();
            table_producto.setItems(list);
        }
        
    }

    @FXML
    private void ingresarProducto(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloProducto.ingresarProducto();
        if (resultado){
            validar.mensajeIngresadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeIngresadoIncorrecto();
          
    }

    @FXML
    private void actualizarProducto(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloProducto.actualizarProducto();
        if (resultado){
            validar.mensajeActualizadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeActualizadoIncorrecto();
            
            
    }

    @FXML
    private void eliminarProducto(ActionEvent event) {
        modeloProducto.setId(txt_id.getText());
        boolean resultado = modeloProducto.eliminarProducto();
        if (resultado){
            validar.mensajeEliminadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeEliminadoIncorrecto();
    }

    @FXML
    private void seleccionarProducto(MouseEvent event) {
        producto = (Producto)table_producto.getSelectionModel().getSelectedItem();
        txt_id.setText(producto.getId());
        txt_nom.setText(producto.getNombre());
        txt_precioProd.setText(String.valueOf(producto.getPrecio()));
        txt_categ.setText(producto.getCategoria());
        txt_descrip.setText(producto.getDescripcion());
        txt_estado.setText(String.valueOf(producto.isEstado()));
        txt_prove.setText(producto.getProveedor());
    }
    
    public void obtenerDatos(){
        boolean validarCampo = txt_id.equals("") && txt_nom.equals("") &&txt_categ.equals("") &&txt_descrip.equals("") &&txt_prove.equals("");
        boolean validarPrecio = validar.validarFloat(txt_precioProd);
        if(!validarCampo && !validarPrecio){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();
        }
        else{
            modeloProducto.setId(txt_id.getText());
            modeloProducto.setNombre(txt_nom.getText());
            modeloProducto.setPrecio(Float.parseFloat(txt_precioProd.getText()));
            modeloProducto.setCategoria(txt_categ.getText());
            modeloProducto.setDescripcion(txt_descrip.getText());
            modeloProducto.setProveedor(txt_prove.getText());
            modeloProducto.setEstado(Boolean.parseBoolean(txt_estado.getText()));
            
        }
        
    }

    @FXML
    private void obtenerEstado(ActionEvent event) {
        String seleccion = String.valueOf(cbxEstado.getValue());
        txt_estado.setText(seleccion.toLowerCase()); 
    }
    
    
}


package Controlador;


import Modelo.Producto;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGestionarProduco implements Initializable {

    
    @FXML private JFXTextField txtEstado;
    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNom;
    @FXML private JFXTextField txtPrecioProd;
    @FXML private JFXTextField txtCateg;
    @FXML private JFXTextField txtDescrip;
    @FXML private JFXTextField txtProve;
    @FXML private TableColumn<Producto, String> tableId;
    @FXML private TableColumn<Producto, String> tableNombre;
    @FXML private TableColumn<Producto, String> tableEstado;
    @FXML private TableColumn<Producto, String> tablePrecio;
    @FXML private TableColumn<Producto, String> tableCategoria;
    @FXML private TableColumn<Producto, String> tableDescrip;
    @FXML private TableColumn<Producto, String> tableProv;
    @FXML private TableView<Producto> tableProducto;
    @FXML private JFXComboBox<Boolean> cbxEstado;
    private final Producto modeloProducto = new Producto();
    private final ControladorValidar validar =  new ControladorValidar();
    private ObservableList<Producto> list = null;
    private Producto producto  = null;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablePrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tableCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableDescrip.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tableProv.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
        tableEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cbxEstado.getItems().addAll(true,false);
        llenarTable();
    }
    
    
    
    public void llenarTable(){
        if(list == null){
            list = modeloProducto.llenarTableProducto();
            tableProducto.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloProducto.llenarTableProducto();
            tableProducto.setItems(list);
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
        modeloProducto.setId(txtId.getText());
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
        producto = (Producto)tableProducto.getSelectionModel().getSelectedItem();
        txtId.setText(producto.getId());
        txtNom.setText(producto.getNombre());
        txtPrecioProd.setText(String.valueOf(producto.getPrecio()));
        txtCateg.setText(producto.getCategoria());
        txtDescrip.setText(producto.getDescripcion());
        txtEstado.setText(String.valueOf(producto.isEstado()));
        txtProve.setText(producto.getProveedor());
    }
    
    public void obtenerDatos(){
        boolean validarCampo = txtId.equals("") && txtNom.equals("") &&txtCateg.equals("") &&txtDescrip.equals("") &&txtProve.equals("");
        boolean validarPrecio = validar.validarFloat(txtPrecioProd);
        if(!validarCampo && !validarPrecio){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();
        }
        else{
            modeloProducto.setId(txtId.getText());
            modeloProducto.setNombre(txtNom.getText());
            modeloProducto.setPrecio(Float.parseFloat(txtPrecioProd.getText()));
            modeloProducto.setCategoria(txtCateg.getText());
            modeloProducto.setDescripcion(txtDescrip.getText());
            modeloProducto.setProveedor(txtProve.getText());
            modeloProducto.setEstado(Boolean.parseBoolean(txtEstado.getText()));
            
        }
        
    }

    @FXML
    private void obtenerEstado(ActionEvent event) {
        String seleccion = String.valueOf(cbxEstado.getValue());
        txtEstado.setText(seleccion.toLowerCase()); 
    }
    
    
}

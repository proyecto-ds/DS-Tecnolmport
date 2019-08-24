
package Controlador;


import Modelo.Inventario;
import Modelo.Local;
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
public class ControladorGestionarInventario implements Initializable {

    
    @FXML private JFXTextField txtEstado;
    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNom;
    @FXML private JFXTextField txtPrecioProd;
    @FXML private JFXTextField txtCateg;
    @FXML private JFXTextField txtDescrip;
    @FXML private JFXTextField txtProve;
    @FXML private JFXTextField txtStock;
    @FXML private JFXTextField txtIdI;
    @FXML private TableColumn<Producto, String> tableId;
    @FXML private TableColumn<Producto, String> tableNombre;
    @FXML private TableColumn<Producto, String> tableEstado;
    @FXML private TableColumn<Producto, String> tablePrecio;
    @FXML private TableColumn<Producto, String> tableCategoria;
    @FXML private TableColumn<Producto, String> tableDescrip;
    @FXML private TableColumn<Producto, String> tableProv;
    @FXML private TableColumn<Producto, String> tableStock;
    @FXML private TableColumn<Producto, String> tableIdI;
    @FXML private TableView<Producto> tableInventario;
    @FXML private JFXComboBox<Boolean> cbxEstado;
    private final Inventario modeloInventario = new Inventario();
    private final Producto modeloProducto = new Producto();
    private final Local modeloLocal = new Local();
    private final ControladorValidar validar =  new ControladorValidar();
    private ObservableList<Producto> list = null;
    private Producto producto = null;
    @FXML private JFXComboBox<String> cbxLocal;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableIdI.setCellValueFactory(new PropertyValueFactory<>("idI"));
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablePrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tableStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableDescrip.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tableProv.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
        tableEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cbxEstado.getItems().addAll(true,false);
        cbxLocal.getItems().addAll("bodega","sucursal","matriz");
        
    }
    
    
    
    public void llenarTable(){
        if(list == null){
            list = modeloInventario.llenarTableInventario();
            tableInventario.setItems(list);
        }
        else{
            list.removeAll(list);
            list = modeloInventario.llenarTableInventario();
            tableInventario.setItems(list);
        }
        
    }

    @FXML
    private void ingresarInventario(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloInventario.ingresarInventario(modeloProducto);
        if (resultado){
            validar.mensajeIngresadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeIngresadoIncorrecto();
          
    }

    @FXML
    private void actualizarInventario(ActionEvent event) {
        obtenerDatos();
        boolean resultado = modeloInventario.actualizarInventario(modeloProducto);
        if (resultado){
            validar.mensajeActualizadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeActualizadoIncorrecto();
            
            
    }

    @FXML
    private void eliminarInventario(ActionEvent event) {
        modeloProducto.setIdI(txtIdI.getText());
        boolean resultado = modeloInventario.eliminarInventario(modeloProducto);
        if (resultado){
            validar.mensajeEliminadoCorrecto();
            llenarTable();
        }
        else
            validar.mensajeEliminadoIncorrecto();
    }

    @FXML
    private void seleccionarInventario(MouseEvent event) {
        producto = (Producto)tableInventario.getSelectionModel().getSelectedItem();
        txtId.setText(producto.getId());
        txtIdI.setText(producto.getIdI());
        txtNom.setText(producto.getNombre());
        txtPrecioProd.setText(String.valueOf(producto.getPrecio()));
        txtStock.setText(String.valueOf(producto.getStock()));
        txtCateg.setText(producto.getCategoria());
        txtDescrip.setText(producto.getDescripcion());
        txtEstado.setText(String.valueOf(producto.isEstado()));
        txtProve.setText(producto.getProveedor());
    }
    
    public void obtenerDatos(){
        boolean validarCampo = txtIdI.equals("")&&txtId.equals("") && txtNom.equals("") &&txtCateg.equals("") &&txtDescrip.equals("") &&txtProve.equals("");
        boolean validarPrecio = validar.validarFloat(txtPrecioProd);
        if(!validarCampo && !validarPrecio){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campo");
            alert.setHeaderText(null);
            alert.setContentText("Campo vacio!");
            alert.showAndWait();
        }
        else{
            modeloProducto.setIdI(txtIdI.getText());
            modeloProducto.setId(txtId.getText());
            modeloProducto.setNombre(txtNom.getText());
            modeloProducto.setPrecio(Float.parseFloat(txtPrecioProd.getText()));
            modeloProducto.setStock(Integer.parseInt(txtStock.getText()));
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

    @FXML
    private void obtenerLocal(ActionEvent event) {
        ObservableList<Local> lista = modeloLocal.obtenerLocales();
        String local = cbxLocal.getValue();
        for(Local l: lista){
            if(l.getTipo().equals(local)){
                modeloInventario.setIdLocal(l.getId());
                llenarTable();
            }
        }
    }  
}

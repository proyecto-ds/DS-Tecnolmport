
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorBusquedaArticulo implements Initializable {

    @FXML private Pane parent1;
    @FXML private TableView<Producto> tableBuscarArticulo;
    @FXML private JFXComboBox<String> cbxBuscar;
    @FXML private JFXTextField textBuscar;
    @FXML private TableColumn<Producto, String> cid;
    @FXML private TableColumn<Producto, String> cnombre;
    @FXML private TableColumn<Producto, String> cdescripcion;
    @FXML private TableColumn<Producto, String> cprecio;
    @FXML private TableColumn<Producto, String> ccategoria;
    @FXML private TableColumn<Producto, String> cproveedor;
    @FXML private TableColumn<Producto, String> cestado;

    private final  Producto producto = new Producto();
    private ObservableList<Producto> list =  producto.llenarTableProducto();
    private final FilteredList filtrado = new FilteredList(list, e->true);
    private final String nomT = "Nombre";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxBuscar.getItems().addAll(nomT,"Descripcion","Categoria");
        cbxBuscar.setValue(nomT);
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        cnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cdescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        ccategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cproveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
        cestado.setCellValueFactory(new PropertyValueFactory<>("Estado"));
        tableBuscarArticulo.setItems(list);
       
    }    
     
     public void llenarTable(){
         
        if(list == null){
            list = producto.llenarTableProducto();
            tableBuscarArticulo.setItems(list);
        }  
    }
    
     
     

    @FXML
    private void buscar(KeyEvent event) {
        mBuscar();
        SortedList sort = new SortedList(filtrado);
        sort.comparatorProperty().bind(tableBuscarArticulo.comparatorProperty());
        tableBuscarArticulo.setItems(sort);   
    }
    
    public void mBuscar(){
        textBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrado.setPredicate( (Predicate <? super Producto>) (Producto p)->{
                if(newValue.isEmpty() || newValue==null){
                    return true;
                }else if(cbxBuscar.getValue().equals("Categoria") ){
                    if(p.getCategoria().contains(newValue))
                         return true;
                }else if(cbxBuscar.getValue().equals(nomT)) {
                    if(p.getNombre().contains(newValue))
                         return true;
                }else if(cbxBuscar.getValue().equals("Descripcion")){
                     if(p.getDescripcion().contains(newValue))
                         return true;  
                }
                return false;
             }  );    
        });
}

   
    
    
    
    
    
}

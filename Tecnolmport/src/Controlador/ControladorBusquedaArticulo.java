/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML private Pane parent2;
    @FXML private TableColumn<Producto, String> cid;
    @FXML private TableColumn<Producto, String> cnombre;
    @FXML private TableColumn<Producto, String> cdescripcion;
    @FXML private TableColumn<Producto, String> ccantidad;
    @FXML private TableColumn<Producto, String> cprecio;
    @FXML private TableColumn<Producto, String> ccategoria;
    @FXML private TableColumn<Producto, String> cproveedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxBuscar.getItems().addAll("Nombre","Descripcion","Categoria");
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        cnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cdescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        ccantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        cprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        ccategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cproveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Pedido;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorGerentePedido implements Initializable {

    
    
    private ObservableList <Pedido> lista ;
    
    private Pedido modeloPedido;
    
    private ObservableList<Pedido> listaPedido;
    
    @FXML
    private TableColumn<Pedido, String> Cid;
    @FXML
    private TableColumn<Pedido, String> CFecha;
    @FXML
    private TableColumn<Pedido, String> CEstado;
    @FXML
    private TableColumn<Pedido, String> CLocal;
    @FXML
    private TableColumn<Pedido, String> CGerente;
    @FXML
    private TableColumn<Pedido, Button> CProductos;
    @FXML
    private TableView<Pedido> tablePedido;
    @FXML
    private Label lblTitulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        CFecha.setCellValueFactory(new PropertyValueFactory<Pedido,String>("fechaPeido"));
        CEstado.setCellValueFactory(new PropertyValueFactory<Pedido,String>("estado"));
        CLocal.setCellValueFactory(new PropertyValueFactory<Pedido,String>("local"));
        CGerente.setCellValueFactory(new PropertyValueFactory<Pedido,String>("gerente"));
        CProductos.setCellValueFactory(new PropertyValueFactory<>("botonP"));
        //lista = FXCollections.observableArrayList ();
        
         Pedido e = new Pedido();
        e.llenarTablePedido(tablePedido);
        
    }
    
    
    void consultarEmpleado(ActionEvent event) {
        //tableEmpleado.setVisible(true);
        
    }
    
   
    
    
    
    
}

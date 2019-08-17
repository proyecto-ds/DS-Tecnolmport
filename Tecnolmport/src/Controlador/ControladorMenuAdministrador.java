/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class ControladorMenuAdministrador implements Initializable {

    @FXML private AnchorPane parentRoot;
    @FXML private Pane parent1;
    @FXML private JFXComboBox<String> cbxGestionar;
    @FXML private Pane parent2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxGestionar.getItems().addAll("Cotizacion","Empleado","Entrega","Inventario","Producto","Pedido","Venta");
    }

    @FXML
    private void obtenerSeleccion(ActionEvent event) throws IOException {
        String seleccion = cbxGestionar.getValue();
        gestionarSeleccion(seleccion);
    }
    
    public void gestionarSeleccion(String seleccion) throws IOException{
        String seleccionG = seleccion.toLowerCase();
        if(seleccionG.equals("cotizacion")){
            System.out.println("");
        }
        else if(seleccionG.equals("empleado")){
            AnchorPane vistaGE = FXMLLoader.load(getClass().getResource(("/Vista/VistaGestionarEmpleado.fxml")));
            parent2.getChildren().setAll(vistaGE);
        }
        else if(seleccionG.equals("producto")){
            AnchorPane vistaGP = FXMLLoader.load(getClass().getResource(("/Vista/VistaGestionarProducto.fxml")));
            parent2.getChildren().setAll(vistaGP);
        }
        else if(seleccionG.equals("inventario")){
            System.out.println("");
        }
        else if(seleccionG.equals("pedido")){
            System.out.println("");
        }
        else if(seleccionG.equals("venta")){
            System.out.println("");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author juanjimenez
 */
public class ControladorVistaGerenteVenta implements Initializable {

    @FXML
    private TableColumn<?, ?> CidVenta;
    @FXML
    private TableColumn<?, ?> CFechaVenta;
    @FXML
    private TableColumn<?, ?> CCotizacion;
    @FXML
    private TableColumn<?, ?> CLocal;
    @FXML
    private TableColumn<?, ?> CPago;
    @FXML
    private TableColumn<?, ?> CTotal;
    @FXML
    private TableColumn<?, ?> CVendedor;
    @FXML
    private TableColumn<?, ?> CidEnvio;
    @FXML
    private TableColumn<?, ?> CProductos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

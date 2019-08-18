/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.CtrlJefeBodega;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBMostrarRuta implements Initializable {

    @FXML
    private TableView<?> tbl_rutaYrepartidor;
    @FXML
    private TableColumn<?, ?> CIdRuta;
    @FXML
    private TableColumn<?, ?> CZona;
    @FXML
    private TableColumn<?, ?> CIdRepartidor;
    @FXML
    private TableColumn<?, ?> CNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

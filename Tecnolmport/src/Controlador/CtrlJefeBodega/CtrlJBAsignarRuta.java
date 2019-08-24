
package Controlador.CtrlJefeBodega;

import Modelo.Repartidor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class CtrlJBAsignarRuta implements Initializable {

    @FXML private JFXComboBox<String> cbrepartidor;
    @FXML private JFXButton btnasignarRuta;
    @FXML private TableView<?> tblrutaEntrega;
    protected Repartidor repartidor = new Repartidor();
    @FXML
    private JFXComboBox<String> cbFiltrarRuta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LinkedList<String> nombre =repartidor.obtenerRepartidorDisponible();
        cbFiltrarRuta.getItems().addAll("Norte","Sur","Centro","Este","Oeste");
        if(!comprobarNulidad(nombre))
            cbrepartidor.getItems().addAll(nombre);
    }    
    
    /**
     * Comprueba que la lista pasada no este vacia
     * @param lista Lista
     * @return True si esta llena
     */
    private boolean comprobarNulidad(List lista){
        return lista.isEmpty();
    }
    
}

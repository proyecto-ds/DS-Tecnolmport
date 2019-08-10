/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnolmport;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bryan
 */
public class Tecnolmport extends Application {
    private Stage stagePrincipal;
    @Override
    public void start(Stage stage) throws Exception {
        this.stagePrincipal= stage;
        SceneLogin();
    }
    
    public void SceneLogin() throws IOException{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaLogin.fxml"));
            Scene scene = new Scene(root);
            stagePrincipal.setScene(scene);
            stagePrincipal.initStyle(StageStyle.UNDECORATED);
            stagePrincipal.show();
            
            //para obtener el stage en otro metodo diferente a esta clase
            //-->Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

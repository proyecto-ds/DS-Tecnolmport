/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnolmport;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author bryan
 */
public class Tecnolmport extends Application {
    private Stage stagePrincipal;
    protected static final Logger LOGGER = Logger.getLogger("TecnoImport Logger");
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
            Image image = new Image("/Imagen/logo1.png");
            stagePrincipal.getIcons().add(image);
            stagePrincipal.show();
        }
        catch(IOException e){
             LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class AffichageFXMLController implements Initializable {

    @FXML
    private Button noir;
    @FXML
    private Button gris;
    @FXML
    private Button ret;
    @FXML
    private ImageView mercnoir;
    @FXML
    private ImageView meganbleu;
    @FXML
    private ImageView renaultblanc;
    @FXML
    private ImageView renaultrouge;
    @FXML
    private Button rouge;
    @FXML
    private Button bleu;
    @FXML
    private Button blanche;
    @FXML
    private Button rougeBrick;

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private void détailsVoitures() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageVoitureClient.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffichageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

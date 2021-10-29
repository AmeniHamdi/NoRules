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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class FXMLTransportAcceuilController implements Initializable {

    @FXML
    private Button affichageVoitureBus;
    @FXML
    private Button fermeracceuil;
    @FXML
    private void fermer(ActionEvent event) {
        // get a handle to the stage
    Stage stage = (Stage) fermeracceuil.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    @FXML
    private void NotezService() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/App.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTransportAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void StatistiqueService() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/PieChart.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTransportAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      @FXML
    private void ListeVoituresClients() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/AffichageFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTransportAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      @FXML
    private void ConsulterEspaceAdmin () {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/GererVoituresTransports.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTransportAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import infotourisme.entities.Voiture;
import infotourisme.services.VoitureService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class AjoutFXMLController implements Initializable {

    @FXML
    private AnchorPane paneV;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox modele;
    @FXML
    private TextField prixvoiture;
    @FXML
    private TextField nbrjours;
    @FXML
    private Button ajoutVoiture;
    @FXML
    private AnchorPane paneTC;
    @FXML
    private TextField prixbillet;
    @FXML
    private TextField capacité;
    @FXML
    private ComboBox typecommun;
    @FXML
    private Button ajoutcommun;
    @FXML
    private ImageView imgcomm;
    
    Connection conn= null;
    PreparedStatement pst=null;
    

    
    public void AjoutVoiturepaneShow(){
        paneV.setVisible(true);
        paneTC.setVisible(false);
    }
    
    public void AjoutTransportCommunpaneShow(){
        paneV.setVisible(false);
        paneTC.setVisible(true);
        
    }
    
    @FXML
    
    /*private void AjouterVoiture (ActionEvent event ) throws Exception {
        conn= mysqlconnect.connect
    }*/
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       /*  paneV.setOnAction(new EventHandler<ActionEvent>() {
             
           @Override
           public void handle(ActionEvent event)  {
               VoitureService vs = new VoitureService();
               Voiture voiture = new Voiture(modele.getText(), Float.valueOf(prixvoiture.getText()),date.getDate());
               try {
                   vs.ajouterVoiture(voiture);
                   Parent root= FXMLLoader.load(getClass().getResource("FXMLaffiche.fxml"));
                   nom.getScene().setRoot(root);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

           
       });*/
         
         
        /* typecommun.getItems().addAll("Porshe","Passat","Megan","Renault","Kia","Mercedes","Wallys","RangeRover");
         modele.getItems().addAll("Bus","Mini-Bus","Train","Métro","Taxi");*/
         
         
    }    
    
}

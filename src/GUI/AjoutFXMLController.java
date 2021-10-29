/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.Date;

import infotourisme.InfoTourismeBD;
import infotourisme.entities.TransportCommun;
import infotourisme.entities.Voiture;
import infotourisme.services.TransportCommunService;
import infotourisme.services.VoitureService;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class AjoutFXMLController implements Initializable {
    @FXML
    private TextField matricule;
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
       
            @FXML
    private ComboBox lieuTrans;

    @FXML
    private ComboBox heureDisp;
    
      Connection cnx;
    PreparedStatement ste = null;
    
    
    
   
    public void AjoutVoiturepaneShow(){
        paneV.setVisible(true);
        paneTC.setVisible(false);
    }
    
    public void AjoutTransportCommunpaneShow(){
        paneV.setVisible(false);
        paneTC.setVisible(true);
        
    }
    
    
      @FXML
    private void clean() {
        matricule.setText(null);
        date.setValue(null);
        modele.setValue(null);
        prixvoiture.setText(null);
        nbrjours.setText(null);
        
        
    }
    
    @FXML
    
     private void ajouterVoiture(ActionEvent event) throws Exception {
         
       
              VoitureService vs = new VoitureService();
                
                java.util.Date date1= java.util.Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
           
                
                try{
                   int p = Integer.parseInt(prixvoiture.getText());
                }catch(NumberFormatException ex){
                    
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERREUR:");
                    alert.setHeaderText("Erreur ");
                    alert.setContentText("Vous Devez entrer un prix Valide! Refaites la saisie .");
                    alert.showAndWait();
                
                    return ;
                }
                
                try{
                   int p = Integer.parseInt(nbrjours.getText());
                }catch(NumberFormatException ex){
                    
                  
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERREUR:");
                    alert.setHeaderText("Erreur ");
                    alert.setContentText("Vous Devez entrer un Nombre de jours! Refaites la saisie .");
                    alert.showAndWait();
                                    return ;
                }
                
            

               Voiture voiture = new Voiture(matricule.getText(), modele.getValue().toString(),Integer.parseInt(prixvoiture.getText()),sqlDate1,Integer.parseInt(nbrjours.getText()));
               try {
                  vs.ajouter(voiture);
                 Parent root= FXMLLoader.load(getClass().getResource("ajoutFXML.fxml"));
                 ajoutVoiture.getScene().setRoot(root);
                 
                 JOptionPane.showMessageDialog(null,"Voiture ajoutée avec succés ");
                   
               } catch (SQLException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   
               }

        
     }
     
     @FXML
     
          private void ajouterTransportCommun(ActionEvent event) throws Exception {
         
       
              TransportCommunService ts = new TransportCommunService();
                
            TransportCommun tc = new TransportCommun(heureDisp.getValue().toString(), lieuTrans.getValue().toString(),Integer.parseInt(prixbillet.getText()),typecommun.getValue().toString(),Integer.parseInt(capacité.getText()));
               try {
                  ts.ajouter(tc);
                 Parent root= FXMLLoader.load(getClass().getResource("ajoutFXML.fxml"));
                 ajoutcommun.getScene().setRoot(root);
               JOptionPane.showMessageDialog(null,"Le moyen de Transport Commun est ajouté avec succés  ");
 
               } catch (SQLException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }
              
              
              
              
              
              
              
              
          }
          
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        modele.getItems().addAll("Porshe","Passat","Megan","Renault","Kia","Mercedes","Wallys","RangeRover");
        typecommun.getItems().addAll("Bus","Mini-Bus","Train","Métro","Taxi","Louage","Bolt","Toktok");
        lieuTrans.getItems().addAll("Station Louage Beb-Alioua","La Gare"," Station Louage Moncef Bey ","Station Métro  Rue Barcelone "," Station Taxi ");
        heureDisp.getItems().addAll("24h/24h"," de 8 a.m à 10 p.m","de 3 a.m à 12 p.m","de midi à minuit ","instantanée");
         
    } 

    
   
    
    
    
}

    

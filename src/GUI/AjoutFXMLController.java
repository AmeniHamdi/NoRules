/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ComboBox<?> modele;
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
    private ComboBox<?> typecommun;
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
        // TODO
    }    
    
}

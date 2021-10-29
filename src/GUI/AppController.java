/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import infotourisme.entities.NotesTransport;
import infotourisme.services.NotesTransportService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class AppController implements Initializable {

    @FXML
    private Label levelLabel;
    @FXML
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void methodeimage1(ActionEvent event) throws SQLException {
        a1.setStyle("-fx-background-color: yellow;");
       a2.setStyle("-fx-background-color: gray;");
       a3.setStyle("-fx-background-color: gray;");
       a4.setStyle("-fx-background-color: gray;");
       levelLabel.setText("Faible") ;
       NotesTransport note=new NotesTransport();
       
        note.setTypeNote(levelLabel.getText());
         NotesTransportService ns=new NotesTransportService();
         ns.ajouter(note);
          JOptionPane.showMessageDialog(null,"Note  ajoutée avec succés ");
    }

    @FXML
    private void methodeimage2(ActionEvent event) throws SQLException {
        a1.setStyle("-fx-background-color: yellow;");
      
       a2.setStyle("-fx-background-color: yellow;");
       a3.setStyle("-fx-background-color: gray;");
       a4.setStyle("-fx-background-color: gray;");
        levelLabel.setText("Pas mal") ;
        NotesTransport note=new NotesTransport();
       
        note.setTypeNote(levelLabel.getText());
         NotesTransportService ns=new NotesTransportService();
         ns.ajouter(note);
         JOptionPane.showMessageDialog(null,"Note  ajoutée avec succés ");

    }

    @FXML
    private void methodeimage3(ActionEvent event) throws SQLException {
        a1.setStyle("-fx-background-color: yellow;");
       a2.setStyle("-fx-background-color: yellow;");
       a3.setStyle("-fx-background-color: yellow;");
       a4.setStyle("-fx-background-color: gray;");
       levelLabel.setText("Moyen") ;
       NotesTransport note=new NotesTransport();
       
        note.setTypeNote(levelLabel.getText());
         NotesTransportService ns=new NotesTransportService();
         ns.ajouter(note);
          JOptionPane.showMessageDialog(null,"Note  ajoutée avec succés ");

    }

    @FXML
    private void methodeimage4(ActionEvent event) throws SQLException {
        a1.setStyle("-fx-background-color: yellow;");
       a2.setStyle("-fx-background-color: yellow;");
       a3.setStyle("-fx-background-color: yellow;");
       a4.setStyle("-fx-background-color: yellow;");
        levelLabel.setText("Excellent") ;
        NotesTransport note=new NotesTransport();
       
        note.setTypeNote(levelLabel.getText());
         NotesTransportService ns=new NotesTransportService();
         ns.ajouter(note);
          JOptionPane.showMessageDialog(null,"Note  ajoutée avec succés ");

    }
    
}

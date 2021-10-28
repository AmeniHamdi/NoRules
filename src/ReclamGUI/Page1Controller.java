/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReclamGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import java.util.logging.Logger;
import javafx.scene.Parent;

/**import javafx.scene.Parent
 * FXML Controller class
 *
 * @author Asus
 */
public class Page1Controller implements Initializable {

    @FXML
    private Button FAQ;
    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnClient;

    /**
     * Initializes the controller class.
     */
     

    @FXML
    private void FAQ(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FAQ.fxml"));
            try {
            Parent root= loader.load();  
            FAQController atc = loader.getController ();
            FAQ.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void btnAdmin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2admin.fxml"));
            try {
            Parent root= loader.load();  
            Page2Controller atc = loader.getController ();
            btnAdmin.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void btnClient(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2users.fxml"));
            try {
            Parent root= loader.load();  
            Page2usersController atc = loader.getController ();
            btnClient.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
}

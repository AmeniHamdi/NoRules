/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

import tn.esprit.interfaces.IUserService;
import user.esprit.entities.User;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXMLloginController implements Initializable {

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtemail;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnok;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnok.addActionListener((e) -> {
            IUserService vs;
            vs = new IUserService();
            vs.ajouter(new User(txtnom.getText(), txtprenom.getText(), txtemail.getText(), txtpassword.getText()));

            try {
                
                btnok.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLlogin.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

//       btnok.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//           
//                IUserService vs;
//                try {
//                    vs = new IUserService();
//                    vs.ajouter(new User(txtnom.getText(), txtprenom.getText() ,txtemail.getText(),txtpassword.getText() ));
//                } catch (SQLException ex) {
//                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                try {
//                    btnok.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLlogin.fxml")));
//                } catch (IOException ex) {
//                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }
}

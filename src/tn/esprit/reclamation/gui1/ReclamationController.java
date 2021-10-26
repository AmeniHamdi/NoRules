/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.gui1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tn.esprit.reclamation.gui1.ReclamationController;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private ComboBox<String> Combobox;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Email;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextArea Description;
    @FXML
    private Button Send;

    
    
    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void Combobox(ActionEvent event) {
    }

     public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rec","root","");
            

        }
        catch (ClassNotFoundException ex) {}
        catch (SQLException ex){}

    }
     
    Connection con ;
    PreparedStatement pst;
    
    
    @FXML
    private void Send(ActionEvent event) {
       
        Connect();
        
	String type = Combobox.getSelectionModel().getSelectedItem();
        String firstname = FirstName.getText();
        String lastname = LastName.getText();
        String email = Email.getText();
	String phonenumber = PhoneNumber.getText();
	String description = Description.getText();
            
        try{
		pst = con.prepareStatement("insert into reclama(type,firstname,lastname,email,phonenumber,description)values(?,?,?,?,?,?)");
		
                pst.setString(1, type);	
		pst.setString(2, firstname);
		pst.setString(3, lastname);
                pst.setString(4, email);
                pst.setString(5, phonenumber);
                pst.setString(6, description);
               
                
                int status = pst.executeUpdate();
                if(status==1){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Reclame");
		alert.setContentText("Reclamation Addedd Successfully");
		alert.showAndWait();
                    
                ObservableList<String> list = null;
		
		Combobox.setItems(list)	;
                FirstName.setText("");
		LastName.setText("");
                Email.setText("");
                PhoneNumber.setText("");
                Description.setText("");
		
                
               Combobox.requestFocus();

                 }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
		alert.setHeaderText("Reclame");
		alert.setContentText("Reclamation Addedd Failed");
		alert.showAndWait();
}
}
catch(SQLException ex){
Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);

}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        ObservableList<String> list = FXCollections.observableArrayList("Renseignements","Complaint","Commercial");
        Combobox.setItems(list);
         
         
    }    

    
}

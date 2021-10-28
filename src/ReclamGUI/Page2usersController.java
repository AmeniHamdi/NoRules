/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReclamGUI;


import ReclamService.Reclamation_Service;
import Reclamentites.users;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Page2usersController implements Initializable {

    private Reclamation_Service service =new Reclamation_Service();
    private TableColumn<users, String> col_btnChambre;
    
    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_email;
    @FXML
    private ComboBox<String> combo_type;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_phonenumber;
    @FXML
    private TextArea txt_description;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btnbackclient;
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        ObservableList<String> list = FXCollections.observableArrayList("Message","Complaint","Commercial");
        combo_type.setItems(list);
         
}

    

    @FXML
    private void ajouter_reclama(ActionEvent event) {
        Connect();
        
	String type = combo_type.getSelectionModel().getSelectedItem();
        String firstname = txt_firstname.getText();
        String lastname = txt_lastname.getText();
        String email = txt_email.getText();
	String phonenumber = txt_phonenumber.getText();
	String description = txt_description.getText();
            
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
		alert.setHeaderText("Contact us");
		alert.setContentText("Successfully");
		alert.showAndWait();
                    
                ObservableList<String> list = null;
		
		combo_type.setItems(list)	;
                txt_firstname.setText("");
		txt_lastname.setText("");
                txt_email.setText("");
                txt_phonenumber.setText("");
                txt_description.setText("");
		
                
               combo_type.requestFocus();

                 }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
		alert.setHeaderText("Reclame");
		alert.setContentText("Failed");
		alert.showAndWait();
}
                
}
catch(SQLException ex){
Logger.getLogger(Page2usersController.class.getName()).log(Level.SEVERE, null, ex);

}
    }

    @FXML
    private void btnbackclient(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
            try {
            Parent root= loader.load();  
            Page1Controller atc = loader.getController ();
            btnbackclient.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

}

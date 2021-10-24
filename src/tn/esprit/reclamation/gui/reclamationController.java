/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.gui;

import javafx.scene.control.TableColumn;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class reclamationController implements Initializable {
    
    @FXML
    private TextField txtIDM;

    @FXML
    private TextField txtnameM;

    @FXML
    private TextField txtyouridM;

    @FXML
    private TextArea txtdescM;

    @FXML
    private Button btnmodifier;
    
    @FXML
    private TextField txtnameA;

    @FXML
    private TextField txtyouridA;

    @FXML
    private TextArea txtdescA;
    
    @FXML
    private Button btnajouter;
    
    @FXML
    private Button btnsupprimer;
    
    @FXML
    private TextField txtIDS;
    
    @FXML
    private TableView<Afficher> table;

    @FXML
    private TableColumn<Afficher, String> idColumn;

    @FXML
    private TableColumn<Afficher, String> nameColumn;

    @FXML
    private TableColumn<Afficher, String> youridColumn;

    @FXML
    private TableColumn<Afficher, String> DescColumn;

     Connection con ;
    PreparedStatement pst;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/re","root","");


        }
        catch (ClassNotFoundException ex) {}
        catch (SQLException ex){}

    }
    
    @FXML
    void Add(ActionEvent event) {
Connect();
	String type = txtnameA.getText();
        String id_client = txtyouridA.getText();
	String description = txtdescA.getText();
	try{
		pst = con.prepareStatement("insert into reclamation(type,id_client,description)values(?,?,?)");
		pst.setString(1, type);	
		pst.setString(2, id_client);
		pst.setString(3, description);
                int status = pst.executeUpdate();
 	if(status==1){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Reclame");
		alert.setContentText("Reclamation Addedd Successfully");
		alert.showAndWait();
		table();
		txtnameA.setText("");
		txtyouridA.setText("");
		txtdescA.setText("");
		txtnameA.requestFocus();

}else{
	Alert alert = new Alert(Alert.AlertType.ERROR);
	alert.setTitle("Fail");
		alert.setHeaderText("Reclame");
		alert.setContentText("Reclamation Addedd Failed");
		alert.showAndWait();
}
}
catch(SQLException ex){
Logger.getLogger(reclamationController.class.getName()).log(Level.SEVERE, null, ex);

}
    }
    
      @FXML
    void Update(ActionEvent event) {
        Connect();
        String Id = txtIDM.getText();
	String type = txtnameM.getText();
        String id_client = txtyouridM.getText();
	String description = txtdescM.getText();
	try{
		pst = con.prepareStatement("update reclamation set type=?, id_client=? ,description=? where Id=?");
		pst.setString(1, type);	
		pst.setString(2, id_client);
		pst.setString(3, description);
                pst.setString(4, Id);
                int status = pst.executeUpdate();
 	if(status==1){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Member");
		alert.setContentText("Update Successfully");
		alert.showAndWait();
                
		txtIDM.setText("");
		txtnameA.setText("");
		txtyouridA.setText("");
		txtdescA.setText("");
		txtnameA.requestFocus();

}else{
	Alert alert = new Alert(Alert.AlertType.ERROR);
	alert.setTitle("Fail");
		alert.setHeaderText("Member");
		alert.setContentText("Update Failed");
		alert.showAndWait();
}
}
catch(SQLException ex){
Logger.getLogger(reclamationController.class.getName()).log(Level.SEVERE, null, ex);

}
    }
    
    @FXML
    void Supprim(ActionEvent event) {
        Connect();
        String Id = txtIDS.getText();
	
	try{
		pst = con.prepareStatement("delete from reclamation where Id=?");
		pst.setString(1, Id);	
                
                int status = pst.executeUpdate();
 	if(status==1){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Member");
		alert.setContentText("Suppression Successfully");
		alert.showAndWait();
                
		txtIDM.setText("");
		txtnameA.setText("");
		txtyouridA.setText("");
		txtdescA.setText("");
		txtnameA.requestFocus();

}else{
	Alert alert = new Alert(Alert.AlertType.ERROR);
	alert.setTitle("Fail");
		alert.setHeaderText("Member");
		alert.setContentText("Suppression Failed");
		alert.showAndWait();
}
}
catch(SQLException ex){
Logger.getLogger(reclamationController.class.getName()).log(Level.SEVERE, null, ex);

}
    }
    
    @FXML
    public void table(){
        
	ObservableList<Afficher> affiche = FXCollections.observableArrayList();
        try{
	pst = con.prepareStatement("select id,type,id_client,description from reclamation");
	ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
	Afficher afficher = new Afficher();
	afficher.setId(rs.getString("ID"));
	afficher.setType(rs.getString("Type"));
	afficher.setId_client(rs.getString("Your ID"));
	afficher.setDescription(rs.getString("Description"));
}


 table.setItems(affiche);
idColumn.setCellValueFactory(f -> f.getValue().idProperty());
nameColumn.setCellValueFactory(f -> f.getValue().typeProperty());
youridColumn.setCellValueFactory(f -> f.getValue().id_clientProperty());
DescColumn.setCellValueFactory(f -> f.getValue().descriptionProperty());

}
catch (SQLException ex){
	Logger.getLogger(reclamationController.class.getName()).log(Level.SEVERE, null, ex);

}
}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     Connect();
     table();
    }    
    
}

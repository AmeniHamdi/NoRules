/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import infotourisme.InfoTourismeBD;
import infotourisme.entities.TransportCommun;
import infotourisme.entities.Voiture;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class TransportCommunListController implements Initializable {

    @FXML
    private TableColumn<TransportCommun, String> tupetrans;
    @FXML
    private TableColumn<TransportCommun, String> prixBillet;
    @FXML
    private TableColumn<TransportCommun, String> lieutrans;
    @FXML
    private TableColumn<TransportCommun, String> capacitetrans;
    @FXML
    private TableColumn<TransportCommun, String> heuredisp;

    @FXML
    private TableView<TransportCommun> tabletransp;

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Voiture voiture = null ;
     ObservableList<TransportCommun> listeTransCommun =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            loadDateTransport();
            refreshTableTransport();
            getAddViewTransport() ;

    }    
    
    
    
    
     @FXML
    private void getAddViewTransport() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/AjoutFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(VoituresListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     private void loadDateTransport() {
        
        connection = InfoTourismeBD.getInstance().getConnection();
        
       refreshTableTransport();
        
        tupetrans.setCellValueFactory(new PropertyValueFactory<>("Type"));
        prixBillet.setCellValueFactory(new PropertyValueFactory<>("prixBillet"));
        lieutrans.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        capacitetrans.setCellValueFactory(new PropertyValueFactory<>("Capacité"));
        heuredisp.setCellValueFactory(new PropertyValueFactory<>("heureDisponibilite"));
       
        
    
    }  
     
      @FXML
    private void refreshTableTransport() {
        try {
            listeTransCommun.clear();
            query= "SELECT * FROM `transportcommuns`" ;
            preparedStatement=connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                
            
                listeTransCommun.add(new  TransportCommun(
                        resultSet.getString("heureDisponibilite"),
                        resultSet.getString("lieu"),
                        resultSet.getInt("prixBillet"),
                        resultSet.getString("Type"),
                         resultSet.getInt("Capacité")));
                        
                tabletransp.setItems(listeTransCommun);
            
                }
        } catch (SQLException ex) {
            Logger.getLogger(VoituresListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML 
         private void SupprimerDeTableTransport(ActionEvent event ) throws SQLException {
           // tableVoitr.getItems().removeAll(tableVoitr.getSelectionModel().getSelectedItems());
             int selectedIndex = tabletransp.getSelectionModel().getSelectedIndex();
            String selectedItem = tupetrans.getCellData(selectedIndex);
                 if(selectedIndex >= 0){
              connection = InfoTourismeBD.getInstance().getConnection();
               String query1 = "DELETE FROM transportcommuns WHERE Type = '" + selectedItem + "';";          
            preparedStatement = connection.prepareStatement(query1);              
               preparedStatement.executeUpdate();
             tabletransp.getItems().remove(selectedIndex);
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR:");
        alert.setHeaderText("No selection was made.");
        alert.setContentText("You have not selected an item to delete. Please try again.");
        alert.showAndWait();
    }
}
            
         
}
       

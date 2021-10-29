/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import infotourisme.InfoTourismeBD;
import infotourisme.entities.Voiture;
import infotourisme.services.VoitureService;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DateTimeStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class VoituresListController implements Initializable {
    
    @FXML
    private TableView<Voiture> tableVoitr;
    @FXML
    private TableColumn<Voiture, String> matrVoiture;
    @FXML
    private TableColumn<Voiture, String> modVoiture;
    @FXML
    private TableColumn<Voiture, String> priVoiture;
    @FXML
    private TableColumn<Voiture, String> datreservVoiture;
    @FXML
    private TableColumn<Voiture, String> nbrjoursvoit;
    @FXML
    private TextField chercherlabel;

    @FXML
    private Button deleteIcon;
    @FXML
    private Button edit;

    
     public static  String idxx;
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Voiture voiture = null ;
     ObservableList<Voiture> listevoiture =FXCollections.observableArrayList();
     
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        matrVoiture.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
        modVoiture.setCellValueFactory(new PropertyValueFactory<>("Modele"));
        priVoiture.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        datreservVoiture.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
        nbrjoursvoit.setCellValueFactory(new PropertyValueFactory<>("nbr_jours"));
        
        
        matrVoiture.setCellFactory(TextFieldTableCell.forTableColumn());
       /* modVoiture.setCellFactory(TextFieldTableCell.forTableColumn()); 
        priVoiture.setCellFactory(TextFieldTableCell.forTableColumn());
         nbrjoursvoit.setCellFactory(TextFieldTableCell.forTableColumn());
      datreservVoiture.setCellFactory(TextFieldTableCell.forTableColumn());  */
        
        
         connection = InfoTourismeBD.getInstance().getConnection();
        
        refreshTable();
         getAddView();
        searchActionPerformed();
        
        tableVoitr.setEditable(true);
    
      
    }  
    
     private static Voiture  v=new Voiture();
   
     @FXML
    private void refreshTable() {
     
              try {
            listevoiture.clear();
            query= "SELECT * FROM `voiture`" ;
            preparedStatement=connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
            
            
            listevoiture.add(new  Voiture(
            resultSet.getString("Matricule"),
            resultSet.getString("Modele"),
            resultSet.getInt("Prix"),
            resultSet.getDate("dateReservation"),
            resultSet.getInt("nbr_jours")));
            tableVoitr.setItems(listevoiture);
            
            }
            } catch (SQLException ex) {
            Logger.getLogger(VoituresListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
       
          
    }

     @FXML
    private void ConsulterContratAssurance () {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/ContratAssurance.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTransportAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }          
    
   
    @FXML
    private void getAddView() {
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
    
       
   @FXML
   
    private void searchActionPerformed() {                                       
        
        ObservableList data =  tableVoitr.getItems();
        chercherlabel.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                tableVoitr.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<Voiture> subentries = FXCollections.observableArrayList();

            long count = tableVoitr.getColumns().stream().count();
            for (int i = 0; i < tableVoitr.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + tableVoitr.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(tableVoitr.getItems().get(i));
                        break;
                    }
                }
            }
            tableVoitr.setItems(subentries);
        });
      
        
              
    }
    
    @FXML 
         private void SupprimerDeTable() throws SQLException {
           // tableVoitr.getItems().removeAll(tableVoitr.getSelectionModel().getSelectedItems());
             int selectedIndex = tableVoitr.getSelectionModel().getSelectedIndex();
            String selectedItem = matrVoiture.getCellData(selectedIndex);
                 if(selectedIndex >= 0){
              connection = InfoTourismeBD.getInstance().getConnection();
               String query1 = "DELETE FROM voiture WHERE Matricule = '" + selectedItem + "';";
               PreparedStatement st = connection.prepareStatement(query1);
               st.executeUpdate();
             tableVoitr.getItems().remove(selectedIndex);
    } else {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR:");
        alert.setHeaderText("No selection was made.");
        alert.setContentText("You have not selected an item to delete. Please try again.");
        alert.showAndWait();
    }
}
  
  
   public void OnEditMat(TableColumn.CellEditEvent<Voiture, String> voitureEvent){
       Voiture v = tableVoitr.getSelectionModel().getSelectedItem();
       v.setMatricule(voitureEvent.getNewValue());
       System.out.println(""+v.getMatricule());
       try {
                          VoitureService.getInstance().update(v);
                          
                    } catch (SQLException ex) {
                       
                    }
       
   }
}
   
   
   
    
           



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.GUI;

import Services.ReservationCRUD;
import entite.Reservation;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLDataException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class AfficheReservationAdminController implements Initializable {

    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, Date> dateres;
    @FXML
    private TableColumn<Reservation, Date> dateDeb;
    @FXML
    private TableColumn<Reservation, Date> dateFi;
    @FXML
    private TableColumn<Reservation, Float> heure;
    @FXML
    private TableColumn<Reservation, Integer> Voiture;
    
         private ObservableList<Reservation> resData = FXCollections.observableArrayList();
         
         ReservationCRUD rc = new ReservationCRUD();
    @FXML
    private TextField recherche;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               try {
            List<Reservation> listReservation= new ArrayList<Reservation>();
            
            listReservation = rc.getAllReservation("En Cours");
            
            resData.clear();
            
           resData.addAll(listReservation);
           
           table.setItems(resData);
        
        dateDeb.setCellValueFactory
        (
            new PropertyValueFactory<>("dutedes")
        );
        
        dateFi.setCellValueFactory
        (
            new PropertyValueFactory<>("datefin")
        );
        
          dateres.setCellValueFactory
        (
            new PropertyValueFactory<>("dateRes")
        );  
         
       
                heure.setCellValueFactory
        (
            new PropertyValueFactory<>("heureres")
        );  
        
         
          Voiture.setCellValueFactory
        (
            new PropertyValueFactory<>("id_voiture")
        );
          
       
        
        
       
        } catch (SQLDataException ex) {
            Logger.getLogger(AfficheReservationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void Accepter(ActionEvent event) {
        
     int id =  table.getSelectionModel().getSelectedItem().getIdres();
          System.out.print("id"+id);
        rc.AccpterReservation(id);
    }

    @FXML
    private void Refuser(ActionEvent event) {
        
        int id =  table.getSelectionModel().getSelectedItem().getIdres();
        System.out.print("id"+id);
        rc.RefuserReservation(id);
    }

    @FXML
    private void Rechercher(ActionEvent event) throws SQLDataException {
        
        dateDeb.setCellValueFactory
        (
            new PropertyValueFactory<>("dutedes")
        );
        
        dateFi.setCellValueFactory
        (
            new PropertyValueFactory<>("datefin")
        );
        
          dateres.setCellValueFactory
        (
            new PropertyValueFactory<>("dateRes")
        );  
         
       
                heure.setCellValueFactory
        (
            new PropertyValueFactory<>("heureres")
        );  
        
         
          Voiture.setCellValueFactory
        (
            new PropertyValueFactory<>("id_voiture")
        );
          
            
            
            List<Reservation> list = rc.getAllReservation("En Cours");
            
            //tableview.setItems(observablelist);
            
            FilteredList<Reservation> filtredData= new FilteredList<>(resData, b ->true);
            recherche.textProperty().addListener((observable,oldValue,newValue) -> {
                Predicate<? super Reservation> Reservation;
                filtredData.setPredicate((Reservation reservation) -> {
                    if (newValue == null || newValue.isEmpty()){
                        return true;
                    }
                 
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String strDatedatefin = dateFormat.format(reservation.getDatefin());  
                String strDatedatedebut = dateFormat.format(reservation.getDutedes());  
                    System.out.print("date"+strDatedatedebut);
                    String lowerCaseFilter = newValue.toLowerCase();
                    if(strDatedatedebut.toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                        return true;
                    }
                    else if (strDatedatefin.toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }
                    
                    else
                        return false;
                } );
            });
             // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Reservation> sortedData = new SortedList<>(filtredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);
  
      
  
    }
    
}

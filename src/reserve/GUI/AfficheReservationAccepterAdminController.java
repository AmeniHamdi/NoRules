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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class AfficheReservationAccepterAdminController implements Initializable {

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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               try {
            List<Reservation> listReservation= new ArrayList<Reservation>();
            
            listReservation = rc.getAllReservation("Accepter");
            
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
            Logger.getLogger(AfficheReservationAccepterAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
    
}

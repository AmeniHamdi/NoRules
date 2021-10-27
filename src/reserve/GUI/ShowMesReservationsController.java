/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.GUI;


import Services.ReservationCRUD;
import entite.Reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author dell
 */
public class ShowMesReservationsController implements Initializable {

    @FXML
    private ListView<Reservation> listView;
   
    ObservableList<Reservation> data;
    
    public static int idE ;
    
    ReservationCRUD ds = new ReservationCRUD();

   
    @FXML
    private Button partager;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
           
            data = (ObservableList<Reservation>) ds.getAllReservationByUser(1);   
            listView.setItems(data);
            listView.setCellFactory((ListView<Reservation> param) -> new ListViewReservation());
            
            
            // TODO
        } catch (SQLDataException ex) {
            Logger.getLogger(ShowMesReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    




    @FXML
    private void handleClose(ActionEvent event) {
        
        
    }



    @FXML
    private void Annuler(ActionEvent event) throws SQLDataException {
        
                    ObservableList<Reservation> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Reservation m : e) 
          idE=m.getIdres();
          System.out.println("controller.ShowDonationsController.Annuler()"+idE);
          ds.deleteReservation(idE);
          
                  try {
       Parent root = FXMLLoader.load(getClass().getResource("ShowMesReservations.fxml"));
            Stage myWindow =  (Stage) partager.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
            
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        
                            ObservableList<Reservation> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Reservation m : e) 
          idE=m.getIdres();
      
          
                  try {
                                System.out.println("controller.ShowDonationsController.Hello()"+idE);

       Parent root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
            Stage myWindow =  (Stage) partager.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
            
        
        
    }

    }

    


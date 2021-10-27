/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.GUI;

import Services.ReservationCRUD;
import entite.Reservation;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rzouga
 */
public class FXMLajoutController implements Initializable {

    @FXML
    private TextField txt1;
    @FXML
    private DatePicker datedeb;
    @FXML
    private DatePicker datefin;

    ReservationCRUD rc = new ReservationCRUD();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajout(ActionEvent event) {
        
         Reservation r = new Reservation ();
         Date dd=  new java.sql.Date(  new Date(datedeb.getEditor().getText()).getTime());
         Date df=  new java.sql.Date(  new Date(datefin.getEditor().getText()).getTime());
         
         r.setDatefin((java.sql.Date) df);
         r.setDutedes((java.sql.Date) dd);
         r.setHeureres(Float.parseFloat(txt1.getText()));
         LocalDate now = LocalDate.now();
         Date date = java.sql.Date.valueOf(now);
         r.setDateRes((java.sql.Date) date);
         r.setId_user(1);
         r.setId_voiture(1);
         r.setEtat("En Cours");
         
         rc.ajouterReservation(r);
         
         

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.GUI;

import Services.ReservationCRUD;
import entite.Reservation;
import infotourisme.Reclamation;
import java.net.URL;
import java.sql.SQLDataException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 * @author ibrahim
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField txt1;
    @FXML
    private DatePicker datedeb;
    @FXML
    private DatePicker datefin;
    
    ReservationCRUD rs = new ReservationCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("reserve.GUI.ModifierController.initialize()");
        Reservation r = new Reservation();
        r=rs.findReservationById(ShowMesReservationsController.idE);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       
        datedeb.setValue( r.getDutedes().toLocalDate());
        datefin.setValue(r.getDatefin().toLocalDate());
        txt1.setText(String.valueOf(r.getHeureres()));
        
     
        // TODO
    }    

    @FXML
    private void Ajout(ActionEvent event) throws SQLDataException {
        
        
                 Reservation r = new Reservation ();
         Date dd=  new java.sql.Date(  new Date(datedeb.getEditor().getText()).getTime());
         Date df=  new java.sql.Date(  new Date(datefin.getEditor().getText()).getTime());
         
         r.setDatefin((java.sql.Date) df);
         r.setDutedes((java.sql.Date) dd);
         r.setHeureres(Float.parseFloat(txt1.getText()));
         LocalDate now = LocalDate.now();
         Date date = java.sql.Date.valueOf(now);
         r.setDateRes((java.sql.Date) date);
         r.setIdres(ShowMesReservationsController.idE);

         
         rs.ModifierReservation(r);
    }
    
}

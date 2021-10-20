/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve;

import Services.ReservationCRUD;
import entite.Reservation;
import utils.Myconnection;

/**
 *
 * @author ibrahim
 */
public class Reserve {
        public static void main(String[] args) {
        
        Myconnection.getMycnx() ; 
        
        ReservationCRUD rec = new ReservationCRUD() ; 
        Reservation reservation = new Reservation (11,"5j","12/12/2021"); 
       // Reservation reservation1 = new Reservation (1,8,"administrativefacile","description"); 
         //rec.modifierReservation(reservation1);
        //rec.ajouterReclamation(reservation);
          rec.supprimerReservation(1);
        //System.out.println(rec.getReclamations()); 
        
//    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
 
}

}

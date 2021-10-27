/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.GUI;



import entite.Reservation;
import javafx.scene.control.ListCell;

/**
 *
 * @author dell
 */
public class ListViewReservation extends ListCell<Reservation> {
    
    
     @Override
     public void updateItem(Reservation e, boolean empty)
    {
        super.updateItem(e,empty);
        if(e != null)
        {
            
            ReservationItemController data = new ReservationItemController();
            data.setInfo(e);
            setGraphic(data.getBox());
        }
    }
    
}

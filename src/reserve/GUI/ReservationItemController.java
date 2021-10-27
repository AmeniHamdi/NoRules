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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ReservationItemController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Text nomuser;
    @FXML
    private Text type;
    
    
        ReservationCRUD rc = new ReservationCRUD();
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
   
    }  
    
    public ReservationItemController(){
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservationtItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
    }

    public HBox getBox() {
        return Hbox;
    }
    
        public void setInfo(Reservation res)  {   
          System.out.println("controller.ListViewEkkkkkkkkkkkkkk"+res);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            String strDate = dateFormat.format(res.getDutedes());
        type.setText(strDate);
        nomuser.setText(rc.findVoitureId(res.getId_voiture()).getModele());
     
     
}
        
}


package singnIn;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import tn.esprit.interfaces.IResponsableService;
import user.esprit.entities.Responsable;



/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXMLsignInController implements Initializable {

  

    @FXML
    private Label txtidentif;

    @FXML
    private Label txtpass;

    @FXML
    private Button btnconnect;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnconnect.setOnAction(new EventHandler<ActionEvent>() ){
            @Override
            public void handle(ActionEvent event) {
           
                IResponsableService vs;
                try {
                    vs = new IResponsableService();
                    vs.ajouter(new Responsable(txtidentif.getText(), txtpass.getText()) );
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLsignInController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    btnconnect.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLaffiche.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLsignInController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
    }    
}

       
    
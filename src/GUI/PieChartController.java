/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import infotourisme.InfoTourismeBD;
import infotourisme.entities.TransportCommun;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart piechart;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection cnx;
            Statement ste;
            int global = 0;
            int faible = 0;
            int pasmal = 0;
            int moyen = 0;
            int excellent = 0;
            String query="SELECT (SELECT COUNT(*) FROM notestransport) as globale,(SELECT COUNT(*) FROM notestransport WHERE typeNote = 'Faible') as count1,(SELECT COUNT(*) FROM notestransport WHERE typeNote = 'Pas mal') as count2, (SELECT COUNT(*) FROM notestransport WHERE typeNote = 'Moyen') as count3, (SELECT COUNT(*) FROM notestransport WHERE typeNote = 'Excellent') as count4" ;
            cnx = InfoTourismeBD.getInstance().getConnection();
            ste = cnx.createStatement();
            ResultSet result = ste.executeQuery(query);
            
          while(result.next()){
            global = result.getInt("globale");
            faible = (result.getInt("count1")*100)/ global;
            pasmal = (result.getInt("count2")* 100)/ global;
            moyen = (result.getInt("count3")*100)/ global;
            excellent = (result.getInt("count4")* 100)/ global;
        }
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Faible: "+faible+" %", faible),
                            new PieChart.Data("Pas Mal: "+pasmal+" %", pasmal),
                            new PieChart.Data("Moyen: "+moyen+" %", moyen),
                            new PieChart.Data("Excellent: "+excellent+" %", excellent));            
            piechart.setData(pieChartData);
            piechart.setPrefSize(800, 600);
            piechart.setStartAngle(30);
            piechart.setLabelLineLength(10);
            piechart.setLegendSide(Side.LEFT);
        } catch (SQLException ex) {
            Logger.getLogger(PieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
  


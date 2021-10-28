/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.Activite_Service;
import entites.Activite;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.util.converter.DateStringConverter;
/**
 * FXML Controller class
 *
 * @author Chokr
 */
public class Activites_frontController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<Activite> tabview;
    @FXML
    private TableColumn<Activite, String> col_destination;
    @FXML
    private TableColumn<Activite, String> col_activite;
    @FXML
    private TableColumn<Activite, Date> col_depart;
    @FXML
    private TableColumn<Activite, Date> col_arrive;
    @FXML
    private ImageView Image_Ac;
 private Activite_Service service =new Activite_Service();
    @FXML
    private Label txt_temp;
    @FXML
    private Button btn_Reserver;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Date aujourdhui = new Date();
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
DateFormat.MEDIUM,
DateFormat.MEDIUM);
        txt_temp.setText(mediumDateFormat.format(aujourdhui));

    
            setCellfromtabletoImage();
          search();
            try {
                                        refreche();
                                    } catch (SQLException ex) {
                               
                                    }
    } 
private void setCellfromtabletoImage() {
        tabview.setOnMouseClicked(e -> {

            Activite ev = tabview.getItems().get(tabview.getSelectionModel().getSelectedIndex());
            String ImageUrl ="http://localhost/images/";
      
            
          
            if (ev.getActivité().equals("Golf"))
            {
                 Image image = new Image(ImageUrl + "golf.jpg");
                   Image_Ac.setImage(image);
            }
            else if (ev.getActivité().equals("Sailing"))
            {
                 Image image = new Image(ImageUrl + "Sailing.jpg");
                   Image_Ac.setImage(image);
            }
            else if (ev.getActivité().equals("Hunting"))
            {
                 Image image = new Image(ImageUrl + "Hunting.jpg");
                   Image_Ac.setImage(image);
            }
            else if (ev.getActivité().equals("Quad"))
            {
                 Image image = new Image(ImageUrl + "Quad.jpg");
                   Image_Ac.setImage(image);
            }
            else
            {
               Image image = new Image(ImageUrl + "image.jpg");
                   Image_Ac.setImage(image);  
            }
       
      
        });
                }
        public void search() {
        txt_Seach.setOnKeyReleased(e
                -> {
            if (txt_Seach.getText().equals("") ) {

                try {
                    refreche();
                } catch (SQLException ex) {
                    
                }

            } else {

                try {
                    col_destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        
        col_activite.setCellValueFactory(new PropertyValueFactory<>("activité"));
       
        col_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
       

        tabview.getItems().clear();



                    tabview.setItems(service.serach(txt_Seach.getText()));

                } catch (SQLException ex) {
                    
                }
        

            }
        }
        );

    }
  public void refreche() throws SQLException {
         
        col_destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        
        col_activite.setCellValueFactory(new PropertyValueFactory<>("activité"));
       
        col_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
       

       
       

        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
        
      
   
    }

    @FXML
    private void Reserver_activite(ActionEvent event) {
        //khdmet reservation
    }
}

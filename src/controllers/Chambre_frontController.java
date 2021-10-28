/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.Chambre_Service;
import entites.chambre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Chambre_frontController implements Initializable {

    @FXML
    private Button btn_back;
    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<chambre> tabview;
    @FXML
    private TableColumn<chambre, Integer> col_nb_lits;
    @FXML
    private TableColumn<chambre, Float> col_prix;
    @FXML
    private TableColumn<chambre, Integer> col_numero;
    @FXML
    private TableColumn<chambre, Integer> col_etage;
 private Chambre_Service service =new Chambre_Service();
    @FXML
    private Button btn_reserver;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      search();
            try {
                                        refreche();
                                    } catch (SQLException ex) {
                                        
                                    }
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
                   col_nb_lits.setCellValueFactory(new PropertyValueFactory<>("nb_lits"));
     
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        col_numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
       
       col_etage.setCellValueFactory(new PropertyValueFactory<>("etage"));
   
        tabview.getItems().clear();



                    tabview.setItems(service.serach_hotel(txt_Seach.getText(),Hotel_frontController.id_hotel));

                } catch (SQLException ex) {
                    
                }
        

            }
        }
        );

    }
public void refreche() throws SQLException {
         
  
       
        col_nb_lits.setCellValueFactory(new PropertyValueFactory<>("nb_lits"));
      
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     
        col_numero.setCellValueFactory(new PropertyValueFactory<>("numero"));

       col_etage.setCellValueFactory(new PropertyValueFactory<>("etage"));
   
        
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout_hotel(Hotel_frontController.id_hotel));
    }

    @FXML
    private void back_hotel(ActionEvent event) throws IOException { 
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/hotel_front.fxml")));
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void reserver_chambre(ActionEvent event) {
        // code reservation
    }
    
}

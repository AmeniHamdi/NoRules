/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Alert.AlertDialog;
import Service.Hotel_Service;
import entites.hotel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Hotel_frontController implements Initializable {

    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<hotel> tabview;
    @FXML
    private TableColumn<hotel, String> col_nom;
    @FXML
    private TableColumn<hotel, String> col_categorie;
    @FXML
    private TableColumn<hotel, String> col_lieu;
    @FXML
    private TableColumn<hotel, Integer> col_nombrechambre;
private Hotel_Service service =new Hotel_Service();
private TableColumn<hotel, String> col_btnChambre;
static int id_hotel=0;
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
                       
        col_btnChambre = new TableColumn("Chambres");
        javafx.util.Callback<TableColumn<hotel, String>, TableCell<hotel, String>> cellFactory
                = (final TableColumn<hotel, String> param) -> {
                    final TableCell<hotel, String> cell = new TableCell<hotel, String>() {
                        
                        final Button btn = new Button("Chambres");
                        
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    hotel u = getTableView().getItems().get(getIndex());
                                    id_hotel=u.getId();
                                    
                                    Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene;
                                    try {
                                        scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/chambre_front.fxml")));
                                      stage.setScene(scene);
            stage.show();
                                    } catch (IOException ex) {
                                        Logger.getLogger(Hotel_frontController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
          
                                  
                                    
                                    
                                });
                                setGraphic(btn);
                                setText(null);
                            }
                        }
                    };
                    return cell;
           };
        col_btnChambre.setCellFactory(cellFactory);
        tabview.getColumns().add(col_btnChambre);
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
                   col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
      
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));

        col_nombrechambre.setCellValueFactory(new PropertyValueFactory<>("nombrechambre"));
     
        tabview.getItems().clear();



                    tabview.setItems(service.serach(txt_Seach.getText()));

                } catch (SQLException ex) {
                    
                }
        

            }
        }
        );

    }
  public void refreche() throws SQLException {
         
  
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));

        col_nombrechambre.setCellValueFactory(new PropertyValueFactory<>("nombrechambre"));
   
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
    }
}

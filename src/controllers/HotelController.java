/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Alert.AlertDialog;
import Service.Hotel_Service;
import entites.BadWords;
import entites.hotel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class HotelController implements Initializable {

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
    @FXML
    private TableColumn<hotel, Integer> col_id;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_lieu;
    @FXML
    private ComboBox<String> combo_categorie;
    @FXML
    private Button btn_ajout;
    @FXML
    private TextField txt_nbrchambre;
     private TableColumn<hotel, String> col_btnDelet;
       private Hotel_Service service =new Hotel_Service();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabview.setEditable(true);
        Modifier();
           search();
            try {
                                        refreche();
                                    } catch (SQLException ex) {
                                        
                                    }
                        combo_categorie.getItems().addAll("3 etoile","4 etoile","5 etoile");
        combo_categorie.getSelectionModel().select(0);
        col_btnDelet = new TableColumn("Supprimer");
        javafx.util.Callback<TableColumn<hotel, String>, TableCell<hotel, String>> cellFactory
                = (final TableColumn<hotel, String> param) -> {
                    final TableCell<hotel, String> cell = new TableCell<hotel, String>() {
                        
                        final Button btn = new Button("supprimer");
                        
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    hotel u = getTableView().getItems().get(getIndex());
                                    
                                    
                                    
                                    
                                    try {
                                        service.Supprimer(u.getId());
                                    } catch (SQLException ex) {
                                     }
                                    
                                    
                                    AlertDialog.showNotification("suppression confirmée!", "suppression a été bien faite", AlertDialog.image_checked);
                                    
                                    
                                    try {
                                        refreche();
                                    } catch (SQLException ex) {
                                     }
                                    
                                    
                                });
                                setGraphic(btn);
                                setText(null);
                            }
                        }
                    };
                    return cell;
           };
        col_btnDelet.setCellFactory(cellFactory);
        tabview.getColumns().add(col_btnDelet);
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
        col_nom.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        col_categorie.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
 col_lieu.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_nombrechambre.setCellValueFactory(new PropertyValueFactory<>("nombrechambre"));
     col_nombrechambre.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       
col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        col_nom.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        col_categorie.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
 col_lieu.setCellFactory(TextFieldTableCell.<hotel> forTableColumn());
        col_nombrechambre.setCellValueFactory(new PropertyValueFactory<>("nombrechambre"));
     col_nombrechambre.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       
col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
    }
    @FXML
    private void ajouter_hotel(ActionEvent event)throws SQLException {
        BadWords.loadConfigs();

        {
             if (txt_nom.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de nom", AlertDialog.image_cross);
        } else if (txt_nom.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur txt_nom !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        }  
         else if (BadWords.filterText(txt_nom.getText())) {

                AlertDialog.showNotification("Error !", "cette application n'autorise pas ces termes", AlertDialog.image_cross);

            }
        
        else if (txt_lieu.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_lieu", AlertDialog.image_cross);
        } else if (txt_lieu.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur txt_lieu !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } 
           else if (BadWords.filterText(txt_lieu.getText())) {

                AlertDialog.showNotification("Error !", "cette application n'autorise pas ces termes", AlertDialog.image_cross);

            }
         else if (txt_nbrchambre.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_nbrchambre", AlertDialog.image_cross);
        } else if (txt_nbrchambre.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur txt_nbrchambre !", "quantite incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(txt_nbrchambre.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de txt_nbrchambre", AlertDialog.image_cross);
        }

        else {
 hotel h = new hotel(txt_nom.getText(),combo_categorie.getSelectionModel().getSelectedItem(),txt_lieu.getText(),Integer.parseInt(txt_nbrchambre.getText()));
             service.Ajouter(h);
            refreche();
        }
        }
    }
     public void Modifier()
    {
               
                col_nom.setOnEditCommit((CellEditEvent<hotel, String> event) -> {
            TablePosition<hotel, String> pos = event.getTablePosition();
                System.out.println(pos);
            String nom = event.getNewValue();
                 
            int row = pos.getRow();
            hotel h = event.getTableView().getItems().get(row);
          
  
            h.setNom(nom);
                    try {
                        service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        });
                
                
            col_categorie.setOnEditCommit((CellEditEvent<hotel, String> event) -> {
            TablePosition<hotel, String> pos = event.getTablePosition();
              
            String categorie = event.getNewValue();
                    
            int row = pos.getRow();
            hotel h = event.getTableView().getItems().get(row);
        
  
            h.setCategorie(categorie);
                    try {
                       service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        });      
                
           col_lieu.setOnEditCommit((CellEditEvent<hotel, String> event) -> {
            TablePosition<hotel, String> pos = event.getTablePosition();
               
            String lieu = event.getNewValue();
                   
            int row = pos.getRow();
            hotel h = event.getTableView().getItems().get(row);
           
  
            h.setLieu(lieu);
                    try {
                           service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                   }
        });     
                
            col_nombrechambre.setOnEditCommit((TableColumn.CellEditEvent<hotel, Integer> event) -> {
            TablePosition<hotel, Integer> pos = event.getTablePosition();
           
            Integer nbr = event.getNewValue();
                  
            int row = pos.getRow();
            hotel h = event.getTableView().getItems().get(row);
          
  
            h.setNombrechambre(nbr);
                    try {
                         service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        });          
                
    }

    @FXML
    private void capture(ActionEvent event) {
         Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
           Scene scene =  node.getScene();
         WritableImage writableImage = scene.snapshot(null);
            File file = new File("HotelCapture.png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                System.out.println("Captured: " + file.getAbsolutePath());
                
            } catch (IOException ex) {
             
            }
            AlertDialog.showNotification("Capture !", "Capture", AlertDialog.image_checked);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Alert.AlertDialog;
import Service.Chambre_Service;
import Service.Hotel_Service;
import entites.chambre;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
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
import javafx.util.converter.FloatStringConverter;
import javax.imageio.ImageIO;
import javafx.scene.chart.BarChart;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ChambreController implements Initializable {

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
    @FXML
    private TableColumn<chambre, Integer> col_id;
    @FXML
    private TableColumn<chambre, Integer> col_id_h;
    @FXML
    private TextField txt_nb_lits;
    @FXML
    private TextField txt_numero;
    @FXML
    private ComboBox<Integer> combo_hotels;
    @FXML
    private Button btn_ajout;
    @FXML
    private TextField txt_prix;
    @FXML
    private TextField txt_etage;
      private TableColumn<chambre, String> col_btnDelet;
      private Chambre_Service service =new Chambre_Service();
private Hotel_Service service_hotel =new Hotel_Service();
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
            combo_hotels.getItems().addAll(service_hotel.getHotels());
        combo_hotels.getSelectionModel().select(0);
        col_btnDelet = new TableColumn("Supprimer");
        javafx.util.Callback<TableColumn<chambre, String>, TableCell<chambre, String>> cellFactory
                = (final TableColumn<chambre, String> param) -> {
                    final TableCell<chambre, String> cell = new TableCell<chambre, String>() {
                        
                        final Button btn = new Button("supprimer");
                        
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    chambre u = getTableView().getItems().get(getIndex());
                                    
                                    
                                    
                                    
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
                   col_nb_lits.setCellValueFactory(new PropertyValueFactory<>("nb_lits"));
     col_nb_lits.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));   
        col_numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
     col_numero.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       col_etage.setCellValueFactory(new PropertyValueFactory<>("etage"));
     col_etage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
        col_id_h.setCellValueFactory(new PropertyValueFactory<>("id_h"));
     col_id_h.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       
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
         
  
       
        col_nb_lits.setCellValueFactory(new PropertyValueFactory<>("nb_lits"));
     col_nb_lits.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));   
        col_numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
     col_numero.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       col_etage.setCellValueFactory(new PropertyValueFactory<>("etage"));
     col_etage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
        col_id_h.setCellValueFactory(new PropertyValueFactory<>("id_h"));
     col_id_h.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));   
       
col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
    }

    @FXML
    private void ajouter_chambre(ActionEvent event) throws SQLException {
        if (txt_numero.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_numero", AlertDialog.image_cross);
        } else if (txt_numero.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur txt_numero !", "txt_numero incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(txt_numero.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de txt_numero", AlertDialog.image_cross);
        }
        else if (txt_nb_lits.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_nb_lits", AlertDialog.image_cross);
        } else if (txt_nb_lits.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur txt_nb_lits !", "txt_nb_lits incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(txt_nb_lits.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de txt_nb_lits", AlertDialog.image_cross);
        }
        else if (txt_etage.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_etage", AlertDialog.image_cross);
        } else if (txt_etage.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur txt_etage !", "txt_etage incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(txt_etage.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de txt_etage", AlertDialog.image_cross);
        }
         else if (txt_prix.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de txt_prix", AlertDialog.image_cross);
        } else if (txt_prix.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur txt_etage !", "txt_prix incorrect", AlertDialog.image_cross);
        } else if (Float.valueOf(txt_prix.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de txt_prix", AlertDialog.image_cross);
        }
        else
        {
   
        
     
             chambre c = new chambre(Integer.parseInt(txt_nb_lits.getText()),Integer.parseInt(txt_numero.getText()),Integer.parseInt(txt_etage.getText()),combo_hotels.getSelectionModel().getSelectedItem(),Float.parseFloat(txt_prix.getText()));
             service.Ajouter(c);
            refreche();
        }
    }
     public void Modifier()
    {
      
                
           
                
            col_etage.setOnEditCommit((TableColumn.CellEditEvent<chambre, Integer> event) -> {
            TablePosition<chambre, Integer> pos = event.getTablePosition();
           
            Integer etage = event.getNewValue();
                  
            int row = pos.getRow();
            chambre c = event.getTableView().getItems().get(row);
          
  
            c.setEtage(etage);
                    try {
                         service.Modifier(c,c.getId());
                    } catch (SQLException ex) {
                     }
        });   
                 col_id_h.setOnEditCommit((TableColumn.CellEditEvent<chambre, Integer> event) -> {
            TablePosition<chambre, Integer> pos = event.getTablePosition();
           
            Integer id_h = event.getNewValue();
                  
            int row = pos.getRow();
            chambre c = event.getTableView().getItems().get(row);
          
  
            c.setId_h(id_h);
                    try {
                         service.Modifier(c,c.getId());
                    } catch (SQLException ex) {
                     }
        }); 
          col_nb_lits.setOnEditCommit((TableColumn.CellEditEvent<chambre, Integer> event) -> {
            TablePosition<chambre, Integer> pos = event.getTablePosition();
           
            Integer nb_lits = event.getNewValue();
                  
            int row = pos.getRow();
            chambre c = event.getTableView().getItems().get(row);
          
  
            c.setNb_lits(nb_lits);
                    try {
                         service.Modifier(c,c.getId());
                    } catch (SQLException ex) {
                     }
        });   
           col_numero.setOnEditCommit((TableColumn.CellEditEvent<chambre, Integer> event) -> {
            TablePosition<chambre, Integer> pos = event.getTablePosition();
           
            Integer numero = event.getNewValue();
                  
            int row = pos.getRow();
            chambre c = event.getTableView().getItems().get(row);
          
  
            c.setNumero(numero);
                    try {
                         service.Modifier(c,c.getId());
                    } catch (SQLException ex) {
                     }
        }); 
              col_prix.setOnEditCommit((TableColumn.CellEditEvent<chambre, Float> event) -> {
            TablePosition<chambre, Float> pos = event.getTablePosition();
           
            Float Prix = event.getNewValue();
                  
            int row = pos.getRow();
            chambre c = event.getTableView().getItems().get(row);
          
  
            c.setPrix(Prix);
                    try {
                        service.Modifier(c,c.getId());
                    } catch (SQLException ex) {
                     }
        });
    }
    
}

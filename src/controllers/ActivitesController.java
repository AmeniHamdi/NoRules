/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Alert.AlertDialog;
import Service.Activite_Service;
import entites.Activite;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.Date;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DateStringConverter;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TablePosition;
/**
 * FXML Controller class
 *
 * @author Chokr
 */
public class ActivitesController implements Initializable {

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
    private TableColumn<Activite, Integer> col_id;
    @FXML
    private Button btn_ajout;

    @FXML
    private DatePicker datedepart;
    @FXML
    private DatePicker datearrive;
    @FXML
    private ComboBox<String> combo_Destination;
     private TableColumn<Activite, String> col_btnDelet;
     private Activite_Service service =new Activite_Service();
    @FXML
    private ComboBox<String> combo_activite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    tabview.setEditable(true);
       combo_Destination.getItems().addAll("Tunis","Bizert","Touzer","Djerba");
        combo_Destination.getSelectionModel().select(0);
        
        
        combo_activite.getItems().addAll("Golf","Sailing","Scuba diving","Hunting","Quad");
        combo_activite.getSelectionModel().select(0);
    Modifier();
           search();
            try {
                                        refreche();
                                    } catch (SQLException ex) {
                               
                                    }
             col_btnDelet = new TableColumn("Supprimer");
        javafx.util.Callback<TableColumn<Activite, String>, TableCell<Activite, String>> cellFactory
                = (final TableColumn<Activite, String> param) -> {
                    final TableCell<Activite, String> cell = new TableCell<Activite, String>() {
                        
                        final Button btn = new Button("supprimer");
                        
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    Activite u = getTableView().getItems().get(getIndex());
                                    
                                    
                                    
                                    
                                    try {
                                        service.Supprimer(u.getId_ac());
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
                     col_destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        col_destination.setCellFactory(TextFieldTableCell.<Activite> forTableColumn());
        col_activite.setCellValueFactory(new PropertyValueFactory<>("activité"));
        col_activite.setCellFactory(TextFieldTableCell.<Activite> forTableColumn());
        col_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_depart.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        col_arrive.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

       
       
col_id.setCellValueFactory(new PropertyValueFactory<>("id_ac"));

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
        col_destination.setCellFactory(TextFieldTableCell.<Activite> forTableColumn());
        col_activite.setCellValueFactory(new PropertyValueFactory<>("activité"));
        col_activite.setCellFactory(TextFieldTableCell.<Activite> forTableColumn());
        col_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_depart.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        col_arrive.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

       
       
col_id.setCellValueFactory(new PropertyValueFactory<>("id_ac"));
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
        
      
   
    } public void Modifier()
    {
               
                col_activite.setOnEditCommit((TableColumn.CellEditEvent<Activite, String> event) -> {
            TablePosition<Activite, String> pos = event.getTablePosition();
                System.out.println(pos);
            String activite = event.getNewValue();
                    System.out.println(activite);
            int row = pos.getRow();
            Activite ac = event.getTableView().getItems().get(row);
     
  
            ac.setActivité(activite);
                    try {
                        service.Modifier(ac,ac.getId_ac());
                    } catch (SQLException ex) {
                        
                    }
        });
                
                
                
                
           col_destination.setOnEditCommit((TableColumn.CellEditEvent<Activite, String> event) -> {
            TablePosition<Activite, String> pos = event.getTablePosition();
               
            String des = event.getNewValue();
                   
            int row = pos.getRow();
            Activite ac = event.getTableView().getItems().get(row);
           
  
            ac.setDestination(des);
                    try {
                         service.Modifier(ac,ac.getId_ac());
                    } catch (SQLException ex) {
                        
                    }
        });     
           col_depart.setOnEditCommit((TableColumn.CellEditEvent<Activite, Date> event) -> {
            TablePosition<Activite, Date> pos = event.getTablePosition();
           
            Date dated = event.getNewValue();
     
 
      
         java.sql.Date dd=  new java.sql.Date(  dated.getTime());
            int row = pos.getRow();
            Activite ac = event.getTableView().getItems().get(row);
          
  
            ac.setDate_depart(dd);
                    try {
                      service.Modifier(ac,ac.getId_ac());
                    } catch (SQLException ex) {
                        
                    }
        });       
              
              
              
                col_arrive.setOnEditCommit((TableColumn.CellEditEvent<Activite, Date> event) -> {
            TablePosition<Activite, Date> pos = event.getTablePosition();
           
            Date dated = event.getNewValue();
     
 
      
         java.sql.Date dd=  new java.sql.Date(  dated.getTime());
            int row = pos.getRow();
            Activite ac = event.getTableView().getItems().get(row);
          
  
            ac.setDate_arrivee(dd);
                    try {
                       service.Modifier(ac,ac.getId_ac());
                    } catch (SQLException ex) {
                        
                    }
        });      
                
                
    }
  
    @FXML
    private void ajouter_activite(ActionEvent event) throws SQLException, ParseException  {
        
  
    
        if (datearrive.getValue() != null && datedepart.getValue() != null) {
        float res1 = 0;
        float res2 = 0;
        LocalDate d = LocalDate.now();
        Date date = java.sql.Date.valueOf(d);
          Date dd = new java.sql.Date(new Date(datedepart.getEditor().getText()).getTime());

            Date df = new java.sql.Date(new Date(datearrive.getEditor().getText()).getTime());
          

            long diff1 = df.getTime() - dd.getTime();

            long diff = dd.getTime() - date.getTime();
            res1 = (diff / (1000 * 60 * 60 * 24));
            res2 = (diff1 / (1000 * 60 * 60 * 24));
             if (datearrive.getValue() == null || datedepart.getValue() == null) {

            AlertDialog.showNotification("Erreur Date !", "Vérifier votre champs !", AlertDialog.image_cross);
        } else if ((res1 < 0)) {

            AlertDialog.showNotification("Erreur Date !", "Vérifier votre date !", AlertDialog.image_cross);

        } else if ((res2 < 0)) {

            AlertDialog.showNotification("Erreur Date !", "Aujourd'hui est " + date, AlertDialog.image_cross);

        }
            else
        {
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date datew = sdf.parse(datedepart.getEditor().getText()); 
                java.sql.Date dda = new java.sql.Date(datew.getTime());     
            
                java.util.Date datewf = sdf.parse(datearrive.getEditor().getText()); 
                java.sql.Date dfa = new java.sql.Date(datewf.getTime());     
            Activite a = new Activite(combo_Destination.getSelectionModel().getSelectedItem(), combo_activite.getSelectionModel().getSelectedItem(),dda, dfa );
            service.Ajouter(a);
             refreche();
        }
        }
        else
        {
           AlertDialog.showNotification("Erreur Date !", "Erreur Date" , AlertDialog.image_cross);  
        }
    
            
    }
    
}

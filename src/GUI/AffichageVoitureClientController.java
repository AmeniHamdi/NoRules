/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import infotourisme.InfoTourismeBD;
import infotourisme.entities.ContratAssurance;
import infotourisme.entities.Voiture;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class AffichageVoitureClientController implements Initializable {
    
    @FXML
    private TableView<Voiture> tablclient;
    @FXML
    private TableColumn<Voiture, String> moddVoit;
    @FXML
    private TableColumn<Voiture, String> matt;
    @FXML
    private TableColumn<Voiture, String> prixtnd;
    @FXML
    private TableColumn<?, ?> dateres;

    @FXML
    private TableColumn<?, ?> nbjours;

    
    @FXML
    private TextField typezone;

      String query = null;
     Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Voiture voiture = null ;
    ObservableList<Voiture> listevoiture =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         moddVoit.setCellValueFactory(new PropertyValueFactory<>("Modele"));
        matt.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        prixtnd.setCellValueFactory(new PropertyValueFactory<>("nbr_jours"));
        dateres.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
        nbjours.setCellValueFactory(new PropertyValueFactory<>("nbr_jours"));
        
        
         connection = InfoTourismeBD.getInstance().getConnection();
        refreshTable();
        RechercheSpecifique();
         addButtonToTable();
    }  
    
     private static Voiture  v=new Voiture();
    
     @FXML
    private void refreshTable() {
     
              try {
             listevoiture.clear();
            query= "SELECT * FROM `voiture`" ;
            preparedStatement=connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
            
            
            listevoiture.add(new  Voiture(
            resultSet.getString("Matricule"),
            resultSet.getString("Modele"),
            resultSet.getInt("Prix"),
            resultSet.getDate("dateReservation"),
            resultSet.getInt("nbr_jours")));
            tablclient.setItems(listevoiture);
            
            
            }
            } catch (SQLException ex) {
            Logger.getLogger(AffichageVoitureClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
       
          
    }
    
     @FXML
   
    private void RechercheSpecifique() {                                       
        
        ObservableList data =  tablclient.getItems();
        typezone.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                tablclient.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<Voiture> subentries = FXCollections.observableArrayList();

            long count = tablclient.getColumns().stream().count();
            for (int i = 0; i < tablclient.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + tablclient.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(tablclient.getItems().get(i));
                        break;
                    }
                }
            }
            tablclient.setItems(subentries);
        });
    }
    
    
     private void addButtonToTable()  {
        TableColumn<Voiture, Void> colBtn = new TableColumn("Réservation");

        Callback<TableColumn<Voiture, Void>, TableCell<Voiture, Void>> cellFactory;
            cellFactory = new Callback<TableColumn<Voiture, Void>, TableCell<Voiture, Void>>() {
                @Override
                public TableCell<Voiture, Void> call(final TableColumn<Voiture, Void> param) {
                    final TableCell<Voiture, Void> cell = new TableCell<Voiture, Void>() {
                        
                        private final Button btn = new Button("Réserver Maintenant");
                        
                        {
                            btn.setOnAction((ActionEvent event) -> {
                                Voiture data = getTableView().getItems().get(getIndex());
                                  System.out.println("selectedData: " + data.getMatricule());
                            });
                        }
                        
                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn);
                            }
                        }
                    };
                    return cell;
                }
            };

        colBtn.setCellFactory(cellFactory);

        tablclient.getColumns().add(colBtn);

    }

}


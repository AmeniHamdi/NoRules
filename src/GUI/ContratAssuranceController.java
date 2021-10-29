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
import infotourisme.entities.TransportCommun;
import infotourisme.services.ContratAssuranceService;
import infotourisme.services.TransportCommunService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ameni Hamdi
 */
public class ContratAssuranceController implements Initializable {
        @FXML
    private Button acceuil;

    @FXML
    private TableView<ContratAssurance> tableassur;

    @FXML
    private TableColumn<ContratAssurance, String> owner;

    @FXML
    private TableColumn<ContratAssurance, String> client;

    @FXML
    private TableColumn<ContratAssurance, String> matrVoit;

    @FXML
    private TableColumn<ContratAssurance, String> dateDeb;

    @FXML
    private TableColumn<ContratAssurance, String> dateFin;

    @FXML
    private Button remassur;

    @FXML
    private Button ajoutassur;
        @FXML
    private Button btnpdf;

        String query = null;
    Connection connection = null ;
    PreparedStatement ps = null ;
    ResultSet resultSet = null ;
    File file=new File("C:\\Users\\Ameni Hamdi\\Documents\\4SE\\ProjetJavaWeb\\Nouveau dossier (3)\\InfoTourisme-Trnsport\\src\\GUI\\data.pdf");

      ObservableList<ContratAssurance> assurance =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadDate();
        
    }    
     private static ContratAssurance  v=new ContratAssurance();

@FXML
    private void refreshTable() {
     
     
    
    try {
        assurance.clear();
        String sql = "select * from contrat_assurance";
        ps=connection.prepareStatement(sql);
        resultSet = ps.executeQuery();
        while (resultSet.next()) {
            
            assurance.add(new  ContratAssurance(
            resultSet.getDate("dateDebut"),
            resultSet.getDate("dateFin"),
            resultSet.getString("matricule"),
            resultSet.getString("createdBy"),
            resultSet.getString("assignedTo")));
             tableassur.setItems(assurance);
 }
            } catch (SQLException ex) {
            Logger.getLogger(ContratAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
  
 
}
 }
    
    
     private void loadDate() {
         
         connection = InfoTourismeBD.getInstance().getConnection();
        
            refreshTable();
            addButtonToTable();
         
        owner.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
        client.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));
        matrVoit.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        dateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
     }
     
     
     
     private void addButtonToTable()  {
        TableColumn<ContratAssurance, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<ContratAssurance, Void>, TableCell<ContratAssurance, Void>> cellFactory;
            cellFactory = new Callback<TableColumn<ContratAssurance, Void>, TableCell<ContratAssurance, Void>>() {
                @Override
                public TableCell<ContratAssurance, Void> call(final TableColumn<ContratAssurance, Void> param) {
                    final TableCell<ContratAssurance, Void> cell = new TableCell<ContratAssurance, Void>() {
                        
                        private final Button btn = new Button("Generate PDF");
                        
                        {
                            btn.setOnAction((ActionEvent event) -> {
                                ContratAssurance data = getTableView().getItems().get(getIndex());
                                
                                String fichier="C:\\Users\\Ameni Hamdi\\Documents\\4SE\\ProjetJavaWeb\\Nouveau dossier (3)\\InfoTourisme-Trnsport\\src\\GUI\\" + data.getMatricule() +".pdf" ;
                                
                                Document document =new Document();
                                try {
                                    PdfWriter.getInstance(document, new FileOutputStream(fichier));
                                } catch (DocumentException | FileNotFoundException ex) {
                                    Logger.getLogger(ContratAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                document.open();
                                
                                
                                Paragraph para=new Paragraph("| "+data.getDateDebut() +" | "+data.getDateFin()+" | "+data.getMatricule()+" | "+data.getCreatedBy()+" | "+data.getAssignedTo() +" |");
                                try {
                                    document.add(para);
                                } catch (DocumentException ex) {
                                    Logger.getLogger(ContratAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                               
                                  document.close();
                                  
                                
                                
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

        tableassur.getColumns().add(colBtn);

    }
     
     
        /*  private void ajouterContrat(ActionEvent event) throws Exception {
         
       
              ContratAssuranceService ca = new ContratAssuranceService();
               SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
                String strDate = formatter.format(dateDeb);  
                String strDate1 = formatter.format(dateFin);
                
            ContratAssurance tc = new TransportCommun(strDate., strDate1 ,matrVoit.getText(),owner.getText(),client.getText());
               try {
                  tc.ajouter(tc);
                 Parent root= FXMLLoader.load(getClass().getResource("ajoutFXML.fxml"));
                 ajoutcommun.getScene().setRoot(root);
               JOptionPane.showMessageDialog(null,"Le moyen de Transport Commun est ajouté avec succés  ");
 
               } catch (SQLException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(AjoutFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }*/
              
    
    }


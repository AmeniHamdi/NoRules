/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReclamGUI;


import ReclamService.Reclamation_Service;
import Reclamentites.BadWords;
import Reclamentites.users;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Page2Controller implements Initializable {

    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<users> tabview;
    private TableColumn<users, String> col_nom;
    private TableColumn<users, String> col_categorie;
    private TableColumn<users, String> col_lieu;
    private TableColumn<users, Integer> col_nombrechambre;
    @FXML
    private TableColumn<users, Integer> col_id;
    private TextField txt_nom;
    private TextField txt_lieu;
    private ComboBox<String> combo_categorie;
    @FXML
    private Button btn_ajout;
    private TextField txt_nbrchambre;
     private TableColumn<users, String> col_btnDelet;
       private Reclamation_Service service =new Reclamation_Service();
    @FXML
    private ComboBox<String> combo_type;
    @FXML
    private TableColumn<users, String> col_type;
    @FXML
    private TableColumn<users, String> col_firstname;
    @FXML
    private TableColumn<users, String> col_lastname;
    @FXML
    private TableColumn<users, String> col_email;
    @FXML
    private TableColumn<users, Integer> col_phonenumber;
    @FXML
    private TableColumn<users, String> col_description;
    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_phonenumber;
    @FXML
    private TextArea txt_description;
    @FXML
    private Button btnbackadmin;

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
        combo_type.getItems().addAll("Message","Complaint","Commercial");
        combo_type.getSelectionModel().select(0);
        col_btnDelet = new TableColumn("Supprimer");
        javafx.util.Callback<TableColumn<users, String>, TableCell<users, String>> cellFactory
                = (final TableColumn<users, String> param) -> {
                    final TableCell<users, String> cell = new TableCell<users, String>() {
                        
                        final Button btn = new Button("supprimer");
                        
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    users u = getTableView().getItems().get(getIndex());
                                    
                                    
                                    
                                    
                                    try {
                                        service.Supprimer(u.getId());
                                    } catch (SQLException ex) {
                                     }
                                    
                                    
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Suppression");
		alert.setHeaderText("Contact us");
		alert.setContentText("Suppression");
		alert.showAndWait();;
                                    
                                    
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
                   col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_type.setCellFactory(TextFieldTableCell.<users> forTableColumn());
        
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_firstname.setCellFactory(TextFieldTableCell.<users> forTableColumn());
        
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
 col_lastname.setCellFactory(TextFieldTableCell.<users> forTableColumn());
 
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
 col_email.setCellFactory(TextFieldTableCell.<users> forTableColumn()); 
     
     col_phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
     col_phonenumber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
     
     col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
 col_description.setCellFactory(TextFieldTableCell.<users> forTableColumn());
       
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
         
  
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_type.setCellFactory(TextFieldTableCell.<users> forTableColumn());
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_firstname.setCellFactory(TextFieldTableCell.<users> forTableColumn());
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        col_lastname.setCellFactory(TextFieldTableCell.<users> forTableColumn());
         col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_email.setCellFactory(TextFieldTableCell.<users> forTableColumn());
        col_phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        col_phonenumber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));  
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_description.setCellFactory(TextFieldTableCell.<users> forTableColumn());
         
       
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabview.getItems().clear();

        tabview.setItems(service.Affichertout());
    }
    @FXML
    private void ajouter_reclamation1(ActionEvent event)throws SQLException {
        BadWords.loadConfigs();

        {
             if (txt_firstname.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Contact us");
		alert.setContentText("Successfully");
		alert.showAndWait();
        } else if (txt_firstname.getText().matches("^[0-9]+$")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Failed");
		alert.setHeaderText("Contact us");
		alert.setContentText("Failed");
		alert.showAndWait();
        }  
         else if (BadWords.filterText(txt_firstname.getText())) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
               

            }
        
        else if (txt_lastname.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } else if (txt_lastname.getText().matches("^[0-9]+$")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } 
           else if (BadWords.filterText(txt_lastname.getText())) {

                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();

            }
           else if (txt_email.getText().equals("")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } else if (txt_email.getText().matches("^[0-9]+$")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } 
           else if (BadWords.filterText(txt_email.getText())) {

                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();

            }
         else if (txt_phonenumber.getText().equals("")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } else if (txt_phonenumber.getText().matches("^[a-zA-Z]+$")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } else if (Integer.valueOf(txt_phonenumber.getText()) <= 0) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        }
        else if (txt_description.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } else if (txt_description.getText().matches("^[0-9]+$")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("cette application n'autorise pas ces termes");
		alert.setHeaderText("Contact us");
		alert.setContentText("cette application n'autorise pas ces termes");
		alert.showAndWait();
        } 
           //else if (BadWords.filterText(txt_lieu.getText())) {

                //AlertDialog.showNotification("Error !", "cette application n'autorise pas ces termes", AlertDialog.image_cross);

           // }

        else {
        users h = new users(Integer.parseInt(txt_phonenumber.getText()),combo_type.getSelectionModel().getSelectedItem(),txt_firstname.getText(),txt_lastname.getText(),txt_email.getText(),txt_description.getText());
            service.Ajouter(h);
            refreche();
        }
        }
    }
     public void Modifier()
    {
               col_type.setOnEditCommit((CellEditEvent<users, String> event) -> {
            TablePosition<users, String> pos = event.getTablePosition();
              
            String type = event.getNewValue();
                    
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
        
  
            h.setType(type);
                    try {
                       service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        }); 
               
                col_firstname.setOnEditCommit((CellEditEvent<users, String> event) -> {
            TablePosition<users, String> pos = event.getTablePosition();
                System.out.println(pos);
            String firstname = event.getNewValue();
                 
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
          
  
            h.setFirstname(firstname);
                    try {
                        service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        });
                
                
                 
                
           col_lastname.setOnEditCommit((CellEditEvent<users, String> event) -> {
            TablePosition<users, String> pos = event.getTablePosition();
               
            String lastname = event.getNewValue();
                   
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
           
  
            h.setLastname(lastname);
                    try {
                           service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                   }
        });     
           col_email.setOnEditCommit((CellEditEvent<users, String> event) -> {
            TablePosition<users, String> pos = event.getTablePosition();
               
            String email = event.getNewValue();
                   
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
           
  
            h.setEmail(email);
                    try {
                           service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                   }
        });  
                
            col_phonenumber.setOnEditCommit((TableColumn.CellEditEvent<users, Integer> event) -> {
            TablePosition<users, Integer> pos = event.getTablePosition();
           
            Integer phonenumber = event.getNewValue();
                  
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
          
  
            h.setPhonenumber(phonenumber);
                    try {
                         service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                     }
        });         
            col_description.setOnEditCommit((CellEditEvent<users, String> event) -> {
            TablePosition<users, String> pos = event.getTablePosition();
               
            String description = event.getNewValue();
                   
            int row = pos.getRow();
            users h = event.getTableView().getItems().get(row);
           
  
            h.setDescription(description);
                    try {
                           service.Modifier(h,h.getId());
                    } catch (SQLException ex) {
                   }
        });  
                
    }

    @FXML
    private void btnbackadmin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
            try {
            Parent root= loader.load();  
            Page1Controller atc = loader.getController ();
            btnbackadmin.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }


    
}

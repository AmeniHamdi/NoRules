/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReclamService;

import RIService.IService;
import ReclamUtils.MyConnexion;
import Reclamentites.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
/**
 *
 * @author lenovo
 */
public class Reclamation_Service implements IService<users> {

    private Connection c = MyConnexion.getInsCon().getcnx();

    @Override
    public void Ajouter(users t) throws SQLException {
    try {
            String requete = "INSERT INTO `reclama`(`type`, `firstname`, `lastname`, `email`, `phonenumber`, `description`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
   pst.setString(1, t.getType());
            pst.setString(2, t.getFirstname());
            pst.setString(3, t.getLastname());
            pst.setString(4, t.getEmail());
            pst.setInt(5, t.getPhonenumber());
            pst.setString(6, t.getDescription());
            
            
            pst.execute();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Ajoute");
		alert.setHeaderText("Contact us");
		alert.setContentText("Ajouter");
		alert.showAndWait();;
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  }

    @Override
    public void Supprimer(int t) throws SQLException {
      PreparedStatement ps;    
        String query = "DELETE FROM `reclama` WHERE id=? ";
        ps = c.prepareStatement(query);
        ps.setInt(1, t);
        ps.execute(); }
    public ObservableList<Integer> getReclamation() {
        ObservableList<Integer> list = FXCollections.observableArrayList();

        String requete = "select * from reclama  ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("id"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void Modifier(users t, int id) throws SQLException {
    PreparedStatement ps;
        String query = "UPDATE `reclama` SET `type`=?,`firstname`=?,`lastname`=?,`email`=?,`phonenumber`=?,`description`=? WHERE id=?";

        ps = c.prepareStatement(query);
   ps.setString(1, t.getType());
            ps.setString(2, t.getFirstname());
             ps.setString(3, t.getLastname());
            ps.setString(4, t.getEmail());
            ps.setInt(5, t.getPhonenumber());
            ps.setString(6, t.getDescription());
        ps.setInt(7, id);
        ps.execute();
    
    }
   public ObservableList<users> serach(String cas) throws SQLException {
                            ObservableList<users> list = FXCollections.observableArrayList();

            String requete = "select * from reclama where  type LIKE '%" + cas + "%' or firstname LIKE '%" + cas+ "%' or lastname LIKE '%" + cas + "%' or email LIKE '%" + cas + "%'or phonenumber LIKE '%" + cas + "%'or description LIKE '%" + cas + "%' ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new users(rs.getInt("id"),rs.getString("type"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getInt("phonenumber"), rs.getString("description")));
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 

    
    
    
    
    
    
    
    }
    @Override
    public ObservableList<users> Affichertout() throws SQLException {
                          ObservableList<users> list = FXCollections.observableArrayList();

            String requete = "select * from reclama ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new users(rs.getInt("id"),rs.getString("type"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getInt("phonenumber"), rs.getString("description")));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 
 }
    
}

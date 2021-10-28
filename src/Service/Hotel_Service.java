/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Alert.AlertDialog;
import IService.IService;
import Utils.MyConnexion;
import entites.hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author lenovo
 */
public class Hotel_Service implements IService<hotel> {

    private Connection c = MyConnexion.getInsCon().getcnx();

    @Override
    public void Ajouter(hotel t) throws SQLException {
    try {
            String requete = "INSERT INTO `hotel`(`nom`, `categorie`, `lieu`, `nombrechambre`) VALUES (?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
   pst.setString(1, t.getNom());
            pst.setString(2, t.getCategorie());
            pst.setString(3, t.getLieu());
            pst.setInt(4, t.getNombrechambre());
            pst.execute();
           AlertDialog.showNotification("Ajout", "Ajout", AlertDialog.image_checked);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  }

    @Override
    public void Supprimer(int t) throws SQLException {
      PreparedStatement ps;    
        String query = "DELETE FROM `hotel` WHERE id=? ";
        ps = c.prepareStatement(query);
        ps.setInt(1, t);
        ps.execute(); }
    public ObservableList<Integer> getHotels() {
        ObservableList<Integer> list = FXCollections.observableArrayList();

        String requete = "select * from hotel  ";
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
    public void Modifier(hotel t, int id) throws SQLException {
    PreparedStatement ps;
        String query = "UPDATE `hotel` SET `nom`=?,`categorie`=?,`nombrechambre`=?,`lieu`=? WHERE id=?";

        ps = c.prepareStatement(query);
   ps.setString(1, t.getNom());
            ps.setString(2, t.getCategorie());
             ps.setInt(3, t.getNombrechambre());
            ps.setString(4, t.getLieu());
        ps.setInt(5, id);
        ps.execute();
    
    }
   public ObservableList<hotel> serach(String cas) throws SQLException {
                            ObservableList<hotel> list = FXCollections.observableArrayList();

            String requete = "select * from hotel where  nom LIKE '%" + cas + "%' or categorie LIKE '%" + cas+ "%' or nombrechambre LIKE '%" + cas + "%' or lieu LIKE '%" + cas + "%' ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new hotel(rs.getInt("id"),rs.getString("nom"), rs.getString("categorie"), rs.getString("lieu"), rs.getInt("nombrechambre")));
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 

    
    
    
    
    
    
    
    }
    @Override
    public ObservableList<hotel> Affichertout() throws SQLException {
                          ObservableList<hotel> list = FXCollections.observableArrayList();

            String requete = "select * from hotel ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new hotel(rs.getInt("id"),rs.getString("nom"), rs.getString("categorie"), rs.getString("lieu"), rs.getInt("nombrechambre")));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 
 }
    
}

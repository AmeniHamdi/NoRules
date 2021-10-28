/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Alert.AlertDialog;
import IService.IService;
import Utils.MyConnexion;
import entites.chambre;

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
public class Chambre_Service implements IService<chambre> {

    private Connection c = MyConnexion.getInsCon().getcnx();

    @Override
    public void Ajouter(chambre t) throws SQLException {
   try {
            String requete = "INSERT INTO `chambre`(`nb_lits`, `prix`, `numero`, `etage`, `id_h`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
   pst.setInt(1, t.getNb_lits());
            pst.setFloat(2, t.getPrix());
            pst.setInt(3, t.getNumero());
            pst.setInt(4, t.getEtage());
             pst.setInt(5, t.getId_h());
            pst.execute();
           AlertDialog.showNotification("Ajout", "Ajout", AlertDialog.image_checked);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    
    
    }

    @Override
    public void Supprimer(int t) throws SQLException {
    PreparedStatement ps;    
        String query = "DELETE FROM `chambre` WHERE id=? ";
        ps = c.prepareStatement(query);
        ps.setInt(1, t);
        ps.execute();   }

    @Override
    public void Modifier(chambre t, int id) throws SQLException {
    
     PreparedStatement ps;
        String query = "UPDATE `chambre` SET `nb_lits`=?,`prix`=?,`numero`=?,`etage`=?,`id_h`=? WHERE id=?";

        ps = c.prepareStatement(query);
   ps.setInt(1, t.getNb_lits());
            ps.setFloat(2, t.getPrix());
             ps.setInt(3, t.getNumero());
            ps.setInt(4, t.getEtage());
            ps.setInt(5, t.getId_h());
        ps.setInt(6, id);
        ps.execute();
    
    }
public ObservableList<chambre> serach(String cas) throws SQLException {
                            ObservableList<chambre> list = FXCollections.observableArrayList();

            String requete = "select * from chambre where  nb_lits LIKE '%" + cas + "%' or numero LIKE '%" + cas+ "%' or etage LIKE '%" + cas + "%' or id_h LIKE '%" + cas+ "%' or prix LIKE '%" + cas + "%' ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new chambre(rs.getInt("id"),rs.getInt("nb_lits"),rs.getInt("numero"),rs.getInt("etage"),rs.getInt("id_h"),rs.getFloat("prix")));
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 

    
    
    
    
    
    
    
    }
    @Override
    public ObservableList<chambre> Affichertout() throws SQLException {
               ObservableList<chambre> list = FXCollections.observableArrayList();

            String requete = "select * from chambre ";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new chambre(rs.getInt("id"),rs.getInt("nb_lits"),rs.getInt("numero"),rs.getInt("etage"),rs.getInt("id_h"),rs.getFloat("prix")));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;  }
    public ObservableList<chambre> Affichertout_hotel(int id_h) throws SQLException {
               ObservableList<chambre> list = FXCollections.observableArrayList();

            String requete = "select * from chambre where id_h="+id_h;
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new chambre(rs.getInt("id"),rs.getInt("nb_lits"),rs.getInt("numero"),rs.getInt("etage"),rs.getInt("id_h"),rs.getFloat("prix")));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;  }
    public ObservableList<chambre> serach_hotel(String cas,int id_h) throws SQLException {
                            ObservableList<chambre> list = FXCollections.observableArrayList();

            String requete = "select * from chambre where  (nb_lits LIKE '%" + cas + "%' or numero LIKE '%" + cas+ "%' or etage LIKE '%" +  cas+ "%' or prix LIKE '%" + cas + "%' ) and id_h="+id_h;
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
        
list.add(new chambre(rs.getInt("id"),rs.getInt("nb_lits"),rs.getInt("numero"),rs.getInt("etage"),rs.getInt("id_h"),rs.getFloat("prix")));
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list; 

    
    
    
    
    
    
    
    }
}

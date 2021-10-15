/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Activites;
import tn.esprit.utils.MyConnection;

/**
 *
 * @author Chokr
 */
public class ActivitesCRUD {
    private Connection cnx ;

    public ActivitesCRUD() {
        cnx = MyConnection.getMyCnx().getConnection();
          
    }
    public void ajouterActivites(Activites a){
        
        try { 
            String req="insert into activité (destination,duree_reservation,date_depart,date_arrivee) values('"+a.getDestination()+"','"+a.getDuree_reservation()+"','"+a.getDate_depart()+"','"+a.getDate_arrivee()+"') " ;
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate (req); 
           System.out.println("Activites Ajoutée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    
    
    }
    public void ajouterActivites1 (Activites a){
        String req="insert into reclamation (type,id_client,description) values(?,?,?) " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1,a.getDestination()) ; 
            pst.setString(2,a.getDuree_reservation()) ;
            pst.setString(3,a.getDate_depart()) ;
            pst.setString(4,a.getDate_arrivee());
            pst.executeUpdate (); 
           System.out.println("Activites Ajoutée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        
    }
    
    public void modifierActivites (Activites a){
        String req="update activité set destination=?, duree_reservation=? ,date_depart=? ,date_arrivee=? where id_ac=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1,a.getId_ac()) ; 
            pst.setString(2, a.getDestination()) ;
            pst.setString(3, a.getDuree_reservation()) ;
            pst.setString(4, a.getDate_depart()) ;
            pst.setString(5,a.getDate_arrivee());
            pst.executeUpdate (); 
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
    }
    public void supprimerStock(int id_ac) {

        String req = "delete from activité where Id_ac=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, id_ac);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    public List<Activites> getActivitess(){
        List<Activites> activitess = new ArrayList<>();
       try {
            String req = "Select * from activité";
            java.sql.Statement st = (java.sql.Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               Activites a = new Activites (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
                activitess.add(a);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return activitess ;
        
    }
}

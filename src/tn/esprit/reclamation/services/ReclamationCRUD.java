/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.services;
import tn.esprit.reclamation.entities.Reclamation ; 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.reclamation.utils.Myconnection;


/**
 *
 * @author achra
 */
public class ReclamationCRUD {
    Connection cnx ; 
    public ReclamationCRUD (){
    cnx = Myconnection.getMycnx().getConnection() ;   
        }
    
    public void ajouterReclamation (Reclamation r){
        String req="insert into reclamation (type,id_client,description) values(?,?,?) " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1,r.getType()) ; 
            pst.setInt(2, r.getId_client()) ;
            pst.setString(3, r.getDescription()) ;
            pst.executeUpdate (); 
           System.out.println("Reclamation Ajoutée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        
    }
    public void modifierReclamation (Reclamation r){
        String req="update reclamation set type=?, id_client=? ,description=? where Id_re=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1,r.getType()) ; 
            pst.setInt(2, r.getId_client()) ;
            pst.setString(3, r.getDescription()) ;
            pst.setInt(4, r.getId_re()) ;
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
    }
     public void supprimerSotck(int id_re) {

        String req = "delete from reclamation where Id_re=?";
        try {
             PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, id_re);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    public List<Reclamation> getReclamations(){
        List<Reclamation> reclamations = new ArrayList<>();
       try {
            String req = "Select * from reclamation";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               Reclamation r = new Reclamation (rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4));
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reclamations ;
        
    }
    
     
    
}

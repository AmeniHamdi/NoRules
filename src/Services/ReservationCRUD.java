/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import entite.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Myconnection;

/**
 *
 * @author ibrahim
 */
public class ReservationCRUD {
    Connection cnx ; 
    public ReservationCRUD (){
    cnx = Myconnection.getMycnx().getConnection() ;   
        }
    
    public void ajouterReclamation (Reservation s){
        String req="insert into reservation (heureres,durres,dateres) values(?,?,?) " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1,s.getHeureres()) ; 
            pst.setString(2, s.getDurres()) ;
            pst.setString(3, s.getDateres()) ;
            pst.executeUpdate (); 
           System.out.println("Reservation Ajoutée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        
    }
    public void modifierReservation (Reservation s){
        String req="update reservation set heureres=?, durres=? ,dateres=? where Idres=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1,s.getHeureres()) ; 
            pst.setString(2, s.getDurres()) ;
            pst.setString(3, s.getDateres()) ;
            pst.setInt(4, s.getIdres()) ;
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
    }
     public void supprimerReservation(int idres) {

        String req = "delete from reservation where Idres=?";
        try {
             PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, idres);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
     public List<Reservation> getReservations(){
        List<Reservation> reservations = new ArrayList<>();
       try {
            String req = "Select * from reservation";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rp = st.executeQuery(req);
            while(rp.next()){
               Reservation s = new Reservation (rp.getInt(1), rp.getFloat(2), rp.getString(3),rp.getString(4));
                reservations.add(s);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reservations ;
        
    }
     
}

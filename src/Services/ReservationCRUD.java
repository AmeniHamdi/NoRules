/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import entite.Reservation;
import entite.User;
import infotourisme.Voiture;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    public void ajouterReservation (Reservation s){
        String req="insert into reservation (heureres,datedeb,datefin,dateres,id_user,id_voiture,etat) values(?,?,?,?,?,?,?) " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1,s.getHeureres()) ; 
            pst.setDate(2, s.getDutedes()) ;
            pst.setDate(3, s.getDatefin()) ;
            pst.setDate(4, s.getDateRes()) ;
            pst.setInt(5, s.getId_user()) ;
            pst.setInt(6, s.getId_voiture()) ;
            pst.setString(7, s.getEtat()) ;
          
            pst.executeUpdate (); 
           System.out.println("Reservation Ajoutée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        
    }
    
    
        public Voiture findVoitureId(int id)
    {
        Voiture e = new Voiture();
        
           
        String requete="select * from voiture where id="+id;
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {  
                
                           e.setIdVoiture(rs.getInt(1));
                           e.setModele(rs.getString(2));
                   
                
            }
           
               
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
   }

        
   public User findUserId(int id)
    {
        User e = new User();
        
           
        String requete="select * from user where id="+id;
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {  
                
                           e.setId(rs.getInt(1));
                           e.setNom(rs.getString(2));
                   
                
            }
           
               
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
   }
   
   
   
    public ObservableList<Reservation> getAllReservationByUser(int id) throws SQLDataException {

        
        List<Reservation> list =new ArrayList<Reservation>();
        int count =0;
        
        String requete="select * from reservation where id_user="+id;
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reservation e = new Reservation();
                e.setIdres(rs.getInt(1));
                e.setHeureres(rs.getInt(2));
                e.setId_user(rs.getInt(6));
                e.setId_voiture(rs.getInt(7));
                e.setDateRes(rs.getDate(5));
                e.setDatefin(rs.getDate(4));
                e.setDutedes(rs.getDate(3));
                e.setEtat(rs.getString(8));
                  
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
    
        public boolean deleteReservation(int idres) throws SQLDataException {
 
        try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM `reservation` WHERE `idres`="+idres;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
        
        
            public boolean ModifierReservation(Reservation e) throws SQLDataException {
        String query = "UPDATE `reservation` SET `heureres`=?,`datedeb`=?,`datefin`=?,`dateres`=? WHERE `idres`= ?";;
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
            
                st.setFloat(1,e.getHeureres());
                st.setDate(2,e.getDutedes());
                st.setDate(3,e.getDatefin());
                st.setDate(4,e.getDateRes());
                st.setInt(5,e.getIdres());
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

            public Reservation findReservationById(int id)
    {
        Reservation e = new Reservation();
        
           
        String requete="select * from reservation where idres="+id;
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {  
                
                e.setIdres(rs.getInt(1));
                e.setHeureres(rs.getInt(2));
                e.setId_user(rs.getInt(6));
                e.setId_voiture(rs.getInt(7));
                e.setDateRes(rs.getDate(5));
                e.setDatefin(rs.getDate(4));
                e.setDutedes(rs.getDate(3));
                e.setEtat(rs.getString(8));
                   
                
            }
           
               
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
   }
            
            
    public List<Reservation> getAllReservation(String etat) throws SQLDataException {

        
        List<Reservation> list =new ArrayList<Reservation>();
        int count =0;
        
        String requete="select * from reservation where etat='"+etat+"'";
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Reservation e = new Reservation();
                e.setIdres(rs.getInt(1));
                e.setHeureres(rs.getInt(2));
                e.setId_user(rs.getInt(6));
                e.setId_voiture(rs.getInt(7));
                e.setDateRes(rs.getDate(5));
                e.setDatefin(rs.getDate(4));
                e.setDutedes(rs.getDate(3));
                e.setEtat(rs.getString(8));
                   
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{

               return list;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
    
    
             public boolean AccpterReservation(int id)
    {
        int test=0;
        boolean check;
        try{
            PreparedStatement pst = cnx.prepareStatement("update reservation set etat='Accepter' where idres="+id); 
            test= pst.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (test == 0)
        {
            check=false;
        }else{
            check=true;
        }
        return check ;
    }

               
             public boolean RefuserReservation(int id)
    {
        int test=0;
        boolean check;
        try{
            PreparedStatement pst = cnx.prepareStatement("update reservation set etat='Refuser' where idres="+id); 
            test= pst.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ReservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (test == 0)
        {
            check=false;
        }else{
            check=true;
        }
        return check ;
    }


     
}

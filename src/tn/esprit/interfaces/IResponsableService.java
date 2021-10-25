/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import user.esprit.entities.Responsable;

/**
 *
 * @author MSI
 */
public class IResponsableService {
    
    
    
    
    Connection cnx;
    Statement ste ;

    @Override
    public void ajouter(Responsable r) {
        
    
        String req="insert into login_user (password) values(?) " ;
        try  { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, r.getId()) ;
            pst.setString(2,r.getPassword()) ; 
           
            pst.executeUpdate (); 
          
            System.out.println("Responsable Ajoutée avec succès");
            } 
        catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }


        
    @Override
    public List<Responsable> readAll() throws SQLException {
    List<Responsable> login_respo = new ArrayList<>();
     ResultSet result =  ste.executeQuery("select * from login_respo");
while(result.next()){
 login_respo.add(new  Responsable(result.getString("id"),result.getString("passwrod")));
        }
        
     return  login_respo;
    }


 @Override
 public void delete(int id ) throws SQLException {
    String req = "delete from login_user where Id=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
          
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
           } 
        catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public void update(Responsable t) throws SQLException {

    String req="update client set nom=?, prenom=?,email=?,password=?,num_passport=? , id=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
           
            pst.setString(1,t.getId()) ; 
             pst.setString(1,t.getPassword()) ; 
            pst.executeUpdate (); 
            System.out.println("Mise à jour effectuée avec succès");
            
             } 
        catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
    }
    
}

    
}

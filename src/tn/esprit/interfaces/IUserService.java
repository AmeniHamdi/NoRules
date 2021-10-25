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
import user.esprit.entities.User;

/**
 *
 * @author MSI
 */
public class IUserService implements Iservice<User> {
    
    Connection cnx;
    Statement ste ;

    @Override
    public void ajouter(User r) {
        
    
        String req="insert into login_user (nom,prenom,email,password,num_passport) values(?,?,?,?,?) " ;
        try  { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
         
            pst.setString(2,r.getNom()) ; 
            pst.setString(3, r.getPrenom()) ;
            pst.setString(4, r.getEmail()) ;
            pst.setString(5, r.getPassword()) ;
           
            pst.executeUpdate (); 
          
            System.out.println("clients Ajoutée avec succès");
            } 
        catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }


        
    @Override
    public List<User> readAll() throws SQLException {
    List<User> login_user = new ArrayList<>();
     ResultSet result =  ste.executeQuery("select * from login_user");
while(result.next()){
 login_user.add(new  User(result.getString("nom"), result.getString("prenom"), result.getString("password"), result.getString("email")));
        }
        
     return  login_user;
    }


 /*@Override
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
    }*/
    
    @Override
    public boolean delete (User t) throws SQLException{
        boolean deleted=false;
        String requeteInsert="delete user "+t.getNom()+"";
        ste.executeUpdate(requeteInsert);
        return deleted;
             
        
        
        
    }

    @Override
    public void update(User t) throws SQLException {

    String req="update client set nom=?, prenom=?,email=?,password=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
           
            pst.setString(1,t.getNom()) ; 
            pst.setString(2, t.getPrenom()) ;
            pst.setString(3, t.getEmail()) ;
            pst.setString(4, t.getPassword()) ;
          
            pst.executeUpdate (); 
            System.out.println("Mise à jour effectuée avec succès");
            
             } 
        catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
    }
    
}

  //*@Override
   // public void delete(int id) throws SQLException {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }


}

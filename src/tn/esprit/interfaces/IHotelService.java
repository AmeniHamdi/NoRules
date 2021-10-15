/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.interfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import tn.esprit.entities.Hotel;
import tn.esprit.util.MyConnection;




/**
 *
 * @author lenovo
 */
public class IHotelService {
    private Connection cnx;

    public IHotelService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    public void ajouterHotel (Hotel h){
        try {
            String req = "INSERT INTO hotel (id,nom,nombrechambre,categorie)values ('"+h.getId()+"','"+h.getNom()+"','"+h.getNombrechambre()+"','"+h.getCategorie()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Hotel added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           
        }
   public void ajouterHotel1 (Hotel h){
        try {
            String req = "INSERT INTO hotel (id,nom,nombrechambre,categorie)values (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
             pst.setString(1, h.getId());
             pst.setString(2, h.getNom());
             pst.setString(3, h.getNombrechambre());
                 pst.setString(4 , h.getCategorie());
            pst.executeUpdate();
            
            System.out.println("Hotel added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
   }
        
   }
    

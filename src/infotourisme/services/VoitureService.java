/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.services;
import infotourisme.IService;
import infotourisme.entities.Voiture;

import infotourisme.InfoTourismeBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ameni Hamdi
 */
 public class VoitureService implements IService<Voiture> {

    Connection cnx;
    Statement ste;

    public VoitureService() throws SQLException {
        cnx = InfoTourismeBD.getInstance().getConnection();
        ste = cnx.createStatement();
        
    }

    @Override
    
    public void ajouter(Voiture v) throws SQLException {

        String requeteInsert = "INSERT INTO `voiture` (`idVoiture`, `Matricule`, `Modele`, `Prix`,`dateReservation`,`nbr_jours`) VALUES ('" + v.getIdVoiture()+ "', '" + v.getMatricule()+ "', '" + v.getModele()+ "', '" + v.getPrix()+ "', '" + v.getDateReservation()+ "','" + v.getNbr_jours()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
  @Override
    public boolean delete(Voiture v) throws SQLException {
        boolean deleted =false ;
    String requeteInsert = "delete from voiture where idVoiture='" + v.getIdVoiture() + "'";
            ste.executeUpdate(requeteInsert);
            return deleted ;
            
    }
    

    @Override
    public void update(Voiture v) throws SQLException {
 
        String req="update voiture set matricule=?, Modele=? ,Prix=? , dateReservation=? , nbr_jours=? where idVoiture=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1,v.getMatricule()) ; 
            pst.setString(2, v.getModele()) ;
            pst.setFloat(3, v.getPrix()) ;
            pst.setString(4, v.getDateReservation()) ;
            pst.setInt(5, v.getNbr_jours()) ;
            pst.setInt(6, v.getIdVoiture()) ;
            pst.executeUpdate (); 
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
     
    
    }
    
    

    @Override
    public List<Voiture> readAll() throws SQLException {
        List<Voiture> voitures = new ArrayList<>();
        ResultSet result =  ste.executeQuery("select * from voiture");
        while(result.next()){
            voitures.add(new Voiture(result.getInt(1), result.getString("Matricule"), result.getString("Modele"), result.getFloat("Prix"), result.getString("dateReservation"), result.getInt("nbr_jours")));
        }
        
        return voitures;
    }


    



}

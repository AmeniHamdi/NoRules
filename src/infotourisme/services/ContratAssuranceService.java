/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.services;

import infotourisme.IContractService;
import infotourisme.InfoTourismeBD;
import infotourisme.entities.ContratAssurance;
import infotourisme.entities.Voiture;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ameni Hamdi
 */
public class ContratAssuranceService implements IContractService<ContratAssurance,Voiture>{
 
       Connection cnx;
    Statement ste;
    public ContratAssuranceService() throws SQLException {
         cnx = InfoTourismeBD.getInstance().getConnection();
        ste = cnx.createStatement();
        
    }
    
    @Override
    public  boolean createContrat(ContratAssurance contrat,Voiture v){

        String req = "INSERT INTO `contrat_assurance` (`dateDebut`, `dateFin`, `matricule`) "
                + "VALUES ( ?, ?,?) ";
        try{
         PreparedStatement ps= (PreparedStatement) cnx.prepareStatement(req);
            ps.setDate(1, contrat.getDateDebut());
            ps.setDate(2, contrat.getDateFin());
            ps.setString(3, v.getMatricule());
           // ps.setString(4, UserService.authUser.getId());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
            
        }
        
    }

   


  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.services;
import infotourisme.entities.TransportCommun;

import infotourisme.IService;
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
public class TransportCommunService implements IService<TransportCommun> {

    Connection cnx;
    Statement ste;

    public TransportCommunService () throws SQLException {
        cnx = InfoTourismeBD.getInstance().getConnection();
        ste = cnx.createStatement();
        
    }

    @Override
    
    public void ajouter(TransportCommun t) throws SQLException {
        String requeteInsert = "INSERT INTO `transportCommuns` (`idTransportCommun`, `PrixBillet`, `Type`, `Capacité`) VALUES ('" + t.getIdTransportCommun()+ "', '" + t.getPrixBillet()+ "', '" + t.getType()+ "', '" + t.getCapacité()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
    
    
     @Override
    public List<TransportCommun> readAll() throws SQLException {
        List<TransportCommun> transportCommuns = new ArrayList<>();
        ResultSet result =  ste.executeQuery("select * from transportCommuns ");
        while(result.next()){
            transportCommuns.add(new TransportCommun(result.getInt(1), result.getInt("PrixBillet"), result.getString("Type"), result.getInt("Capacité")));
        }
        
        return transportCommuns;
    }

    @Override
    public boolean delete(TransportCommun t) throws SQLException {
        
                boolean deleted =false ;
            String requeteInsert = "delete from transportCommuns where idTransportCommun='" + t.getIdTransportCommun() + "'";
            ste.executeUpdate(requeteInsert);
            return deleted ;
            
    }

    @Override
    public void update(TransportCommun t) throws SQLException {
           String req="update transportCommuns set PrixBillet=?, Type=? ,Capacité=?  " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1,t.getPrixBillet()) ; 
            pst.setString(2, t.getType()) ;
            pst.setInt(3, t.getCapacité()) ;
            pst.setInt(4, t.getIdTransportCommun()) ;
            pst.executeUpdate (); 
            System.out.println("Mise à jour  sur Moyens de Transport Commun  effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    
}
    
    
    


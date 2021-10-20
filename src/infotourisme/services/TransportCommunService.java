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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TransportCommun v) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
    
    
    


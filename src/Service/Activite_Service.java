/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Alert.AlertDialog;
import IService.IService;
import entites.Activite;
import Utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Chokr
 */
public class Activite_Service implements IService<Activite> {

    private Connection c = MyConnexion.getInsCon().getcnx();

    @Override
    public void Ajouter(Activite t) throws SQLException {
           try {
               System.out.println(t);
            String requete = "INSERT INTO `activité`(`destination`, `activité`, `date_depart`, `date_arrivee`) VALUES (?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
   pst.setString(1, t.getDestination());
            pst.setString(2, t.getActivité());
            pst.setDate(3, t.getDate_depart());
             pst.setDate(4, t.getDate_arrivee());
            pst.execute();
               AlertDialog.showNotification("Ajout", "Ajout", AlertDialog.image_checked);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(int t) throws SQLException {
     
         String requete = "DELETE FROM `activité` WHERE `id_ac`=" + String.valueOf(t) + "";
        try {

            PreparedStatement pst = c.prepareStatement(requete);
            pst.execute(requete);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
  public ObservableList<Activite> serach(String cas) throws SQLException {
        ObservableList<Activite> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `activité` a where   ( a.destination LIKE '%" + cas + "%'or  a.activité LIKE '%" + cas + "%' or  a.date_depart LIKE '%" +   cas + "%'or  a.date_arrivee LIKE '%" + cas + "%' )";
       try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                   list.add(new Activite(rs.getString("destination"),rs.getString("activité"), rs.getDate("date_depart"), rs.getDate("date_arrivee")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    @Override
    public void Modifier(Activite t, int id) throws SQLException {
           PreparedStatement ps;
        String query = "UPDATE `activité` SET `destination`=?,`activité`=?,`date_depart`=?,`date_arrivee`=? WHERE id_ac=?";

        
        ps = c.prepareStatement(query);
   ps.setString(1, t.getDestination());
            ps.setString(2, t.getActivité());
            ps.setDate(3, t.getDate_depart());
            ps.setDate(4, t.getDate_arrivee());
        ps.setInt(5, id);
        ps.execute();
    }

    @Override
    public ObservableList<Activite> Affichertout() throws SQLException {
             ObservableList<Activite> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `activité` ";
       try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                   list.add(new Activite(rs.getInt("id_ac"),rs.getString("destination"),rs.getString("activité"), rs.getDate("date_depart"), rs.getDate("date_arrivee")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
}

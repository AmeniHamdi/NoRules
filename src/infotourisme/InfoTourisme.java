/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;

import java.sql.SQLException;

/**
 *
 * @author Ameni Hamdi
 */
public class InfoTourisme {

   
    public static void main(String[] args)throws SQLException {
        
         Voiture v1 = new Voiture("122Tunis6287", "porshe", 1300,"01/05/2022", 5);
        

         VoitureService vs = new VoitureService();
          //vs.ajouter(v1);
          //v1.setIdVoiture(0);
       // vs.delete(v1);
         v1.setIdVoiture(0);
         v1.setMatricule("157tun1993");
         v1.setModele("Mercedes");
         v1.setPrix(3500);
         v1.setDateReservation("15/10/2021");
         v1.setNbr_jours(5);
         vs.update(v1);
         
         //System.out.println(vs.readAll());


       
        
    }
    
}

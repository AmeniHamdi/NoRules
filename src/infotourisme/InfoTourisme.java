/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;
import infotourisme.entities.Chauffeur;
import infotourisme.entities.Voiture;
import infotourisme.entities.TransportCommun;
import infotourisme.services.ChauffeurService;
import infotourisme.services.TransportCommunService;
import infotourisme.services.VoitureService;



import java.sql.SQLException;
import java.time.Clock;

/**
 *
 * @author Ameni Hamdi
 */
public class InfoTourisme {

    public static void main(String[] args)throws SQLException {
        
         Voiture v1 = new Voiture("122Tunis6287", "porshe", 1300,"01/05/2022", 5);
         Voiture v2 = new Voiture("122Tunis5842", "Wallys", 900,"12/05/2022", 25);
         Voiture v3 = new Voiture("122Tunis6000", "Megan", 900,"12/05/2023", 30);
         Voiture v4 = new Voiture("122Tunis6052", "Renault", 530,"06/05/2023", 28);

         

         

        
         TransportCommun t1=new TransportCommun(80,"train",30);
         TransportCommun t2=new TransportCommun(90,"Bus",25);
         
         VoitureService vs = new VoitureService();
         TransportCommunService ts = new TransportCommunService();
         ChauffeurService cs= new ChauffeurService();
         
         

         //System.out.println("Les tests Pour La Classe Voitures ");
         //vs.ajouter(v4);
        //v1.setIdVoiture(1);
        //vs.delete(v1);
         //v1.setIdVoiture(0);
        // v1.setMatricule("157tun1993");
         //v1.setModele("Mercedes");
         //v1.setPrix(3500);
        // v1.setDateReservation("15/10/2021");
        // v1.setNbr_jours(5);
         //vs.update(v1);
         
       // System.out.println("Les tests Pour La Classe Transport Commun ");
        
        //System.out.println("Ajout ");

         //vs.ajouter(v3);
         //ts.ajouter(t1);
        //vs.ajouter(v2);
               // System.out.println("Ajout Transport ");

        //ts.ajouter(t2);
         //ts.ajouter(t1);
         System.out.println("Les tests Pour La Classe Chauffeur ");
         
        System.out.println(ChauffeurService.genererId("ameni","hamdi" ,  2021));
         
        
         vs.readAll();


       
        
    }
    
}

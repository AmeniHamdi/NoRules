/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;

import infotourisme.entities.ContratAssurance;
import infotourisme.entities.Voiture;
import infotourisme.entities.TransportCommun;
import infotourisme.services.ContratAssuranceService;
import infotourisme.services.TransportCommunService;
import infotourisme.services.VoitureService;
import java.io.IOException;
import java.sql.Date;




import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ameni Hamdi
 */
public class InfoTourisme {
    
   
    
    public static void main(String[] args)throws Exception {
        
        
        java.util.Date utilDate = new SimpleDateFormat("dd MMM yyyy").parse("01 Novembre 2012");
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      
       

                
         Voiture v1 = new Voiture("122Tunis6287", "porshe", 1300,sqlDate, 5);
       //  Voiture v2 = new Voiture("122Tunis5842", "Wallys", 900,date2, 25);
       //  Voiture v3 = new Voiture("122Tunis6000", "Megan", 900,date3, 30);
       //s  Voiture v4 = new Voiture("122Tunis6052", "Renault", 530,date4, 28);

         

         

        
         TransportCommun t1=new TransportCommun(80,"train",30);
         TransportCommun t2=new TransportCommun(90,"Bus",25);
         TransportCommun t3=new TransportCommun(188,"MiniBus",10);

         
         VoitureService vs = new VoitureService();
         TransportCommunService ts = new TransportCommunService();
         
         

         //System.out.println("Les tests Pour La Classe Voitures ");
         //vs.ajouter(v4);
        //t1.setIdTransportCommun(9);
        //ts.delete(t1);
        /* v1.setIdVoiture(3);
         v1.setMatricule("157tun1993");
         v1.setModele("PASSAT");
         v1.setPrix(300);
         v1.setDateReservation(date1);
         v1.setNbr_jours(10);
         vs.update(v1);*/
         
       // System.out.println("Les tests Pour La Classe Transport Commun ");
        
        //System.out.println("Ajout ");

        // vs.ajouter(v1);
         //ts.ajouter(t1);
        //vs.ajouter(v2);
               // System.out.println("Ajout Transport ");

        //ts.ajouter(t3);
         //ts.ajouter(t1);
      //   System.out.println("Les tests Pour La Classe Chauffeur ");
         
       // System.out.println(ChauffeurService.genererId("ines","hamdi" ,  2030));
         
       
        vs.readAll();


       
        
    }
   
}
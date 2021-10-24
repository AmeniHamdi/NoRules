/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;

import infotourisme.entities.ContratAssurance;
import infotourisme.entities.TransportCommun;
import infotourisme.entities.Voiture;
import infotourisme.services.ContratAssuranceService;
import infotourisme.services.TransportCommunService;
import infotourisme.services.VoitureService;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ameni Hamdi
 */
public class contract {
    
       
    public static void main(String[] args)throws Exception {
        
      ContratAssuranceService contratService= new ContratAssuranceService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
       Date dateDebut = dateFormat.parse("01-01-2020 20:20:55.00");
       Date dateFin = dateFormat.parse("01-02-2020 20:20:55.00");
       
      java.util.Date utilDatedebut = new SimpleDateFormat("dd MMM yyyy").parse("01 Novembre 2012");
        java.sql.Date sqlDatedebut = new java.sql.Date(utilDatedebut.getTime());
        java.util.Date utilDateFin = new SimpleDateFormat("dd MMM yyyy").parse("01 Novembre 2012");
        java.sql.Date sqlDateFin = new java.sql.Date(utilDateFin.getTime());
        
       Timestamp timestampDebut = new java.sql.Timestamp(dateDebut.getTime());
       Timestamp timestampFin = new java.sql.Timestamp(dateFin.getTime());
        System.out.println(timestampDebut);
      // String datedebut = "01/01/2021";
      // String datefin = "06/01/2021";

        ContratAssurance contart = new ContratAssurance(sqlDatedebut,sqlDateFin);
        Voiture v = new Voiture();
        v.setMatricule("Fiat punto");
        boolean result = contratService.createContrat(contart,v);
        if(result){
            // show success notificatiuon
        }else{
            // show error notification
        }


       
        
    }
 
    
}

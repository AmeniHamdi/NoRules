/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam;

import tn.esprit.reclamation.entities.Reclamation;
import java.sql.Connection;
import java.sql.Timestamp;

import tn.esprit.reclamation.utils.Myconnection;
import tn.esprit.reclamation.services.ReclamationCRUD ; 

 
public class Reclam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Myconnection.getMycnx() ; 
        
        ReclamationCRUD rec = new ReclamationCRUD() ; 
        Reclamation reclamation = new Reclamation ("ehsen",13,"zzzz"); 
        Reclamation reclamation1 = new Reclamation (8,"administrativefacile",2,"description"); 
      //rec.modifierReclamation(reclamation1);
    //rec.ajouterReclamation(reclamation);
          rec.supprimerSotck(8);
        System.out.println(rec.getReclamations()); 
        
//    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
 
}

 
         
    }
    


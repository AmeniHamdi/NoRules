/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.entities;

import java.sql.Date;



/**
 *
 * @author Ameni Hamdi
 */
public class Voiture {
 
    private String Matricule;
    private String Modele;
    private int Prix;
    private Date dateReservation;
    private int nbr_jours ;
    
    
    
     public Voiture() {
    }
   
      public Voiture( String Matricule, String Modele, int Prix , Date dateReservation ,int nbr_jours) {
   
        this.Matricule = Matricule;
        this.Modele = Modele;
        this.Prix = Prix;
        this.dateReservation = dateReservation;
        this.nbr_jours = nbr_jours;
    }
      


    public Voiture(String Matricule,String Modele, int Prix) {
       this.Matricule = Matricule;
        this.Modele = Modele;
        this.Prix = Prix;
       
    }
     



    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String Modele) {
        this.Modele = Modele;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        this.Prix = prix;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNbr_jours() {
        return nbr_jours;
    }

    public void setNbr_jours(int nbr_jours) {
        this.nbr_jours = nbr_jours;
    }

    @Override
    public String toString() {
        return "Voiture{" + " Matricule=" + Matricule + ", Modele=" + Modele + ", prix=" + Prix + ", dateReservation=" + dateReservation + ", nbr_jours=" + nbr_jours + '}';
    }

    
}

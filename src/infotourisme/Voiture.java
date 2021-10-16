/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;


/**
 *
 * @author Ameni Hamdi
 */
public class Voiture {
    private int idVoiture;
    private String Matricule;
    private String Modele;
    private float Prix;
    private String dateReservation;
    private int nbr_jours ;
    
    
    
     public Voiture() {
    }
   
      public Voiture(int idVoiture, String Matricule, String Modele, float Prix , String dateReservation ,int nbr_jours) {
          
        this.idVoiture = idVoiture;
        this.Matricule = Matricule;
        this.Modele = Modele;
        this.Prix = Prix;
        this.dateReservation = dateReservation;
        this.nbr_jours = nbr_jours;
    }
      
     public Voiture( String Matricule, String Modele, float Prix ,String dateReservation ,int nbr_jours) {
      
        this.Matricule = Matricule;
        this.Modele = Modele;
        this.Prix = Prix;
         this.dateReservation = dateReservation;
        this.nbr_jours = nbr_jours;
    } 

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
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

    public void setPrix(float prix) {
        this.Prix = prix;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
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
        return "Voiture{" + "idVoiture=" + idVoiture + ", Matricule=" + Matricule + ", Modele=" + Modele + ", prix=" + Prix + ", dateReservation=" + dateReservation + ", nbr_jours=" + nbr_jours + '}';
    }

    
   
     
     
}

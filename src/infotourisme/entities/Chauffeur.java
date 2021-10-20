/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.entities;

import java.util.ArrayList;

/**
 *
 * @author Ameni Hamdi
 */
public class Chauffeur {
    
        private  String id ;
        private  String nom;
        private  String prenom;
        private  int anneeEmbauche;
	private  ArrayList<Voiture> listVoitures;

    public Chauffeur() {
    }

    public Chauffeur(String id, String nom,String prenom, int anneeEmbauche, ArrayList<Voiture> listVoitures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.anneeEmbauche = anneeEmbauche;
        this.listVoitures = listVoitures;
    }

     public Chauffeur( String nom, ArrayList<Voiture> listVoitures) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeEmbauche = anneeEmbauche;
        this.listVoitures = listVoitures;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeEmbauche() {
        return anneeEmbauche;
    }

    public void setAnneeEmbauche(int anneeEmbauche) {
        this.anneeEmbauche = anneeEmbauche;
    }
    
    
    public ArrayList<Voiture> getListVoitures() {
        return listVoitures;
    }

    public void setListVoiture(ArrayList<Voiture> listVoitures) {
        this.listVoitures = listVoitures;
    }

    

    @Override
    public String toString() {
        return "Chauffeur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", anneeEmbauche=" + anneeEmbauche + ", listVoitures=" + listVoitures + '}';
    }
    
    
    
    
   

}

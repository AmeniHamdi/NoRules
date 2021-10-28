/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author lenovo
 */
public class hotel {
    private int id;
    private String nom,categorie,lieu;
    private int nombrechambre;

    public hotel(String nom, String categorie, String lieu, int nombrechambre) {
        this.nom = nom;
        this.categorie = categorie;
        this.lieu = lieu;
        this.nombrechambre = nombrechambre;
    }

    public hotel(int id, String nom, String categorie, String lieu, int nombrechambre) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.lieu = lieu;
        this.nombrechambre = nombrechambre;
    }

    public hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNombrechambre() {
        return nombrechambre;
    }

    public void setNombrechambre(int nombrechambre) {
        this.nombrechambre = nombrechambre;
    } 

    @Override
    public String toString() {
        return "hotel{" + "id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", lieu=" + lieu + ", nombrechambre=" + nombrechambre + '}';
    }
    
}

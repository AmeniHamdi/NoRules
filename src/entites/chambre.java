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
public class chambre {
   
     	private int id,nb_lits,numero,etage,id_h;
        private float prix;

    public chambre(int nb_lits, int numero, int etage, int id_h, float prix) {
        this.nb_lits = nb_lits;
        this.numero = numero;
        this.etage = etage;
        this.id_h = id_h;
        this.prix = prix;
    }

    public chambre(int id, int nb_lits, int numero, int etage, int id_h, float prix) {
        this.id = id;
        this.nb_lits = nb_lits;
        this.numero = numero;
        this.etage = etage;
        this.id_h = id_h;
        this.prix = prix;
    }

    public chambre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_lits() {
        return nb_lits;
    }

    public void setNb_lits(int nb_lits) {
        this.nb_lits = nb_lits;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getId_h() {
        return id_h;
    }

    public void setId_h(int id_h) {
        this.id_h = id_h;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
        

		 	 
}

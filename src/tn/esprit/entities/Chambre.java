/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author lenovo
 */
public class Chambre {
    private int Nb_lits;
    private float Prix;
    private int Numero;
    private int etage;

    public Chambre() {
    }

    public Chambre(int Nb_lits, int Prix, int Numero) {
        this.Nb_lits = Nb_lits;
        this.Prix = Prix;
        this.Numero = Numero;
    }

    public int getNb_lits() {
        return Nb_lits;
    }

    public void setNb_lits(int Nb_lits) {
        this.Nb_lits = Nb_lits;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(float Prix) {
        this.Prix = Prix;
    }

    

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
    

    @Override
    public String toString() {
        return "Chambre{" + "Nb_lits=" + Nb_lits + ", Prix=" + Prix + ", Numero=" + Numero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.Numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chambre other = (Chambre) obj;
        if (this.Numero != other.Numero) {
            return false;
        }
        return true;
    }
    
    
}

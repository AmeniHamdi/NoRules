/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author Chokr
 */
public class Activites {
    private int id_ac ;
    private String destination ;
    private String duree_reservation ;
    private String date_depart ;
    private String date_arrivee ;

    public Activites() {
    }

    public Activites(int id_ac, String destination, String duree_reservation, String date_depart, String date_arrivee) {
        this.id_ac = id_ac;
        this.destination = destination;
        this.duree_reservation = duree_reservation;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
    }

    public Activites(String destination, String duree_reservation, String date_depart, String date_arrivee) {
        this.destination = destination;
        this.duree_reservation = duree_reservation;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
    }

    public int getId_ac() {
        return id_ac;
    }

    public void setId_ac(int id_ac) {
        this.id_ac = id_ac;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuree_reservation() {
        return duree_reservation;
    }

    public void setDuree_reservation(String duree_reservation) {
        this.duree_reservation = duree_reservation;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    @Override
    public String toString() {
        return "activites{" + "id_ac=" + id_ac + ", destination=" + destination + ", duree_reservation=" + duree_reservation + ", date_depart=" + date_depart + ", date_arrivee=" + date_arrivee + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id_ac;
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
        final Activites other = (Activites) obj;
        if (this.id_ac != other.id_ac) {
            return false;
        }
        return true;
    }

  
    
    
}

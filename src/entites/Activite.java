/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.sql.Date;
/**
 *
 * @author Chokr
 */
public class Activite {
    private int id_ac;
    private String destination,activité;
        private Date date_depart , date_arrivee ;       

    @Override
    public String toString() {
        return "Activite{" + "id_ac=" + id_ac + ", destination=" + destination + ", activit\u00e9=" + activité + ", date_depart=" + date_depart + ", date_arrivee=" + date_arrivee + '}';
    }

    public Activite(String destination, String activité, Date date_depart, Date date_arrivee) {
        this.destination = destination;
        this.activité = activité;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
    }

    public Activite(int id_ac, String destination, String activité, Date date_depart, Date date_arrivee) {
        this.id_ac = id_ac;
        this.destination = destination;
        this.activité = activité;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
    }

    public Activite() {
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

    public String getActivité() {
        return activité;
    }

    public void setActivité(String activité) {
        this.activité = activité;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }
    
 

}

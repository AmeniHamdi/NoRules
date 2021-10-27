/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

//import java.util.Date;

import java.sql.Date;


/**
 *
 * @author ibrahim
 */
public class Reservation {
    private int idres;
    private float heureres;
    private Date dutedes;
    private  Date datefin ;
    private Date dateRes ;
    private int id_user ;
    private int id_voiture ;
    
    private String etat ;
    
    public Reservation (){
    }

    public int getIdres() {
        return idres;
    }

    public void setIdres(int idres) {
        this.idres = idres;
    }

    public float getHeureres() {
        return heureres;
    }

    public void setHeureres(float heureres) {
        this.heureres = heureres;
    }

    public Date getDutedes() {
        return dutedes;
    }

    public void setDutedes(Date dutedes) {
        this.dutedes = dutedes;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idres=" + idres + ", heureres=" + heureres + ", dutedes=" + dutedes + ", datefin=" + datefin + ", dateRes=" + dateRes + ", id_user=" + id_user + ", id_voiture=" + id_voiture + ", etat=" + etat + '}';
    }



 
    
}

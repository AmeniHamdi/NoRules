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
public class TransportCommun {
    
  
    private  String heureDisponibilite ;
    private  String lieu ;
    private int PrixBillet;
    private String Type;
    private int Capacité;

    public TransportCommun() {
    }

    public TransportCommun(String heureDisponibilite,String lieu , int PrixBillet, String Type, int Capacité) {
   
        this.heureDisponibilite = heureDisponibilite;
        this.lieu = lieu;
         this.PrixBillet = PrixBillet;
        this.Type = Type;
        this.Capacité = Capacité;
    }

  

   

    public String getHeureDisponibilite() {
        return heureDisponibilite;
    }

    public void setHeureDisponibilite(String heureDisponibilite) {
        this.heureDisponibilite = heureDisponibilite;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

  
    

    public int getPrixBillet() {
        return PrixBillet;
    }

    public void setPrixBillet(int PrixBillet) {
        this.PrixBillet = PrixBillet;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getCapacité() {
        return Capacité;
    }

    public void setCapacité(int Capacité) {
        this.Capacité = Capacité;
    }

    @Override
    public String toString() {
        return "TransportCommun{" + "heureDisponibilite=" + heureDisponibilite + ", lieu=" + lieu + ", PrixBillet=" + PrixBillet + ", Type=" + Type + ", Capacit\u00e9=" + Capacité + '}';
    }


   

  
    
}

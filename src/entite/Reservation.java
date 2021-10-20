/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

//import java.util.Date;

/**
 *
 * @author ibrahim
 */
public class Reservation {
    private int idres;
    private float heureres;
    private String durres;
    private  String dateres ;    
    public Reservation (){
    }

    public Reservation(float heureres, String durres, String dateres) {
        this.heureres = heureres;
        this.durres = durres;
        this.dateres = dateres;
    }
    
    public Reservation (int idres,float heureres,String durres,String dateres){
    this.idres=idres;
    this.heureres=heureres;
    this.durres=durres;
    this.dateres=dateres;
    }
    public int getIdres () {
    return idres ;
    }
    public void setIdres (int id){
    this.idres=id ;
    }
    public float getHeureres(){
    return heureres;
    }
    public void setHeureres(float heureres){
    this.heureres=heureres;
    }
    public String getDurres(){
    return durres;
    }
    public void setDurres(String durres){
        this.durres=durres;
    }
    public String getDateres(){
    return dateres;
    }
    public void setDateres(String dateres){
    this.dateres=dateres ;}

    @Override
    public String toString() {
        return "Reservation{" + "idres=" + idres + ", heureres=" + heureres + ", durres=" + durres + ", dateres=" + dateres + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idres;
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
        final Reservation other = (Reservation) obj;
        if (this.idres != other.idres) {
            return false;
        }
        return true;
    }
    
    
}

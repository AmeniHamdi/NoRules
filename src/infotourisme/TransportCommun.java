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
public class TransportCommun {
    private int idTransportCommun;
    private Float prixBillet;
    private int capacité;
    private String Type ;

    public TransportCommun() {
    }

    public TransportCommun(int idTransportCommun, Float prixBillet, int capacité, String Type) {
        this.idTransportCommun = idTransportCommun;
        this.prixBillet = prixBillet;
        this.capacité = capacité;
        this.Type = Type;
    }

    public TransportCommun(Float prixBillet, int capacité, String Type) {
        this.prixBillet = prixBillet;
        this.capacité = capacité;
        this.Type = Type;
    }

    public int getIdTransportCommun() {
        return idTransportCommun;
    }

    public void setIdTransportCommun(int idTransportCommun) {
        this.idTransportCommun = idTransportCommun;
    }

    public Float getPrixBillet() {
        return prixBillet;
    }

    public void setPrixBillet(Float prixBillet) {
        this.prixBillet = prixBillet;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "TransportCommun{" + "idTransportCommun=" + idTransportCommun + ", prixBillet=" + prixBillet + ", capacit\u00e9=" + capacité + ", Type=" + Type + '}';
    }
    
    
    
    
    
    
}

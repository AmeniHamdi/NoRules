/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.entities;

/**
 *
 * @author Ameni Hamdi
 */
public class TransportCommun {
    
    private int idTransportCommun;
    private int PrixBillet;
    private String Type;
    private int Capacité;

    public TransportCommun() {
    }

    public TransportCommun(int idTransportCommun, int PrixBillet, String Type, int Capacité) {
        this.idTransportCommun = idTransportCommun;
        this.PrixBillet = PrixBillet;
        this.Type = Type;
        this.Capacité = Capacité;
    }

    public TransportCommun(int PrixBillet, String Type, int Capacité) {
        this.PrixBillet = PrixBillet;
        this.Type = Type;
        this.Capacité = Capacité;
    }

    public int getIdTransportCommun() {
        return idTransportCommun;
    }

    public void setIdTransportCommun(int idTransportCommun) {
        this.idTransportCommun = idTransportCommun;
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
        return "TransportCommun{" + "idTransportCommun=" + idTransportCommun + ", PrixBillet=" + PrixBillet + ", Type=" + Type + ", Capacit\u00e9=" + Capacité + '}';
    }
    
}

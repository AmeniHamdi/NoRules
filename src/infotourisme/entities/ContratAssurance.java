/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Ameni Hamdi
 */
public class ContratAssurance {
    Date dateDebut ;
    Date dateFin;
    String createdBy;
    String assignedTo;

    public ContratAssurance(Date dateDebut, Date dateFin, String createdBy, String assignedTo) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    public ContratAssurance(Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "ContratAssurance{" + "dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", createdBy=" + createdBy + ", assignedTo=" + assignedTo + '}';
    }
    
    
}

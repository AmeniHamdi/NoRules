/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.entities;

/**
 *
 * @author achra
 */
public class Reclamation {
   private int  id_re ; 
   private String type ;  
   private int id_client ; 
   private String  description ; 

    public Reclamation() {
    }

    public Reclamation(String type, int id_client, String description) {
        this.type = type;
        this.id_client = id_client;
        this.description = description;
    }

    public Reclamation(int id_re, String type, int user_id, String description) {
        this.id_re = id_re;
        this.type = type;
        this.id_client = user_id;
        this.description = description;
    }

    public int getId_re() {
        return id_re;
    }

    public String getType() {
        return type;
    }

    public int getId_client() {
        return id_client;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id_re) {
        this.id_re = id_re;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public String toString() {
        return "Reclamation{" + "id_re=" + id_re + ", type=" + type + ", id_client=" + id_client + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_re;
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
        final Reclamation other = (Reclamation) obj;
        if (this.id_re != other.id_re) {
            return false;
        }
        return true;
    }
   
   
}

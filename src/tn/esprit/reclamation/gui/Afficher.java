/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Afficher {
private final StringProperty id;
private final StringProperty type;
private final StringProperty id_client;
private final StringProperty description;

public Afficher(){
id = new SimpleStringProperty(this, "id");
type= new SimpleStringProperty(this, "type");
id_client= new SimpleStringProperty(this, "id_client");
description= new SimpleStringProperty(this, "description");

}

public StringProperty idProperty() { return id ;} ;
public String getId() {return id.get(); }
public void setId(String newId) {id.set(newId); };

public StringProperty typeProperty() { return type; } ;
public String getType() {return type.get(); } ;
public void setType(String newType ){type.set(newType); };

public StringProperty id_clientProperty() { return id_client; } 
public String getId_client() {return id_client.get(); }
public void setId_client(String newId_client) {id_client.set(newId_client); }

public StringProperty descriptionProperty() { return description; } 
public String getDescription() {return description.get(); }
public void setDescription(String newDescription) {description.set(newDescription); }

@Override 
public String toString (){
return String.format("%s[id=%s, type=%s]",
getId(), getType(),getId_client(), getDescription());
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.esprit.entities;

/**
 *
 * @author MSI
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
  
   

    public User() {
    }

    public User(String nom, String prenom, String email, String password ) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
       
        
    }

    
    

  

    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + '}';
    }

  

    
    
    
    
    
    
    
}

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.interfaces;

import java.sql.SQLException;
import user.esprit.entities.User;

/**
 *
 * @author MSI
 */
public class Test {
    
    public static void main(String[] args) throws SQLException {
    
    
        IUserService s1= new IUserService();

    User u1= new User( "Bjaoui", "Cyrine", "cyrineBjaoui@esprit.tn", "azerty");
    
    
    s1.ajouter(u1);
    s1.readAll();
    
    
    
    
    
    }
}

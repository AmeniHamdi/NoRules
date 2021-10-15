/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    private String url= "jdbc:mysql://localhost:3306/ac" ; 
    private String user= "root" ; 
    private String pwd= "" ;
    private Connection cnx;

    private static MyConnection myCnx;
     
    private MyConnection() {
         try {
            cnx = (Connection) DriverManager.getConnection(url, user, pwd) ; 
            System.out.println("Connected ! ");  
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());        
           }
    }

    public Connection getConnection() {
        return cnx;
    }
    
    public static MyConnection getMyCnx(){
    if(myCnx == null){
       myCnx = new MyConnection();
    }
    return myCnx; 
    }
    
    
    
    
}

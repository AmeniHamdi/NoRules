/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.reclamation.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author achra
 */
public class Myconnection {
    private String url= "jdbc:mysql://localhost:3306/re" ; 
    private String user= "root" ; 
    private String pwd= "" ;
    Connection cnx;
    
    public static Myconnection mycnx ; 
    private Myconnection(){
        
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, pwd) ; 
            System.out.println("Connected ! ");  
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());        
           }
        }
    
    public Connection getConnection(){
    return ( cnx);}
    
    
    public static Myconnection getMycnx(){
    if(mycnx==null){
     mycnx= new Myconnection();   }
    return(mycnx) ; 
    
    }
    
    
}

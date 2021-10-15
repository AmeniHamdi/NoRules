/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author lenovo
 */
public class MyConnection {
    private String url="jdbc:mysql://localhost:3306/hotel";
    private String usr="root";
    private String pwd="";
    private Connection cnx;
    private static MyConnection myCnx;
    

    private MyConnection() {
        try {
            cnx=(Connection) DriverManager.getConnection(url, usr, pwd);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    public Connection getConnection() {
        return cnx;
        
    }
    public static MyConnection getMyCnx(){
        if(myCnx==null){
            myCnx = new MyConnection();
            
        }
        return myCnx;
    }

    
    }
    
    
  

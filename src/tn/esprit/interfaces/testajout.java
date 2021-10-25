/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.interfaces;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MSI
 */
public class testajout extends Application{
  
    public void start(Stage primaryStage) throws IOException {
        
       
        Parent root=FXMLLoader.load(getClass().getResource("../Pojet/Login/FXMLloginController.fxml"));
      
        Scene scene = new Scene(root);
        
      primaryStage.setTitle("LOGIN");
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
   
    
    
    
    
      public static void main(String[] args) {
             launch(args);
    }
          
          
      }

   

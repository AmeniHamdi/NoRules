
package ac;

import tn.esprit.entities.Activites;
import tn.esprit.services.ActivitesCRUD;


 

public class Ac {
    public static void main(String[] args) {
        ActivitesCRUD actt = new ActivitesCRUD() ;
        //Activites act = new Activites ("nardine","aachrahf","mnari","azeasdqd"); 
        Activites act1 = new Activites (2,"chokr","moe","tslmt","zttttz");
        
        
        //actt.ajouterActivites(act1);
        System.out.println(actt.getActivitess());
        actt.modifierActivites(act1);
        //actt.supprimerStock(1);
    }
}
   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.services;


import infotourisme.entities.Chauffeur;
import infotourisme.IService;
import infotourisme.InfoTourismeBD;
import infotourisme.entities.Voiture;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Ameni Hamdi
 */
public class ChauffeurService
implements IService<Chauffeur> {

    Connection cnx;
    Statement ste;

    public ChauffeurService() throws SQLException {
        cnx = InfoTourismeBD.getInstance().getConnection();
        ste = cnx.createStatement();
        
    }

    @Override
    public void ajouter(Chauffeur v) throws SQLException {
        String requeteInsert = "INSERT INTO `chauffeur` (`id`, `nom`, `prenom`, `anneeEmbauche`,`listVoiture`,`nbr_jours`) VALUES ('" + v.getId()+ "', '" + v.getNom()+ "', '" + v.getPrenom()+ "', '" + v.getAnneeEmbauche()+ "', '" + v.getListVoitures()+ "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Chauffeur v) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Chauffeur v) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chauffeur> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public static String genererId(String nom,String prenom ,  int anneeEmbauche) {

		String reponse = "";

		nom = supprimerCaractereSpecialNom(nom);
		prenom = supprimerCaractereSpecialNom(prenom);


		/*
		 * ON VEUT L'ANNEE D'EMBAUCHE EN STRING POUR POUVOIR LA MANIPULER AVEC
		 * SUBSTRING() D'OU L'UTILISATION DE LA CONVERSION Integer.toString()
		 */
		String anneeEmbauche_String = Integer.toString(anneeEmbauche);
		if (nom.length() < 3 || prenom.length() < 1 || anneeEmbauche_String.length() < 1) {
			System.out.println();
		} else {
			/* DECOUPAGE DE NOM, PRENOM ET ANNEE D'EMBAUCHE */
			reponse = nom.substring(0, 3) + prenom.charAt(0)
					+ anneeEmbauche_String.substring(2);
		}

		return reponse;
	}


        /* FONCTION supprimerCaractereSpecialNom() */
	/**
	 * @see 'VERIFICATION' ET SUPPRESSION DES CARACTERES SPECIAUX; UTILE POUR LA
	 *      FONCTION genererNumeroIdentification()
	 * @see 'isLetter()' : VERIFIE SI L'ELEMENT EST UNE LETTRE
	 */
	public static String supprimerCaractereSpecialNom(String word) {
		StringBuilder nomSansCaractere = new StringBuilder(); // VARIABLE DESIGNANT LE NOM DU CHAUFFEUR SANS CARACTERE SPECIAL

		for (int i = 0; i < word.length(); i++) {
			/*
			 * POUR CHAQUE CARACTERE DU MOT, ON VERIFIE SI C'EST UNE LETTRE OU UN CARACTRE
			 * SPECIAL
			 */
			if (Character.isLetter(word.charAt(i))) {
				/* ON CONCATENE POUR OBTENIR LE NOM SANS CARACTERE SEPCIAL */
				nomSansCaractere.append(word.charAt(i));
			}
		}
		return nomSansCaractere.toString();
	}
       
}

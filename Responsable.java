package ProjetE5;

import java.time.LocalDate;

import AccesBdd.BddAccess;

public class Responsable {

	private BddAccess refBdd = null;
	
	public void setRefBdd(BddAccess bdd) {
		refBdd = bdd;
	}
	
	public void ajouterConseil(String libelle,String type) {
		LocalDate date = LocalDate.now();
		String requete = "INSERT INTO  conseils(`libelle`, `dateParution`, `type`) VALUES ("+'"'+ libelle  +'"'+ " , " +'"'+ date.toString() +'"'+ " , " +'"'+  type +'"'+ ")";
		System.out.println(requete);
		refBdd.creerStatement();
		refBdd.envoiRequeteUpdate(requete);
		
	}
	
	
}

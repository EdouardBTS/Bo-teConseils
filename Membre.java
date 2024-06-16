package ProjetE5;

import java.sql.ResultSet;

import AccesBdd.BddAccess;

public class Membre {

	private BddAccess refBdd = null;
	private ResultSet result;
	
	public void visualiserConseils(String typeConseil) {
		String req = "SELECT libelle,dateParution from conseils where type=";
		req = req + "'"+typeConseil+"'";
		
		result = refBdd.envoiRequeteSelect(req);
		refBdd.recupereReponseSelect();
	}
	
	public void setRefBdd(BddAccess bdd) {
		refBdd = bdd;
	}
}

package ProjetE5;

import AccesBdd.BddAccess;

public class MainGestConseil {

	public static void main(String[] args) {
		
		// Creation du composant BddAccess
		BddAccess bdd = new BddAccess();
		
		// 1ere etape: Recherche et chargement du driver en memoire
		bdd.rechercherDriver("com.mysql.jdbc.Driver");

		// 2eme etape: Connexion a la BDD
		//bdd.connecterBdd("jdbc:mysql://localhost/M2LAssoc","root","");
		bdd.connecterBdd("jdbc:mysql://localhost/m2lassoc?useSSL=false","root","");
		
		// 3eme etape: Creation du conteneur de requete
		bdd.creerStatement();
		// -----------------------------------------------
		
		// Creation d'un objet Membre
		Membre m = new Membre();
		
		// Main donne la reference de bdd a Membre
		m.setRefBdd(bdd);
		
		// Creation d'un objet Responsable
		Responsable resp = new Responsable();
		
		// Main donne la reference de bdd a Responsable
		resp.setRefBdd(bdd);
		
		// Creation de l'objet IhmGestConseils
		IhmGestConseils ihmGest = new IhmGestConseils();
		
		// Donner a IhmGest la reference a bdd
		ihmGest.setRefBdd(bdd);
		
		// Donner a IhmGest la reference a membre
		ihmGest.setRefMembre(m);
		
		// Donner a IhmGest la reference a responsable
		ihmGest.setRefResp(resp);
	}
}

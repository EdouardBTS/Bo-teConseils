package ProjetE5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import AccesBdd.BddAccess;

public class IhmGestConseils extends JFrame implements ActionListener {

	private BddAccess refBdd = null;
	
	// Creation d'un objet JPanel (toile)
	private JPanel pan = new JPanel();
	
	// Radio boutons
	private JRadioButton radMembre = new JRadioButton("Membre");
	private JRadioButton radResp = new JRadioButton("Responsable");
	
	// Pour grouper les radio boutons
	private ButtonGroup bg = new ButtonGroup();
	
	// Les labels
	private JLabel labelNom = new JLabel("Nom: ");
	private JLabel labelLogin = new JLabel("Login: ");
	private JLabel labelPassword = new JLabel("Mot de passe: ");
	
	// Les zones de saisie
	private JTextField zoneNom = new JTextField(20);
	private JTextField zoneLogin = new JTextField(20);
	private JTextField zonePassword = new JTextField(20);
	
	// Les boutons
	private JButton boutonCnx = new JButton("Connexion");
	
	private String nom;
	private String login;
	private String motDePasse;
	
	private boolean clickSurMembre = false;
	private boolean clickSurResp = false;
	
	private Membre refMembre = null;
	private Responsable refResp = null;
	
	//private IhmMembre ihmM;
	
	
	// Constructeur
	public IhmGestConseils() {
		
		// Ajoute un titre a la fenetre
		setTitle("Gestion conseils associations");
				
		// Dimensionner la fenetre (400 pixels de large 
		// sur 400 de haut
		setSize(400, 400);
				
		// A la fermeture de la fenetre fermer le programme
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// Associer le panel au cadre defini
		setContentPane(pan);
				
		// Associer une couleur de fond au Panel
		pan.setBackground(Color.green);
		
		// Rend la fenetre visible a l'ecran
		setVisible(true);
		
		// Grouper les boutons
		bg.add(radMembre);
		bg.add(radResp);
		
		pan.add(radMembre);
		pan.add(radResp);
		
		pan.add(labelNom);
		pan.add(zoneNom);
		pan.add(labelLogin);
		pan.add(zoneLogin);
		
		pan.add(labelPassword);
		pan.add(zonePassword);
		
		pan.add(boutonCnx);
		
		// Faire connaitre a l'ecouteur le bouton et 
		// les radio bouton
		boutonCnx.addActionListener(this);
		radMembre.addActionListener(this);
		radResp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
	
		ResultSet rs = null;
		
		if(evt.getSource() == boutonCnx) {
		
			System.out.println("Vous avez appuye sur Connexion ");
		
			// Recuperer les nom, login et mot de passe
			// des zones de saisie
			nom = zoneNom.getText();
			login = zoneLogin.getText();
			motDePasse = zonePassword.getText();
		
			//Exemple pour le controle
			/*
			int age;
			age = Integer.parseInt(zoneNom.getText());
			age = age +1;
			System.out.println(age);
		
			// Pour mettre une valeur dans une zone de saisie
			zoneLogin.setText("Tata");
			 */
			// Fin controle
			
			if(clickSurMembre == true) {
				// Formuler la requete d'authentification
				String req = "SELECT nom from connexionmember where nom =";
				req = req +"'"+nom+"'";
				req = req + " and login="+"'"+login+"'";
				req = req + " and mdp="+"'"+motDePasse+"'";
				rs = refBdd.envoiRequeteSelect(req);
						
				// Traiter la reponse
				try {
					if(rs.next()) {
						System.out.println("Membre reconnu");
						
						// Creer la fenetre IhmMembre
						IhmMembre ihmM = new IhmMembre();
						
						// Donner a IhmMembre la reference de Membre
						ihmM.setRefMembre(refMembre);
						
						// Donner a bdd la reference de IhmMembre
						refBdd.setIhmMembre(ihmM);
					}
					else {
						System.out.println("Desole vous n'avez pas acces en tant que membre!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(clickSurResp == true) {
				// Formuler la requete d'authentification
				String req = "SELECT nom from connexionresp where nom =";
				req = req +"'"+nom+"'";
				req = req + " and login="+"'"+login+"'";
				req = req + " and mdp="+"'"+motDePasse+"'";
				rs = refBdd.envoiRequeteSelect(req);
						
				// Traiter la reponse
				try {
					if(rs.next()) {
						System.out.println("Responsable reconnu");
						
						// Creer la fenetre IhmResponsable
						IhmResponsable ihmResp = new IhmResponsable();
						
						// Donner a ihmResp la reference a resp
						ihmResp.setRefResponsable(refResp);
					}
					else {
						System.out.println("Desole vous n'avez pas acces en tant que responsable!!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(evt.getSource() == radMembre) {
			System.out.println("Vous avez appuye sur membre ");
			clickSurMembre = true;
			clickSurResp = false;
			
		}
		else if(evt.getSource() == radResp) {
			System.out.println("Vous avez appuye sur responsable ");
			clickSurMembre = false;
			clickSurResp = true;
		}
	}

	public  void setRefBdd(BddAccess bdd) {
		refBdd = bdd;
	}

	public void setRefMembre(Membre m) {
		refMembre = m;
	}

	public void setRefResp(Responsable resp) {
		refResp = resp;
	}
}

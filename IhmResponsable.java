package ProjetE5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IhmResponsable extends JFrame implements ActionListener {

	// Creation d'un objet JPanel (toile)
	private JPanel pan = new JPanel();
	
	private JLabel labelSaisie = new JLabel("saisie conseils: ");
	private JLabel labelCategConseils = new JLabel("Categories conseils: ");
	
	// Liste deroulante
	private String[] listeCategorie = {"Juridiques", "Remboursement frais", "Litiges"};
	private JComboBox combo = new JComboBox(listeCategorie);
	
	// Les zones de saisie
	private JTextField zoneConseil = new JTextField(50);
	
	private JButton boutonOK = new JButton("Validation");
	
	private Responsable refResp;
	
	
	public IhmResponsable() {
		// Ajoute un titre a la fenetre
		setTitle("Fenetre Ihm responsable");
						
		// Dimensionner la fenetre (300 pixels de large 
		// sur 400 de haut
		setSize(300, 400);
						
		// A la fermeture de la fenetre fermer le programme
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
		// Associer le panel au cadre defini
		setContentPane(pan);
		
		// Associer une couleur de fond au Panel
		pan.setBackground(Color.yellow);
		
		pan.add(labelCategConseils);
		pan.add(combo);
		pan.add(labelSaisie);
		pan.add(zoneConseil);
		pan.add(boutonOK);
		boutonOK.addActionListener(this);
		combo.addActionListener(this);
		setVisible(true);
	}
	
	@Override
public void actionPerformed(ActionEvent evt) {
		String option = (String)combo.getSelectedItem();
		if(evt.getSource() == boutonOK) {
		
			String libelle = zoneConseil.getText(); 	
		refResp.ajouterConseil(libelle,option);
		}
	}

	public void setRefResponsable(Responsable resp) {
		refResp = resp;
	}
}

package ProjetE5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IhmMembre extends JFrame implements ActionListener {

	// Creation d'un objet JPanel (toile)
	private JPanel pan = new JPanel();
	
	private JLabel labelVisu = new JLabel("Visualisation conseils: ");
	private JLabel labelCategConseils = new JLabel("Categories conseils: ");
	
	// Zones de texte Area
	private JTextArea zoneAffich = new JTextArea(15,40);
		
	// Ascenseurs pour la JTextArea
	private JScrollPane scroll = new JScrollPane(zoneAffich);
	
	// Liste deroulante
	private String[] listeCategorie = {"Juridiques", "Remboursement frais", "Litiges"};
	private JComboBox combo = new JComboBox(listeCategorie);
	
	private JButton boutonOK = new JButton("Validation");
	
	private Membre refMembre = null;
	
	public IhmMembre() {
		
		// Ajoute un titre a la fenetre
		setTitle("Fenetre Ihm membre");
				
		// Dimensionner la fenetre (300 pixels de large 
		// sur 400 de haut
		setSize(400, 500);
				
		// A la fermeture de la fenetre fermer le programme
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// Associer le panel au cadre defini
		setContentPane(pan);
				
		// Associer une couleur de fond au Panel
		pan.setBackground(Color.cyan);
				
		pan.add(labelVisu);
		pan.add(scroll);
		pan.add(labelCategConseils);
		pan.add(combo);
		pan.add(boutonOK);
		
		// Associer les boutons aux ecouteurs
		boutonOK.addActionListener(this);
		combo.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		String option = (String)combo.getSelectedItem();
		
		if(evt.getSource() == boutonOK) {
			zoneAffich.setText("");
			refMembre.visualiserConseils(option);
		}
	}


	public void setRefMembre(Membre membre) {
		refMembre = membre;
	}

	public void afficherConseils(String msg) {
		
		zoneAffich.append(msg);
	}
}

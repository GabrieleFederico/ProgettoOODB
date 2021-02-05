package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;
import controllers.ControllerConsegneUtente;
import controllers.ControllerConsegneRider;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogConfermaIncaricoRider extends JDialog {
	
	public JDialogConfermaIncaricoRider(String CodC, ControllerConsegneRider cr) {
		setAlwaysOnTop(true);
		setTitle("Conferma");
		setBounds(100, 100, 361, 244);
		getContentPane().setLayout(null);
		
		JLabel labelOrdine = new JLabel("Ordine:");
		labelOrdine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelOrdine.setBounds(59, 33, 64, 14);
		getContentPane().add(labelOrdine);
		
		JLabel labelConferma = new JLabel("Vuoi prendere in carico questo ordine?");
		labelConferma.setBounds(74, 77, 232, 14);
		getContentPane().add(labelConferma);
		
		JButton buttonAccetta = new JButton("Accetta");
		buttonAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CodR = cr.getRider().getCodR();
				cr.nuovoOrdineRider(CodR, CodC);
				cr.getHomeRider().aggiornaInterfaccia();
				dispose();
			}
		});
		buttonAccetta.setBounds(231, 145, 89, 23);
		getContentPane().add(buttonAccetta);
		
		JButton buttonAnnulla = new JButton("Annulla");
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		buttonAnnulla.setBounds(34, 145, 89, 23);
		getContentPane().add(buttonAnnulla);
		
		JLabel labelCodC = new JLabel(CodC);
		labelCodC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCodC.setBounds(125, 33, 76, 14);
		getContentPane().add(labelCodC);
		
		
	}
	
	
}

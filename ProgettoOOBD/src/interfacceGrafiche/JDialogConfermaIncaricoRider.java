package interfacceGrafiche;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;

import classiEntità.Rider;
import controllers.ControllerConsegne;
import controllers.ControllerRider;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogConfermaIncaricoRider extends JDialog {
	
	public JDialogConfermaIncaricoRider(String CodC, ControllerConsegne controller, ControllerRider cr) {
		setAlwaysOnTop(true);
		setTitle("Conferma");
		setBounds(100, 100, 361, 244);
		getContentPane().setLayout(null);
		
		JLabel LabelOrdine = new JLabel("Ordine:");
		LabelOrdine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelOrdine.setBounds(59, 33, 64, 14);
		getContentPane().add(LabelOrdine);
		
		JLabel LabelConferma = new JLabel("Vuoi prendere in carico questo ordine?");
		LabelConferma.setBounds(74, 77, 232, 14);
		getContentPane().add(LabelConferma);
		
		JButton ButtonAccetta = new JButton("Accetta");
		ButtonAccetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CodR = cr.getCodR();
				controller.nuovoOrdineRider(CodR, CodC);
				dispose();
			}
		});
		ButtonAccetta.setBounds(231, 145, 89, 23);
		getContentPane().add(ButtonAccetta);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		ButtonAnnulla.setBounds(34, 145, 89, 23);
		getContentPane().add(ButtonAnnulla);
		
		JLabel LabelCodC = new JLabel(CodC);
		LabelCodC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCodC.setBounds(125, 33, 76, 14);
		getContentPane().add(LabelCodC);
		
		
	}
	
	
}

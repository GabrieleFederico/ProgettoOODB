package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;

import classiEntità.Carrello;
import controllers.ControllerCarrello;
import controllers.ControllerConsegneUtente;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogConclusioneOrdine extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public JDialogConclusioneOrdine(ControllerCarrello c) {
		setBounds(100, 100, 450, 190);
		getContentPane().setLayout(null);
		
		JLabel labelGrazie = new JLabel("Grazie!");
		labelGrazie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelGrazie.setBounds(179, 11, 61, 14);
		getContentPane().add(labelGrazie);
		
		JLabel labelConferma = new JLabel("Il suo ordine è stato eseguito correttamente.");
		labelConferma.setBounds(96, 60, 300, 14);
		getContentPane().add(labelConferma);
		
		JButton buttonOk = new JButton("ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				c.getJFrameCarrello().dispose();
				
			}
		});
		buttonOk.setBounds(168, 117, 72, 23);
		getContentPane().add(buttonOk);

	}

}

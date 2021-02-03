package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;

import classiEntità.Carrello;
import controllers.ControllerCarrello;
import controllers.ControllerConsegne;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogConclusioneOrdine extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public JDialogConclusioneOrdine(ControllerCarrello c) {
		setBounds(100, 100, 450, 190);
		getContentPane().setLayout(null);
		
		JLabel LabelGrazie = new JLabel("Grazie!");
		LabelGrazie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelGrazie.setBounds(179, 11, 61, 14);
		getContentPane().add(LabelGrazie);
		
		JLabel LabelConferma = new JLabel("Il suo ordine è stato eseguito correttamente.");
		LabelConferma.setBounds(96, 60, 300, 14);
		getContentPane().add(LabelConferma);
		
		JButton ButtonOk = new JButton("ok");
		ButtonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				c.getfc().dispose();
				
			}
		});
		ButtonOk.setBounds(168, 117, 72, 23);
		getContentPane().add(ButtonOk);

	}

}

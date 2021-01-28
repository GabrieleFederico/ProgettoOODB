package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConclusioneOrdine extends JDialog {

	private static final long serialVersionUID = 1L;

	public ConclusioneOrdine() {
		setBounds(100, 100, 450, 190);
		getContentPane().setLayout(null);
		
		JLabel LabelGrazie = new JLabel("Grazie!");
		LabelGrazie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelGrazie.setBounds(179, 11, 61, 14);
		getContentPane().add(LabelGrazie);
		
		JLabel LabelConferma = new JLabel("Il suo ordine è stato eseguito correttamente.");
		LabelConferma.setBounds(96, 60, 300, 14);
		getContentPane().add(LabelConferma);
		
		JButton okButton = new JButton("ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				//torna_home
			}
		});
		okButton.setBounds(168, 117, 72, 23);
		getContentPane().add(okButton);

	}

}

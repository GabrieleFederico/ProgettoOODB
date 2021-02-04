package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;
import controllers.ControllerConsegne;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogConfermaConsegnaOrdine extends JDialog {

	public JDialogConfermaConsegnaOrdine(String CodC, ControllerConsegne c) {
		
		setTitle("Conferma Ordine");
		setBounds(100, 100, 348, 228);
		getContentPane().setLayout(null);
		
		JLabel LabelConferma = new JLabel("Vuole confermare la consegna di questo ordine?");
		LabelConferma.setBounds(10, 79, 283, 14);
		getContentPane().add(LabelConferma);
		
		JButton ButtonConferma = new JButton("Conferma");
		ButtonConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.ordineConsegnato(CodC);
				dispose();
			}
		});
		ButtonConferma.setBounds(214, 141, 108, 23);
		getContentPane().add(ButtonConferma);
		
		JButton labelAnnulla = new JButton("Annulla");
		labelAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		labelAnnulla.setBounds(10, 141, 108, 23);
		getContentPane().add(labelAnnulla);
		
		JLabel labelOrdine = new JLabel("Ordine:");
		labelOrdine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelOrdine.setBounds(39, 29, 67, 14);
		getContentPane().add(labelOrdine);
		
		JLabel LabelCodC = new JLabel(CodC);
		LabelCodC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCodC.setBounds(102, 31, 108, 14);
		getContentPane().add(LabelCodC);

	}

}

package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class JDialogRiderOrdineConsegnato extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public JDialogRiderOrdineConsegnato(String CodC) {
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel LabelDomanda = new JLabel("Vuoi confermare la consergna di quest'ordine?");
		LabelDomanda.setBounds(10, 72, 400, 14);
		contentPanel.add(LabelDomanda);
		
		JLabel LabelConferma = new JLabel("Conferma ordine n");
		LabelConferma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelConferma.setBounds(67, 11, 159, 36);
		contentPanel.add(LabelConferma);
		
		JButton ButtonConferma = new JButton("Conferma");
		ButtonConferma.setBounds(335, 156, 89, 23);
		contentPanel.add(ButtonConferma);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.setBounds(10, 156, 89, 23);
		contentPanel.add(ButtonAnnulla);

		JLabel LabelCodiceOrdine = new JLabel ("a");
		LabelCodiceOrdine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCodiceOrdine.setBounds(222, 11, 159, 36);
		contentPanel.add(LabelCodiceOrdine);
	}
}

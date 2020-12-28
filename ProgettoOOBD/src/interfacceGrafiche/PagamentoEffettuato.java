package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class PagamentoEffettuato extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PagamentoEffettuato dialog = new PagamentoEffettuato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagamentoEffettuato() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton ButtonHome = new JButton("Torna alla Home");
			ButtonHome.setBounds(306, 139, 118, 23);
			contentPanel.add(ButtonHome);
		}
		{
			JButton ButtonMieiOrdini = new JButton("I miei ordini");
			ButtonMieiOrdini.setBounds(10, 139, 89, 23);
			contentPanel.add(ButtonMieiOrdini);
		}
		{
			JLabel LabelGrazie = new JLabel("Grazie");
			LabelGrazie.setFont(new Font("Tahoma", Font.PLAIN, 14));
			LabelGrazie.setBounds(189, 22, 46, 14);
			contentPanel.add(LabelGrazie);
		}
		{
			JLabel LabelOrdineEffettuato = new JLabel("Il suo ordine \u00E8 stato effettuato correttamente.");
			LabelOrdineEffettuato.setBounds(96, 76, 257, 14);
			contentPanel.add(LabelOrdineEffettuato);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(312, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(382, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}

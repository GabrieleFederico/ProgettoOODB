package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ConfermaIncaricoRider extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ConfermaIncaricoRider() {
		setBounds(100, 100, 450, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel LabelConferma = new JLabel("Sei sicuro di voler accettare quest'ordine?");
			contentPanel.add(LabelConferma);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonAccetta = new JButton("Accetta");
				ButtonAccetta.setActionCommand("OK");
				buttonPane.add(ButtonAccetta);
				getRootPane().setDefaultButton(ButtonAccetta);
			}
			{
				JButton ButtonRifiuta = new JButton("Rifiuta");
				ButtonRifiuta.setActionCommand("Cancel");
				buttonPane.add(ButtonRifiuta);
			}
		}
	}

}

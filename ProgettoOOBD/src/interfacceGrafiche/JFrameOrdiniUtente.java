package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntità.Utente;
import controllers.ControllerOrdini;

public class JFrameOrdiniUtente extends JFrame {

	private JPanel contentPane;

	public JFrameOrdiniUtente(Utente utente, ControllerOrdini co) {

		setBounds(100, 100, 649, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}

package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class JFrameOrdiniRider extends JFrame {

	private JPanel contentPane;

	public JFrameOrdiniRider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelOrdini = new JLabel("Gli ordini presi da lei in carico sono:");
		LabelOrdini.setBounds(10, 32, 189, 14);
		contentPane.add(LabelOrdini);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.setBounds(619, 417, 89, 23);
		contentPane.add(ButtonIndietro);
	}

}

package Interfacce;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameRegistrati extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JTextField TFNewEmail;
	private JTextField TFNewPassword;

	public JFrameRegistrati() {
		setTitle("Registrati");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelEmail = new JLabel("Inserisci la tua email:");
		LabelEmail.setBounds(47, 94, 160, 14);
		contentPane.add(LabelEmail);
		
		TFNewEmail = new JTextField();
		TFNewEmail.setBounds(202, 91, 162, 20);
		contentPane.add(TFNewEmail);
		TFNewEmail.setColumns(10);
		
		TFNewPassword = new JTextField();
		TFNewPassword.setBounds(202, 150, 162, 20);
		contentPane.add(TFNewPassword);
		TFNewPassword.setColumns(10);
		
		JLabel LabelPassword = new JLabel("Inserisci la tua password:");
		LabelPassword.setBounds(34, 153, 173, 14);
		contentPane.add(LabelPassword);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.setBounds(10, 216, 89, 23);
		contentPane.add(ButtonAnnulla);
		
		JButton ButtonConferma = new JButton("Conferma");
		ButtonConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		ButtonConferma.setBounds(335, 216, 89, 23);
		contentPane.add(ButtonConferma);
		
		JLabel LabelInserire = new JLabel("La preghiamo di inserire i suoi dati:");
		LabelInserire.setBounds(34, 44, 303, 14);
		contentPane.add(LabelInserire);
	}

}

package interfacceGrafiche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntità.Utenti;
import controllers.ControllerLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class JFrameRegistratiUtente extends JFrame {
	
	private JPanel contentPane;
	private JTextField TFNewEmail;
	private JTextField TFNewPassword;
	private ControllerLogin controller;
	private JTextField TFNewNome;
	private JTextField TFNewCognome;
	private JTextField TFNewIndirizzo;
	
	public JFrameRegistratiUtente(ControllerLogin c) {
		controller = c;
		setTitle("Registrati");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(74, 94, 75, 14);
		contentPane.add(labelEmail);
		
		TFNewEmail = new JTextField();
		TFNewEmail.setBounds(198, 91, 166, 20);
		contentPane.add(TFNewEmail);
		TFNewEmail.setColumns(10);
		
		TFNewPassword = new JTextField();
		TFNewPassword.setBounds(198, 119, 166, 20);
		contentPane.add(TFNewPassword);
		TFNewPassword.setColumns(10);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setBounds(74, 122, 75, 14);
		contentPane.add(labelPassword);
		
		JButton buttonAnnulla = new JButton("Annulla");
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tornaHomeDaUtente();
			}
		});
		buttonAnnulla.setBounds(34, 308, 89, 23);
		contentPane.add(buttonAnnulla);
		
		JButton buttonConferma = new JButton("Conferma");
		buttonConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Utenti utente = new Utenti(TFNewEmail.getText(), TFNewPassword.getText(), TFNewNome.getText(), TFNewCognome.getText(), TFNewIndirizzo.getText());
					controller.registraCredenzialiUtente(utente);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		buttonConferma.setBounds(304, 308, 109, 23);
		contentPane.add(buttonConferma);
		
		JLabel labelInserire = new JLabel("La preghiamo di inserire i suoi dati:");
		labelInserire.setBounds(34, 44, 303, 14);
		contentPane.add(labelInserire);
		
		JLabel labelNewNome = new JLabel("Nome:");
		labelNewNome.setBounds(74, 153, 75, 14);
		contentPane.add(labelNewNome);
		
		JLabel labelNewCognome = new JLabel("Cognome:");
		labelNewCognome.setBounds(74, 184, 75, 14);
		contentPane.add(labelNewCognome);
		
		JLabel labelNewIndirizzo = new JLabel("Indirizzo:");
		labelNewIndirizzo.setBounds(74, 215, 75, 14);
		contentPane.add(labelNewIndirizzo);
		
		TFNewNome = new JTextField();
		TFNewNome.setBounds(198, 150, 166, 20);
		contentPane.add(TFNewNome);
		TFNewNome.setColumns(10);
		
		TFNewCognome = new JTextField();
		TFNewCognome.setBounds(198, 181, 166, 20);
		contentPane.add(TFNewCognome);
		TFNewCognome.setColumns(10);
		
		TFNewIndirizzo = new JTextField();
		TFNewIndirizzo.setBounds(198, 212, 166, 20);
		contentPane.add(TFNewIndirizzo);
		TFNewIndirizzo.setColumns(10);
	}
}

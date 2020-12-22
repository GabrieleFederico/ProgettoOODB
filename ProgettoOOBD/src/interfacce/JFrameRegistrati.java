package interfacce;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerLogin;

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

	ControllerLogin controllore;
	private JTextField TFNewNome;
	private JTextField TFNewCognome;
	private JTextField TFNewIndirizzo;
	
	public JFrameRegistrati(ControllerLogin c) {
		controllore = c;
		setTitle("Registrati");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setBounds(74, 94, 75, 14);
		contentPane.add(LabelEmail);
		
		TFNewEmail = new JTextField();
		TFNewEmail.setBounds(198, 91, 166, 20);
		contentPane.add(TFNewEmail);
		TFNewEmail.setColumns(10);
		
		TFNewPassword = new JTextField();
		TFNewPassword.setBounds(198, 119, 166, 20);
		contentPane.add(TFNewPassword);
		TFNewPassword.setColumns(10);
		
		JLabel LabelPassword = new JLabel("Password:");
		LabelPassword.setBounds(74, 122, 75, 14);
		contentPane.add(LabelPassword);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.setBounds(34, 308, 89, 23);
		contentPane.add(ButtonAnnulla);
		
		JButton ButtonConferma = new JButton("Conferma");
		ButtonConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			controllore.RegistraCredenziali(TFNewEmail.getText(), TFNewPassword.getText(), TFNewNome.getText(), TFNewCognome.getText(), TFNewIndirizzo.getText());	
			}
		});
		ButtonConferma.setBounds(304, 308, 109, 23);
		contentPane.add(ButtonConferma);
		
		JLabel LabelInserire = new JLabel("La preghiamo di inserire i suoi dati:");
		LabelInserire.setBounds(34, 44, 303, 14);
		contentPane.add(LabelInserire);
		
		JLabel LabelNewNome = new JLabel("Nome:");
		LabelNewNome.setBounds(74, 153, 75, 14);
		contentPane.add(LabelNewNome);
		
		JLabel LabelNewCognome = new JLabel("Cognome:");
		LabelNewCognome.setBounds(74, 184, 75, 14);
		contentPane.add(LabelNewCognome);
		
		JLabel LabelNewIndirizzo = new JLabel("Indirizzo:");
		LabelNewIndirizzo.setBounds(74, 215, 75, 14);
		contentPane.add(LabelNewIndirizzo);
		
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

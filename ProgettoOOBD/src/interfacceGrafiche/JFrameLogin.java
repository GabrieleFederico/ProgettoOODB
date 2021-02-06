package interfacceGrafiche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntità.Riders;
import classiEntità.Utenti;
import controllers.ControllerLogin;
import controllers.ControllerPrincipale;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrameLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField TFEmail;
	private JTextField TFPassword;
	private ControllerLogin controller;
	
	public JFrameLogin(ControllerLogin c, ControllerPrincipale c1) {

		setTitle("Login");
		controller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TFEmail = new JTextField();
		TFEmail.setBounds(276, 140, 149, 20);
		contentPane.add(TFEmail);
		TFEmail.setColumns(10);
		
		TFPassword = new JTextField();
		TFPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				if(e1.getKeyCode() == KeyEvent.VK_ENTER) {
					login(c1);
				}
			}
		});
		TFPassword.setBounds(276, 219, 149, 20);
		contentPane.add(TFPassword);
		TFPassword.setColumns(10);
		
		JButton buttonRegistrati = new JButton("Registrati");
		buttonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.loginRegistratiButton();	 
			}
		});
		buttonRegistrati.setBounds(523, 389, 139, 23);
		contentPane.add(buttonRegistrati);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				login(c1);
			}
		});
		buttonLogin.setBounds(276, 304, 89, 23);
		contentPane.add(buttonLogin);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(197, 143, 46, 14);
		contentPane.add(labelEmail);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPassword.setBounds(179, 220, 70, 14);
		contentPane.add(labelPassword);
		
		JLabel labelBenvenuto = new JLabel("Benvenuto, inserisci i tuoi dati:");
		labelBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelBenvenuto.setBounds(212, 67, 243, 14);
		contentPane.add(labelBenvenuto);
		
		JLabel labelRegistrati = new JLabel("Non sei ancora iscritto?");
		labelRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelRegistrati.setBounds(523, 352, 165, 14);
		contentPane.add(labelRegistrati);
		
		JButton buttonChiudi = new JButton("Chiudi");
		buttonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		buttonChiudi.setBounds(34, 432, 89, 23);
		contentPane.add(buttonChiudi);
		
		JButton buttonRegistraRider = new JButton("Registrati da Rider");
		buttonRegistraRider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.loginRegistratiRiderButton();	
			}
		});
		buttonRegistraRider.setBounds(523, 432, 139, 23);
		contentPane.add(buttonRegistraRider);
			
		}
	
		public void login(ControllerPrincipale c1) {
			
				try {
					Riders r = controller.controllaCredenzialiRider(TFEmail.getText(), TFPassword.getText());
					Utenti u = controller.controllaCredenzialiUtente(TFEmail.getText(), TFPassword.getText());
					if(r != null) {
						controller.passaAdHomeRider(c1, r);
					} else if (u != null) {
						controller.passaAdHomeUtente(c1, u);
					} else {
						JDialogErrore loginSbagliato = new JDialogErrore("Email e/o Password errata/e");
						svuotaCampi();
					}
				}
				catch(SQLException e){
					System.out.println(e.getMessage());
				}
			}
		
		public void svuotaCampi() {
			TFEmail.setText(null);
			TFPassword.setText(null);
		}
}



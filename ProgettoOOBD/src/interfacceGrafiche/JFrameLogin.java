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

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField TFEmail;
	private JTextField TFPassword;
	
	ControllerLogin controllore;
	ControllerPrincipale controller;
	JDialogErroreLogin LoginSbagliato = new JDialogErroreLogin();
	
	public JFrameLogin(ControllerLogin c, ControllerPrincipale c1) {

		setTitle("Login");
		controllore=c;
		controller = c1;
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
					login(c1, c);
				}
			}
		});
		TFPassword.setBounds(276, 219, 149, 20);
		contentPane.add(TFPassword);
		TFPassword.setColumns(10);
		
		JButton ButtonRegistrati = new JButton("Registrati");
		ButtonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.loginRegistratiButton();	 
			}
		});
		ButtonRegistrati.setBounds(523, 389, 139, 23);
		contentPane.add(ButtonRegistrati);
		
		JButton ButtonLogin = new JButton("Login");
		ButtonLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				login(c1, c);
			}
		});
		ButtonLogin.setBounds(276, 304, 89, 23);
		contentPane.add(ButtonLogin);
		
		JLabel LabelEmail = new JLabel("Email");
		LabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelEmail.setBounds(197, 143, 46, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelPassword.setBounds(179, 220, 70, 14);
		contentPane.add(LabelPassword);
		
		JLabel LabelBenvenuto = new JLabel("Benvenuto, inserisci i tuoi dati:");
		LabelBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelBenvenuto.setBounds(212, 67, 243, 14);
		contentPane.add(LabelBenvenuto);
		
		JLabel LabelRegistrati = new JLabel("Non sei ancora iscritto?");
		LabelRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelRegistrati.setBounds(523, 352, 165, 14);
		contentPane.add(LabelRegistrati);
		
		JButton ButtonChiudi = new JButton("Chiudi");
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		ButtonChiudi.setBounds(34, 432, 89, 23);
		contentPane.add(ButtonChiudi);
		
		JButton ButtonRegistraRider = new JButton("Registrati da Rider");
		ButtonRegistraRider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.loginRegistratiRiderButton();	
			}
		});
		ButtonRegistraRider.setBounds(523, 432, 139, 23);
		contentPane.add(ButtonRegistraRider);
			
		}
	
		public void login(ControllerPrincipale c1, ControllerLogin c) {
			
				try {
					Riders r = c.getRider(TFEmail.getText(), TFPassword.getText());
					Utenti u = c.controllaCredenziali(TFEmail.getText(), TFPassword.getText());
					if(r != null) {
						c.PassaAdHomeRider(c1, r);
					} else if (u != null) {
						c.PassaAdHomeUtente(c1, u);
					} else {
						LoginSbagliato.setVisible(true);
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



package Interfacce;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JTextField TFLogin;
	private JTextField TFPassword;
	
	
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TFLogin = new JTextField();
		TFLogin.setBounds(276, 140, 149, 20);
		contentPane.add(TFLogin);
		TFLogin.setColumns(10);
		
		TFPassword = new JTextField();
		TFPassword.setBounds(276, 219, 149, 20);
		contentPane.add(TFPassword);
		TFPassword.setColumns(10);
		
		JButton ButtonRegistrati = new JButton("Registrati");
		ButtonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
			}
		});
		ButtonRegistrati.setBounds(558, 418, 89, 23);
		contentPane.add(ButtonRegistrati);
		
		JButton ButtonLogin = new JButton("Login");
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
		LabelRegistrati.setBounds(523, 393, 165, 14);
		contentPane.add(LabelRegistrati);
		
		JButton ButtonChiudi = new JButton("Chiudi");
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		ButtonChiudi.setBounds(36, 418, 89, 23);
		contentPane.add(ButtonChiudi);
	}

}

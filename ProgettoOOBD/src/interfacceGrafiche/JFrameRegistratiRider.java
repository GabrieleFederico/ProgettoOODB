package interfacceGrafiche;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controllers.ControllerLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameRegistratiRider extends JFrame {

	private JPanel contentPane;
	private JTextField TFNewNome;
	private JTextField TFNewCognome;
	private JTextField TFNewEmail;
	private JTextField TFNewPassword;

	public JFrameRegistratiRider(ControllerLogin c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(34, 93, 68, 14);
		contentPane.add(labelNome);
		
		JLabel labelCognome = new JLabel("Cognome:");
		labelCognome.setBounds(34, 143, 68, 14);
		contentPane.add(labelCognome);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(34, 193, 68, 14);
		contentPane.add(labelEmail);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setBounds(34, 243, 68, 14);
		contentPane.add(labelPassword);
		
		JLabel labelMezzo = new JLabel("Mezzo:");
		labelMezzo.setBounds(34, 293, 68, 14);
		contentPane.add(labelMezzo);
		
		TFNewNome = new JTextField();
		TFNewNome.setBounds(130, 90, 145, 20);
		contentPane.add(TFNewNome);
		TFNewNome.setColumns(10);
		
		TFNewCognome = new JTextField();
		TFNewCognome.setBounds(130, 140, 145, 20);
		contentPane.add(TFNewCognome);
		TFNewCognome.setColumns(10);
		
		TFNewEmail = new JTextField();
		TFNewEmail.setBounds(130, 190, 145, 20);
		contentPane.add(TFNewEmail);
		TFNewEmail.setColumns(10);
		
		TFNewPassword = new JTextField();
		TFNewPassword.setBounds(130, 240, 145, 20);
		contentPane.add(TFNewPassword);
		TFNewPassword.setColumns(10);
		
		JButton buttonAnnulla = new JButton("Annulla");
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.tornaHomeDaRider();
			}
		});
		buttonAnnulla.setBounds(10, 351, 89, 23);
		contentPane.add(buttonAnnulla);
		
		JLabel labelInserire = new JLabel("Inserire i dati richiesti:");
		labelInserire.setBounds(34, 50, 379, 14);
		contentPane.add(labelInserire);
		
		JComboBox<String> comboBoxMezzo = new JComboBox<String>();
		comboBoxMezzo.setModel(new DefaultComboBoxModel<String>(new String[] {"Moto", "Automobile", "Bici"}));
		comboBoxMezzo.setBounds(130, 289, 145, 22);
		contentPane.add(comboBoxMezzo);
		
		JLabel labelBenvenuto = new JLabel("Benvenuto");
		labelBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelBenvenuto.setBounds(165, 25, 98, 14);
		contentPane.add(labelBenvenuto);
		
		JButton buttonRegistrati = new JButton("Registrati");
		buttonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mezzo = comboBoxMezzo.getSelectedItem().toString();
				c.registraCredenzialiRider( TFNewNome.getText(), TFNewCognome.getText(),TFNewEmail.getText(), mezzo, TFNewPassword.getText());	
			}
		});
		buttonRegistrati.setBounds(281, 351, 89, 23);
		contentPane.add(buttonRegistrati);
		
		
	}
}

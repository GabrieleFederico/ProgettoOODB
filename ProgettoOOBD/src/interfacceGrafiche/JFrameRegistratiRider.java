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
		
		JLabel LabelNome = new JLabel("Nome:");
		LabelNome.setBounds(34, 93, 68, 14);
		contentPane.add(LabelNome);
		
		JLabel LabelCognome = new JLabel("Cognome:");
		LabelCognome.setBounds(34, 143, 68, 14);
		contentPane.add(LabelCognome);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setBounds(34, 193, 68, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelPassword = new JLabel("Password:");
		LabelPassword.setBounds(34, 243, 68, 14);
		contentPane.add(LabelPassword);
		
		JLabel LabelMezzo = new JLabel("Mezzo:");
		LabelMezzo.setBounds(34, 293, 68, 14);
		contentPane.add(LabelMezzo);
		
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
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.tornaHomeDaRider();
			}
		});
		ButtonAnnulla.setBounds(10, 351, 89, 23);
		contentPane.add(ButtonAnnulla);
		
		JLabel LabelInserire = new JLabel("Inserire i dati richiesti:");
		LabelInserire.setBounds(34, 50, 379, 14);
		contentPane.add(LabelInserire);
		
		JComboBox<String> comboBoxMezzo = new JComboBox<String>();
		comboBoxMezzo.setModel(new DefaultComboBoxModel<String>(new String[] {"Moto", "Automobile", "Bici"}));
		comboBoxMezzo.setBounds(130, 289, 145, 22);
		contentPane.add(comboBoxMezzo);
		
		JLabel LabelBenvenuto = new JLabel("Benvenuto");
		LabelBenvenuto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelBenvenuto.setBounds(165, 25, 98, 14);
		contentPane.add(LabelBenvenuto);
		
		JButton ButtonRegistrati = new JButton("Registrati");
		ButtonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mezzo = comboBoxMezzo.getSelectedItem().toString();
				c.registraCredenzialiRider( TFNewNome.getText(), TFNewCognome.getText(),TFNewEmail.getText(), mezzo, TFNewPassword.getText());	
			}
		});
		ButtonRegistrati.setBounds(281, 351, 89, 23);
		contentPane.add(ButtonRegistrati);
		
		
	}
}

package interfacceGrafiche;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class JFrameHomeRider extends JFrame {

	private JPanel contentPane;

	public JFrameHomeRider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelOrdiniDisponibili = new JLabel("Sono disponibili i seguenti ordini:");
		LabelOrdiniDisponibili.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelOrdiniDisponibili.setBounds(10, 50, 240, 14);
		contentPane.add(LabelOrdiniDisponibili);
		
		JButton ButtonIMieiOrdini = new JButton("I miei ordini");
		ButtonIMieiOrdini.setBounds(584, 407, 100, 23);
		
		ButtonIMieiOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//apri una nuova finestra con gli ordini effettuati dal rider
			}
		});
		contentPane.add(ButtonIMieiOrdini);
		
		JButton ButtonLogout = new JButton("Logout");
		ButtonLogout.setBounds(10, 407, 89, 23);
		contentPane.add(ButtonLogout);
	
	}
}

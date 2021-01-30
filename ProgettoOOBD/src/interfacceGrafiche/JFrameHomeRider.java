package interfacceGrafiche;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import classiEntità.ConsegneSenzaRider;
import controllers.ControllerConsegne;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class JFrameHomeRider extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ControllerConsegne controller;
	private JScrollPane scrollPane;

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
				//JFrame_Ordini_effettuati_Rider
			}
		});
		contentPane.add(ButtonIMieiOrdini);
		
		JButton ButtonLogout = new JButton("Logout");
		ButtonLogout.setBounds(10, 407, 89, 23);
		contentPane.add(ButtonLogout);
		
		JButton ButtonAggiorna = new JButton("Aggiorna");
		ButtonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getConsegne();
			}
		});
		ButtonAggiorna.setBounds(298, 407, 89, 23);
		contentPane.add(ButtonAggiorna);
	
		getConsegne();
	}
	
	public void getConsegne() {
		
		int y = 50;
		
		ArrayList<ConsegneSenzaRider> consegneDisponibili = new ArrayList<ConsegneSenzaRider>();
		consegneDisponibili = controller.getConsegneDisponibili();
		ConsegneSenzaRider a;
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, consegneDisponibili.size()*100));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for (ConsegneSenzaRider c : consegneDisponibili) {
			
			JButton bottone = new JButton("Partenza:" + c.getIndirizzoP() + "%n Arrivo:" + c.getIndirizzoA() + 
										  "%n Orario:" + c.getOrario() + "Destinatario:" + c.getNomeUtente() + " " + c.getCognomeUtente());
			bottone.setBounds(250, y, 250, 150);
			pannelloScrollPane.add(bottone);
			
			bottone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					Object source = arg0.getSource();
//					JDialog_Conferma
				}
			});
			y=+200;
		}
	}
	
	
	
	
	
	
}

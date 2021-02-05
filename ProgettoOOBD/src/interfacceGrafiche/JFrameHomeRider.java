package interfacceGrafiche;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import controllers.ControllerConsegneRider;
import controllers.ControllerPrincipale;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class JFrameHomeRider extends JFrame {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JDialogConfermaIncaricoRider confermaIncarico;
	private ArrayList<Consegne> consegneDisponibili;
	private ControllerConsegneRider c2;
	
	public JFrameHomeRider(ControllerConsegneRider cr, ControllerPrincipale c1) {
		
		c2 = cr;
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelOrdiniDisponibili = new JLabel("Sono disponibili i seguenti ordini:");
		labelOrdiniDisponibili.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelOrdiniDisponibili.setBounds(10, 50, 240, 14);
		contentPane.add(labelOrdiniDisponibili);
		
		JButton luttonIMieiOrdini = new JButton("I miei ordini");
		luttonIMieiOrdini.setBounds(589, 447, 100, 23);
		luttonIMieiOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cr.apriMieiOrdini();
			}
		});
		contentPane.add(luttonIMieiOrdini);
		
		JButton buttonLogout = new JButton("Logout");
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.logout();
				dispose();
			}
		});
		buttonLogout.setBounds(10, 447, 89, 23);
		contentPane.add(buttonLogout);
		
		JButton buttonAggiorna = new JButton("Aggiorna");
		buttonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aggiornaInterfaccia();
			}
		});
		buttonAggiorna.setBounds(301, 447, 89, 23);
		contentPane.add(buttonAggiorna);
		
		getConsegne();
	}
	
	public void getConsegne() {
		
		consegneDisponibili = new ArrayList<Consegne>();
		consegneDisponibili = c2.getConsegneDisponibili();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(690, consegneDisponibili.size()*160));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 690, 354);
		contentPane.add(scrollPane);
		
		int y = 1, xLabel = 50, xButton = 250;
		
		for (Consegne c : consegneDisponibili) {
			
			JLabel label = new JLabel("<html> Codice Ordine:" + c.getCodC() + "<br>Partenza:" + c.getIndirizzoP() + "<br>Arrivo:" + c.getIndirizzoA() + "<br>Orario:" + c.getOrario() + 
					  "<br>Destinatario:" + c.getComposizioneConsegna().getProprietario().getNome() + " " + c.getComposizioneConsegna().getProprietario().getCognome() + "</html>");
			label.setBounds(xLabel, y, 150, 130);
			pannelloScrollPane.add(label);
			JButton bottone = new JButton ("Prendi in carico");
			bottone.setBounds(xButton, y+30, 150, 30);
			pannelloScrollPane.add(bottone);
			bottone.addActionListener(new ActionListener() {
				public void  actionPerformed(ActionEvent arg0) {
					confermaIncarico = new JDialogConfermaIncaricoRider(c.getCodC(), c2);
					confermaIncarico.setVisible(true);
				}
			});
			y = y+150;
		}
		pannelloScrollPane.updateUI();
		y = 1;
	}

	public void aggiornaInterfaccia() {
		contentPane.remove(scrollPane);
		getConsegne();
		
	}
	
}

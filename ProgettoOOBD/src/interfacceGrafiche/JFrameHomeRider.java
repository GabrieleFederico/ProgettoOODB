package interfacceGrafiche;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import controllers.ControllerConsegne;
import controllers.ControllerRider;
import controllers.ControllorePrincipale;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class JFrameHomeRider extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ControllerConsegne c1 = new ControllerConsegne();
	private JDialogConfermaIncaricoRider confermaIncarico;
	private ArrayList<Consegne> consegneDisponibili;
	private int y = 1, xLabel = 50, xButton = 250;
	private ControllerRider c2;
	private JFrameOrdiniRider iMieiOrdini;
	
	public JFrameHomeRider(ControllerConsegne controller, ControllerRider cr, ControllorePrincipale c1) {
		c2 = cr;
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelOrdiniDisponibili = new JLabel("Sono disponibili i seguenti ordini:");
		LabelOrdiniDisponibili.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelOrdiniDisponibili.setBounds(10, 50, 240, 14);
		contentPane.add(LabelOrdiniDisponibili);
		
		JButton ButtonIMieiOrdini = new JButton("I miei ordini");
		ButtonIMieiOrdini.setBounds(589, 447, 100, 23);
		ButtonIMieiOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iMieiOrdini = new JFrameOrdiniRider(cr);
				iMieiOrdini.setVisible(true);
			}
		});
		contentPane.add(ButtonIMieiOrdini);
		
		JButton ButtonLogout = new JButton("Logout");
		ButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.Logout();
				dispose();
			}
		});
		ButtonLogout.setBounds(10, 447, 89, 23);
		contentPane.add(ButtonLogout);
		
		JButton ButtonAggiorna = new JButton("Aggiorna");
		ButtonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aggiornaInterfaccia();
			}
		});
		ButtonAggiorna.setBounds(301, 447, 89, 23);
		contentPane.add(ButtonAggiorna);
		
		getConsegne();
	}
	
	
	public void getConsegne() {
		
		consegneDisponibili = new ArrayList<Consegne>();
		consegneDisponibili = c1.getConsegneDisponibili();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(690, consegneDisponibili.size()*160));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 690, 354);
		contentPane.add(scrollPane);
		
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
					confermaIncarico = new JDialogConfermaIncaricoRider(c.getCodC(), c1, c2);
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

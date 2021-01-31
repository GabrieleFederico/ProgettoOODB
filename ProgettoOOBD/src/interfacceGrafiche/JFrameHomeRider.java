package interfacceGrafiche;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import controllers.ControllerConsegne;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

public class JFrameHomeRider extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ControllerConsegne c1 = new ControllerConsegne();

	public JFrameHomeRider(ControllerConsegne controller) {
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
		
		int y = 0;
		
		ArrayList<Consegne> consegneDisponibili = new ArrayList<Consegne>();
		consegneDisponibili = c1.getConsegneDisponibili();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, consegneDisponibili.size()*100));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for (Consegne c : consegneDisponibili) {
			
			JLabel labelCliccabile = new JLabel("Codice Ordine:" + c.getCodC());
			labelCliccabile.setBounds(50, y, 250, 150);
			pannelloScrollPane.add(labelCliccabile);
			
			labelCliccabile.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
//					Object source = arg0.getSource();
//					JDialog_Conferma
				}
			});

			JLabel labelInformazioni = new JLabel ("<html> Partenza:" + c.getIndirizzoP() + "<br>Arrivo:" + c.getIndirizzoA() + "<br>Orario:" + c.getOrario() + 
					  "<br>Destinatario:" + c.getComposizioneConsegna().getProprietario().getNome() + " " + c.getComposizioneConsegna().getProprietario().getCognome() + "</html>");
			labelInformazioni.setBounds(60, y+45, 250, 150);
			pannelloScrollPane.add(labelInformazioni);
			y=+70;
			
			labelCliccabile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			labelInformazioni.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}
	
	
	
	
	
	
}

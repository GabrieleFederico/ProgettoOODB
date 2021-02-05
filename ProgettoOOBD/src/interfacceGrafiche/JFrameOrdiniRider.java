package interfacceGrafiche;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import classiEntità.Riders;
import controllers.ControllerConsegneUtente;
import controllers.ControllerConsegneRider;
import javax.swing.JLabel;
import javax.swing.JButton;

public class JFrameOrdiniRider extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ArrayList<Consegne> listaConsegne;
	private JDialogConfermaConsegnaOrdine conferma;
	private ControllerConsegneRider ccr;
	private int y = 10;

	public JFrameOrdiniRider(ControllerConsegneRider cr) {
		setTitle("I miei ordini");
		setBounds(100, 100, 734, 508);
		ccr = cr;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelOrdini = new JLabel("Gli ordini presi da lei in carico sono i seguenti:");
		labelOrdini.setBounds(10, 32, 300, 14);
		contentPane.add(labelOrdini);
		
		JButton buttonIndietro = new JButton("Indietro");
		buttonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		buttonIndietro.setBounds(619, 435, 89, 23);
		contentPane.add(buttonIndietro);
		
		getConsegneDaEffettuare(cr);

	}
	
	public void getConsegneDaEffettuare(ControllerConsegneRider controller) {
		
		listaConsegne = controller.getOrdiniByRider();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(690, listaConsegne.size()*140));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 690, 354);
		contentPane.add(scrollPane);
		
		for (Consegne c : listaConsegne) {
			
			JLabel labelConsegna = new JLabel("<html> Codice Ordine:" + c.getCodC() + "<br>Partenza:" + c.getIndirizzoP() + "<br>Arrivo:" + c.getIndirizzoA() + "<br>Orario:" + c.getOrario() + 
					  "<br>Destinatario:" + c.getComposizioneConsegna().getProprietario().getNome() + " " + c.getComposizioneConsegna().getProprietario().getCognome() + "</html>");
			labelConsegna.setBounds(58, y, 150, 110);
			pannelloScrollPane.add(labelConsegna);
			
			JButton bottone = new JButton ("Consegnato");
			bottone.setBounds(258, y+30, 150, 30);
			pannelloScrollPane.add(bottone);
			bottone.addActionListener(new ActionListener() {
				public void  actionPerformed(ActionEvent arg0) {
					conferma = new JDialogConfermaConsegnaOrdine(c.getCodC(), controller);
					conferma.setVisible(true);
				}
			});
			
			y = y+120;
		}
		pannelloScrollPane.updateUI();
		y = 10;
	}

	public void aggiornaInterfaccia() {
		contentPane.remove(scrollPane);
		getConsegneDaEffettuare(ccr);
	}
}

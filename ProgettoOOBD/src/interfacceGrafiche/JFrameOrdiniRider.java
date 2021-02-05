package interfacceGrafiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import classiEntità.Riders;
import controllers.ControllerConsegneUtente;
import controllers.ControllerConsegneRider;
import javax.swing.JLabel;
import javax.swing.JButton;

public class JFrameOrdiniRider extends JFrame {

	private JPanel contentPane;
	private ArrayList<Consegne> listaConsegne;
	private JDialogConfermaConsegnaOrdine conferma;
	private int y = 70;

	public JFrameOrdiniRider(ControllerConsegneRider cr) {
		
		setTitle("I miei ordini");
		setBounds(100, 100, 734, 490);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelOrdini = new JLabel("Gli ordini presi da lei in carico sono i seguenti:");
		LabelOrdini.setBounds(10, 32, 300, 14);
		contentPane.add(LabelOrdini);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		ButtonIndietro.setBounds(619, 417, 89, 23);
		contentPane.add(ButtonIndietro);
		
		getConsegneDaEffettuare(cr);

	}
	
	public void getConsegneDaEffettuare(ControllerConsegneRider controller) {
		
		listaConsegne = controller.getOrdiniByRider();
		
		for (Consegne c : listaConsegne) {
			
			JLabel LabelConsegna = new JLabel("<html> Codice Ordine:" + c.getCodC() + "<br>Partenza:" + c.getIndirizzoP() + "<br>Arrivo:" + c.getIndirizzoA() + "<br>Orario:" + c.getOrario() + 
					  "<br>Destinatario:" + c.getComposizioneConsegna().getProprietario().getNome() + " " + c.getComposizioneConsegna().getProprietario().getCognome() + "</html>");
			LabelConsegna.setBounds(58, y, 150, 110);
			contentPane.add(LabelConsegna);
			
			JButton bottone = new JButton ("Consegnato");
			bottone.setBounds(258, y+30, 150, 30);
			contentPane.add(bottone);
			bottone.addActionListener(new ActionListener() {
				public void  actionPerformed(ActionEvent arg0) {
					conferma = new JDialogConfermaConsegnaOrdine(c.getCodC(), controller);
					conferma.setVisible(true);
				}
			});
			
			y = y+120;
		}
	}

}

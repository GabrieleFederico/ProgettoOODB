package interfacceGrafiche;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classiEntità.Consegne;
import controllers.ControllerRider;
import javax.swing.JLabel;
import javax.swing.JButton;

public class JFrameOrdiniRider extends JFrame {

	private JPanel contentPane;
	private ArrayList<Consegne> listaConsegne = new ArrayList<Consegne>();
	private JDialogConfermaConsegnaOrdine conferma;
	private int y = 70;

	public JFrameOrdiniRider(ControllerRider controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelOrdini = new JLabel("Gli ordini presi da lei in carico sono:");
		LabelOrdini.setBounds(10, 32, 189, 14);
		contentPane.add(LabelOrdini);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.setBounds(619, 417, 89, 23);
		contentPane.add(ButtonIndietro);
		
		getConsegneDaEffettuare(controller);

	}
	
	public void getConsegneDaEffettuare(ControllerRider controller) {
		
		listaConsegne = controller.getOrdiniByRider();
		
		for (Consegne c : listaConsegne) {
			
			JLabel LabelConsegna = new JLabel("<html> Codice Ordine:" + c.getCodC() + "<br>Partenza:" + c.getIndirizzoP() + "<br>Arrivo:" + c.getIndirizzoA() + "<br>Orario:" + c.getOrario() + 
					  "<br>Destinatario:" + c.getComposizioneConsegna().getProprietario().getNome() + " " + c.getComposizioneConsegna().getProprietario().getCognome() + "</html>");
			LabelConsegna.setBounds(58, y, 150, 110);
			contentPane.add(LabelConsegna);
			LabelConsegna.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					conferma = new JDialogConfermaConsegnaOrdine(c.getCodC());
					conferma.setVisible(true);
				}
			});
			
			y = y+120;
		}
	}

}

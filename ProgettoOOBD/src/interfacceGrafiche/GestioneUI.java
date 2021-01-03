package interfacceGrafiche;


import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ControllerRicercaProdotto;

public class GestioneUI {

	private JLabel labelRisultato;
	private ControllerRicercaProdotto a;
	
	public void aggiornaInterfaccia(JPanel pannello, int componentiNecessarie, ArrayList<String> risultatoRicerca) {
		
		int i;
		int max = pannello.getComponentCount();
		
		for(i = max-1; i > componentiNecessarie-1; i--)
			pannello.getComponent(i).setVisible(false);
			
		pannello.updateUI();
		
		int x = 100;
		int y = 130;
		int larg = 184;
		int lung = 26;
		for(String s: risultatoRicerca) {
			labelRisultato = new JLabel(s);
			labelRisultato.setBounds(x, y, larg, lung);
			y += 30;
			pannello.add(labelRisultato);
			labelRisultato.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					a = new ControllerRicercaProdotto(s);
				}
			});
			labelRisultato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
	}
		
	public void TornaHome(JPanel pannello, int componentiNecessarie) {
			
		int i;
		int max = pannello.getComponentCount();
		
		for(i = max-1; i > componentiNecessarie-1; i--)
			pannello.getComponent(i).setVisible(true);
		
		int j = max-1;
		
		while(pannello.getComponent(j) instanceof JLabel) {
			pannello.remove(j);
			j--;
		}
		
		pannello.updateUI();
	}
}

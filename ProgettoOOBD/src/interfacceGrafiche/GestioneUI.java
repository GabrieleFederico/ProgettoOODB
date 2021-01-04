package interfacceGrafiche;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import classiEntità.Prodotto;
import classiEntità.Ristorante;
import controllers.ControllerRicercaMenu;

public class GestioneUI {

	private JLabel labelRisultato;
	private ControllerRicercaMenu a;
	private JSpinner contatore;
	private JButton bottone;

	public void aggiornaInterfacciaRistoranti(JPanel pannello, int componentiNecessarie,
			ArrayList<Ristorante> risultatoRicerca) {

		int i;
		int max = pannello.getComponentCount();

		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.getComponent(i).setVisible(false);

		pannello.updateUI();

		int xNome = 100;
		int yNome = 130;
		int xIndirizzo = 120;
		int yIndirizzo = 145;
		int larg = 185;
		int lung = 20;
		for (Ristorante r : risultatoRicerca) {
			labelRisultato = new JLabel(r.getNome());
			labelRisultato.setBounds(xNome, yNome, larg, lung);
			pannello.add(labelRisultato);
			labelRisultato.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					a = new ControllerRicercaMenu(r);
				}
			});
			labelRisultato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			yNome += 50;
			labelRisultato = new JLabel(r.getIndirizzo());
			labelRisultato.setBounds(xIndirizzo, yIndirizzo, larg, lung);
			pannello.add(labelRisultato);
			yIndirizzo += 50;
		}
	}

	public void TornaHome(JPanel pannello, int componentiNecessarie) {

		int i;
		int max = pannello.getComponentCount();

		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.getComponent(i).setVisible(true);

		int j = max - 1;

		while (pannello.getComponent(j) instanceof JLabel) {
			pannello.remove(j);
			j--;
		}

		pannello.updateUI();
	}

	public void aggiornaInterfacciaProdotti(JPanel pannello, int componentiNecessarie,
			ArrayList<Prodotto> risultatoRicerca) {

		int i;
		int max = pannello.getComponentCount();

		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.remove(i);

		pannello.updateUI();

		int x = 100;
		int y = 130;
		int larg = 185;
		int lung = 20;

		for (Prodotto p : risultatoRicerca) {
			labelRisultato = new JLabel(p.getNomeP());
			labelRisultato.setBounds(x, y, larg, lung);
			pannello.add(labelRisultato);

			contatore = new JSpinner();
			contatore.setBounds(x + 250, y, 40, 20);
			pannello.add(contatore);
			bottone = new JButton("Aggiungi al carrello");
			bottone.setBounds(x + 350, y, 200, 20);
			pannello.add(bottone);
			y += 50;

		}
	}
}

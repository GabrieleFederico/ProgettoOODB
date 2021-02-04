package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import classiEntit�.Consegne;
import classiEntit�.Prodotto;
import classiEntit�.Utente;
import controllers.ControllerConsegne;

public class JFrameOrdiniUtente extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel ordine;
	private JButton dettagliOrdine;
	private ArrayList<JButton> bottoni = new ArrayList<JButton>();
	private ArrayList<Consegne> ordini;
	
	public JFrameOrdiniUtente(ControllerConsegne co, Utente u) {

		setTitle("I Miei Ordini");
		setBounds(100, 100, 649, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ordini = co.getOrdiniByUtente(u);
		
		int y = 25;
		int lung = 50;
		int larg = 185;
		int xLabel = 100;
		int xBottone = 400;
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, ordini.size()*52));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for(Consegne o : ordini) {
			
			if(o.isConsegnato()) {
				ordine = new JLabel("<html>Ordine numero: " + o.getCodC() + "<br>" + "Consegnato alle: " + o.getOrario() + "</html>");
			}
			else {
				ordine = new JLabel("<html>Ordine numero: " + o.getCodC() + "<br>" + "Non ancora consegnato" + "</html>");
			}
			
			
			ordine.setBounds(xLabel, y, larg, lung);
			
			pannelloScrollPane.add(ordine);

			dettagliOrdine = new JButton("Dettagli Ordine");
			dettagliOrdine.setBounds(xBottone, y, 150, 20);
			
			dettagliOrdine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton) arg0.getSource();
					co.apriDettagli(ordini.get(bottoni.indexOf(source)));
				}
			});
			pannelloScrollPane.add(dettagliOrdine);

			y += 70;
			
			bottoni.add(dettagliOrdine);

		}
		

	}

}

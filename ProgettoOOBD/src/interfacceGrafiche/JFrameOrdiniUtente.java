package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import classiEntitą.Consegne;
import classiEntitą.Prodotto;
import classiEntitą.Utente;
import controllers.ControllerOrdini;

public class JFrameOrdiniUtente extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel ordine;
	private JButton dettagliOrdine;
	private ArrayList<Consegne> ordini;
	
	public JFrameOrdiniUtente(ControllerOrdini co) {

		setBounds(100, 100, 649, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ordini = co.getOrdiniByUtente();
		
		int y = 25;
		int lung = 20;
		int index = 0;
		int larg = 185;
		int xLabel = 100;
		double totale = 0;
		int xBottone = 400;
		int xLabelPrezzo = 260;	
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, ordini.size()*50));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for(Consegne o : ordini) {
			
			ordine = new JLabel(o.getCodC());
			ordine.setBounds(xLabel, y, larg, lung);
			pannelloScrollPane.add(ordine);

			dettagliOrdine = new JButton("Dettagli Ordine");
			dettagliOrdine.setBounds(xBottone, y, 150, lung);
			
			dettagliOrdine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				}
			});
			pannelloScrollPane.add(dettagliOrdine);

			y += 50;

		}
		

	}

}

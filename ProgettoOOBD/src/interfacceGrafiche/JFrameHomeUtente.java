package interfacceGrafiche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classiEntitą.Ristoranti;
import classiEntitą.Utenti;
import controllers.ControllerRicercaRistoranti;
import controllers.ControllerPrincipale;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JFrameHomeUtente extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	private JScrollPane scrollPane;
	private ControllerPrincipale controllore;

	public JFrameHomeUtente(ControllerRicercaRistoranti c, ControllerPrincipale c1, Utenti utente) {
		setTitle("Home");
		controllore = c1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputTF = new JTextField();
		inputTF.setBounds(23, 11, 332, 28);
		contentPane.add(inputTF);
		inputTF.setColumns(10);

		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.logout();
				dispose();
			}
		});
		logOutButton.setBounds(10, 433, 89, 28);
		contentPane.add(logOutButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TornaHome(contentPane, componentiNecessarie);
				homeButton.setEnabled(false);
			}
		});
		homeButton.setEnabled(false);
		homeButton.setBounds(324, 435, 89, 25);
		contentPane.add(homeButton);

		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TFInput = inputTF.getText();
					
				aggiornaInterfacciaRistoranti(contentPane, componentiNecessarie, c.ricerca(TFInput));	
				homeButton.setEnabled(true);
			}
		});
		cercaButton.setBounds(365, 11, 120, 28);
		contentPane.add(cercaButton);

		JButton iMieiOrdiniButton = new JButton("I miei ordini");
		iMieiOrdiniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllore.apriOrdini(utente);
			}
		});
		iMieiOrdiniButton.setBounds(625, 12, 118, 27);
		contentPane.add(iMieiOrdiniButton);

		JButton carrelloButton = new JButton("Carrello");
		carrelloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllore.apriCarrello(c);
			}
		});
		carrelloButton.setBounds(625, 434, 118, 26);
		contentPane.add(carrelloButton);

		componentiNecessarie = contentPane.getComponentCount();
		
		JButton paniniButton = new JButton("Panini");
		paniniButton.setBounds(10, 160, 215, 163);
		contentPane.add(paniniButton);

		JButton pizzaButton = new JButton("Pizza");
		pizzaButton.setBounds(270, 160, 215, 163);
		contentPane.add(pizzaButton);

		JButton sushiButton = new JButton("Sushi");
		sushiButton.setBounds(528, 160, 215, 163);
		contentPane.add(sushiButton);

		sushiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aggiornaInterfacciaRistoranti(contentPane, componentiNecessarie, c.ricerca("Sushi"));
				homeButton.setEnabled(true);
		
			}
		});

		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aggiornaInterfacciaRistoranti(contentPane, componentiNecessarie, c.ricerca("Pizz"));
				homeButton.setEnabled(true);

			}
		});

		paniniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aggiornaInterfacciaRistoranti(contentPane, componentiNecessarie, c.ricerca("Panin"));
				homeButton.setEnabled(true);

			}
		});
	}
	
	public void aggiornaInterfacciaRistoranti(JPanel pannello, int componentiNecessarie, ArrayList<Ristoranti> risultatoRicerca) {

		JLabel labelRisultato;
		
		int i;
		int max = pannello.getComponentCount();
		
		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.getComponent(i).setVisible(false);

		pannello.updateUI();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(new BoxLayout(pannelloScrollPane, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane(pannelloScrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for (Ristoranti r : risultatoRicerca) {
			
			labelRisultato = new JLabel(r.getNome());
			labelRisultato.setBorder(new EmptyBorder(0, 60, 0, 0));
			pannelloScrollPane.add(labelRisultato);
			
			labelRisultato.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					controllore.passaAInterfacciaRistorante(r);
				}
			});
			labelRisultato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			labelRisultato = new JLabel(r.getIndirizzo());
			labelRisultato.setBorder(new EmptyBorder(0, 70, 30, 0));
			pannelloScrollPane.add(labelRisultato);	
		}
		pannelloScrollPane.updateUI();
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
		scrollPane.removeAll();
		pannello.updateUI();
		scrollPane.setVisible(false);
	}
}

package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import classiEntit‡.Carrello;
import classiEntit‡.Prodotto;
import classiEntit‡.Ristorante;
import controllers.ControllerCarrello;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JFrameCarrello extends JFrame {

	private JPanel contentPane;
	private ControllerCarrello controller;
	private int componentiNecessarie;
	private Carrello carrello;

	public JFrameCarrello(ControllerCarrello c) {
		controller = c;
		setBounds(100, 100, 716, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelCarrello = new JLabel("Carrello");
		LabelCarrello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCarrello.setBounds(320, 11, 140, 14);
		contentPane.add(LabelCarrello);
		
		JButton ButtonPaga = new JButton("Paga");
		ButtonPaga.setBounds(601, 413, 89, 23);
		contentPane.add(ButtonPaga);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ButtonIndietro.setBounds(10, 413, 89, 23);
		contentPane.add(ButtonIndietro);
		
		componentiNecessarie = contentPane.getComponentCount();
		
		carrello = controller.ottieniCarrello();
		setVisible(true);
		
	}
	
	public JPanel getPannello() {
		return contentPane;
	}
	
	public int getComponentiNecessarie() {
		return componentiNecessarie;
	}
	
	public void aggiornaInterfacciaCarrello() {
		
		JLabel prodottoNelCarrello;
		JButton bottone;
		JSpinner contatore;
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		ArrayList<JButton> bottoni = new ArrayList<JButton>();
		ArrayList<JSpinner> contatori = new ArrayList<JSpinner>();

		
		int xLabel = 100;
		int xBottone = 300;
		int xSpinner = 250;
		int y = 130;
		int larg = 185;
		int lung = 20;
		
		for(Prodotto p : carrello.getProdotti()) {
			
			prodottoNelCarrello = new JLabel(p.getNomeP());
			prodottoNelCarrello.setBounds(xLabel, y, larg, lung);
			contentPane.add(prodottoNelCarrello);

			bottone = new JButton("Rimuovi");
			bottone.setBounds(xBottone, y, 150, lung);

			bottone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton) arg0.getSource();
					controller.rimuoviDalCarrello(carrello, bottoni.indexOf(source));
					contentPane.remove(labels.get(bottoni.indexOf(source)));
					contentPane.remove(contatori.get(bottoni.indexOf(source)));
					contentPane.remove(source);
					carrello.getProdotti().remove(bottoni.indexOf(source));
					contentPane.updateUI();
					labels.remove(bottoni.indexOf(source));
					contatori.remove(bottoni.indexOf(source));
					spostamentoVersoAlto(labels, contatori, bottoni, bottoni.indexOf(source));
					bottoni.remove(source);
				}
			});
			contentPane.add(bottone);

			contatore = new JSpinner();
			contatore.setBounds(xSpinner, y, 35, 20);
			contatore.setModel(new SpinnerNumberModel(carrello.getQuantit‡Prodotti().get(carrello.getProdotti().indexOf(p)), 0, null, 1));
			contatore.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					//TODO
					controller.rimuoviParzialmenteDalCarrello();
				}
			});
			
			contentPane.add(contatore);
			
			y += 50;
			labels.add(prodottoNelCarrello);
			bottoni.add(bottone);
			contatori.add(contatore);
		}

	}

	public void spostamentoVersoAlto(ArrayList<JLabel> labels, ArrayList<JSpinner> contatori, ArrayList<JButton> bottoni, int indice){
		for(int i = indice; indice<labels.size(); indice++) {
			System.out.println(labels.size());
			labels.get(i).setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}
}

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
import controllers.ControllerRicercaMenu;
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
import javax.swing.JScrollPane;

public class JFrameCarrello extends JFrame {

	private JPanel contentPane;
	private ControllerCarrello controller;
	private int componentiNecessarie;
	private Carrello carrello;
	private ControllerRicercaMenu controllerMenu;

	public JFrameCarrello(ControllerCarrello c) {
		controller = c;
		setBounds(100, 100, 716, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelCarrello = new JLabel("Carrello");
		LabelCarrello.setBounds(298, 11, 55, 20);
		contentPane.add(LabelCarrello);
		LabelCarrello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton ButtonPaga = new JButton("Paga");
		ButtonPaga.setBounds(587, 389, 80, 23);
		contentPane.add(ButtonPaga);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.setBounds(21, 389, 89, 23);
		contentPane.add(ButtonIndietro);
		
		JLabel LabelTotale = new JLabel("Totale:");
		LabelTotale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelTotale.setBounds(553, 364, 80, 14);
		contentPane.add(LabelTotale);
		
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
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
		ArrayList<Double> prezziArticoli = new ArrayList<Double>();

		
		int xLabel = 100;
		int xLabelPrezzo = 280;
		int xBottone = 400;
		int xSpinner = 350;
		int y = 100;
		int larg = 185;
		int lung = 20;
		int index = 0;
		
		for(Prodotto p : carrello.getProdotti()) {
			
			prodottoNelCarrello = new JLabel(p.getNomeP());
			prodottoNelCarrello.setBounds(xLabel, y, larg, lung);
			contentPane.add(prodottoNelCarrello);

			bottone = new JButton("Rimuovi");
			bottone.setBounds(xBottone, y, 150, lung);
			
			prezziArticoli = controller.getPrezzi(carrello);
			JLabel prezzo = new JLabel(prezziArticoli.get(index).toString() + "Ä");
			prezzo.setBounds(xLabelPrezzo, y, larg, lung);
			contentPane.add(prezzo);
			index++;
			
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
		
		Double totale = getTotale(contatori, prezziArticoli);
		JLabel totaleDaPagare = new JLabel(totale.toString());
		totaleDaPagare.setBounds(600, 364, 80, 14);
		contentPane.add(totaleDaPagare);

	}

	public void spostamentoVersoAlto(ArrayList<JLabel> labels, ArrayList<JSpinner> contatori, ArrayList<JButton> bottoni, int indice){
		
		int i;
		
		for(i = indice; i < labels.size(); i++) {
			labels.get(i).setBounds(labels.get(i).getX(), labels.get(i).getY()-50, labels.get(i).getWidth(), labels.get(i).getHeight());
		}
		
		for(i = indice; i < contatori.size(); i++) {
			contatori.get(i).setBounds(contatori.get(i).getX(), contatori.get(i).getY()-50, contatori.get(i).getWidth(), contatori.get(i).getHeight());
		}
		
		for(i = indice+1; i < bottoni.size(); i++) {
			bottoni.get(i).setBounds(bottoni.get(i).getX(), bottoni.get(i).getY()-50, bottoni.get(i).getWidth(), bottoni.get(i).getHeight());
		}
		
	}
	
	public Double getTotale(ArrayList<JSpinner> contatori, ArrayList<Double> prezziArticoli) {
		double risultato = 0;
		int i;
		
		for (i=0; i < contatori.size(); i++) {
			risultato = risultato + (prezziArticoli.get(i) * (int) contatori.get(i).getValue());
		}
		return risultato;
	}
}

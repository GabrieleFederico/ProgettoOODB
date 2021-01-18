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
import classiEntità.Carrello;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
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
		
		JLabel prodottoNelCarrello, prezzo;
		JButton bottone;
		JSpinner contatore;
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		ArrayList<JButton> bottoni = new ArrayList<JButton>();
		ArrayList<JLabel> prezziJLabel = new ArrayList<JLabel>();
		ArrayList<JSpinner> contatori = new ArrayList<JSpinner>();
		ArrayList<Double> prezziArticoli = new ArrayList<Double>();
		ArrayList<Integer> quantitàProdotti = new ArrayList<Integer>();
//		ArrayLisy<Double> 

		int y = 100;
		int lung = 20;
		int index = 0;
		int larg = 185;
		int xLabel = 100;
		double totale = 0;
		int xBottone = 400;
		int xSpinner = 350;
		int xLabelPrezzo = 260;	
		JLabel totaleDaPagare = new JLabel();
		String stringaRisultato = new String();
		
		prezziArticoli = controller.getPrezzi(carrello);
		quantitàProdotti = controller.ottieniCarrello().getQuantitàProdotti();
		
		for(Prodotto p : carrello.getProdotti()) {
			
			prodottoNelCarrello = new JLabel(p.getNomeP());
			prodottoNelCarrello.setBounds(xLabel, y, larg, lung);
			contentPane.add(prodottoNelCarrello);

			bottone = new JButton("Rimuovi");
			bottone.setBounds(xBottone, y, 150, lung);
			
			prezzo = new JLabel(prezziArticoli.get(index) * quantitàProdotti.get(index) + "€");
			prezzo.setBounds(xLabelPrezzo, y, larg, lung);
			contentPane.add(prezzo);
			prezziJLabel.add(prezzo);
			
			double prezzoSingolo = Double.parseDouble(prezzo.getText().substring(0, prezzo.getText().indexOf("€")));
			
			bottone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton) arg0.getSource();
					controller.rimuoviDalCarrello(carrello, bottoni.indexOf(source));
					contentPane.remove(prezziJLabel.get(bottoni.indexOf(source)));
					contentPane.remove(labels.get(bottoni.indexOf(source)));
					contentPane.remove(contatori.get(bottoni.indexOf(source)));
					contentPane.remove(source);
					carrello.getProdotti().remove(bottoni.indexOf(source));
					contentPane.updateUI();
					
					prezziJLabel.remove(bottoni.indexOf(source));
					labels.remove(bottoni.indexOf(source));
					contatori.remove(bottoni.indexOf(source));
					spostamentoVersoAlto(labels, contatori, bottoni, bottoni.indexOf(source), prezziJLabel);
					
					bottoni.remove(source);
				}
			});
			contentPane.add(bottone);
			final int i = index; 
			final double prezzoArticoloSingolo = prezziArticoli.get(i);

			contatore = new JSpinner();
			contatore.setBounds(xSpinner, y, 35, 20);
			contatore.setModel(new SpinnerNumberModel(carrello.getQuantitàProdotti().get(carrello.getProdotti().indexOf(p)), 1, null, 1));
			contatore.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					String nomeProdotto = p.getNomeP();
					int nuovoValore = (int) contatori.get(i).getValue();
					controller.ModificaQuantitàCarrello(nuovoValore, carrello, nomeProdotto);
					prezziJLabel.get(i).setText((prezzoArticoloSingolo * nuovoValore + "€"));
					String bla = String.valueOf(getPrezzoTotale(prezziJLabel));
					totaleDaPagare.setText(bla);
					contentPane.updateUI();
				}
			});
			
			contentPane.add(contatore);
			
			y += 50;
			labels.add(prodottoNelCarrello);
			bottoni.add(bottone);
			contatori.add(contatore);			
			index++;
		}
		
		totale = getPrezzoTotale(prezziJLabel);
		stringaRisultato = String.valueOf(totale);
		totaleDaPagare.setText(stringaRisultato);
		totaleDaPagare.setBounds(600, 364, 80, 14);
		contentPane.add(totaleDaPagare);
	}
	
	
	public void spostamentoVersoAlto(ArrayList<JLabel> labels, ArrayList<JSpinner> contatori, ArrayList<JButton> bottoni, int indice, ArrayList<JLabel> prezziJLabel){
		
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
		
		for(i = indice; i < prezziJLabel.size(); i++) {
			prezziJLabel.get(i).setBounds(prezziJLabel.get(i).getX(), prezziJLabel.get(i).getY()-50, prezziJLabel.get(i).getWidth(), prezziJLabel.get(i).getHeight());
		}
		
	}
	
	public double getPrezzoTotale (ArrayList<JLabel> prezziJLabel) {
		
		double totale = 0;
		
		for (JLabel j : prezziJLabel) {
			double temp = Double.parseDouble(j.getText().substring(0, j.getText().indexOf("€")));
			totale = totale + temp;
		}
		return totale;
	}
}

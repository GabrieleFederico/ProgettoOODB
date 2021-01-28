package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import classiEntità.Carrello;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
import controllers.ControllerCarrello;
import controllers.ControllerRicercaMenu;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;

public class JFrameCarrello extends JFrame {

	private JPanel contentPane;
	private ControllerCarrello controller;
	private int componentiNecessarie;
	private Carrello carrello;
	private JScrollPane scrollPane;
	private ControllerRicercaMenu controllerMenu;
	private JDialogCassa cassa;
	ArrayList<Ristorante> listaRistoranti = new ArrayList<Ristorante>();

	public JFrameCarrello(ControllerCarrello c) {
		controller = c;
		setBounds(100, 100, 813, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelCarrello = new JLabel("Carrello");
		LabelCarrello.setBounds(372, 11, 55, 20);
		contentPane.add(LabelCarrello);
		LabelCarrello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton ButtonCassa = new JButton("Vai alla cassa");
		ButtonCassa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cassa = new JDialogCassa();
				cassa.setVisible(true);
			}
		});
		ButtonCassa.setBounds(594, 446, 136, 23);
		contentPane.add(ButtonCassa);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.setBounds(24, 446, 89, 23);
		contentPane.add(ButtonIndietro);
		
		JLabel LabelTotale = new JLabel("Totale:");
		LabelTotale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelTotale.setBounds(594, 430, 80, 14);
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
		
		JLabel prodottoNelCarrello, prezzo, provenienza;
		JButton bottone;
		JSpinner contatore;
		ArrayList<JLabel> nomiArticoliJLabel = new ArrayList<JLabel>();
		ArrayList<JButton> bottoni = new ArrayList<JButton>();
		ArrayList<JLabel> prezziJLabel = new ArrayList<JLabel>();
		ArrayList<JSpinner> contatori = new ArrayList<JSpinner>();
		ArrayList<Double> prezziArticoli = new ArrayList<Double>();
		ArrayList<Integer> quantitàProdotti = new ArrayList<Integer>();
		ArrayList<JLabel> labelsNomiRistoranti = new ArrayList<JLabel>();

		int y = 10;
		int lung = 20;
		int index = 0;
		int larg = 185;
		int xLabel = 100;
		double totale = 0;
		int xBottone = 400;
		int xSpinner = 350;
		int xLabelPrezzo = 260;	
		String nomeRistorante = new String();
		JLabel totaleDaPagare = new JLabel();
		String stringaRisultato = new String();
		
		prezziArticoli = controller.getPrezzi(carrello);
		quantitàProdotti = controller.ottieniCarrello().getQuantitàProdotti();
		listaRistoranti = controller.ottieniCarrello().getProvenienzaProdotti();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, carrello.getProdotti().size()*75));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		
		for(Prodotto p : carrello.getProdotti()) {
 
			provenienza = new JLabel(listaRistoranti.get(index).getNome());
			
			if (!Objects.equals(nomeRistorante, provenienza.getText())){
				provenienza.setBounds(xLabel-60, y, larg, lung);
				pannelloScrollPane.add(provenienza);
				nomeRistorante = provenienza.getText();
				y += 40;
				labelsNomiRistoranti.add(provenienza);
			}
			
			prodottoNelCarrello = new JLabel(p.getNomeP());
			prodottoNelCarrello.setBounds(xLabel, y, larg, lung);
			pannelloScrollPane.add(prodottoNelCarrello);

			bottone = new JButton("Rimuovi");
			bottone.setBounds(xBottone, y, 150, lung);
			
			prezzo = new JLabel(prezziArticoli.get(index) * quantitàProdotti.get(index) + "€");
			prezzo.setBounds(xLabelPrezzo, y, larg, lung);
			pannelloScrollPane.add(prezzo);
			prezziJLabel.add(prezzo);
			
			bottone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton) arg0.getSource();

					boolean prodottiInRistorante = controller.rimuoviDalCarrello(carrello, bottoni.indexOf(source));
					pannelloScrollPane.remove(prezziJLabel.get(bottoni.indexOf(source)));
					pannelloScrollPane.remove(nomiArticoliJLabel.get(bottoni.indexOf(source)));
					pannelloScrollPane.remove(contatori.get(bottoni.indexOf(source)));
					pannelloScrollPane.remove(source);
					carrello.getProdotti().remove(bottoni.indexOf(source));
					
					Ristorante temp = carrello.getProvenienzaProdotti().get(bottoni.indexOf(source));
					carrello.getProvenienzaProdotti().remove(bottoni.indexOf(source));
					
					if(!prodottiInRistorante) {
						for(JLabel l : labelsNomiRistoranti) {
							if(l.getText().equals(temp.getNome())) {
								pannelloScrollPane.remove(labelsNomiRistoranti.get(labelsNomiRistoranti.indexOf(l)));
								labelsNomiRistoranti.remove(l);
								break;
							}
						}
					}
					
					prezziJLabel.remove(bottoni.indexOf(source));
					nomiArticoliJLabel.remove(bottoni.indexOf(source));
					contatori.remove(bottoni.indexOf(source));
					spostamentoVersoAlto(nomiArticoliJLabel, contatori, bottoni, bottoni.indexOf(source), prezziJLabel, labelsNomiRistoranti, prodottiInRistorante);
					
					bottoni.remove(source);
					String nuovoPrezzoTotale = String.valueOf(getPrezzoTotale(prezziJLabel));
					totaleDaPagare.setText(nuovoPrezzoTotale);
					
					contentPane.updateUI();
					pannelloScrollPane.updateUI();
				}
			});
			pannelloScrollPane.add(bottone);
			final int i = index; 
			final double prezzoArticoloSingolo = prezziArticoli.get(i);

			contatore = new JSpinner();
			contatore.setBounds(xSpinner, y, 35, 20);
			contatore.setModel(new SpinnerNumberModel(carrello.getQuantitàProdotti().get(carrello.getProdotti().indexOf(p)), 1, null, 1));
			contatore.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					JSpinner source = (JSpinner) e.getSource();
					String nomeProdotto = p.getNomeP();
					int nuovoValore = (int) contatori.get(contatori.indexOf(source)).getValue();
					controller.ModificaQuantitàCarrello(nuovoValore, carrello, nomeProdotto);
					prezziJLabel.get(contatori.indexOf(source)).setText((prezzoArticoloSingolo * nuovoValore + "€"));
					String nuovoPrezzoTotale = String.valueOf(getPrezzoTotale(prezziJLabel));
					totaleDaPagare.setText(nuovoPrezzoTotale);
					pannelloScrollPane.updateUI();
				}
			});
			
			pannelloScrollPane.add(contatore);
			
			y += 40;
			nomiArticoliJLabel.add(prodottoNelCarrello);
			bottoni.add(bottone);
			contatori.add(contatore);			
			index++;
		}
		
		totale = getPrezzoTotale(prezziJLabel);
		stringaRisultato = String.valueOf(totale);
		totaleDaPagare.setText(stringaRisultato);
		totaleDaPagare.setBounds(640, 430, 80, 14);
		contentPane.add(totaleDaPagare);
	}
	
	
	public void spostamentoVersoAlto(ArrayList<JLabel> labels, ArrayList<JSpinner> contatori, ArrayList<JButton> bottoni, int indice, ArrayList<JLabel> prezziJLabel,
			ArrayList<JLabel> labelsNomiRistoranti, boolean prodottiInRistorante){
		
		int i;
		int value;
		
		if(prodottiInRistorante) 
			value = 40;
		else
			value = 80;
		
		for(i = indice; i < labels.size(); i++) {
			labels.get(i).setBounds(labels.get(i).getX(), labels.get(i).getY()-value, labels.get(i).getWidth(), labels.get(i).getHeight());
		}
		
		for(i = indice; i < contatori.size(); i++) {
			contatori.get(i).setBounds(contatori.get(i).getX(), contatori.get(i).getY()-value, contatori.get(i).getWidth(), contatori.get(i).getHeight());
		}
		
		for(i = indice+1; i < bottoni.size(); i++) {
			bottoni.get(i).setBounds(bottoni.get(i).getX(), bottoni.get(i).getY()-value, bottoni.get(i).getWidth(), bottoni.get(i).getHeight());
		}
		
		for(i = indice; i < prezziJLabel.size(); i++) {
			prezziJLabel.get(i).setBounds(prezziJLabel.get(i).getX(), prezziJLabel.get(i).getY()-value, prezziJLabel.get(i).getWidth(), prezziJLabel.get(i).getHeight());
		}
		
		JLabel temp = new JLabel(listaRistoranti.get(indice).getNome());
		int k = labelsNomiRistoranti.indexOf(temp);
		
		for(i = k+1; i < labelsNomiRistoranti.size(); i++) {
			labelsNomiRistoranti.get(i).setBounds(labelsNomiRistoranti.get(i).getX(), labelsNomiRistoranti.get(i).getY()-value, labelsNomiRistoranti.get(i).getWidth(), labelsNomiRistoranti.get(i).getHeight());
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

package interfacceGrafiche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
import controllers.ControllerCarrello;
import controllers.ControllerRicercaMenu;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class JFrameRistorante extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	ControllerRicercaMenu controller;
	
	public JFrameRistorante(ControllerRicercaMenu c, Ristorante r) {
		setTitle(r.getNome());
		controller = c;
		setBounds(100, 100, 769, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputTF = new JTextField();
		inputTF.setBounds(23, 11, 311, 28);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		JComboBox<String> FasciaPrezzo = new JComboBox<String>();
		FasciaPrezzo.setBounds(362, 11, 191, 28);
		FasciaPrezzo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selezionare fascia di prezzo", "0-5", "5-10", "10-20"}));
		contentPane.add(FasciaPrezzo);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.setBounds(583, 11, 89, 28);
		CercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TFInput = inputTF.getText();
				String PrezzoInput = null;
				
				if(FasciaPrezzo.getSelectedIndex() != 0)
					PrezzoInput = FasciaPrezzo.getSelectedItem().toString();
					
				try {
					c.RicercaProdotto(TFInput, contentPane, componentiNecessarie, PrezzoInput);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		contentPane.add(CercaButton);
		
		componentiNecessarie = contentPane.getComponentCount();
		c.getMenu(r, contentPane, componentiNecessarie, this);
		
	}
	

	public void aggiornaInterfacciaProdotti(JPanel pannello, int componentiNecessarie, Menu risultatoRicerca, ControllerCarrello cc) {

		JLabel labelRisultato;
		JSpinner contatore;
		JButton bottone;
		
		int i;
		int max = pannello.getComponentCount();

		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.remove(i);

		pannello.updateUI();

		int x = 100;
		int y = 130;
		int larg = 185;
		int lung = 20;
		int index = 0;
		ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();

		for (Prodotto p : risultatoRicerca.getProdotti()) {
			labelRisultato = new JLabel(p.getNomeP());
			labelRisultato.setBounds(x, y, larg, lung);
			pannello.add(labelRisultato);

			contatore = new JSpinner();
			contatore.setBounds(x + 250, y, 40, 20);
			contatore.setModel(new SpinnerNumberModel(1, 1, null, 1));
			pannello.add(contatore);
			spinners.add(contatore);
			bottone = new JButton("Aggiungi al carrello");
			bottone.setBounds(x + 350, y, 200, 20);
			pannello.add(bottone);
			final int riga = index;
	
			ArrayList<Double> prezziArticoli = risultatoRicerca.getPrezzi();
			JLabel prezzo = new JLabel(prezziArticoli.get(index).toString() + "€");
			prezzo.setBounds(x + 200, y, larg, lung);
			pannello.add(prezzo);
			y += 50;
			index++;
			
			bottone.addActionListener(new ActionListener() {
				public void  actionPerformed(ActionEvent arg0) {
					String nomep = risultatoRicerca.getProdotti().get(riga).getNomeP();
					int quantità = (int) spinners.get(riga).getValue();
					double prezzi = prezziArticoli.get(riga).doubleValue();
					cc.aggiungiAlCarrello(nomep, quantità, prezzi);
				}
			});
			
		}
		
	
	}
}

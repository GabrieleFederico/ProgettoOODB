package interfacceGrafiche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import classiEntità.Menù;
import classiEntità.Prodotti;
import classiEntità.Ristoranti;
import controllers.ControllerCarrello;
import controllers.ControllerRicercaMenu;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class JFrameRistorante extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	private Ristoranti rist;
	
	public JFrameRistorante(ControllerRicercaMenu c, Ristoranti r) {
		setTitle(r.getNome());
		rist = r;
		setBounds(100, 100, 769, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputTF = new JTextField();
		inputTF.setBounds(23, 11, 311, 28);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		JComboBox<String> fasciaPrezzo = new JComboBox<String>();
		fasciaPrezzo.setBounds(362, 11, 191, 28);
		fasciaPrezzo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selezionare fascia di prezzo", "0-5", "5-10", "10-20"}));
		contentPane.add(fasciaPrezzo);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.setBounds(583, 11, 89, 28);
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TFInput = inputTF.getText();
				String PrezzoInput = null;
				
				if(fasciaPrezzo.getSelectedIndex() != 0)
					PrezzoInput = fasciaPrezzo.getSelectedItem().toString();
					
				try {
					c.ricercaProdotto(TFInput, contentPane, componentiNecessarie, PrezzoInput);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		contentPane.add(cercaButton);
		
		componentiNecessarie = contentPane.getComponentCount();
		c.getMenu(r, contentPane, componentiNecessarie, this);
		
	}
	
	
	public void aggiornaInterfacciaProdotti(JPanel pannello, int componentiNecessarie, Menù risultatoRicerca, ControllerCarrello cc) {

		JLabel labelRisultato;
		JSpinner contatore;
		JButton bottone;
		JScrollPane scrollPane;
		
		int i;
		int max = pannello.getComponentCount();

		for (i = max - 1; i > componentiNecessarie - 1; i--)
			pannello.remove(i);

		pannello.updateUI();
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, risultatoRicerca.getProdotti().size()*50));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);

		int x = 100;
		int y = 10;
		int larg = 185;
		int lung = 20;
		int index = 0;
		ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();

		for (Prodotti p : risultatoRicerca.getProdotti()) {
			labelRisultato = new JLabel(p.getNomeP());
			labelRisultato.setBounds(x, y, larg, lung);
			pannelloScrollPane.add(labelRisultato);
			
			contatore = new JSpinner();
			contatore.setBounds(x + 250, y, 40, 20);
			contatore.setModel(new SpinnerNumberModel(1, 1, null, 1));
			pannelloScrollPane.add(contatore);
			spinners.add(contatore);
			bottone = new JButton("Aggiungi al carrello");
			bottone.setBounds(x + 350, y, 200, 20);
			pannelloScrollPane.add(bottone);
	
			ArrayList<Double> prezziArticoli = risultatoRicerca.getPrezzi();
			JLabel prezzo = new JLabel(prezziArticoli.get(index).toString() + "€");
			prezzo.setBounds(x + 200, y, larg, lung);
			pannelloScrollPane.add(prezzo);
			final int riga = index;
			
			bottone.addActionListener(new ActionListener() {
				public void  actionPerformed(ActionEvent arg0) {
					String nomep = risultatoRicerca.getProdotti().get(riga).getNomeP();
					int quantità = (int) spinners.get(riga).getValue();
					double prezzi = prezziArticoli.get(riga).doubleValue();
					cc.aggiungiAlCarrello(nomep, quantità, prezzi, rist);
				}
			});
			index++;
			y += 50;
		}
		
	
	}
}

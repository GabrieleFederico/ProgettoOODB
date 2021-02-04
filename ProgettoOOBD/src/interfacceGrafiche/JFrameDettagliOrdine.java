package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Prodotti;

public class JFrameDettagliOrdine extends JFrame {

	private JLabel prodotto;
	private JLabel prezzo;
	private JPanel contentPane;
	private JScrollPane scrollPane;

	public JFrameDettagliOrdine(Carrello carrello) {
		
		setTitle("Dettagli Ordine");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, carrello.getProdotti().size()*50));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
		JLabel ristorante = new JLabel(carrello.getProvenienzaProdotti().get(0).getNome() + "    " + carrello.getProvenienzaProdotti().get(0).getIndirizzo());
		ristorante.setBounds(5, -20, 300, 100);
		
		pannelloScrollPane.add(ristorante);
		
		int y = 10;
		
		for(Prodotti p : carrello.getProdotti()) {
			
			prodotto = new JLabel(p.getNomeP());
			prezzo = new JLabel(carrello.getPrezzi().get(carrello.getProdotti().indexOf(p)).toString()+ "€");
			prodotto.setBounds(100, y, 100, 100);
			prezzo.setBounds(250, y, 100, 100);
			pannelloScrollPane.add(prezzo);
			pannelloScrollPane.add(prodotto);
			
			y += 30;
		}
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}

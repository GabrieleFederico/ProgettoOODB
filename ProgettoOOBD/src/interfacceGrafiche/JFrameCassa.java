package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntità.Carrello;
import classiEntità.Ristorante;
import controllers.ControllerCarrello;
import controllers.ControllerConsegne;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameCassa extends JFrame {

	private JPanel contentPanel = new JPanel();
	private ControllerCarrello cc;
	private ConclusioneOrdine co;

	public JFrameCassa(double totale, ControllerCarrello c, Carrello carrello, ControllerConsegne cor, ArrayList<Ristorante> listaRistoranti) {
		
		setTitle("Pagamento");
		setBounds(150, 150, 510, 273);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JComboBox<String> comboBoxMezzo = new JComboBox<String>();
		comboBoxMezzo.setModel(new DefaultComboBoxModel<String>(new String[] { "Nessuna preferenza", "Automobile", "Moto", "Bici" }));
		comboBoxMezzo.setBounds(95, 93, 125, 22);
		contentPanel.add(comboBoxMezzo);
		
		JComboBox<String> comboBoxOrario = new JComboBox<String>();
		comboBoxOrario.setMaximumRowCount(4);
		comboBoxOrario.setModel(new DefaultComboBoxModel<String>(new String[] {"19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"}));
		comboBoxOrario.setBounds(299, 38, 89, 22);
		contentPanel.add(comboBoxOrario);
		
		JButton ButtonPaga = new JButton("Paga");
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mezzo;
				String orario = (String)comboBoxOrario.getSelectedItem();
				if(comboBoxMezzo.getSelectedIndex() == 0)
					mezzo = null;
				else
					mezzo = (String)comboBoxMezzo.getSelectedItem();
				
				c.ArchiviaCarrello(carrello);
				cor.creaOrdine(carrello, listaRistoranti, mezzo, orario);
				co = new ConclusioneOrdine(c);
				co.setVisible(true);
				dispose();
			}
		});
		ButtonPaga.setBounds(395, 200, 89, 23);
		contentPanel.add(ButtonPaga);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
			 }
		});
		ButtonAnnulla.setBounds(10, 200, 89, 23);
		contentPanel.add(ButtonAnnulla);
		
		JLabel LabelOrario = new JLabel("Inserire l'orario in cui desidera ricevere l'ordine:");
		LabelOrario.setBounds(10, 42, 291, 14);
		contentPanel.add(LabelOrario);
		
		JLabel LabelTotale = new JLabel("Il totale del suo ordine è:");
		LabelTotale.setBounds(10, 157, 143, 14);
		contentPanel.add(LabelTotale);
		
		String stringaRisultato = String.valueOf(totale);
		JLabel JLabelprezzoTotale = new JLabel(stringaRisultato);
		JLabelprezzoTotale.setBounds(160, 157, 60, 14);
		contentPanel.add(JLabelprezzoTotale);
		
		JLabel labelMezzo = new JLabel("Mezzo");
		labelMezzo.setBounds(10, 97, 46, 14);
		contentPanel.add(labelMezzo);
		
			
	}
}


package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntità.Carrello;
import classiEntità.Ristoranti;
import controllers.ControllerCarrello;
import controllers.ControllerConsegneUtente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameCassa extends JFrame {

	private JPanel contentPanel = new JPanel();
	private JDialogConclusioneOrdine co;

	public JFrameCassa(double totale, ControllerCarrello c, Carrello carrello, ControllerConsegneUtente cor, ArrayList<Ristoranti> listaRistoranti) {
		
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
		
		JButton buttonPaga = new JButton("Paga");
		buttonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mezzo;
				String orario = comboBoxOrario.getSelectedItem().toString();
				
				if(comboBoxMezzo.getSelectedIndex() == 0)
					mezzo = null;
				else
					mezzo = (String)comboBoxMezzo.getSelectedItem();
				
				cor.creaOrdine(carrello, listaRistoranti, mezzo, orario, c);
				co = new JDialogConclusioneOrdine(c);
				co.setVisible(true);
				dispose();
			}
		});
		buttonPaga.setBounds(395, 200, 89, 23);
		contentPanel.add(buttonPaga);
		
		JButton buttonAnnulla = new JButton("Annulla");
		buttonAnnulla.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
			 }
		});
		buttonAnnulla.setBounds(10, 200, 89, 23);
		contentPanel.add(buttonAnnulla);
		
		JLabel labelOrario = new JLabel("Inserire l'orario in cui desidera ricevere l'ordine:");
		labelOrario.setBounds(10, 42, 291, 14);
		contentPanel.add(labelOrario);
		
		JLabel labelTotale = new JLabel("Il totale del suo ordine è:");
		labelTotale.setBounds(10, 157, 143, 14);
		contentPanel.add(labelTotale);
		
		String stringaRisultato = String.valueOf(totale);
		JLabel JLabelprezzoTotale = new JLabel(stringaRisultato);
		JLabelprezzoTotale.setBounds(160, 157, 60, 14);
		contentPanel.add(JLabelprezzoTotale);
		
		JLabel labelMezzo = new JLabel("Mezzo");
		labelMezzo.setBounds(10, 97, 46, 14);
		contentPanel.add(labelMezzo);
		
			
	}
}


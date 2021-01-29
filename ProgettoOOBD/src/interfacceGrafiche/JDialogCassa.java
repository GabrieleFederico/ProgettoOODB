package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JDialogCassa extends JDialog {

	private JPanel contentPanel = new JPanel();
	private ControllerCarrello cc;
	private ConclusioneOrdine co;

	public JDialogCassa() {
		setTitle("Pagamento");
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(150, 150, 450, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton ButtonPaga = new JButton("Paga");
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cc.ArchiviaOrdine();
				co = new ConclusioneOrdine();
				co.setVisible(true);
				setVisible(false);
			}
		});
		ButtonPaga.setBounds(335, 139, 89, 23);
		contentPanel.add(ButtonPaga);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				setVisible(false);
			 }
		});
		ButtonAnnulla.setBounds(10, 139, 89, 23);
		contentPanel.add(ButtonAnnulla);
		
		JLabel LabelOrario = new JLabel("Inserire l'orario in cui desidera ricevere l'ordine:");
		LabelOrario.setBounds(10, 42, 257, 14);
		contentPanel.add(LabelOrario);
		
		
		JComboBox<String> comboBoxOrario = new JComboBox<String>();
		comboBoxOrario.setMaximumRowCount(4);
		comboBoxOrario.setModel(new DefaultComboBoxModel<String>(new String[] {"19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"}));
		comboBoxOrario.setBounds(261, 38, 89, 22);
		contentPanel.add(comboBoxOrario);
		
		JLabel LabelTotale = new JLabel("Il totale del suo ordine �:");
		LabelTotale.setBounds(10, 88, 143, 14);
		contentPanel.add(LabelTotale);
		
		//ottenere_totale_da_carrello
//		double totale = carrello.getPrezzoTotale(prezziJLabel);
		double totale = 10;
		String stringaRisultato = String.valueOf(totale);
		JLabel JLabelprezzoTotale = new JLabel(stringaRisultato);
		JLabelprezzoTotale.setBounds(160, 88, 60, 14);
		contentPanel.add(JLabelprezzoTotale);
			
	}
}

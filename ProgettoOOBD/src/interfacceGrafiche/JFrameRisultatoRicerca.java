package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;

import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameRisultatoRicerca extends JFrame {

	private JPanel contentPane;
	private JTextField TFRicerca;
	ControllerCarrello controller;

	
	public JFrameRisultatoRicerca(ControllerCarrello c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonCerca = new JButton("Cerca");
		ButtonCerca.setBounds(643, 12, 89, 26);
		contentPane.add(ButtonCerca);
		
		JComboBox CBPrezzo = new JComboBox();
		CBPrezzo.setModel(new DefaultComboBoxModel(new String[] {"Fascia di prezzo", "0-5", "5-10", "10-20"}));
		CBPrezzo.setBounds(494, 11, 139, 28);
		contentPane.add(CBPrezzo);
		
		JComboBox CBMezzo = new JComboBox();
		CBMezzo.setModel(new DefaultComboBoxModel(new String[] {"Selezionare mezzo", "Automobile", "Moto", "Bicicletta"}));
		CBMezzo.setBounds(331, 11, 144, 28);
		contentPane.add(CBMezzo);
		
		TFRicerca = new JTextField();
		TFRicerca.setBounds(10, 11, 311, 28);
		contentPane.add(TFRicerca);
		TFRicerca.setColumns(10);
		
		JButton ButtonCarrello = new JButton("Carrello");
		ButtonCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.carrelloButton();
			}
		});
		ButtonCarrello.setBounds(654, 411, 89, 23);
		contentPane.add(ButtonCarrello);
		
		JButton ButtonHome = new JButton("Home");
		ButtonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		ButtonHome.setBounds(10, 411, 89, 23);
		contentPane.add(ButtonHome);
	}
}

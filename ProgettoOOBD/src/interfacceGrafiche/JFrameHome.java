package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;
import controllers.ControllerRicerca;
import controllers.ControllorePrincipale;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JFrameHome extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	ControllerRicerca controller;
	ControllorePrincipale controllore;
	
	
	public JFrameHome(ControllerRicerca c, ControllorePrincipale c1) {
		setTitle("Home");
		controller = c;
		controllore = c1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputTF = new JTextField();
		inputTF.setBounds(10, 11, 311, 28);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		JComboBox Mezzo = new JComboBox();
		Mezzo.setModel(new DefaultComboBoxModel(new String[] {"Selezionare mezzo", "Automobile", "Moto", "Bicicletta"}));
		Mezzo.setBounds(331, 11, 144, 28);
		contentPane.add(Mezzo);
		
		JComboBox FasciaPrezzo = new JComboBox();
		FasciaPrezzo.setModel(new DefaultComboBoxModel(new String[] {"Fascia di prezzo", "0-5", "5-10", "10-20"}));
		FasciaPrezzo.setBounds(494, 11, 139, 28);
		contentPane.add(FasciaPrezzo);
		
		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.setBounds(654, 433, 89, 28);
		contentPane.add(LogOutButton);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.setBounds(654, 11, 89, 26);
		contentPane.add(CercaButton);
		
		JButton IMieiOrdiniButton = new JButton("I miei ordini");
		IMieiOrdiniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IMieiOrdiniButton.setBounds(10, 433, 139, 26);
		contentPane.add(IMieiOrdiniButton);
		
		JButton carrelloButton = new JButton("Carrello");
		carrelloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllore.apriCarrello(c);
			}
		});
		carrelloButton.setBounds(654, 62, 89, 23);
		contentPane.add(carrelloButton);
		
		JButton buttonHome = new JButton("Home");
		buttonHome.setEnabled(false);
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonHome.setBounds(10, 62, 101, 37);
		contentPane.add(buttonHome);
		
		componentiNecessarie = contentPane.getComponentCount();
		
		JButton PaniniButton = new JButton("Panini");
		PaniniButton.setBounds(10, 192, 215, 163);
		contentPane.add(PaniniButton);
		
		JButton PizzaButton = new JButton("Pizza");
		PizzaButton.setBounds(251, 192, 215, 163);
		contentPane.add(PizzaButton);
		
		JButton SushiButton = new JButton("Sushi");
		SushiButton.setBounds(493, 192, 215, 163);
		contentPane.add(SushiButton);
		SushiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Sushi", contentPane, componentiNecessarie);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		PizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Pizz", contentPane, componentiNecessarie);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		
		PaniniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Panin", contentPane, componentiNecessarie);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}
}

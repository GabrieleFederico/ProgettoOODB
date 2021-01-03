package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;
import controllers.ControllerRicercaRistoranti;
import controllers.ControllorePrincipale;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Cursor;

public class JFrameHome extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	ControllerRicercaRistoranti controller;
	ControllorePrincipale controllore;
	
	
	public JFrameHome(ControllerRicercaRistoranti c, ControllorePrincipale c1) {
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
		inputTF.setBounds(23, 11, 311, 28);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		JComboBox Mezzo = new JComboBox();
		Mezzo.setModel(new DefaultComboBoxModel(new String[] {"Selezionare mezzo", "Automobile", "Moto", "Bicicletta"}));
		Mezzo.setBounds(351, 11, 144, 28);
		contentPane.add(Mezzo);
		
		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.setBounds(654, 433, 89, 28);
		contentPane.add(LogOutButton);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TFInput = inputTF.getText();
				String RiderInput = null;
				String PrezzoInput = null;
				if(Mezzo.getSelectedIndex() != 0);
					RiderInput = Mezzo.getSelectedItem().toString();
					
				try {
					c.Ricerca(TFInput, contentPane, componentiNecessarie, null);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		CercaButton.setBounds(515, 11, 89, 28);
		contentPane.add(CercaButton);
		
		JButton IMieiOrdiniButton = new JButton("I miei ordini");
		IMieiOrdiniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IMieiOrdiniButton.setBounds(625, 12, 118, 27);
		contentPane.add(IMieiOrdiniButton);
		
		JButton carrelloButton = new JButton("Carrello");
		carrelloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllore.apriCarrello(c);
			}
		});
		carrelloButton.setBounds(333, 434, 89, 26);
		contentPane.add(carrelloButton);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					c.TornaHome(contentPane, componentiNecessarie);	
			}
		});
		HomeButton.setEnabled(false);
		HomeButton.setBounds(10, 436, 89, 25);
		contentPane.add(HomeButton);
		
		componentiNecessarie = contentPane.getComponentCount();
		
		JButton PaniniButton = new JButton("Panini");
		PaniniButton.setBounds(10, 160, 215, 163);
		contentPane.add(PaniniButton);
		
		JButton PizzaButton = new JButton("Pizza");
		PizzaButton.setBounds(270, 160, 215, 163);
		contentPane.add(PizzaButton);
		
		JButton SushiButton = new JButton("Sushi");
		SushiButton.setBounds(528, 160, 215, 163);
		contentPane.add(SushiButton);
		
		SushiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Sushi", contentPane, componentiNecessarie, null);
					HomeButton.setEnabled(true);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		PizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Pizz", contentPane, componentiNecessarie, null);
					HomeButton.setEnabled(true);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});

		PaniniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c.Ricerca("Panin", contentPane, componentiNecessarie, null);
					HomeButton.setEnabled(true);
					} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});

		
	}
	

}

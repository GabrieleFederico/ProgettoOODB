package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerRicerca;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class JFrameHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ControllerRicerca controller;
	
	public JFrameHome(ControllerRicerca c) {
		setTitle("Home");
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(71, 11, 264, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox Mezzo = new JComboBox();
		Mezzo.setModel(new DefaultComboBoxModel(new String[] {"Selezionare mezzo", "Automobile", "Moto", "Bicicletta"}));
		Mezzo.setBounds(359, 11, 144, 28);
		contentPane.add(Mezzo);
		
		JComboBox FasciaPrezzo = new JComboBox();
		FasciaPrezzo.setModel(new DefaultComboBoxModel(new String[] {"Fascia di prezzo", "0-5", "5-10", "10-20"}));
		FasciaPrezzo.setToolTipText("Scegliere fascia di prezzo\r\n0-5\r\n5-10\r\n10-20\r\n");
		FasciaPrezzo.setBounds(555, 11, 139, 28);
		contentPane.add(FasciaPrezzo);
		
		JButton ricercaPredefinita1 = new JButton("ricercaPredefinita1");
		ricercaPredefinita1.setBounds(10, 197, 215, 163);
		contentPane.add(ricercaPredefinita1);
		
		JButton ricercaPredefinita2 = new JButton("ricercaPredefinita2");
		ricercaPredefinita2.setBounds(298, 197, 215, 163);
		contentPane.add(ricercaPredefinita2);
		
		JButton ricercaPredefinita3 = new JButton("ricercaPredefinita3");
		ricercaPredefinita3.setBounds(583, 197, 215, 163);
		contentPane.add(ricercaPredefinita3);
	}
}

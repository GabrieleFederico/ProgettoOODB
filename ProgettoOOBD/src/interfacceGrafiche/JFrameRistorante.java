package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;
import controllers.ControllerRicercaProdotto;
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
import javax.swing.JTextPane;
import java.awt.Cursor;

public class JFrameRistorante extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	private int componentiNecessarie;
	ControllerRicercaProdotto controller;
	ControllorePrincipale controllore;
	
	
	public JFrameRistorante(ControllerRicercaProdotto c, String nomeRistorante) throws SQLException {
		setTitle(nomeRistorante);
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
		
		JComboBox FasciaPrezzo = new JComboBox();
		FasciaPrezzo.setBounds(362, 11, 191, 28);
		FasciaPrezzo.setModel(new DefaultComboBoxModel(new String[] {"Selezionare fascia di prezzo", "0-5", "5-10", "10-20"}));
		contentPane.add(FasciaPrezzo);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.setBounds(583, 11, 89, 28);
		CercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TFInput = inputTF.getText();
				String PrezzoInput = null;
				
				if(FasciaPrezzo.getSelectedIndex() != 0);
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

		c.getMenu(nomeRistorante, contentPane, componentiNecessarie);

//		Come dare un'azione ad una label
		
//		lblNewLabel.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				try {
//					c.Ricerca("Panin", contentPane, componentiNecessarie, null, null);
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
//			}
//		});
	}
}

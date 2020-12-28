package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCarrello;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameCarrello extends JFrame {

	private JPanel contentPane;
	ControllerCarrello controller;

	public JFrameCarrello(ControllerCarrello c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelCarrello = new JLabel("Carrello");
		LabelCarrello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelCarrello.setBounds(320, 11, 140, 14);
		contentPane.add(LabelCarrello);
		
		JButton ButtonPaga = new JButton("Paga");
		ButtonPaga.setBounds(601, 413, 89, 23);
		contentPane.add(ButtonPaga);
		
		JButton ButtonIndietro = new JButton("Indietro");
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ButtonIndietro.setBounds(10, 413, 89, 23);
		contentPane.add(ButtonIndietro);
	}
}

package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classiEntitą.Carrello;
import classiEntitą.Prodotto;
import classiEntitą.Ristorante;
import controllers.ControllerCarrello;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameCarrello extends JFrame {

	private JPanel contentPane;
	private ControllerCarrello controller;
	private int componentiNecessarie;
	private Carrello carrello;

	public JFrameCarrello(ControllerCarrello c) {
		controller = c;
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
		
		componentiNecessarie = contentPane.getComponentCount();
		
		carrello = controller.ottieniCarrello();
		setVisible(true);
		
	}
	
	public JPanel getPannello() {
		return contentPane;
	}
	
	public int getComponentiNecessarie() {
		return componentiNecessarie;
	}
	
	public void aggiornaInterfacciaCarrello() {
		
		JLabel prodottoNelCarrello;
		JButton bottone;
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		ArrayList<JButton> bottoni = new ArrayList<JButton>();

		
		int xLabel = 100;
		int xBottone = 300;
		int y = 130;
		int larg = 185;
		int lung = 20;
		int i = 0;
		
		
		for(Prodotto p : carrello.getProdotti()) {
			
			prodottoNelCarrello = new JLabel(p.getNomeP());
			prodottoNelCarrello.setBounds(xLabel, y, larg, lung);
			contentPane.add(prodottoNelCarrello);
			final int indice = i;

			bottone = new JButton("Rimuovi");
			bottone.setBounds(xBottone, y, larg, lung);
			bottone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.rimuoviDalCarrello(carrello, bottoni.indexOf(contentPane.getComponent(indice)));
					
				}
			});
			contentPane.add(bottone);
			y += 50;
			labels.add(prodottoNelCarrello);
			bottoni.add(bottone);
			i++;
		}

	}
}

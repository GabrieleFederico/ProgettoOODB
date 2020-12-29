package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicerca {
	
	JFrameHome fr;
	
	JLabel ciao;
	
	public ControllerRicerca(ControllorePrincipale c) {
		fr = new JFrameHome(this, c);
		fr.setVisible(true);
	}
	
	public void Ricerca (String nome, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		RistoranteDAOPostgres RP = new RistoranteDAOPostgres();
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		risultatoRicerca = RP.getRistoranteByNomeOrProdotto(nome);
		
		for(String s: risultatoRicerca) {
			System.out.println(s + "\n");
		}
		int i;
		int max = pannello.getComponentCount();
		
		for(i = max-1; i > componentiNecessarie-1; i--) {
			pannello.remove(i);
			pannello.updateUI();
		}
		
		int x = 100;
		int y = 130;
		int larg = 184;
		int lung = 26;
		for(String s: risultatoRicerca) {
			ciao = new JLabel(s.toString());
			ciao.setBounds(x, y, larg, lung);
			y += 30;
			pannello.add(ciao);
		}
	}
}

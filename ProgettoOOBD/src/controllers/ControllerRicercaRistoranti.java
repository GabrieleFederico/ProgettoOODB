package controllers;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHome fr;
	JLabel labelRisultato;
	
	public ControllerRicercaRistoranti(ControllorePrincipale c) {
		fr = new JFrameHome(this, c);
		fr.setVisible(true);
	}
	
	public void Ricerca (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo, String mezzo) throws SQLException {
		
		RistoranteDAOPostgres rp = new RistoranteDAOPostgres();
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		
		if(fasciaPrezzo == null && mezzo == null)
			risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		else
			risultatoRicerca = rp.getRistoranteByRicercaComplessa(ricerca, mezzo, fasciaPrezzo);
	
		int i;
		int max = pannello.getComponentCount();
		
		for(i = max-1; i > componentiNecessarie-1; i--)
			pannello.getComponent(i).setVisible(false);
			
		pannello.updateUI();
		
		int x = 100;
		int y = 130;
		int larg = 184;
		int lung = 26;
		for(String s: risultatoRicerca) {
			labelRisultato = new JLabel(s.toString());
			labelRisultato.setBounds(x, y, larg, lung);
			y += 30;
			pannello.add(labelRisultato);
		}
	}
	
	public void AggiungiElementi(Component comp, ArrayList<String> risultatoRicerca) {
		
		
	}

	public void TornaHome( JPanel pannello, int componentiNecessarie) {
		
		int i;
		int max = pannello.getComponentCount();
		
		for(i = max-1; i > componentiNecessarie-1; i--)
			pannello.getComponent(i).setVisible(true);
		
		int j = max-1;
		
		while(pannello.getComponent(j) instanceof JLabel) {
			pannello.remove(j);
			j--;
		}
		
		pannello.updateUI();
	}

}	
	
	


package controllers;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfacceGrafiche.GestioneUI;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHome fr;
	GestioneUI gestore;
	
	public ControllerRicercaRistoranti(ControllorePrincipale c) {
		
		fr = new JFrameHome(this, c);
		fr.setVisible(true);
	}
	
	public void Ricerca (String ricerca, JPanel pannello, int componentiNecessarie, String mezzo) throws SQLException {
		
		RistoranteDAOPostgres rp = new RistoranteDAOPostgres();
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		
		if(mezzo == null)
			risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		else
			risultatoRicerca = rp.getRistoranteByRicercaComplessa(ricerca, mezzo);

		gestore = new GestioneUI();
		gestore.aggiornaInterfaccia(pannello, componentiNecessarie, risultatoRicerca);
		
	}

	public void TornaHome(JPanel pannello, int componentiNecessarie) {
		
		gestore.TornaHome(pannello, componentiNecessarie);
	}


}	
	
	


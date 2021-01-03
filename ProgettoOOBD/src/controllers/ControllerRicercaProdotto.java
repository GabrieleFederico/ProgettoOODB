package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import interfacceGrafiche.GestioneUI;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaProdotto {
	
	JFrameRistorante fr;
	GestioneUI gestore;
	
	public ControllerRicercaProdotto(String nomeRistorante) {
		
		fr = new JFrameRistorante(this, nomeRistorante);
		fr.setVisible(true);
	}
	
	public void RicercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		RistoranteDAOPostgres rp = new RistoranteDAOPostgres();
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		else
			risultatoRicerca = rp.getRistoranteByRicercaComplessa(ricerca, fasciaPrezzo);

		gestore = new GestioneUI();
		gestore.aggiornaInterfaccia(pannello, componentiNecessarie, risultatoRicerca);
		
	}


}

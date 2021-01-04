package controllers;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classiEntità.Ristorante;
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
		ArrayList<Ristorante> risultatoRicerca = new ArrayList<Ristorante>();
		
		if(mezzo == null)
			risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		else
			risultatoRicerca = rp.getRistoranteByRicercaComplessa(ricerca, mezzo);
			
		
		gestore = new GestioneUI();
		gestore.aggiornaInterfacciaRistoranti(pannello, componentiNecessarie, risultatoRicerca);
		
	}

	public void TornaHome(JPanel pannello, int componentiNecessarie) {
		
		gestore.TornaHome(pannello, componentiNecessarie);
	}


}	
	
	


package controllers;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classiEntitą.Ristorante;
import interfacceGrafiche.JFrameHomeUtente;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHomeUtente fr;
	ControllorePrincipale C;
	
	public ControllerRicercaRistoranti(ControllorePrincipale c) {
		C = c;
		fr = new JFrameHomeUtente(this, C);
		fr.setVisible(true);
	}
	
	public void Ricerca (String ricerca, JPanel pannello, int componentiNecessarie, String mezzo) throws SQLException {
		
		RistoranteDAOPostgres rp = new RistoranteDAOPostgres();
		ArrayList<Ristorante> risultatoRicerca = new ArrayList<Ristorante>();
		
		if(mezzo == null)
			risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		else
			risultatoRicerca = rp.getRistoranteByRicercaComplessa(ricerca, mezzo);
		
		fr.aggiornaInterfacciaRistoranti(pannello, componentiNecessarie, risultatoRicerca, C);
			
	}

}	
	
	


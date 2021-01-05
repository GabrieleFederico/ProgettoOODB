package controllers;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classiEntità.Ristorante;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHome fr;
	ControllorePrincipale C;
	
	public ControllerRicercaRistoranti(ControllorePrincipale c) {
		C = c;
		fr = new JFrameHome(this, C);
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
	
	


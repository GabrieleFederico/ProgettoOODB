package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
import interfacceGrafiche.GestioneUI;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.MenùDAOPostgres;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaMenu {
	
	JFrameRistorante fr;
	GestioneUI gestore;
	Ristorante r;
	
	public ControllerRicercaMenu(Ristorante rist) {
		
		r = rist;
		gestore = new GestioneUI();
		
		try {
			fr = new JFrameRistorante(this, r);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		fr.setVisible(true);
	}
	
	public void RicercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		MenùDAOPostgres mp = new  MenùDAOPostgres();
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getProdottoByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);

		gestore.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca);
		
	}

	public void getMenu(Ristorante rist, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		MenùDAOPostgres mp = new MenùDAOPostgres();
		Menu menùRistorante = new Menu();
				
		menùRistorante = mp.getMenùByRistorante(rist);
		
		gestore.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, menùRistorante.getProdotti());
		
	}


}

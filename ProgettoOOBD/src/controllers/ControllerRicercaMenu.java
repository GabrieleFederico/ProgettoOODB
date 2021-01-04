package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntit�.Menu;
import classiEntit�.Prodotto;
import classiEntit�.Ristorante;
import interfacceGrafiche.GestioneUI;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.Men�DAOPostgres;
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
		
		Men�DAOPostgres mp = new  Men�DAOPostgres();
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getProdottoByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);

		gestore.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca);
		
	}

	public void getMenu(Ristorante rist, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		Men�DAOPostgres mp = new Men�DAOPostgres();
		Menu men�Ristorante = new Menu();
				
		men�Ristorante = mp.getMen�ByRistorante(rist);
		
		gestore.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, men�Ristorante.getProdotti());
		
	}


}

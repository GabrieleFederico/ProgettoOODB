package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntit�.Menu;
import classiEntit�.Prodotto;
import classiEntit�.Ristorante;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.Men�DAOPostgres;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaMenu {
	
	JFrameRistorante fr;
	Ristorante r;
	String Email;
	ControllerCarrello CCarrello;
	
	public ControllerRicercaMenu(Ristorante rist, ControllerCarrello ccarrello) {
		
		r = rist;
		CCarrello = ccarrello;
		
		fr = new JFrameRistorante(this, r);
		fr.setVisible(true);
	}
	
	public ArrayList<Prodotto> RicercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		Men�DAOPostgres mp = new  Men�DAOPostgres();
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getProdottoByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristorante rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		Men�DAOPostgres mp = new Men�DAOPostgres();
		Menu men�Ristorante = new Menu();

		men�Ristorante = mp.getMen�ByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, men�Ristorante.getProdotti(), CCarrello);
		
	}


}

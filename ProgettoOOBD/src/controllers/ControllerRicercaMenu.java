package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.MenùDAOPostgres;
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
		
		MenùDAOPostgres mp = new  MenùDAOPostgres();
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getProdottoByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristorante rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		MenùDAOPostgres mp = new MenùDAOPostgres();
		Menu menùRistorante = new Menu();

		menùRistorante = mp.getMenùByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, menùRistorante.getProdotti(), CCarrello);
		
	}


}

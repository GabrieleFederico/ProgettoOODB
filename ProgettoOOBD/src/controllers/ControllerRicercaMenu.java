package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntità.Menù;
import classiEntità.Prodotti;
import classiEntità.Ristoranti;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.MenùDAOPostgres;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaMenu {
	
	JFrameRistorante fr;
	Ristoranti r;
	String Email;
	ControllerCarrello CCarrello;
	
	public ControllerRicercaMenu(Ristoranti rist, ControllerCarrello ccarrello) {
		
		r = rist;
		CCarrello = ccarrello;
		
		fr = new JFrameRistorante(this, r);
		fr.setVisible(true);
	}
	

	public Menù ricercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		MenùDAOPostgres mp = new  MenùDAOPostgres();
		Menù risultatoRicerca = new Menù();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristoranti rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		MenùDAOPostgres mp = new MenùDAOPostgres();
		Menù menùRistorante = new Menù();

		menùRistorante = mp.getMenùByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, menùRistorante, CCarrello);
		
	}


}

package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import classiEntit�.Men�;
import classiEntit�.Prodotti;
import classiEntit�.Ristoranti;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.Men�DAOPostgres;
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
	

	public Men� ricercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		Men�DAOPostgres mp = new  Men�DAOPostgres();
		Men� risultatoRicerca = new Men�();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristoranti rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		Men�DAOPostgres mp = new Men�DAOPostgres();
		Men� men�Ristorante = new Men�();

		men�Ristorante = mp.getMen�ByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, men�Ristorante, CCarrello);
		
	}


}

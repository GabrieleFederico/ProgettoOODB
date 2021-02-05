package controllers;

import java.sql.SQLException;

import javax.swing.JPanel;

import classiEntità.Menù;
import classiEntità.Ristoranti;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.MenùDAOPostgres;

public class ControllerRicercaMenu {
	
	JFrameRistorante fr;
	Ristoranti r;
	String Email;
	ControllerCarrello CCarrello;
	MenùDAOPostgres menuDao = new  MenùDAOPostgres();
	
	public ControllerRicercaMenu(Ristoranti rist, ControllerCarrello ccarrello) {
		
		r = rist;
		CCarrello = ccarrello;
		
		fr = new JFrameRistorante(this, r);
		fr.setVisible(true);
	}
	

	public Menù ricercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		Menù risultatoRicerca = new Menù();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = menuDao.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = menuDao.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristoranti rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		Menù menùRistorante = new Menù();

		menùRistorante = menuDao.getMenùByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, menùRistorante, CCarrello);
		
	}


}

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
	MenùDAOPostgres menuDao;
	
	public ControllerRicercaMenu(Ristoranti rist, ControllerCarrello ccarrello) {
		
		menuDao = new  MenùDAOPostgres();
		r = rist;
		
		fr = new JFrameRistorante(this, r, ccarrello);
		fr.setVisible(true);
	}
	

	public Menù ricercaProdotto (String ricerca, String fasciaPrezzo) {
		
		Menù risultatoRicerca = new Menù();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = menuDao.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = menuDao.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		return risultatoRicerca;

	}

	public Menù getMenu() {
		
		Menù menùRistorante = new Menù();

		menùRistorante = menuDao.getMenùByRistorante(r);

		return menùRistorante;
		
	}


}

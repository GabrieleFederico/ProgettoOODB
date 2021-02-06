package controllers;

import java.sql.SQLException;

import javax.swing.JPanel;

import classiEntit�.Men�;
import classiEntit�.Ristoranti;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.Men�DAOPostgres;

public class ControllerRicercaMenu {
	
	JFrameRistorante fr;
	Ristoranti r;
	String Email;
	Men�DAOPostgres menuDao;
	
	public ControllerRicercaMenu(Ristoranti rist, ControllerCarrello ccarrello) {
		
		menuDao = new  Men�DAOPostgres();
		r = rist;
		
		fr = new JFrameRistorante(this, r, ccarrello);
		fr.setVisible(true);
	}
	

	public Men� ricercaProdotto (String ricerca, String fasciaPrezzo) {
		
		Men� risultatoRicerca = new Men�();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = menuDao.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = menuDao.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		return risultatoRicerca;

	}

	public Men� getMenu() {
		
		Men� men�Ristorante = new Men�();

		men�Ristorante = menuDao.getMen�ByRistorante(r);

		return men�Ristorante;
		
	}


}

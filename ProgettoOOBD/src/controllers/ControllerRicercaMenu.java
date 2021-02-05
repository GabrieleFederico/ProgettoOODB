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
	ControllerCarrello CCarrello;
	Men�DAOPostgres menuDao = new  Men�DAOPostgres();
	
	public ControllerRicercaMenu(Ristoranti rist, ControllerCarrello ccarrello) {
		
		r = rist;
		CCarrello = ccarrello;
		
		fr = new JFrameRistorante(this, r);
		fr.setVisible(true);
	}
	

	public Men� ricercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		Men� risultatoRicerca = new Men�();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = menuDao.getMenuByNomeProdottoAndRistorante(ricerca, r);
		else
			risultatoRicerca = menuDao.getProdottoByRicercaComplessa(ricerca, r, fasciaPrezzo);
		
		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, risultatoRicerca, CCarrello);
		
		return risultatoRicerca;

	}

	public void getMenu(Ristoranti rist, JPanel pannello, int componentiNecessarie, JFrameRistorante fr) {
		
		Men� men�Ristorante = new Men�();

		men�Ristorante = menuDao.getMen�ByRistorante(rist);

		fr.aggiornaInterfacciaProdotti(pannello, componentiNecessarie, men�Ristorante, CCarrello);
		
	}


}

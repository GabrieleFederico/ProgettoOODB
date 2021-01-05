package controllers;

import classiEntitą.Utente;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.CarrelloDAOPostgres;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;
	Utente utente;

	
	public ControllerCarrello(Utente utente) {
		this.utente = utente;
		fc = new JFrameCarrello(this);
	}

	public void aggiungiAlCarrello(String nomep, int quantitą) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.aggiungiProdottoAlCarrello(nomep, quantitą, utente);
	}
		
}

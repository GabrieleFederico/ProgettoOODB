package controllers;

import classiEntità.Utente;
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

	public void aggiungiAlCarrello(String nomep, int quantità) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.aggiungiProdottoAlCarrello(nomep, quantità, utente);
	}
		
}

package controllers;

import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.CarrelloDAOPostgres;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;
	String Email;

	
	public ControllerCarrello(String email) {
		Email = email;
	}

	public void aggiungiAlCarrello(String nomep, int quantit�) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		
		cp.aggiungiProdottoAlCarrello(nomep, quantit�, Email);
	}
		
}

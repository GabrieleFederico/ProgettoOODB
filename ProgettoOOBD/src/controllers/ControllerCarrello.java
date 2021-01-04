package controllers;

import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.CarrelloDAOPostgres;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;

	
	public ControllerCarrello() {
//		fc = new JFrameCarrello(this);
//		fc.setVisible(true);
	}

	public void aggiungiAlCarrello(String nomep, int quantità, String email) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		
		cp.aggiungiProdottoAlCarrello(nomep, quantità, email);
		
		
	}
		
}

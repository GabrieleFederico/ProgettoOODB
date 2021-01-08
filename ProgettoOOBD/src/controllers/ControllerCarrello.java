package controllers;

import classiEntità.Carrello;
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
	}

	public void aggiungiAlCarrello(String nomep, int quantità) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.aggiungiProdottoAlCarrello(nomep, quantità, utente);
	}
	
	public Carrello ottieniCarrello() {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		Carrello temp = cp.getCarrelloByUtente(utente);
		
		return temp;
	}
	
	public void rimuoviDalCarrello(Carrello carrello, int indice) {
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.rimuoviProdottoDalCarrello(carrello, indice);

	}
	
	//TODO
	public void rimuoviParzialmenteDalCarrello() {
		
	}
		
}

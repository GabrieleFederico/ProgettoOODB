package controllers;

import java.util.ArrayList;

import classiEntitą.Carrello;
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
	}

	public void aggiungiAlCarrello(String nomep, int quantitą, double prezzo) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.aggiungiProdottoAlCarrello(nomep, quantitą, utente, prezzo);
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

	public ArrayList<Double> getPrezzi(Carrello carrello) {
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		ArrayList<Double> prezzi = cp.getArrayListPrezzi(carrello);		
		return prezzi;
	}
		
}

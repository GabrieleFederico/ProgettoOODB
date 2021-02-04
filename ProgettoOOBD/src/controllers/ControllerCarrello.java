package controllers;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JLabel;

import classiEntit‡.Carrello;
import classiEntit‡.Ristorante;
import classiEntit‡.Utente;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHomeUtente;
import interfacceGrafiche.JFrameCassa;
import postgresDAOImpl.CarrelloDAOPostgres;

public class ControllerCarrello {
	
	JFrameHomeUtente fh;
	JFrameCarrello fc;
	Utente utente;

	
	public ControllerCarrello(Utente utente) {
		this.utente = utente;
	}

	public void aggiungiAlCarrello(String nomep, int quantit‡, double prezzo, Ristorante ristorante) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.aggiungiProdottoAlCarrello(nomep, quantit‡, utente, prezzo, ristorante);
	}
	
	public Carrello ottieniCarrello() {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		Carrello temp = cp.getCarrelloByUtente(utente);
		
		return temp;
	}
	
	public boolean rimuoviDalCarrello(Carrello carrello, int indice) {
		
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		Ristorante temp = cp.rimuoviProdottoDalCarrello(carrello, indice);
		
		return cp.esisteRistoranteNelCarrello(temp);
	}
	
	
	public void ModificaQuantit‡Carrello(int nuovoValore, Carrello carrello,  String nomeProdotto) {
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.cambiaQuantit‡Carrello(nuovoValore, carrello, nomeProdotto);		
		
	}

	public ArrayList<Double> getPrezzi(Carrello carrello) {
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		ArrayList<Double> prezzi = cp.getArrayListPrezzi(carrello);		
		return prezzi;
	}

	public void ArchiviaCarrello(Carrello carrello, Ristorante r) {
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		cp.archiviaCarrello(carrello, r);
	}

	public Window getfc() {
		return fc;
	}
		
}

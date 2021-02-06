package controllers;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JLabel;

import classiEntit‡.Carrello;
import classiEntit‡.Ristoranti;
import classiEntit‡.Utenti;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHomeUtente;
import interfacceGrafiche.JFrameCassa;
import postgresDAOImpl.CarrelloDAOPostgres;

public class ControllerCarrello {
	
	JFrameHomeUtente fh;
	JFrameCarrello fc;
	Utenti utente;
	CarrelloDAOPostgres carrelloDao;
	
	public ControllerCarrello(Utenti utente) {
		carrelloDao = new CarrelloDAOPostgres();
		this.utente = utente;
	}

	public void aggiungiAlCarrello(String nomep, int quantit‡, double prezzo, Ristoranti ristorante) {
		
		
		carrelloDao.aggiungiProdottoAlCarrello(nomep, quantit‡, utente, prezzo, ristorante);
	}
	
	public Carrello ottieniCarrello() {
		
		Carrello temp = carrelloDao.getCarrelloByUtente(utente);
		
		return temp;
	}
	
	public boolean rimuoviDalCarrello(Carrello carrello, int indice) {
		
		Ristoranti temp = carrelloDao.rimuoviProdottoDalCarrello(carrello, indice);
		
		return carrelloDao.esisteRistoranteNelCarrello(temp);
	}
	
	
	public void modificaQuantit‡Carrello(int nuovoValore, Carrello carrello,  String nomeProdotto) {
		
		carrelloDao.cambiaQuantit‡Carrello(nuovoValore, carrello, nomeProdotto);		
		
	}

	public ArrayList<Double> getPrezzi(Carrello carrello) {
		
		ArrayList<Double> prezzi = carrelloDao.getArrayListPrezzi(carrello);		
		return prezzi;
	}

	public void archiviaCarrello(Carrello carrello, Ristoranti r) {
		
		carrelloDao.archiviaCarrello(carrello, r);
	}

	public Window getJFrameCarrello() {
		return fc;
	}
		
}

package controllers;

import classiEntità.Rider;
import classiEntità.Ristorante;
import classiEntità.Utente;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHomeRider;

public class ControllorePrincipale {

	String Email;
	ControllerCarrello ccarrello;
	
	public static void main(String[] args) {

		ControllorePrincipale principale = new ControllorePrincipale();	
		
		principale.start();

	}
	
	public void start() {
		ControllerLogin c = new ControllerLogin(this);
	}
	
	public void passaAdHomeUtente(ControllerLogin c, Utente utente) {
		ccarrello = new ControllerCarrello(utente);
		c = null;
		ControllerRicercaRistoranti c1 = new ControllerRicercaRistoranti(this, utente);
	}
	
	public void passaAdHomeRider(ControllerLogin c, Rider rider) {
		
		c = null;
		ControllerRider cr = new ControllerRider(rider);
		
	}
	
	public void passaAInterfacciaRistorante(Ristorante r) {
		ControllerRicercaMenu crm = new ControllerRicercaMenu(r, ccarrello);

	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		ccarrello.fc = new JFrameCarrello(ccarrello);
		ccarrello.fc.aggiornaInterfacciaCarrello();
	}

}

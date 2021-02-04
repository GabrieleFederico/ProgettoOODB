package controllers;

import classiEntità.Riders;
import classiEntità.Ristoranti;
import classiEntità.Utenti;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHomeRider;
import interfacceGrafiche.JFrameLogin;

public class ControllerPrincipale {

	String Email;
	ControllerCarrello ccarrello;
	ControllerConsegne co = new ControllerConsegne();
	
	public static void main(String[] args) {

		ControllerPrincipale principale = new ControllerPrincipale();	
		
		principale.start();

	}
	
	public void start() {
		ControllerLogin c = new ControllerLogin(this);
	}
	
	public void passaAdHomeUtente(ControllerLogin c, Utenti utente) {
		ccarrello = new ControllerCarrello(utente);
		c = null;
		ControllerRicercaRistoranti c1 = new ControllerRicercaRistoranti(this, utente);
	}
	
	public void passaAdHomeRider(ControllerLogin c, Riders rider) {
		
		c = null;
		ControllerRider cr = new ControllerRider(rider, co, this);
		
	}
	
	public void passaAInterfacciaRistorante(Ristoranti r) {
		ControllerRicercaMenu crm = new ControllerRicercaMenu(r, ccarrello);

	}
	
	public void apriOrdini(Utenti u) {

		co.apriOrdini(u);
		
	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		ccarrello.fc = new JFrameCarrello(ccarrello, co);
		ccarrello.fc.aggiornaInterfacciaCarrello();
	}

	public void logout() {
		start();	
	}
}

package controllers;

import classiEntità.Rider;
import classiEntità.Ristorante;
import classiEntità.Utente;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHomeRider;
import interfacceGrafiche.JFrameLogin;

public class ControllorePrincipale {

	String Email;
	ControllerCarrello ccarrello;
	ControllerConsegne co = new ControllerConsegne();
	
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
		ControllerRider cr = new ControllerRider(rider, co, this);
		
	}
	
	public void passaAInterfacciaRistorante(Ristorante r) {
		ControllerRicercaMenu crm = new ControllerRicercaMenu(r, ccarrello);

	}
	
	public void apriOrdini(Utente u) {

		co.apriOrdini(u);
		
	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		ccarrello.fc = new JFrameCarrello(ccarrello, co);
		ccarrello.fc.aggiornaInterfacciaCarrello();
	}

	public void Logout() {
		start();	
	}
}

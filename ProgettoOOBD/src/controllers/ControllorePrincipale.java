package controllers;

import classiEntità.Ristorante;
import classiEntità.Utente;
import interfacceGrafiche.JFrameCarrello;

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
	
	public void passaAdHome(ControllerLogin c, Utente utente) {
		ccarrello = new ControllerCarrello(utente);
		ControllerRicercaRistoranti c1 = new ControllerRicercaRistoranti(this);
	}
	
	public void passaAInterfacciaRistorante(Ristorante r) {
		ControllerRicercaMenu crm = new ControllerRicercaMenu(r, ccarrello);
	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		ccarrello.fc = new JFrameCarrello(ccarrello);
		ccarrello.fc.aggiornaInterfacciaCarrello();
	}

}

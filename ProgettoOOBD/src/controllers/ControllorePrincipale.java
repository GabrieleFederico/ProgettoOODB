package controllers;

import classiEntità.Ristorante;

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
	
	public void passaAdHome(ControllerLogin c, String email) {
		ccarrello = new ControllerCarrello(email);
		ControllerRicercaRistoranti c1 = new ControllerRicercaRistoranti(this);
		Email = email;
	}
	
	public void passaAInterfacciaRistorante(Ristorante r) {
		ControllerRicercaMenu crm = new ControllerRicercaMenu(r, ccarrello);
	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		c.fr.setVisible(false);
		ControllerCarrello carrello = new ControllerCarrello(Email);
		
	}

}

package controllers;

public class ControllorePrincipale {

	public static void main(String[] args) {

		ControllorePrincipale principale = new ControllorePrincipale();	
		
		principale.Start();

	}
	
	void Start() {
		ControllerLogin c = new ControllerLogin(this);
	}
	
	void PassaAdHome(ControllerLogin c) {
		ControllerRicercaRistoranti c1 = new ControllerRicercaRistoranti(this);
	}

	public void apriCarrello(ControllerRicercaRistoranti c) {
		c.fr.setVisible(false);
		ControllerCarrello carrello = new ControllerCarrello();
		
	}

}

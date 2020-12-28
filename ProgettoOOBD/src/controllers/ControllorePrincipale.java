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
		ControllerRicerca c1 = new ControllerRicerca(this);
	}

	public void apriCarrello(ControllerRicerca c) {
		c.fr.setVisible(false);
		ControllerCarrello carrello = new ControllerCarrello();
		
	}

}

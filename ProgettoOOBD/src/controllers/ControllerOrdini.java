package controllers;

import java.util.ArrayList;

import classiEntit�.Consegne;
import classiEntit�.Utente;
import interfacceGrafiche.JFrameOrdiniUtente;

public class ControllerOrdini {

	
	public ControllerOrdini(Utente utente) {
		
		JFrameOrdiniUtente ordini = new JFrameOrdiniUtente(utente, this);
	}
	
	public ArrayList<Consegne> getOrdiniByUtente(){
		return null;
	}
}

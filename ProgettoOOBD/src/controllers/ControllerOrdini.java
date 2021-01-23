package controllers;

import java.util.ArrayList;

import classiEntità.Consegne;
import classiEntità.Utente;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerOrdini {

	Utente u;
	
	public ControllerOrdini(Utente utente) {
		u = utente;
		JFrameOrdiniUtente ordini = new JFrameOrdiniUtente(this);
		ordini.setVisible(true);
	}
	
	public ArrayList<Consegne> getOrdiniByUtente(){
		
		ArrayList<Consegne> ris = new ArrayList<Consegne>();
		ConsegneDAOPostgres cd = new ConsegneDAOPostgres();
		ris = cd.getConsegneByUtente(u);
		
		return ris;
	}
}

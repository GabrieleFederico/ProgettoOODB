package controllers;

import java.util.ArrayList;

import classiEntitą.Carrello;
import classiEntitą.Consegne;
import classiEntitą.Utente;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
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
	
	public void apriDettagli(Consegne ordine) {
		
		JFrameDettagliOrdine dettagli = new JFrameDettagliOrdine(getDettagliOrdine(ordine));
	}
	
	public Carrello getDettagliOrdine(Consegne ordine) {
		
		Carrello risultato;
		CarrelloDAOPostgres cp = new CarrelloDAOPostgres();
		risultato = cp.getCarrelloByOrdine(ordine);
		
		return risultato;
	}
}

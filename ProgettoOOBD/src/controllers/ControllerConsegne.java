package controllers;

import java.util.ArrayList;

import classiEntit�.Carrello;
import classiEntit�.Consegne;
import classiEntit�.Rider;
import classiEntit�.Utente;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerConsegne {
	
	private String mezzo;

	public void CConsegne(Rider rider) {
		this.mezzo = rider.getMezzo();
	}
	
	public ArrayList<Consegne> getOrdiniByUtente(Utente u){
		
		ArrayList<Consegne> ris = new ArrayList<Consegne>();
		ConsegneDAOPostgres cd = new ConsegneDAOPostgres();
		ris = cd.getConsegneByUtente(u);
		
		return ris;
	}
	
	public ArrayList<Consegne> getOrdiniByRider(){
		
		return null;
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
	
	public void apriOrdini(Utente u) {
		JFrameOrdiniUtente ordini = new JFrameOrdiniUtente(this, u);
		ordini.setVisible(true);
	}
	
	public void creaOrdine(Carrello carrello) {
		
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		cp.creaConsegna();
	}

	public ArrayList<Consegne> getConsegneDisponibili() {

		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getConsegneByMezzo(mezzo);
		
		return risultato;
		
	}
}

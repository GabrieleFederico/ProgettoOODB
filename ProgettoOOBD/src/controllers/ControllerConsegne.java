package controllers;

import java.util.ArrayList;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.ConsegneSenzaRider;
import classiEntità.Rider;
import classiEntità.Utente;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
import postgresDAOImpl.ConsegneDAOPostgres;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerConsegne {
	
	private Rider rider;

	public ControllerConsegne() {

	}
	
	public ControllerConsegne(Rider rider) {
		this.rider = rider;
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

	public ArrayList<ConsegneSenzaRider> getConsegneDisponibili() {
		
		ArrayList<ConsegneSenzaRider> risultato;
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		risultato = cp.getConsegneByMezzo(rider.getMezzo());
		
		return risultato;
		
	}
}

package controllers;

import java.util.ArrayList;

import classiEntit�.Carrello;
import classiEntit�.Consegne;
import classiEntit�.ConsegneSenzaRider;
import classiEntit�.Rider;
import classiEntit�.Ristorante;
import classiEntit�.Utente;
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
	
	public void creaOrdine(Carrello carrello, ArrayList<Ristorante> listaRistoranti) {
			
		Ristorante temp = new Ristorante();
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		temp = listaRistoranti.get(0);
			
		for(Ristorante r : listaRistoranti) {
			if(!temp.getIndirizzo().equals(r.getIndirizzo())) {
				cp.creaConsegna(temp.getIndirizzo(), carrello.getProprietario());
			}
			else if(r.getIndirizzo().equals(listaRistoranti.get(listaRistoranti.size()-1).getIndirizzo())) {
				cp.creaConsegna(r.getIndirizzo(), carrello.getProprietario());
			}
			temp = r;
		}
	}

	public ArrayList<ConsegneSenzaRider> getConsegneDisponibili() {
		
		ArrayList<ConsegneSenzaRider> risultato;
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		risultato = cp.getConsegneByMezzo(rider.getMezzo());
		
		return risultato;
		
	}
}

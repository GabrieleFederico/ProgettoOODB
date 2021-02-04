package controllers;

import java.util.ArrayList;
import java.util.Objects;
import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Riders;
import classiEntit‡.Ristoranti;
import classiEntit‡.Utenti;
import interfacceGrafiche.JDialogMaxAttivit‡;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
import postgresDAOImpl.ConsegneDAOPostgres;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerConsegne {
	
	private String mezzo;
	private String CodR;

	public void CConsegne(Riders rider) {
		this.mezzo = rider.getMezzo();
	}
	
	public String getCodR(Riders rider) {
		this.CodR = rider.getCodR();
		return CodR;
	}
	
	public ArrayList<Consegne> getOrdiniByUtente(Utenti u){
		
		ArrayList<Consegne> ris = new ArrayList<Consegne>();
		ConsegneDAOPostgres cd = new ConsegneDAOPostgres();
		ris = cd.getConsegneByUtente(u);
		
		return ris;
	}
	
	public ArrayList<Consegne> getOrdiniByRider(Riders rider){
		
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getOrdiniByRider(rider);
		
		return risultato;
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
	
	public void apriOrdini(Utenti u) {
		JFrameOrdiniUtente ordini = new JFrameOrdiniUtente(this, u);
		ordini.setVisible(true);
	}
	
	public void creaOrdine(Carrello carrello, ArrayList<Ristoranti> listaRistoranti, String mezzo, String orario, ControllerCarrello c) {
			
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		String provenienza = null;
		
		for(Ristoranti r : listaRistoranti) {
			if (!Objects.equals(r.getIndirizzo(), provenienza)){
				cp.creaConsegna(r.getIndirizzo(), carrello.getProprietario(), mezzo, orario);
				provenienza = r.getIndirizzo();
			}
			c.archiviaCarrello(carrello, r);
			
		}
		
	}

	public ArrayList<Consegne> getConsegneDisponibili() {

		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getConsegneByMezzo(mezzo);
		
		return risultato;
		
	}

	public void nuovoOrdineRider(String CodR, String CodC) {
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		cp.assegnaConsegnaRider(CodR, CodC, this);
		
	}

	public void ordineConsegnato(String CodC) {
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		cp.ordineConsegnato(CodC);
		
	}

	public void maxAttivit‡Rider() {
		JDialogMaxAttivit‡ maxAttivit‡ = new JDialogMaxAttivit‡();
		maxAttivit‡.setVisible(true);
		
	}
}

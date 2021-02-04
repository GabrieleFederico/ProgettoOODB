package controllers;

import java.util.ArrayList;
import java.util.Objects;
import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Rider;
import classiEntit‡.Ristorante;
import classiEntit‡.Utente;
import interfacceGrafiche.JDialogMaxAttivit‡;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerConsegne {
	
	private String mezzo;
	private String CodR;

	public void CConsegne(Rider rider) {
		this.mezzo = rider.getMezzo();
	}
	
	public String getCodR(Rider rider) {
		this.CodR = rider.getCodR();
		return CodR;
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
	
	public void creaOrdine(Carrello carrello, ArrayList<Ristorante> listaRistoranti, String mezzo, String orario, ControllerCarrello c) {
			
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		String provenienza = null;
		
		for(Ristorante r : listaRistoranti) {
			if (!Objects.equals(r.getIndirizzo(), provenienza)){
				cp.creaConsegna(r.getIndirizzo(), carrello.getProprietario(), mezzo, orario);
				provenienza = r.getIndirizzo();
			}
			c.ArchiviaCarrello(carrello, r);
			
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

	public void MaxAttivit‡Rider() {
		JDialogMaxAttivit‡ maxAttivit‡ = new JDialogMaxAttivit‡();
		maxAttivit‡.setVisible(true);
		
	}
}

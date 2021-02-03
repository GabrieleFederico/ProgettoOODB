package controllers;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JLabel;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Rider;
import classiEntità.Ristorante;
import classiEntità.Utente;
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
	
	public void creaOrdine(Carrello carrello, ArrayList<Ristorante> listaRistoranti, String mezzo, String orario) {
			
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		String provenienza = null;
		String codiceCarrello;
		
		for(Ristorante r : listaRistoranti) {
			if (!Objects.equals(r.getIndirizzo(), provenienza)){
				codiceCarrello = cp.getCodCOrdine(carrello.getProprietario().getEmail(), r.getNome() + "," + r.getIndirizzo());
				cp.creaConsegna(r.getIndirizzo(), carrello.getProprietario(), mezzo, orario, codiceCarrello);
				provenienza = r.getIndirizzo();
			}
			
		}
		
	}

	public ArrayList<Consegne> getConsegneDisponibili() {

		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getConsegneByMezzo(mezzo);
		
		return risultato;
		
	}

	public void nuovoOrdineRider(String CodR, String CodC) {
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		cp.assegnaConsegnaRider(CodR, CodC);
		
	}

	public void ordineConsegnato(String CodC) {
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		cp.ordineConsegnato(CodC);
		
	}
}

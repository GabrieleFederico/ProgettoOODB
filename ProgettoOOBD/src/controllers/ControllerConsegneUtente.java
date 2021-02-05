package controllers;

import java.util.ArrayList;
import java.util.Objects;
import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Ristoranti;
import classiEntità.Utenti;
import interfacceGrafiche.JFrameDettagliOrdine;
import interfacceGrafiche.JFrameOrdiniUtente;
import postgresDAOImpl.CarrelloDAOPostgres;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerConsegneUtente {


	ConsegneDAOPostgres consegneDao = new ConsegneDAOPostgres();
	CarrelloDAOPostgres carrelloDao = new CarrelloDAOPostgres();
	
	public ArrayList<Consegne> getOrdiniByUtente(Utenti u){
		
		ArrayList<Consegne> ris = new ArrayList<Consegne>();
		ris = consegneDao.getConsegneByUtente(u);
		
		return ris;
	}
	
	public void apriDettagli(Consegne ordine) {
		
		JFrameDettagliOrdine dettagli = new JFrameDettagliOrdine(getDettagliOrdine(ordine));
	}
	
	public Carrello getDettagliOrdine(Consegne ordine) {
		
		Carrello risultato;
		risultato = carrelloDao.getCarrelloByOrdine(ordine);
		
		return risultato;
	}
	
	public void apriOrdini(Utenti u) {
		JFrameOrdiniUtente ordini = new JFrameOrdiniUtente(this, u);
		ordini.setVisible(true);
	}
	
	public void creaOrdine(Carrello carrello, ArrayList<Ristoranti> listaRistoranti, String mezzo, String orario, ControllerCarrello c) {
			
		String provenienza = null;
		
		for(Ristoranti r : listaRistoranti) {
			if (!Objects.equals(r.getIndirizzo(), provenienza)){
				consegneDao.creaConsegna(r.getIndirizzo(), carrello.getProprietario(), mezzo, orario);
				provenienza = r.getIndirizzo();
			}
			c.archiviaCarrello(carrello, r);
			
		}
		
	}

}

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

	public ArrayList<Consegne> getOrdiniByUtente(Utenti u){
		
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

}

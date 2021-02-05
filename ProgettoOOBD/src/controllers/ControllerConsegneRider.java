package controllers;

import java.util.ArrayList;

import classiEntit�.Consegne;
import classiEntit�.Riders;
import interfacceGrafiche.JDialogErrore;
import interfacceGrafiche.JDialogMaxAttivit�;
import interfacceGrafiche.JFrameHomeRider;
import interfacceGrafiche.JFrameOrdiniRider;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerConsegneRider {
	
	private Riders rider;
	private JFrameHomeRider homeRider;
	private JFrameOrdiniRider ordiniRider;
	
	public ControllerConsegneRider(Riders rider, ControllerPrincipale c1) {
		
		this.rider = rider;
		homeRider = new JFrameHomeRider(this, c1);
		homeRider.setVisible(true);
	}
	
	public void apriMieiOrdini() {
	
		ordiniRider = new JFrameOrdiniRider(this);
		ordiniRider.setVisible(true);
	}

	public JFrameHomeRider getHomeRider() {
		return homeRider;
	}
	
	public JFrameOrdiniRider getJFrameOrdiniRider() {
		return ordiniRider;
	}

	public Riders getRider() {
		return rider;
	}
	
	public ArrayList<Consegne> getOrdiniByRider(){
		
		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getOrdiniByRider(rider);
		
		return risultato;
	}
	
	public ArrayList<Consegne> getConsegneDisponibili() {

		ConsegneDAOPostgres cp = new ConsegneDAOPostgres();
		ArrayList<Consegne> risultato = cp.getConsegneByMezzo(rider.getMezzo());
		
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
	
	public void maxAttivit�Rider() {
		JDialogErrore maxAttivit� = new JDialogErrore("<html>ATTENZIONE <br>Possiedi gi� il massimo numero di ordini.</html>");
		maxAttivit�.setVisible(true);
		
	}
	
}

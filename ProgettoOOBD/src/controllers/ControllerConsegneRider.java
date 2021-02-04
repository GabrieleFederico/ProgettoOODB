package controllers;

import java.util.ArrayList;

import classiEntit‡.Consegne;
import classiEntit‡.Riders;
import interfacceGrafiche.JDialogMaxAttivit‡;
import interfacceGrafiche.JFrameHomeRider;
import postgresDAOImpl.ConsegneDAOPostgres;

public class ControllerConsegneRider {
	
	private Riders rider;
	private JFrameHomeRider homeRider;
	
	public ControllerConsegneRider(Riders rider, ControllerPrincipale c1) {
		
		this.rider = rider;
		homeRider = new JFrameHomeRider(this, c1);
		homeRider.setVisible(true);
	}

	public JFrameHomeRider getHomeRider() {
		return homeRider;
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
	
	public void maxAttivit‡Rider() {
		JDialogMaxAttivit‡ maxAttivit‡ = new JDialogMaxAttivit‡();
		maxAttivit‡.setVisible(true);
		
	}
	
}

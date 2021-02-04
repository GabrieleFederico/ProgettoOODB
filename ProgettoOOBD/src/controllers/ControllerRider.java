package controllers;

import java.util.ArrayList;

import classiEntità.Consegne;
import classiEntità.Rider;
import interfacceGrafiche.JFrameHomeRider;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerRider {
	
	private Rider rider;
	private ControllerConsegne controller;
	
	public ControllerRider(Rider rider, ControllerConsegne c, ControllorePrincipale c1) {
		
		controller = c;
		this.rider = rider;
		JFrameHomeRider homeRider = new JFrameHomeRider(controller, this, c1);
		homeRider.setVisible(true);
	}
	
	public String getCodR() {
		String CodR = rider.getCodR();
		return CodR;
	}

	public ArrayList<Consegne> getOrdiniByRider() {
		
		RiderDAOPostgres rp = new RiderDAOPostgres();
		ArrayList<Consegne> risultato = rp.getOrdiniByRider(rider);
		
		return risultato;
		
	}

	public ControllerConsegne getController() {
		return controller;
	}
	
	
}

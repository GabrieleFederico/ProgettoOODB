package controllers;

import java.util.ArrayList;

import classiEntit�.Consegne;
import classiEntit�.Rider;
import interfacceGrafiche.JFrameHomeRider;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerRider {
	
	private Rider rider;
	private ControllerConsegne controller;
	
	public ControllerRider(Rider rider, ControllerConsegne c, ControllorePrincipale c1) {
		
		controller = c;
		this.rider = rider;
		JFrameHomeRider homeRider = new JFrameHomeRider(controller, this, c1, c, rider);
		homeRider.setVisible(true);
	}
	
	public String getCodR() {
		String CodR = rider.getCodR();
		return CodR;
	}
	
}

package controllers;

import classiEntità.Rider;
import interfacceGrafiche.JFrameHomeRider;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerRider {
	
	private Rider rider;
	private ControllerConsegne controller;
	
	public ControllerRider(Rider rider) {
		
		JFrameHomeRider homeRider = new JFrameHomeRider(controller);
		homeRider.setVisible(true);
		this.rider = rider;
	}

}

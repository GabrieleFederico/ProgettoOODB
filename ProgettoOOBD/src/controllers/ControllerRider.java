package controllers;

import classiEntità.Riders;
import interfacceGrafiche.JFrameHomeRider;

public class ControllerRider {
	
	private Riders rider;
	private ControllerConsegne controller;
	private JFrameHomeRider homeRider;
	
	public ControllerRider(Riders rider, ControllerConsegne c, ControllerPrincipale c1) {
		
		controller = c;
		this.rider = rider;
		homeRider = new JFrameHomeRider(controller, this, c1, rider);
		homeRider.setVisible(true);
	}

	public JFrameHomeRider getHomeRider() {
		return homeRider;
	}

	public Riders getRider() {
		return rider;
	}
	

	
	
}

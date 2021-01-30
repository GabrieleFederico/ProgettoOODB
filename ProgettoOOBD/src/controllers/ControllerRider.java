package controllers;

import classiEntità.Rider;
import interfacceGrafiche.JFrameHomeRider;
import postgresDAOImpl.RiderDAOPostgres;

public class ControllerRider {
	
	Rider rider;
	
	public ControllerRider(Rider rider) {
		
		JFrameHomeRider homeRider = new JFrameHomeRider();
		homeRider.setVisible(true);
		this.rider = rider;
	}

}

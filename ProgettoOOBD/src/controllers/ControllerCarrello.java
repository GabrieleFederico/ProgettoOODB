package controllers;

import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;
	
	public ControllerCarrello() {
		fc = new JFrameCarrello(this);
		fc.setVisible(true);
	}
		
}

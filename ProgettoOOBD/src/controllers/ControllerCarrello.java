package controllers;

import java.sql.Connection;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;
import interfacceGrafiche.JFrameRisultatoRicerca;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;
	JFrameRisultatoRicerca fr;
	
	public ControllerCarrello() {
		fc = new JFrameCarrello(this);
		fc.setVisible(true);
	}
		
}

package controllers;

import java.sql.Connection;
import interfacceGrafiche.JFrameCarrello;
import interfacceGrafiche.JFrameHome;
import interfacceGrafiche.JFrameRisultatoRicerca;

public class ControllerCarrello {
	
	JFrameHome fh;
	JFrameCarrello fc;
	JFrameRisultatoRicerca fr;
	Connection connessione;
		
	public void carrelloButton() {
		fr = new JFrameRisultatoRicerca(this);
		fr.setVisible(false);
		fc = new JFrameCarrello(this);
		fc.setVisible(true);
	}

	public void HomeButton() {
		fr = new JFrameRisultatoRicerca(this);
		fr.setVisible(false);
		fh = new JFrameHome(this);
		fh.setVisible(true);
		//Due.controller.per.lo.stesso.JFrame?
	}
		
		
		
}

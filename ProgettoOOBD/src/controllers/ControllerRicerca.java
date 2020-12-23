package controllers;

import java.sql.Connection;

import interfacceGrafiche.JFrameHome;

public class ControllerRicerca {
	
	JFrameHome fr;
	Connection connessione;
	
	public ControllerRicerca(Connection connessione) {
		this.connessione = connessione;
		fr = new JFrameHome(this);
		fr.setVisible(true);
	}
	
}

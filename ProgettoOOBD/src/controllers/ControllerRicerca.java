package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import interfacceGrafiche.JFrameHome;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicerca {
	
	JFrameHome fr;
	Connection connessione;
	
	public ControllerRicerca(Connection connessione) {
		this.connessione = connessione;
		fr = new JFrameHome(this);
		fr.setVisible(true);
	}
	
	public void Ricerca (String nome) throws SQLException {
		RistoranteDAOPostgres RP = new RistoranteDAOPostgres(connessione);
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		risultatoRicerca = RP.getRistoranteByNomeOrProdotto(nome);
		for(String s: risultatoRicerca) {
			System.out.println(s + "\n");	
		}
	}
}

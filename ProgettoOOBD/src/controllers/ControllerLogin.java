package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacce.JFrameLogin;
import interfacce.JFrameRegistrati;
import postgresDAOImpl.UtenteDAOPostgres;


public class ControllerLogin {


	JFrameRegistrati fr;
	JFrameLogin fl;
	Connection connessione;


	public ControllerLogin(Connection connessione) {
			
		this.connessione = connessione;
		fl = new JFrameLogin(this);
		fl.setVisible(true);
	}
		
	public void LoginRegistratiButton() {
			
		fr = new JFrameRegistrati(this);
		fl.setVisible(false);
		fr.setVisible(true);
	}

	public void RegistraCredenziali(String email, String pwd, String nome, String cognome, String indirizzo) throws SQLException {

		UtenteDAOPostgres u1 = new UtenteDAOPostgres(connessione);
		Utente utente = new Utente (email, pwd, nome, cognome, indirizzo);
		u1.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);
			
	}
	public boolean ControllaCredenziali(String email, String pwd) throws SQLException {
		
		UtenteDAOPostgres u2 = new UtenteDAOPostgres(connessione);
		if(u2.esisteUtente(email, pwd))
			return true;
		else
			return false;
	}
		
}

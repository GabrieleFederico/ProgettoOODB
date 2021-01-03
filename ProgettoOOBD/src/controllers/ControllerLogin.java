package controllers;

import java.sql.SQLException;

import classiEntità.Utente;
import interfacceGrafiche.Errore;
import interfacceGrafiche.JFrameLogin;
import interfacceGrafiche.JFrameRegistrati;
import postgresDAOImpl.UtenteDAOPostgres;


public class ControllerLogin {

	private JFrameRegistrati fr;
	private JFrameLogin fl;

	public ControllerLogin(ControllorePrincipale controller) {
			
		fl = new JFrameLogin(this, controller);
		fl.setVisible(true);
	}
		
	public void LoginRegistratiButton() {
			
		fr = new JFrameRegistrati(this);
		fl.setVisible(false);
		fr.setVisible(true);
	}

	
	public void RegistraCredenziali(String email, String pwd, String nome, String cognome, String indirizzo) throws SQLException {

		UtenteDAOPostgres u1 = new UtenteDAOPostgres();
		Utente utente = new Utente (email, pwd, nome, cognome, indirizzo);
		u1.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);
			
	}
	public boolean ControllaCredenziali(String email, String pwd) throws SQLException{
		
		UtenteDAOPostgres u2 = new UtenteDAOPostgres();
		if(u2.esisteUtente(email, pwd)) 
			return true;
		else 
			return false;
		
	}
	
	public void PassaAdHome(ControllerLogin this, ControllorePrincipale c) {
		fl.dispose();
		c.PassaAdHome(this);
		
	}
}

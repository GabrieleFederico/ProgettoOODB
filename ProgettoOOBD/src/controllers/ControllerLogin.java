package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import classiEntità.Utente;
import controllers.ControllerLogin;
import interfacce.JFrameLogin;
import interfacce.JFrameRegistrati;
import postgresDAOImpl.UtenteDAOPostgres;


public class ControllerLogin {


	JFrameRegistrati fr;
	JFrameLogin fl;
	UtenteDAOPostgres u1;
	private Connection connessione;
	
	public static void main(String[] args) {
		ControllerLogin c = new ControllerLogin();
	}		
	
		public ControllerLogin() {
				
				fl = new JFrameLogin(this);
				fl.setVisible(true);
		}
		
		public void LoginRegistratiButton() {
			
			fr = new JFrameRegistrati(this);
			fl.setVisible(false);
			fr.setVisible(true);
		}

		public void RegistraCredenziali(String email, String pwd, String nome, String cognome, String indirizzo) throws SQLException {
			
			u1 = new UtenteDAOPostgres(connessione);
			
			Utente utente = new Utente (email, pwd, nome, cognome, indirizzo);
			
			fl.setVisible(true);
			fr.setVisible(false);
			
		}
		
}

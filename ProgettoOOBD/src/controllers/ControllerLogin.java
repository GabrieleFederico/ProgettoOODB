package controllers;

import java.sql.SQLException;

import classiEntità.Rider;
import classiEntità.Utente;
import interfacceGrafiche.Errore;
import interfacceGrafiche.JFrameLogin;
import interfacceGrafiche.JFrameRegistrati;
import postgresDAOImpl.RiderDAOPostgres;
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
		Utente utente = new Utente(email, pwd, nome, cognome, indirizzo);
		u1.inserisciUtente(utente);

		fl.setVisible(true);
		fr.setVisible(false);

	}

	public Utente ControllaCredenziali(String email, String pwd) throws SQLException {

		UtenteDAOPostgres u2 = new UtenteDAOPostgres();
		Utente utente = new Utente(email, pwd, null, null, null);
		utente = u2.getUtenteByCredenziali(email, pwd);
		
		return utente;

	}

	public void PassaAdHomeUtente(ControllerLogin this, ControllorePrincipale c, Utente utente) {
		fl.dispose();
		c.passaAdHomeUtente(this, utente);

	}
	
	public void PassaAdHomeRider(ControllerLogin this, ControllorePrincipale c, Rider rider) {
		fl.dispose();
		c.passaAdHomeRider(this, rider);

	}
	
	public Rider getRider(String email, String password) {
		
		Rider rider = null;
		RiderDAOPostgres rd = new RiderDAOPostgres();
		
		rider = rd.getRiderByEmail(email, password);
		
		
		return rider;
	}
}

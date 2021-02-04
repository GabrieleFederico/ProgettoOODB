package controllers;

import java.sql.SQLException;

import classiEntità.Riders;
import classiEntità.Utenti;
import interfacceGrafiche.JDialogErroreLogin;
import interfacceGrafiche.JFrameLogin;
import interfacceGrafiche.JFrameRegistratiRider;
import interfacceGrafiche.JFrameRegistratiUtente;
import postgresDAOImpl.RidersDAOPostgres;
import postgresDAOImpl.UtentiDAOPostgres;

public class ControllerLogin {

	private JFrameRegistratiUtente fr;
	private JFrameLogin fl;
	private JFrameRegistratiRider frr;
	private ControllerPrincipale cc;

	public ControllerLogin(ControllerPrincipale controller) {

		fl = new JFrameLogin(this, controller);
		fl.setVisible(true);
		cc = controller;
	}

	public void loginRegistratiButton() {

		fr = new JFrameRegistratiUtente(this);
		fl.setVisible(false);
		fr.setVisible(true);
	}

	public void registraCredenzialiUtente(String email, String pwd, String nome, String cognome, String indirizzo) throws SQLException {

		UtentiDAOPostgres u1 = new UtentiDAOPostgres();
		Utenti utente = new Utenti(email, pwd, nome, cognome, indirizzo);
		u1.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);

	}

	public Utenti controllaCredenziali(String email, String pwd) throws SQLException {
		
		UtentiDAOPostgres u2 = new UtentiDAOPostgres();
		Utenti utente = new Utenti();
		utente = u2.getUtenteByCredenziali(email, pwd);
		
		return utente;
	}

	public void PassaAdHomeUtente(ControllerLogin this, ControllerPrincipale c, Utenti utente) {
		fl.dispose();
		c.passaAdHomeUtente(this, utente);

	}
	
	public void PassaAdHomeRider(ControllerLogin this, ControllerPrincipale c, Riders rider) {
		fl.dispose();
		c.passaAdHomeRider(this, rider);

	}
	
	public Riders getRider(String email, String password) {
		
		RidersDAOPostgres rd = new RidersDAOPostgres();
		Riders rider = rd.getRiderByEmail(email, password);
		
		return rider;
	}
	
	public void registraCredenzialiRider(String nome, String cognome, String email, String mezzo, String password) {
		
		RidersDAOPostgres r1 = new RidersDAOPostgres();
		r1.inserisciRider(nome, cognome, email, mezzo, password);
		fl.setVisible(true);
		frr.setVisible(false);		
	}

	public void loginRegistratiRiderButton() {
		frr = new JFrameRegistratiRider(this);
		fl.setVisible(false);
		frr.setVisible(true);
		
	}

	public void tornaHomeDaUtente() {
		
		fr.setVisible(false);
		fl = new JFrameLogin(this, cc);
		fl.setVisible(true);
	}
	
	public void tornaHomeDaRider() {

		frr.setVisible(false);
		fl = new JFrameLogin(this, cc);
		fl.setVisible(true);	
	}

}

package controllers;

import java.sql.SQLException;

import classiEntità.Rider;
import classiEntità.Utente;
import interfacceGrafiche.JDialogErroreLogin;
import interfacceGrafiche.JFrameLogin;
import interfacceGrafiche.JFrameRegistratiRider;
import interfacceGrafiche.JFrameRegistratiUtente;
import postgresDAOImpl.RiderDAOPostgres;
import postgresDAOImpl.UtenteDAOPostgres;

public class ControllerLogin {

	private JFrameRegistratiUtente fr;
	private JFrameLogin fl;
	private JFrameRegistratiRider frr;
	private ControllorePrincipale cc;

	public ControllerLogin(ControllorePrincipale controller) {

		fl = new JFrameLogin(this, controller);
		fl.setVisible(true);
		cc = controller;
	}

	public void LoginRegistratiButton() {

		fr = new JFrameRegistratiUtente(this);
		fl.setVisible(false);
		fr.setVisible(true);
	}

	public void RegistraCredenzialiUtente(String email, String pwd, String nome, String cognome, String indirizzo) throws SQLException {

		UtenteDAOPostgres u1 = new UtenteDAOPostgres();
		Utente utente = new Utente(email, pwd, nome, cognome, indirizzo);
		u1.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);

	}

	public Utente ControllaCredenziali(String email, String pwd) throws SQLException {
		
		UtenteDAOPostgres u2 = new UtenteDAOPostgres();
		Utente utente = new Utente();
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
		
		RiderDAOPostgres rd = new RiderDAOPostgres();
		Rider rider = rd.getRiderByEmail(email, password);
		
		return rider;
	}
	
	public void RegistraCredenzialiRider(String nome, String cognome, String email, String mezzo, String password) {
		
		RiderDAOPostgres r1 = new RiderDAOPostgres();
		r1.inserisciRider(nome, cognome, email, mezzo, password);
		fl.setVisible(true);
		frr.setVisible(false);		
	}

	public void LoginRegistratiRiderButton() {
		frr = new JFrameRegistratiRider(this);
		fl.setVisible(false);
		frr.setVisible(true);
		
	}

	public void TornaHomeDaUtente() {
		
		fr.setVisible(false);
		fl = new JFrameLogin(this, cc);
		fl.setVisible(true);
	}
	
	public void TornaHomeDaRider() {

		frr.setVisible(false);
		fl = new JFrameLogin(this, cc);
		fl.setVisible(true);	
	}

}

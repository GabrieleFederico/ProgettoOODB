package controllers;

import java.sql.SQLException;

import classiEntità.Riders;
import classiEntità.Utenti;
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

	private RidersDAOPostgres riderDao = new RidersDAOPostgres();
	private UtentiDAOPostgres utenteDao = new UtentiDAOPostgres();

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

	public void registraCredenzialiUtente(Utenti utente) throws SQLException {

		utenteDao.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);

	}

	public Utenti controllaCredenziali(String email, String pwd) throws SQLException {
		
		Utenti utente = new Utenti();
		utente = utenteDao.getUtenteByCredenziali(email, pwd);
		
		return utente;
	}

	public void passaAdHomeUtente(ControllerLogin this, ControllerPrincipale c, Utenti utente) {
		fl.dispose();
		c.passaAdHomeUtente(this, utente);

	}
	
	public void passaAdHomeRider(ControllerLogin this, ControllerPrincipale c, Riders rider) {
		fl.dispose();
		c.passaAdHomeRider(this, rider);

	}
	
	public Riders getRider(String email, String password) {
		
		Riders rider = riderDao.getRiderByEmail(email, password);
		
		return rider;
	}
	
	public void registraCredenzialiRider(Riders rider) {
		
		RidersDAOPostgres r1 = new RidersDAOPostgres();
		r1.inserisciRider(rider);
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

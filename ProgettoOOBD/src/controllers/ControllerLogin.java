package controllers;

import java.sql.SQLException;

import classiEntit�.Riders;
import classiEntit�.Utenti;
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

	private RidersDAOPostgres riderDao;
	private UtentiDAOPostgres utenteDao;

	public ControllerLogin(ControllerPrincipale controller) {

		riderDao = new RidersDAOPostgres();
		utenteDao = new UtentiDAOPostgres();
		fl = new JFrameLogin(this, controller);
		fl.setVisible(true);
		cc = controller;
	}

	public void loginRegistratiButton() {

		fr = new JFrameRegistratiUtente(this);
		fl.setVisible(false);
	}

	public void registraCredenzialiUtente(Utenti utente) {

		utenteDao.inserisciUtente(utente);
		
		fl.setVisible(true);
		fr.setVisible(false);

	}

	public Utenti controllaCredenzialiUtente(String email, String pwd) throws SQLException {
		
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
	
	public Riders controllaCredenzialiRider(String email, String password) {
		
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

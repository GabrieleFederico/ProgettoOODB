package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import dbConn.ConnessioneDB;

public class ControllorePrincipale {

	public static void main(String[] args) {
		
		Connection connessione = null;
		ConnessioneDB connessioneDB = null;
		ControllorePrincipale principale = new ControllorePrincipale();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
		}
		catch (SQLException exception){
            System.out.println("SQLException: "+ exception.getMessage());
        }
		
		principale.Start(connessione);

	}
	
	void Start(Connection connessione) {
		ControllerLogin c = new ControllerLogin(connessione, this);
	}
	
	void PassaAdHome(ControllerLogin c, Connection connessione) {
		c.fl.dispose();
		ControllerRicerca c1 = new ControllerRicerca(connessione);
	}
}

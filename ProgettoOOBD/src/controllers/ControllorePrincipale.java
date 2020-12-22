package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import dbConn.ConnessioneDB;

public class ControllorePrincipale {

	public static void main(String[] args) {
		
		Connection connessione = null;
		ConnessioneDB connessioneDB = null;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
		}
		catch (SQLException exception)
        {
            System.out.println("SQLException: "+ exception.getMessage());
        }
		
		ControllerLogin c = new ControllerLogin(connessione);

	}

}

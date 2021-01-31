package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.ConsegneSenzaRider;
import classiEntità.Prodotto;
import classiEntità.Rider;
import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.ConsegneDAO;

public class ConsegneDAOPostgres implements ConsegneDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getConsegneByUtentePS, getConsegneByRiderPS, creaConsegnaPS, getConsegneByMezzoPS;
	
	@Override
	public ArrayList<Consegne> getConsegneByUtente(Utente utente) {
		
		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		Consegne temp; 
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByUtentePS = connessione.prepareStatement("SELECT * FROM archivioconsegne NATURAL JOIN consegne WHERE email = ?");
			getConsegneByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getConsegneByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Consegne();
				temp.setCodC(rs.getString("codc"));
				temp.setOrario(rs.getTime("dataconsegna"));
				temp.setIndirizzoP(rs.getString("indirizzop"));
				temp.setIndirizzoA(rs.getString("indirizzoa"));
				risultato.add(temp);
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
	
	@Override
	public ArrayList<Consegne> getConsegneByRider(Rider rider) {
		
		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		Consegne temp; 
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByRiderPS = connessione.prepareStatement("SELECT * FROM archivioconsegne NATURAL JOIN consegne WHERE codr = ?");
			getConsegneByRiderPS.setString(1, rider.getCodR());
			ResultSet rs = getConsegneByRiderPS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Consegne();
				temp.setCodC(rs.getString("codc"));
				temp.setOrario(rs.getTime("dataconsegna"));
				temp.setIndirizzoP(rs.getString("indirizzop"));
				temp.setIndirizzoA(rs.getString("indirizzoa"));
				risultato.add(temp);
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
	
	public void creaConsegna(String indirizzoP, Utente utente) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			creaConsegnaPS = connessione.prepareStatement("INSERT INTO CONSEGNE VALUES (default, CURRENT_TIMESTAMP, ?, ?, ?, 'false', null)");
			creaConsegnaPS.setString(1, indirizzoP);
			creaConsegnaPS.setString(2, utente.getIndirizzo());
			creaConsegnaPS.setString(3, utente.getEmail());
			creaConsegnaPS.executeUpdate();
			connessione.close();
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<ConsegneSenzaRider> getConsegneByMezzo(String mezzo) {

		ArrayList<ConsegneSenzaRider> risultato = new ArrayList<ConsegneSenzaRider>();
		ConsegneSenzaRider temp;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByMezzoPS = connessione.prepareStatement("SELECT  CS.CodC, CS.Orario, CS.IndirizzoP, CS.IndirizzoA, U.Nome, U.Cognome, U.emailUtente,"
																+ "CS.Mezzo FROM CONSEGNESENZARIDER AS CS NATURAL JOIN UTENTE AS U WHERE Mezzo = ?");
			getConsegneByMezzoPS.setString(1, mezzo);
			ResultSet rs = getConsegneByMezzoPS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new ConsegneSenzaRider();
				temp.setCodC(rs.getString("CodC"));
				temp.setOrario(rs.getTime("Orario"));
				temp.setIndirizzoP(rs.getString("IndirizzoP"));
				temp.setIndirizzoA(rs.getString("IndirizzoA"));
				temp.setNomeUtente(rs.getString("Nome"));
				temp.setCognomeUtente(rs.getString("cognome"));
				temp.setEmailUtente(rs.getString("EmailUtente"));
				temp.setMezzo(rs.getString("Mezzo"));
				risultato.add(temp);
			}
		} 
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
		
}
	
	



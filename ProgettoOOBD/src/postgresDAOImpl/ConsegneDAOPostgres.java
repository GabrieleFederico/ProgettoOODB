package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;

import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Riders;
import classiEntit‡.Utenti;
import controllers.ControllerConsegneRider;
import dbConn.ConnessioneDB;
import interfacceDAO.ConsegneDAO;

public class ConsegneDAOPostgres implements ConsegneDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getConsegneByUtentePS, getConsegneByRiderPS, creaConsegnaPS, getConsegneByMezzoPS, getOrdiniByRiderPS;
	private PreparedStatement assegnaConsegnaRiderPS, ordineConsegnatoPS;
	
	@Override
	public ArrayList<Consegne> getConsegneByUtente(Utenti utente) {
		
		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		Consegne temp; 
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByUtentePS = connessione.prepareStatement("SELECT * FROM archivioconsegne WHERE emailutente = ?");
			getConsegneByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getConsegneByUtentePS.executeQuery();
			
			
			while(rs.next()) {
				temp = new Consegne();
				temp.setCodC(rs.getString("codc"));
				temp.setOrario(rs.getTimestamp("dataeoraconsegna"));
				temp.setIndirizzoP(rs.getString("indirizzop"));
				temp.setIndirizzoA(rs.getString("indirizzoa"));
				temp.setConsegnato(true);
				risultato.add(temp);
			}
			
			getConsegneByUtentePS = connessione.prepareStatement("SELECT * FROM consegne WHERE emailutente = ?");
			getConsegneByUtentePS.setString(1, utente.getEmail());
			rs = getConsegneByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Consegne();
				temp.setCodC(rs.getString("codc"));
				temp.setOrario(rs.getTimestamp("orario"));
				temp.setIndirizzoP(rs.getString("indirizzop"));
				temp.setIndirizzoA(rs.getString("indirizzoa"));
				temp.setConsegnato(rs.getBoolean("consegnato"));
				risultato.add(temp);
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
	
	@Override
	public ArrayList<Consegne> getConsegneByRider(Riders rider) {
		
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
				temp.setOrario(rs.getTimestamp("dataconsegna"));
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
	
	public void creaConsegna(String indirizzoP, Utenti utente, String mezzo, String orario) {
		
		
		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			creaConsegnaPS = connessione.prepareStatement("INSERT INTO CONSEGNE VALUES (default, ?, ?, ?, ?, 'false', null, ?)");
			creaConsegnaPS.setTime(1, Time.valueOf(orario + ":00"));
			creaConsegnaPS.setString(2, indirizzoP);
			creaConsegnaPS.setString(3, utente.getIndirizzo());
			creaConsegnaPS.setString(4, utente.getEmail());
			creaConsegnaPS.setString(5, mezzo);
			creaConsegnaPS.executeUpdate();
			
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Consegne> getConsegneByMezzo(String mezzo) {

		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		Consegne temp;
		Carrello carrello = new Carrello();
		Utenti utente = new Utenti();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByMezzoPS = connessione.prepareStatement("SELECT  CONSEGNE.CodC, CONSEGNE.Orario, CONSEGNE.IndirizzoP, CONSEGNE.IndirizzoA, CONSEGNE.emailutente," 
																+ "UTENTE.Nome, UTENTE.Cognome FROM CONSEGNE NATURAL JOIN UTENTE "
																+ "WHERE CONSEGNE.CodR IS NULL AND (CONSEGNE.mezzorichiesto = ? OR CONSEGNE.mezzorichiesto IS NULL)");
			getConsegneByMezzoPS.setString(1, mezzo);
			ResultSet rs = getConsegneByMezzoPS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Consegne();
				temp.setCodC(rs.getString("CodC"));
				temp.setOrario(rs.getTimestamp("Orario"));
				temp.setIndirizzoP(rs.getString("IndirizzoP"));
				temp.setIndirizzoA(rs.getString("IndirizzoA"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setEmail(rs.getString("EmailUtente"));
				carrello.setProprietario(utente);
				temp.setComposizioneConsegna(carrello);
				risultato.add(temp);
			
			}
		} 
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}


	public void assegnaConsegnaRider(String CodR, String CodC, ControllerConsegneRider cc) {

		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			assegnaConsegnaRiderPS =  connessione.prepareStatement("UPDATE consegne SET CodR = ? WHERE CodC = ?");
			assegnaConsegnaRiderPS.setString(1, CodR);
			assegnaConsegnaRiderPS.setString(2, CodC);
			assegnaConsegnaRiderPS.executeUpdate();
		
		} catch (SQLException e) {
				cc.maxAttivit‡Rider();
		} 
		
	}

	public void ordineConsegnato(String CodC) {

		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			ordineConsegnatoPS =  connessione.prepareStatement("UPDATE consegne SET consegnato = TRUE WHERE CodC = ?");
			ordineConsegnatoPS.setString(1, CodC);
			ordineConsegnatoPS.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Consegne> getOrdiniByRider(Riders rider) {
		
		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getOrdiniByRiderPS = connessione.prepareStatement("SELECT CONSEGNE.CodC, CONSEGNE.Orario, CONSEGNE.IndirizzoP, CONSEGNE.IndirizzoA, CONSEGNE.emailutente, "
					 										+ "UTENTE.Nome, UTENTE.Cognome FROM CONSEGNE NATURAL JOIN UTENTE "
					 										+ "WHERE CONSEGNE.CodR = ?");
			getOrdiniByRiderPS.setString(1, rider.getCodR());
			ResultSet rs = getOrdiniByRiderPS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				Consegne consegne = new Consegne();
				consegne.setCodC(rs.getString("CodC"));
				consegne.setOrario(rs.getTimestamp("orario"));
				consegne.setIndirizzoP(rs.getString("IndirizzoP"));
				consegne.setIndirizzoA(rs.getString("IndirizzoA"));
				Utenti utente = new Utenti();
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setEmail(rs.getString("EmailUtente"));
				Carrello carrello = new Carrello();
				carrello.setProprietario(utente);
				consegne.setComposizioneConsegna(carrello);
				risultato.add(consegne);
			}  
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
		
}
	
	



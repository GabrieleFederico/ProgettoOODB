package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Rider;
import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.ConsegneDAO;

public class ConsegneDAOPostgres implements ConsegneDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getConsegneByUtentePS, getConsegneByRiderPS, creaConsegnaPS, getConsegneByMezzoPS, getCodCOrdinePS;
	private PreparedStatement assegnaConsegnaRiderPS, ordineConsegnatoPS;
	
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
	
	public void creaConsegna(String indirizzoP, Utente utente, String mezzo, String orario, String CodC) {
		
		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			creaConsegnaPS = connessione.prepareStatement("INSERT INTO CONSEGNE VALUES (?, ?, ?, ?, ?, 'false', null, ?)");
			creaConsegnaPS.setString(1, CodC);
			creaConsegnaPS.setTime(2, Time.valueOf(orario + ":00"));
			creaConsegnaPS.setString(3, indirizzoP);
			creaConsegnaPS.setString(4, utente.getIndirizzo());
			creaConsegnaPS.setString(5, utente.getEmail());
			creaConsegnaPS.setString(6, mezzo);
			creaConsegnaPS.executeUpdate();
			connessione.close();
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Consegne> getConsegneByMezzo(String mezzo) {

		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		Consegne temp;
		Carrello carrello = new Carrello();
		Utente utente = new Utente();
		
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
				temp.setOrario(rs.getTime("Orario"));
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

	public String getCodCOrdine(String proprietario, String provenienzaProdotto) {
		
		String codice = null;
		
		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCodCOrdinePS = connessione.prepareStatement("select distinct CodC from carrello where proprietario = ? AND provenienzaProdotto = ?");
			getCodCOrdinePS.setString(1, proprietario);
			getCodCOrdinePS.setString(2, provenienzaProdotto);
			ResultSet rs = getCodCOrdinePS.executeQuery();
			
			while(rs.next()) {
				codice = rs.getString("CodC");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return codice;
		
	}

	public void assegnaConsegnaRider(String CodR, String CodC) {

		try {			
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			assegnaConsegnaRiderPS =  connessione.prepareStatement("UPDATE consegne SET CodR = ? WHERE CodC = ?");
			assegnaConsegnaRiderPS.setString(1, CodR);
			assegnaConsegnaRiderPS.setString(2, CodC);
			assegnaConsegnaRiderPS.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		
}
	
	



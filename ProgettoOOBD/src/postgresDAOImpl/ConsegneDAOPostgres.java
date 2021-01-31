package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void creaConsegna() {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			creaConsegnaPS = connessione.prepareStatement("");
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
		
}
	
	



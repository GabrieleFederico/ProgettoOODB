package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Rider;
import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.RiderDAO;

public class RiderDAOPostgres implements RiderDAO{
	

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getRiderByEmailPS, inserisciRiderPS, getOrdiniByRiderPS;

	
	public Rider getRiderByEmail(String email, String password) {
		
		Rider risultato = new Rider();

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getRiderByEmailPS = connessione.prepareStatement("SELECT * FROM rider WHERE emailrider = ? AND pwd = ?");
			getRiderByEmailPS.setString(1, email);
			getRiderByEmailPS.setString(2, password);
			ResultSet rs = getRiderByEmailPS.executeQuery();
			connessione.close();
			
			if(rs.next()) {
				risultato.setCodR(rs.getString("CodR"));
				risultato.setCognome(rs.getString("cognome"));
				risultato.setNome(rs.getString("nome"));
				risultato.setMezzo(rs.getString("mezzo"));
				return risultato;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		return null;
	}
	
	public void inserisciRider(String nome, String cognome, String email, String mezzo, String password) {
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			inserisciRiderPS = connessione.prepareStatement("INSERT INTO RIDER VALUES (default, ?, ?, ?, ?, ?);");
			inserisciRiderPS.setString(1, nome);
			inserisciRiderPS.setString(2, cognome);
			inserisciRiderPS.setString(3, email);
			inserisciRiderPS.setString(4, mezzo);
			inserisciRiderPS.setString(5, password);
			inserisciRiderPS.executeUpdate();
			connessione.close();
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public ArrayList<Consegne> getOrdiniByRider(Rider rider) {
		
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
				consegne.setOrario(rs.getTime("orario"));
				consegne.setIndirizzoP(rs.getString("IndirizzoP"));
				consegne.setIndirizzoA(rs.getString("IndirizzoA"));
				Utente utente = new Utente();
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

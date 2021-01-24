package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntit�.Carrello;
import classiEntit�.Consegne;
import classiEntit�.Prodotto;
import classiEntit�.Rider;
import classiEntit�.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.ConsegneDAO;

public class ConsegneDAOPostgres implements ConsegneDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getConsegneByUtentePS, getConsegneByRiderPS;
	
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
	
	

}
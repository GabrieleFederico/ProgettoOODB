package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Carrello;
import classiEntità.Consegne;
import classiEntità.Prodotto;
import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.ConsegneDAO;

public class ConsegneDAOPostgres implements ConsegneDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getConsegneByUtentePS;
	
	@Override
	public ArrayList<Consegne> getConsegneByUtente(Utente utente) {
		
		ArrayList<Consegne> risultato = new ArrayList<Consegne>();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getConsegneByUtentePS = connessione.prepareStatement("SELECT * FROM archivioconsegne NATURAL JOIN consegne WHERE email = ?");
			getConsegneByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getConsegneByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	

}

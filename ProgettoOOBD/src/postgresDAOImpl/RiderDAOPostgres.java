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
	private PreparedStatement getRiderByEmailPS, inserisciRiderPS;

	
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




}

package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntit�.Carrello;
import classiEntit�.Consegne;
import classiEntit�.Men�;
import classiEntit�.Prodotti;
import classiEntit�.Riders;
import classiEntit�.Utenti;
import dbConn.ConnessioneDB;
import interfacceDAO.RidersDAO;

public class RidersDAOPostgres implements RidersDAO{
	

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getRiderByEmailPS, inserisciRiderPS;

	
	public Riders getRiderByEmail(String email, String password) {
		
		Riders risultato = new Riders();

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
	
	public void inserisciRider(Riders rider) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			inserisciRiderPS = connessione.prepareStatement("INSERT INTO RIDER VALUES (default, ?, ?, ?, ?, ?);");
			inserisciRiderPS.setString(1, rider.getNome());
			inserisciRiderPS.setString(2, rider.getCognome());
			inserisciRiderPS.setString(3, rider.getEmail());
			inserisciRiderPS.setString(4, rider.getMezzo());
			inserisciRiderPS.setString(5, rider.getPassword());
			inserisciRiderPS.executeUpdate();
			connessione.close();
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}


}
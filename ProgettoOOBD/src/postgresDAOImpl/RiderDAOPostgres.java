package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Rider;
import dbConn.ConnessioneDB;
import interfacceDAO.RiderDAO;

public class RiderDAOPostgres implements RiderDAO{
	

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getRiderByEmail;

	
	public Rider getRiderByEmail(String email, String password) {
		
		Rider risultato = new Rider();

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getRiderByEmail = connessione.prepareStatement("SELECT * FROM rider WHERE emailrider = ? AND pwd = ?");
			getRiderByEmail.setString(1, email);
			getRiderByEmail.setString(2, password);
			ResultSet rs = getRiderByEmail.executeQuery();
			connessione.close();
			
			if(rs.next()) {
				risultato.setCognome(rs.getString("cognome"));
				risultato.setNome(rs.getString("nome"));
				risultato.setMezzo(rs.getString("mezzo"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		return risultato;
	}
	
	@Override
	public ArrayList<Rider> getAllRider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rider> getRiderByMezzo(String mezzo) {
		// TODO Auto-generated method stub
		return null;
	}

}

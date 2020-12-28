package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.UtenteDAO;

public class UtenteDAOPostgres implements UtenteDAO {

	private ConnessioneDB connessioneDB;
	private Connection connessione;
	private PreparedStatement inserisciUtentePS, getAllUtentiPS, esisteUtentePS;

	@Override
	public void inserisciUtente(Utente utente) {
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			inserisciUtentePS = connessione.prepareStatement("INSERT INTO Utente VALUES (?, ?, ?, ?, ?)");
			inserisciUtentePS.setString(1, utente.getNome());
			inserisciUtentePS.setString(2, utente.getEmail());
			inserisciUtentePS.setString(3, utente.getIndirizzo());
			inserisciUtentePS.setString(4, utente.getPassword());
			inserisciUtentePS.setString(5, utente.getCognome());
			inserisciUtentePS.executeUpdate();
			connessione.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public boolean esisteUtente(String email, String pwd) {
		
		boolean esiste = false;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			esisteUtentePS = connessione.prepareStatement("SELECT * FROM Utente WHERE email = ? AND pwd = ?");
			esisteUtentePS.setString(1, email);
			esisteUtentePS.setString(2, pwd);
			ResultSet rs = esisteUtentePS.executeQuery();
			connessione.close();
			if(rs.next())
				esiste = true;
			else
				esiste = false;
		}
		
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return esiste;
	}

	@Override
	public ArrayList<Utente> getAllUtenti() {
		
		return null;
	}

	
}

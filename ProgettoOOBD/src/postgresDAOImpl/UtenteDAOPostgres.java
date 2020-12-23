package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Utente;
import interfacceDAO.UtenteDAO;

public class UtenteDAOPostgres implements UtenteDAO {

	private Connection connessione;
	private PreparedStatement inserisciUtentePS, getAllUtentiPS, esisteUtentePS;

	public UtenteDAOPostgres(Connection connessione) throws SQLException {
		this.connessione = connessione;
		inserisciUtentePS = connessione.prepareStatement("INSERT INTO Utente VALUES (?, ?, ?, ?, ?)");
		esisteUtentePS = connessione.prepareStatement("SELECT * FROM Utente WHERE email = ? AND pwd = ?");
	}

	@Override
	public void inserisciUtente(Utente utente) throws SQLException {
		inserisciUtentePS.setString(1, utente.getNome());
		inserisciUtentePS.setString(2, utente.getEmail());
		inserisciUtentePS.setString(3, utente.getIndirizzo());
		inserisciUtentePS.setString(4, utente.getPassword());
		inserisciUtentePS.setString(5, utente.getCognome());
		inserisciUtentePS.executeUpdate();
	}
	
	@Override
	public boolean esisteUtente(String email, String pwd) throws SQLException {
		
		esisteUtentePS.setString(1, email);
		esisteUtentePS.setString(2, pwd);
		ResultSet rs = esisteUtentePS.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Utente> getAllUtenti() {
		
		return null;
	}

	
}

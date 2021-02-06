package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Utenti;
import dbConn.ConnessioneDB;
import interfacceDAO.UtentiDAO;
import interfacceGrafiche.JDialogErrore;

public class UtentiDAOPostgres implements UtentiDAO {

	private ConnessioneDB connessioneDB;
	private Connection connessione;
	private PreparedStatement inserisciUtentePS, esisteUtentePS;

	@Override
	public void inserisciUtente(Utenti utente) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			inserisciUtentePS = connessione.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, ?)");
			inserisciUtentePS.setString(1, utente.getEmail());
			inserisciUtentePS.setString(2, utente.getPassword());
			inserisciUtentePS.setString(3, utente.getNome());
			inserisciUtentePS.setString(4, utente.getCognome());
			inserisciUtentePS.setString(5, utente.getIndirizzo());
			inserisciUtentePS.executeUpdate();
			connessione.close();
		}
		catch(SQLException e){
			JDialogErrore errore = new JDialogErrore("Errore in fase di registrazione: controllare i dati e riprovare");
		}
	}
	
	@Override
	public Utenti getUtenteByCredenziali(String email, String pwd) {
		
		Utenti risultato = new Utenti();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			esisteUtentePS = connessione.prepareStatement("SELECT * FROM Utente WHERE emailUtente = ? AND pwd = ?");
			esisteUtentePS.setString(1, email);
			esisteUtentePS.setString(2, pwd);
			ResultSet rs = esisteUtentePS.executeQuery();
			connessione.close();
			
			if(rs.next()) {
				risultato.setEmail(email);
				risultato.setPassword(pwd);
				risultato.setNome(rs.getString("nome"));
				risultato.setCognome(rs.getString("cognome"));
				risultato.setIndirizzo(rs.getString("indirizzo"));
			}
			else {
				risultato = null;
			}
		}
		
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}
		
		return risultato;
	}

	
}

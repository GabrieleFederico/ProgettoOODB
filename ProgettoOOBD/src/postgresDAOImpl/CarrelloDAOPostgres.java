package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classiEntit�.Carrello;
import classiEntit�.Prodotto;
import classiEntit�.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistoranteDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getCarrelloByUtentePS;
	
	@Override
	public void aggiungiProdottoAlCarrello(String nomep, int quantit�, Utente utente) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?, ?)");
			getCarrelloByUtentePS.setString(1, "codice");
			getCarrelloByUtentePS.setString(2, nomep);
			getCarrelloByUtentePS.setInt(3, quantit�);
			getCarrelloByUtentePS.setString(4, utente.getEmail());
			getCarrelloByUtentePS.executeUpdate();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Carrello getCarrelloByUtente(Utente utente) {
		
		Carrello risultato = new Carrello(utente);
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("SELECT nomep, quantitaprodotto FROM carrello WHERE proprietario LIKE ?");
			getCarrelloByUtentePS.setString(1, utente.getEmail());
			getCarrelloByUtentePS.executeQuery();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return risultato;
	}


}
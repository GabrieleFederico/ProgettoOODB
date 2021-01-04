package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classiEntitą.Carrello;
import classiEntitą.Prodotto;
import classiEntitą.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistoranteDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getCarrelloByUtentePS;
	
	public void aggiungiProdottoAlCarrello(String nomep, int quantitą, String email) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?)");
			getCarrelloByUtentePS.setString(1, nomep);
			getCarrelloByUtentePS.setInt(2, quantitą);
			getCarrelloByUtentePS.setString(3, email);
			getCarrelloByUtentePS.executeUpdate();
			connessione.close();

		} catch (SQLException e) {
		System.out.println(e.getMessage());

		}
	}

	@Override
	public Carrello getCarrelloByUtente(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}
}
package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classiEntit‡.Carrello;
import classiEntit‡.Prodotto;
import classiEntit‡.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistoranteDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement aggiungiProdottoAlCarrelloPS, getCarrelloByUtentePS;
	
	@Override
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utente utente) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			aggiungiProdottoAlCarrelloPS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?, ?)");
			aggiungiProdottoAlCarrelloPS.setString(1, "codice");
			aggiungiProdottoAlCarrelloPS.setString(2, nomep);
			aggiungiProdottoAlCarrelloPS.setInt(3, quantit‡);
			aggiungiProdottoAlCarrelloPS.setString(4, utente.getEmail());
			aggiungiProdottoAlCarrelloPS.executeUpdate();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Carrello getCarrelloByUtente(Utente utente) {
		
		Carrello risultato = new Carrello(utente);
		Prodotto temp;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("SELECT nomep, quantitaprodotto FROM carrello WHERE proprietario LIKE ?");
			getCarrelloByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getCarrelloByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultato.getProdotti().add(temp);
				risultato.getQuantit‡Prodotti().add(rs.getInt("quantitaprodotto"));
			}

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return risultato;
	}


}
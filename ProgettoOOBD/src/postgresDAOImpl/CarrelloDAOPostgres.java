package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import classiEntit‡.Carrello;
import classiEntit‡.Prodotto;
import classiEntit‡.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistoranteDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement aggiungiProdottoAlCarrelloPS, getCarrelloByUtentePS, rimuoviProdottoDalCarrelloPS, getArrayListPrezziPS, cambiaQuantit‡CarrelloPS;
	
	@Override
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utente utente, double prezzo) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			aggiungiProdottoAlCarrelloPS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?, ?, ?)");
			aggiungiProdottoAlCarrelloPS.setString(1, "codice");
			aggiungiProdottoAlCarrelloPS.setString(2, nomep);
			aggiungiProdottoAlCarrelloPS.setInt(3, quantit‡);
			aggiungiProdottoAlCarrelloPS.setString(4, utente.getEmail());
			aggiungiProdottoAlCarrelloPS.setDouble(5, prezzo);
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

	public void rimuoviProdottoDalCarrello(Carrello carrello, int indice) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			rimuoviProdottoDalCarrelloPS = connessione.prepareStatement("DELETE FROM carrello WHERE proprietario = ? AND nomep = ?");
			rimuoviProdottoDalCarrelloPS.setString(1, carrello.getProprietario().getEmail());
			rimuoviProdottoDalCarrelloPS.setString(2, carrello.getProdotti().get(indice).getNomeP());
			rimuoviProdottoDalCarrelloPS.executeUpdate();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public ArrayList<Double> getArrayListPrezzi(Carrello carrello) {
		
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		double temp;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getArrayListPrezziPS = connessione.prepareStatement("SELECT prezzo FROM carrello WHERE proprietario = ?");
			getArrayListPrezziPS.setString(1, carrello.getProprietario().getEmail());
			ResultSet rs = getArrayListPrezziPS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = rs.getDouble("prezzo");
				risultatoPrezzi.add(temp);
				
			}
				
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultatoPrezzi;
	}

	public void cambiaQuantit‡Carrello(int nuovoValore, Carrello carrello, String nomeProdotto) {

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			cambiaQuantit‡CarrelloPS = connessione.prepareStatement("UPDATE CARRELLO SET quantitaprodotto = ? WHERE proprietario = ? AND nomep = ?");
			cambiaQuantit‡CarrelloPS.setInt(1, nuovoValore);
			cambiaQuantit‡CarrelloPS.setString(2, carrello.getProprietario().getEmail());
			cambiaQuantit‡CarrelloPS.setString(3, nomeProdotto);
			cambiaQuantit‡CarrelloPS.executeUpdate();
			connessione.close();	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}


package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Prodotto;
import classiEntit‡.Ristorante;
import classiEntit‡.Utente;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistoranteDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement aggiungiProdottoAlCarrelloPS, getCarrelloByUtentePS, rimuoviProdottoDalCarrelloPS, getArrayListPrezziPS, cambiaQuantit‡CarrelloPS;
	private PreparedStatement getCarrelloByOrdinePS, esisteRistorantePS;
	
	@Override
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utente utente, double prezzo, Ristorante ristorante) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			aggiungiProdottoAlCarrelloPS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?, ?, ?)");
			aggiungiProdottoAlCarrelloPS.setString(1, nomep);
			aggiungiProdottoAlCarrelloPS.setInt(2, quantit‡);
			aggiungiProdottoAlCarrelloPS.setString(3, utente.getEmail());
			aggiungiProdottoAlCarrelloPS.setDouble(4, prezzo);
			aggiungiProdottoAlCarrelloPS.setString(5, ristorante.getNome());
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
		Ristorante temp2;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("SELECT nomep, quantitaprodotto, provenienzaprodotto FROM carrello WHERE proprietario = ? ORDER BY carrello.provenienzaprodotto ASC");
			getCarrelloByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getCarrelloByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultato.getProdotti().add(temp);
				risultato.getQuantit‡Prodotti().add(rs.getInt("quantitaprodotto"));
				temp2 = new Ristorante();
				temp2.setNome(rs.getString("provenienzaprodotto"));
				risultato.getProvenienzaProdotti().add(temp2);
				
			}

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return risultato;
	}

	public Ristorante rimuoviProdottoDalCarrello(Carrello carrello, int indice) {
		
		Ristorante ris = carrello.getProvenienzaProdotti().get(indice);
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			rimuoviProdottoDalCarrelloPS = connessione.prepareStatement("DELETE FROM carrello WHERE proprietario = ? AND nomep = ? AND provenienzaprodotto = ?");
			rimuoviProdottoDalCarrelloPS.setString(1, carrello.getProprietario().getEmail());
			rimuoviProdottoDalCarrelloPS.setString(2, carrello.getProdotti().get(indice).getNomeP());
			rimuoviProdottoDalCarrelloPS.setString(3, carrello.getProvenienzaProdotti().get(indice).getNome());
			rimuoviProdottoDalCarrelloPS.executeUpdate();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ris;
		
	}
	
	public boolean esisteRistoranteNelCarrello(Ristorante rist) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			esisteRistorantePS = connessione.prepareStatement("SELECT * FROM carrello WHERE provenienzaprodotto = ?");
			esisteRistorantePS.setString(1, rist.getNome());
			ResultSet rs = esisteRistorantePS.executeQuery();
			connessione.close();
			
			if(rs.next()) 
				return true;
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
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
	
	public Carrello getCarrelloByOrdine(Consegne ordine){
		
		Prodotto temp;
		Carrello risultato = new Carrello();
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByOrdinePS = connessione.prepareStatement("SELECT * FROM archiviocarrello WHERE codc = ?");
			getCarrelloByOrdinePS.setString(1, ordine.getCodC());
			ResultSet rs = getCarrelloByOrdinePS.executeQuery();
			connessione.close();
			
			while(rs.next()){
				temp = new Prodotto();
				temp.setNomeP(rs.getString("NomeP"));
				risultato.getProdotti().add(temp);
				risultato.getPrezzi().add(rs.getDouble("prezzo"));
			}
				
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
	
}


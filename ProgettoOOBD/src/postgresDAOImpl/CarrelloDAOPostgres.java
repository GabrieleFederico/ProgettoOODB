package postgresDAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JLabel;

import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Prodotti;
import classiEntit‡.Ristoranti;
import classiEntit‡.Utenti;
import dbConn.ConnessioneDB;
import interfacceDAO.CarrelloDAO;
import interfacceDAO.RistorantiDAO;

public class CarrelloDAOPostgres implements CarrelloDAO{
	
	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement aggiungiProdottoAlCarrelloPS, getCarrelloByUtentePS, rimuoviProdottoDalCarrelloPS, getArrayListPrezziPS, cambiaQuantit‡CarrelloPS;
	private PreparedStatement getCarrelloByOrdinePS, esisteRistorantePS;
	private CallableStatement archiviaCarrelloPS;
	
	@Override
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utenti utente, double prezzo, Ristoranti ristorante) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			aggiungiProdottoAlCarrelloPS = connessione.prepareStatement("INSERT INTO Carrello VALUES (?, ?, ?, ?, ?)");
			aggiungiProdottoAlCarrelloPS.setString(1, nomep);
			aggiungiProdottoAlCarrelloPS.setInt(2, quantit‡);
			aggiungiProdottoAlCarrelloPS.setString(3, utente.getEmail());
			aggiungiProdottoAlCarrelloPS.setString(4, ristorante.getNome() + "," + ristorante.getIndirizzo());
			aggiungiProdottoAlCarrelloPS.setDouble(5, prezzo);

			aggiungiProdottoAlCarrelloPS.executeUpdate();
			connessione.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Carrello getCarrelloByUtente(Utenti utente) {
		
		Carrello risultato = new Carrello(utente);
		Prodotti temp;
		Ristoranti temp2;
		String tmp;
		int i;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByUtentePS = connessione.prepareStatement("SELECT prodotto, quantitaprodotto, provenienzaprodotto FROM carrello WHERE proprietario = ? ORDER BY carrello.provenienzaprodotto ASC");
			getCarrelloByUtentePS.setString(1, utente.getEmail());
			ResultSet rs = getCarrelloByUtentePS.executeQuery();
			connessione.close();
			
			while(rs.next()) {
				tmp = new String();
				temp = new Prodotti();
				temp.setNomeP(rs.getString("prodotto"));
				risultato.getProdotti().add(temp);
				risultato.getQuantit‡Prodotti().add(rs.getInt("quantitaprodotto"));
				temp2 = new Ristoranti();
				tmp = rs.getString("provenienzaprodotto");
				i = tmp.indexOf(",");
				temp2.setNome(tmp.substring(0, i));
				temp2.setIndirizzo(tmp.substring(i+1));
				risultato.getProvenienzaProdotti().add(temp2);
				
			}

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return risultato;
	}

	public Ristoranti rimuoviProdottoDalCarrello(Carrello carrello, int indice) {
		
		Ristoranti ris = carrello.getProvenienzaProdotti().get(indice);
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			rimuoviProdottoDalCarrelloPS = connessione.prepareStatement("DELETE FROM carrello WHERE proprietario = ? AND prodotto = ? AND provenienzaprodotto = ?");
			rimuoviProdottoDalCarrelloPS.setString(1, carrello.getProprietario().getEmail());
			rimuoviProdottoDalCarrelloPS.setString(2, carrello.getProdotti().get(indice).getNomeP());
			rimuoviProdottoDalCarrelloPS.setString(3, carrello.getProvenienzaProdotti().get(indice).getNome() + "," + carrello.getProvenienzaProdotti().get(indice).getIndirizzo());
			rimuoviProdottoDalCarrelloPS.executeUpdate();
			connessione.close();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ris;
		
	}
	
	public boolean esisteRistoranteNelCarrello(Ristoranti rist) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			esisteRistorantePS = connessione.prepareStatement("SELECT * FROM carrello WHERE provenienzaprodotto = ?");
			esisteRistorantePS.setString(1, rist.getNome() + "," + rist.getIndirizzo());
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
			cambiaQuantit‡CarrelloPS = connessione.prepareStatement("UPDATE CARRELLO SET quantitaprodotto = ? WHERE proprietario = ? AND prodotto = ?");
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
		
		Prodotti temp;
		Carrello risultato = new Carrello();
		Ristoranti temp2 = new Ristoranti();
		String provenienza;
		boolean sentinella = true;
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getCarrelloByOrdinePS = connessione.prepareStatement("SELECT * FROM archiviocarrello WHERE codc = ?");
			getCarrelloByOrdinePS.setString(1, ordine.getCodC());
			ResultSet rs = getCarrelloByOrdinePS.executeQuery();
			connessione.close();

			while(rs.next()){
				temp = new Prodotti();
				temp.setNomeP(rs.getString("prodotto"));
				risultato.getProdotti().add(temp);
				risultato.getPrezzi().add(rs.getDouble("prezzo"));
				
				if(sentinella) {
					provenienza = rs.getString("provenienzaprodotto");
					temp2.setNome(provenienza.substring(0, provenienza.indexOf(",")));
					temp2.setIndirizzo(provenienza.substring(provenienza.indexOf(",")+1));
					sentinella = false;
				}
			}
			
			
			risultato.getProvenienzaProdotti().add(temp2);
				
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return risultato;
	}
	
	public void archiviaCarrello(Carrello carrello, Ristoranti r) {
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			archiviaCarrelloPS = connessione.prepareCall("call ArchiviaCarrello(?, ?)");
			archiviaCarrelloPS.setString(1, carrello.getProprietario().getEmail());
			archiviaCarrelloPS.setString(2, r.getNome() + ',' + r.getIndirizzo());
			archiviaCarrelloPS.execute();
			connessione.close();
			
				
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}


package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;
import dbConn.ConnessioneDB;
import interfacceDAO.MenùDAO;

public class MenùDAOPostgres implements MenùDAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getMenùByRistorantePS, getProdottiByNomeAndRistorantePS, getProdottiByRicercaCPS;

	
	public Menu getMenùByRistorante(Ristorante r) {

		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Menu risultato = new Menu();
		Prodotto temp;
		Double prezzoTemp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getMenùByRistorantePS = connessione.prepareStatement("SELECT menu.nomep, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?");
			getMenùByRistorantePS.setString(1, r.getNome());
			getMenùByRistorantePS.setString(2, r.getIndirizzo());
			ResultSet rs = getMenùByRistorantePS.executeQuery();
			connessione.close();

			while (rs.next()) {
			
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultatoRicerca.add(temp);
			
				prezzoTemp = rs.getDouble("prezzo");
				risultatoPrezzi.add(prezzoTemp);
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	
			risultato.setPrezzi(risultatoPrezzi);
			risultato.setProdotti(risultatoRicerca);
		
		return risultato;
	}


	public Menu getMenuByNomeProdottoAndRistorante(String ricerca, Ristorante r) {
		
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Menu risultato = new Menu();
		Prodotto temp;
		Double prezzoTemp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getProdottiByNomeAndRistorantePS = connessione.prepareStatement("SELECT menu.nomep, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.nomep LIKE ?))");
			getProdottiByNomeAndRistorantePS.setString(1, r.getNome());
			getProdottiByNomeAndRistorantePS.setString(2, r.getIndirizzo());
			getProdottiByNomeAndRistorantePS.setString(3, "%"+ricerca+"%");
			ResultSet rs = getProdottiByNomeAndRistorantePS.executeQuery();
			connessione.close();

			
			while (rs.next()) {
				
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultatoRicerca.add(temp);
			
				prezzoTemp = rs.getDouble("prezzo");
				risultatoPrezzi.add(prezzoTemp);
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	
			risultato.setPrezzi(risultatoPrezzi);
			risultato.setProdotti(risultatoRicerca);
		
		return risultato;
		
	}
	

	public Menu getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo) {
		
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Menu risultato = new Menu();
		Prodotto temp;
		Double prezzoTemp;
		risultato.setRistorante(r);
		
		int indiceSeparatore;
		indiceSeparatore = fasciaPrezzo.indexOf("-");
		String prezzoMinimo = fasciaPrezzo.substring(0, indiceSeparatore);
		String prezzoMassimo = fasciaPrezzo.substring(indiceSeparatore+1, fasciaPrezzo.length());
		
		
		int min = Integer.parseInt(prezzoMinimo);
		int max = Integer.parseInt(prezzoMassimo);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getProdottiByRicercaCPS = connessione.prepareStatement("SELECT menu.nomep, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.nomep LIKE ?) AND (menu.prezzo BETWEEN ? AND ?))");
			getProdottiByRicercaCPS.setString(1, r.getNome());
			getProdottiByRicercaCPS.setString(2, r.getIndirizzo());
			getProdottiByRicercaCPS.setString(3, "%"+ricerca+"%");
			getProdottiByRicercaCPS.setInt(4, min);
			getProdottiByRicercaCPS.setInt(5, max);

			ResultSet rs = getProdottiByRicercaCPS.executeQuery();
			connessione.close();

			while (rs.next()) {
				
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultatoRicerca.add(temp);
			
				prezzoTemp = rs.getDouble("prezzo");
				risultatoPrezzi.add(prezzoTemp);
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	
			risultato.setPrezzi(risultatoPrezzi);
			risultato.setProdotti(risultatoRicerca);
		
		return risultato;
	}
}

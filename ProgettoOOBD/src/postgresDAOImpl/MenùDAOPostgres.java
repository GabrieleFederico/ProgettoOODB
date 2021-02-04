package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntit�.Men�;
import classiEntit�.Prodotti;
import classiEntit�.Ristoranti;
import dbConn.ConnessioneDB;
import interfacceDAO.Men�DAO;

public class Men�DAOPostgres implements Men�DAO{

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getMen�ByRistorantePS, getProdottiByNomeAndRistorantePS, getProdottiByRicercaCPS;

	@Override
	public Men� getMen�ByRistorante(Ristoranti r) {

		ArrayList<Prodotti> risultatoRicerca = new ArrayList<Prodotti>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Men� risultato = new Men�();
		Prodotti temp;
		Double prezzoTemp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getMen�ByRistorantePS = connessione.prepareStatement("SELECT menu.prodotto, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?");
			getMen�ByRistorantePS.setString(1, r.getNome());
			getMen�ByRistorantePS.setString(2, r.getIndirizzo());
			ResultSet rs = getMen�ByRistorantePS.executeQuery();
			connessione.close();

			while (rs.next()) {
			
				temp = new Prodotti();
				temp.setNomeP(rs.getString("prodotto"));
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

	@Override
	public Men� getMenuByNomeProdottoAndRistorante(String ricerca, Ristoranti r) {
		
		ArrayList<Prodotti> risultatoRicerca = new ArrayList<Prodotti>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Men� risultato = new Men�();
		Prodotti temp;
		Double prezzoTemp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getProdottiByNomeAndRistorantePS = connessione.prepareStatement("SELECT menu.prodotto, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.nomep LIKE ?))");
			getProdottiByNomeAndRistorantePS.setString(1, r.getNome());
			getProdottiByNomeAndRistorantePS.setString(2, r.getIndirizzo());
			getProdottiByNomeAndRistorantePS.setString(3, "%"+ricerca+"%");
			ResultSet rs = getProdottiByNomeAndRistorantePS.executeQuery();
			connessione.close();

			
			while (rs.next()) {
				
				temp = new Prodotti();
				temp.setNomeP(rs.getString("prodotto"));
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
	
	@Override
	public Men� getProdottoByRicercaComplessa(String ricerca, Ristoranti r, String fasciaPrezzo) {
		
		ArrayList<Prodotti> risultatoRicerca = new ArrayList<Prodotti>();
		ArrayList<Double> risultatoPrezzi = new ArrayList<Double>();
		Men� risultato = new Men�();
		Prodotti temp;
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
			getProdottiByRicercaCPS = connessione.prepareStatement("SELECT menu.prodotto, menu.prezzo FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.prodotto LIKE ?) AND (menu.prezzo BETWEEN ? AND ?))");
			getProdottiByRicercaCPS.setString(1, r.getNome());
			getProdottiByRicercaCPS.setString(2, r.getIndirizzo());
			getProdottiByRicercaCPS.setString(3, "%"+ricerca+"%");
			getProdottiByRicercaCPS.setInt(4, min);
			getProdottiByRicercaCPS.setInt(5, max);

			ResultSet rs = getProdottiByRicercaCPS.executeQuery();
			connessione.close();

			while (rs.next()) {
				
				temp = new Prodotti();
				temp.setNomeP(rs.getString("prodotto"));
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

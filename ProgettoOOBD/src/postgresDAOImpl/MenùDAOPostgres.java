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
		Menu risultato = new Menu();
		Prodotto temp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getMenùByRistorantePS = connessione.prepareStatement("SELECT menu.nomep FROM menu NATURAL JOIN ristoranti WHERE ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?");
			getMenùByRistorantePS.setString(1, r.getNome());
			getMenùByRistorantePS.setString(2, r.getIndirizzo());
			ResultSet rs = getMenùByRistorantePS.executeQuery();
			connessione.close();

			while (rs.next()) {
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultatoRicerca.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		risultato.setProdotti(risultatoRicerca);

		return risultato;
	}

	public ArrayList<Prodotto> getProdottoByNomeProdottoAndRistorante(String ricerca, Ristorante r) {
		
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		Menu risultato = new Menu();
		Prodotto temp;
		risultato.setRistorante(r);

		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getProdottiByNomeAndRistorantePS = connessione.prepareStatement("SELECT menu.nomep FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.nomep LIKE ?))");
			getProdottiByNomeAndRistorantePS.setString(1, r.getNome());
			getProdottiByNomeAndRistorantePS.setString(2, r.getIndirizzo());
			getProdottiByNomeAndRistorantePS.setString(3, "%"+ricerca+"%");
			ResultSet rs = getProdottiByNomeAndRistorantePS.executeQuery();
			connessione.close();

			while (rs.next()) {
				temp = new Prodotto();
				temp.setNomeP(rs.getString("nomep"));
				risultatoRicerca.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		risultato.setProdotti(risultatoRicerca);

		return risultatoRicerca;
	}

	public ArrayList<Prodotto> getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo) {
		
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		Menu risultato = new Menu();
		Prodotto temp;
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
			getProdottiByRicercaCPS = connessione.prepareStatement("SELECT menu.nomep FROM menu NATURAL JOIN ristoranti WHERE ((ristoranti.nome LIKE ? AND ristoranti.indirizzo LIKE ?) AND (menu.nomep LIKE ?) AND (menu.prezzop BETWEEN ? AND ?))");
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
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		risultato.setProdotti(risultatoRicerca);

		return risultatoRicerca;
	}
}

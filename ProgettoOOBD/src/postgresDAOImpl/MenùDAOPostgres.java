package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Menu;
import dbConn.ConnessioneDB;

public class MenùDAOPostgres {

	private Connection connessione;
	private ConnessioneDB connessioneDB;
	private PreparedStatement getMenùByRistorantePS;

	public Menu getMenùByRistorante(String nomeRistorante) throws SQLException {
		
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		Menu risultato = new Menu();
		risultato.setRistorante(ristorante);
		
		try {
			connessioneDB = ConnessioneDB.getIstanza();
			connessione = connessioneDB.getConnessione();
			getMenùByRistorantePS = connessione.prepareStatement("SELECT menu.nomep FROM menu NATURAL JOIN ristoranti WHERE ristoranti.nome = ?");
			getMenùByRistorantePS.setString(1, nomeRistorante);	
			ResultSet rs = getMenùByRistorantePS.executeQuery();
			connessione.close();
			
			while(rs.next())
				risultatoRicerca.add(rs.getString("nomep"));
	} 
	catch (SQLException e) {
		System.out.println(e.getMessage());
		
	}
	return risultatoRicerca;
}

	public ArrayList<String> getProdottoByNomeProdottoAndRistorante(String ricerca, String nomeRistorante) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getProdottoByRicercaComplessa(String ricerca, String fasciaPrezzo) {
		// TODO Auto-generated method stub
		return null;
	}
}

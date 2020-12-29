package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbConn.ConnessioneDB;
import interfacceDAO.RistoranteDAO;


public class RistoranteDAOPostgres implements RistoranteDAO {

		private Connection connessione;
		private ConnessioneDB connessioneDB;
		private PreparedStatement getRistoranteByNomeOrProdottoPS;

		@Override
		public ArrayList<String> getRistoranteByNomeOrProdotto(String ricerca) {
			
			ArrayList<String> risultatoRicerca = new ArrayList<String>();
			try {
				connessioneDB = ConnessioneDB.getIstanza();
				connessione = connessioneDB.getConnessione();
				getRistoranteByNomeOrProdottoPS = connessione.prepareStatement("SELECT ristoranti.nome, ristoranti.indirizzo FROM ristoranti NATURAL JOIN menu  WHERE ristoranti.Nome LIKE ? OR menu.nomep LIKE ? GROUP BY ristoranti.nome,ristoranti.indirizzo");
				getRistoranteByNomeOrProdottoPS.setString(1,  "%" + ricerca + "%");
				getRistoranteByNomeOrProdottoPS.setString(2,  "%" + ricerca + "%");
				ResultSet rs = getRistoranteByNomeOrProdottoPS.executeQuery();
				connessione.close();
				
				while(rs.next())
					risultatoRicerca.add(rs.getString("nome"));
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return risultatoRicerca;
		}
}
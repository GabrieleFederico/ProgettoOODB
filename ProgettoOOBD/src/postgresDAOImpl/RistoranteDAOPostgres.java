package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Ristorante;
import dbConn.ConnessioneDB;
import interfacceDAO.RistoranteDAO;


public class RistoranteDAOPostgres implements RistoranteDAO {

		private Connection connessione;
		private ConnessioneDB connessioneDB;
		private PreparedStatement getRistoranteByNomeOrProdottoPS;

		@Override
		public ArrayList<Ristorante> getRistoranteByNomeOrProdotto(String ricerca) {
			
			String risultatoRicerca;
			Ristorante temp;
			ArrayList<Ristorante> risultato = new ArrayList<Ristorante>();
			
			try {
				connessioneDB = ConnessioneDB.getIstanza();
				connessione = connessioneDB.getConnessione();
				getRistoranteByNomeOrProdottoPS = connessione.prepareStatement("SELECT ristoranti.nome, ristoranti.indirizzo FROM ristoranti NATURAL JOIN menu WHERE ristoranti.nome LIKE ? OR menu.prodotto LIKE ? GROUP BY ristoranti.nome, ristoranti.indirizzo");
				getRistoranteByNomeOrProdottoPS.setString(1,  "%" + ricerca + "%");
				getRistoranteByNomeOrProdottoPS.setString(2,  "%" + ricerca + "%");
				ResultSet rs = getRistoranteByNomeOrProdottoPS.executeQuery();
				connessione.close();
				
				while(rs.next()) {
					temp = new Ristorante();
					risultatoRicerca = rs.getString("nome");
					temp.setNome(risultatoRicerca);
					risultatoRicerca = rs.getString("indirizzo");
					temp.setIndirizzo(risultatoRicerca);
					risultato.add(temp);
				}
				
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return risultato;
		}
}
		
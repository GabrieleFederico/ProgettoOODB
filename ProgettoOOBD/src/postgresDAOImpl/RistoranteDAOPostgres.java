package postgresDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import interfacceDAO.RistoranteDAO;


public class RistoranteDAOPostgres implements RistoranteDAO {

		private Connection connessione;
		private PreparedStatement getRistoranteByNomeOrProdottoPS;

		public RistoranteDAOPostgres(Connection connessione) throws SQLException {
			this.connessione = connessione;
			getRistoranteByNomeOrProdottoPS = connessione.prepareStatement("SELECT ristoranti.nome FROM ristoranti NATURAL JOIN menu WHERE ristoranti.Nome LIKE ? or menu.nomep LIKE ?");
		}
		
		
		public ArrayList<String> getRistoranteByNomeOrProdotto(String ricerca) throws SQLException {
			getRistoranteByNomeOrProdottoPS.setString(1, ricerca);
			getRistoranteByNomeOrProdottoPS.setString(2, ricerca);
			
			ResultSet rs = getRistoranteByNomeOrProdottoPS.executeQuery();
			
			ArrayList<String> risultatoRicerca = new ArrayList<String>();
			
			while(rs.next()) {
				risultatoRicerca.add(rs.getString("nome"));
			}
			return risultatoRicerca;
		}
}
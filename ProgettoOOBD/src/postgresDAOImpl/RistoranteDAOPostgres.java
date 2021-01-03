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
		private PreparedStatement getRistoranteByRicercaComplessaPS;

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
		
		
		public ArrayList<String> getRistoranteByRicercaComplessa(String tfInput, String riderInput){
			
			ArrayList<String> risultatoRicercaC = new ArrayList<String>();
			
//			int indiceSeparatore;
//			indiceSeparatore = prezzoInput.indexOf("-");
//			String prezzoMinimo = prezzoInput.substring(0, indiceSeparatore);
//			String prezzoMassimo = prezzoInput.substring(indiceSeparatore+1, prezzoInput.length());
//			
//			
//			int min = Integer.parseInt(prezzoMinimo);
//			int max = Integer.parseInt(prezzoMassimo);
			
			
			try {
				connessioneDB = ConnessioneDB.getIstanza();
				connessione = connessioneDB.getConnessione();
				
				if(riderInput != null) {
					getRistoranteByRicercaComplessaPS = connessione.prepareStatement("SELECT ristoranti.nome FROM (ristoranti NATURAL JOIN menu) JOIN (alserviziodi NATURAL JOIN rider) ON ristoranti.codn = alserviziodi.codn WHERE ((ristoranti.nome LIKE ? OR menu.nomep LIKE ?) AND (rider.mezzo LIKE ?)) GROUP BY ristoranti.nome, ristoranti.indirizzo");
					getRistoranteByRicercaComplessaPS.setString(1,  "%" + tfInput + "%");
					getRistoranteByRicercaComplessaPS.setString(2,  "%" + tfInput + "%");
					getRistoranteByRicercaComplessaPS.setString(3,  riderInput);
				}
				else {
					
				}
				ResultSet res = getRistoranteByRicercaComplessaPS.executeQuery();
				connessione.close();
				
				while(res.next())
					risultatoRicercaC.add(res.getString("nome"));
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return risultatoRicercaC;
}
}
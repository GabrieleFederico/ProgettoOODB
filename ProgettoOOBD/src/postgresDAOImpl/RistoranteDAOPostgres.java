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
		
		
		public ArrayList<String> getRistoranteByRicercaComplessa(String tfInput, String riderInput, String prezzoInput){
			
			ArrayList<String> risultatoRicercaC = new ArrayList<String>();
			
			//implementare_classe_con_metodo_per_questo
			int low;
			int max;
			
			if (prezzoInput.equals("0-5")) {
				low=0;
				max=5;
			}	
			else if (prezzoInput.equals("5-10")) {
				low=5;
				max=10;
			}
			else if(prezzoInput.equals("10-20")){
				low=10;
				max=20;
			}
			else {
				low=0;
				max=100;
			}
			
			if (riderInput.equals("Selezionare mezzo")){
				//non_so_cosa_farci
			}
			
			try {
				connessioneDB = ConnessioneDB.getIstanza();
				connessione = connessioneDB.getConnessione();
				getRistoranteByRicercaComplessaPS = connessione.prepareStatement("SELECT ristoranti.nome, ristoranti.indirizzo FROM ristoranti NATURAL JOIN menu WHERE ristoranti.Nome LIKE ? OR menu.nomep LIKE ? AND  menu.prezzop BETWEEN ? AND ? GROUP BY ristoranti.nome,ristoranti.indirizzo");
				getRistoranteByRicercaComplessaPS.setString(1,  "%" + tfInput + "%");
				getRistoranteByRicercaComplessaPS.setString(2,  "%" + tfInput + "%");
				getRistoranteByRicercaComplessaPS.setInt(3,  low);
				getRistoranteByRicercaComplessaPS.setInt(4,  max);
				System.out.println(getRistoranteByRicercaComplessaPS);
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
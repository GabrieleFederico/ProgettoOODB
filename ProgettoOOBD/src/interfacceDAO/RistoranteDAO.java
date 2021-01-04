package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Ristorante;

public interface RistoranteDAO {

	public ArrayList<Ristorante> getRistoranteByNomeOrProdotto(String ricerca) throws SQLException;
	public ArrayList<Ristorante> getRistoranteByRicercaComplessa(String tfInput, String riderInput);
	
}

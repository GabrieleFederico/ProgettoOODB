package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntitą.Ristorante;

public interface RistoranteDAO {

	public ArrayList<Ristorante> getRistoranteByNomeOrProdotto(String ricerca) throws SQLException;
	
}

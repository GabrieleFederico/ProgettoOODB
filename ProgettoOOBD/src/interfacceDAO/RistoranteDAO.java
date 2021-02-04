package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Ristorante;

public interface RistoranteDAO {

	public ArrayList<Ristorante> getRistoranteByNomeOrProdotto(String ricerca);
	
}

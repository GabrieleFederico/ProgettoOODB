package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RistoranteDAO {

	public ArrayList<String> getRistoranteByNomeOrProdotto(String ricerca) throws SQLException;
	
}

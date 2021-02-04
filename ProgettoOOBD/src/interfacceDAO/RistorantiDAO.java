package interfacceDAO;

import java.util.ArrayList;

import classiEntità.Ristoranti;

public interface RistorantiDAO {

	public ArrayList<Ristoranti> getRistoranteByNomeOrProdotto(String ricerca);
	
}

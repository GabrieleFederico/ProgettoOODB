package interfacceDAO;

import java.util.ArrayList;

import classiEntit�.Ristoranti;

public interface RistorantiDAO {

	public ArrayList<Ristoranti> getRistoranteByNomeOrProdotto(String ricerca);
	
}

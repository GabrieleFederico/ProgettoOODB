package interfacceDAO;

import java.util.ArrayList;

import classiEntitą.Ristoranti;

public interface RistorantiDAO {

	public ArrayList<Ristoranti> getRistoranteByNomeOrProdotto(String ricerca);
	
}

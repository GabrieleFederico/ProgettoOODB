package interfacceDAO;

import classiEntit�.Menu;
import classiEntit�.Ristorante;

public interface Men�DAO {
	
	public Menu getMen�ByRistorante(Ristorante r);
	public Menu getMenuByNomeProdottoAndRistorante(String ricerca, Ristorante r);
	public Menu getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo);


}

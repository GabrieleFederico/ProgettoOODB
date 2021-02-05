package interfacceDAO;

import classiEntit�.Men�;
import classiEntit�.Ristoranti;

public interface Men�DAO {
	
	public Men� getMen�ByRistorante(Ristoranti r);
	public Men� getMenuByNomeProdottoAndRistorante(String ricerca, Ristoranti r);
	public Men� getProdottoByRicercaComplessa(String ricerca, Ristoranti r, String fasciaPrezzo);

}

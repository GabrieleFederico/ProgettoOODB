package interfacceDAO;

import classiEntità.Menù;
import classiEntità.Ristoranti;

public interface MenùDAO {
	
	public Menù getMenùByRistorante(Ristoranti r);
	public Menù getMenuByNomeProdottoAndRistorante(String ricerca, Ristoranti r);
	public Menù getProdottoByRicercaComplessa(String ricerca, Ristoranti r, String fasciaPrezzo);

}

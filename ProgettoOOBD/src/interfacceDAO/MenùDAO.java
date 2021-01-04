package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;

public interface MenùDAO {
	
	public Menu getMenùByRistorante(Ristorante ristorante) throws SQLException;
	public ArrayList<Prodotto> getProdottoByNomeProdottoAndRistorante(String ricerca, Ristorante r);
	public ArrayList<Prodotto> getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo);


}

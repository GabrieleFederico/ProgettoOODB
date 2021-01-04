package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntit�.Menu;
import classiEntit�.Prodotto;
import classiEntit�.Ristorante;

public interface Men�DAO {
	
	public Menu getMen�ByRistorante(Ristorante ristorante) throws SQLException;
	public ArrayList<Prodotto> getProdottoByNomeProdottoAndRistorante(String ricerca, Ristorante r);
	public ArrayList<Prodotto> getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo);


}

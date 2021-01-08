package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntit�.Menu;
import classiEntit�.Prodotto;
import classiEntit�.Ristorante;

public interface Men�DAO {
	
	public Menu getMen�ByRistorante(Ristorante r);
	public Menu getMenuByNomeProdottoAndRistorante(String ricerca, Ristorante r);
	public Menu getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo);


}

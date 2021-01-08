package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import classiEntità.Menu;
import classiEntità.Prodotto;
import classiEntità.Ristorante;

public interface MenùDAO {
	
	public Menu getMenùByRistorante(Ristorante r);
	public Menu getMenuByNomeProdottoAndRistorante(String ricerca, Ristorante r);
	public Menu getProdottoByRicercaComplessa(String ricerca, Ristorante r, String fasciaPrezzo);


}

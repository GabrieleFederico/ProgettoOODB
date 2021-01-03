package interfacceDAO;

import java.util.ArrayList;
import classiEntità.Prodotto;

public interface ProdottoDAO {

	public ArrayList<Prodotto> getProdottoByPrezzo(float prezzomin, float prezzomax);
	public ArrayList<Prodotto> getProdottoByDisponibile();
	public ArrayList<Prodotto> getProdottoByNome(String nome);
	public ArrayList<Prodotto> getProdottoByRistorante(String nome);
}

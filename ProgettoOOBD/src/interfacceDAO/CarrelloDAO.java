package interfacceDAO;

import classiEntit�.Carrello;
import classiEntit�.Ristorante;
import classiEntit�.Utente;

public interface CarrelloDAO {

	public Carrello getCarrelloByUtente(Utente utente);
	public void aggiungiProdottoAlCarrello(String nomep, int quantit�, Utente utente, double prezzo, Ristorante ristorante);
}

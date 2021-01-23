package interfacceDAO;

import classiEntità.Carrello;
import classiEntità.Ristorante;
import classiEntità.Utente;

public interface CarrelloDAO {

	public Carrello getCarrelloByUtente(Utente utente);
	public void aggiungiProdottoAlCarrello(String nomep, int quantità, Utente utente, double prezzo, Ristorante ristorante);
}

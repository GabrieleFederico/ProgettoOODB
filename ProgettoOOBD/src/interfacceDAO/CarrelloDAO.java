package interfacceDAO;

import classiEntitą.Carrello;
import classiEntitą.Ristorante;
import classiEntitą.Utente;

public interface CarrelloDAO {

	public Carrello getCarrelloByUtente(Utente utente);
	public void aggiungiProdottoAlCarrello(String nomep, int quantitą, Utente utente, double prezzo, Ristorante ristorante);
}

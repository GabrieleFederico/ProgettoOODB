package interfacceDAO;

import classiEntità.Carrello;
import classiEntità.Utente;

public interface CarrelloDAO {

	public Carrello getCarrelloByUtente(Utente utente);
}

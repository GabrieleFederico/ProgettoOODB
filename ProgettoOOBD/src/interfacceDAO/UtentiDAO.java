package interfacceDAO;

import classiEntit�.Utenti;

public interface UtentiDAO {
	
	public void inserisciUtente(Utenti utente);
	public Utenti getUtenteByCredenziali(String email, String pwd);
	
}

package interfacceDAO;

import classiEntit�.Utente;

public interface UtenteDAO {
	
	public void inserisciUtente(Utente utente);
	public Utente getUtenteByCredenziali(String email, String pwd);
	
}

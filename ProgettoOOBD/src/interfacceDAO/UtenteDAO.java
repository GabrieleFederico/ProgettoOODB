package interfacceDAO;

import classiEntità.Utente;

public interface UtenteDAO {
	
	public void inserisciUtente(Utente utente);
	public Utente getUtenteByCredenziali(String email, String pwd);
	
}

package interfacceDAO;

import classiEntitą.Utenti;

public interface UtentiDAO {
	
	public void inserisciUtente(Utenti utente);
	public Utenti getUtenteByCredenziali(String email, String pwd);
	
}

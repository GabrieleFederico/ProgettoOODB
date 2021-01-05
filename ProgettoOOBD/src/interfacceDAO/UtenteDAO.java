package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import classiEntità.Utente;

public interface UtenteDAO {
	
	public ArrayList<Utente> getAllUtenti();
	public Utente getUtenteByCredenziali(String email, String pwd) throws SQLException;
	public void inserisciUtente(Utente utente) throws SQLException;
	
}

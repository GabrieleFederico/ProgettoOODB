package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import classiEntit�.Utente;

public interface UtenteDAO {
	
	public ArrayList<Utente> getAllUtenti();
	public void inserisciUtente(Utente utente) throws SQLException;
	
}

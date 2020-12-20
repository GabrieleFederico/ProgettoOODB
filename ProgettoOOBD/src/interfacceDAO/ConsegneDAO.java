package interfacceDAO;

import java.util.ArrayList;
import classiEntità.Consegne;
import classiEntità.Utente;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utente utente);

}

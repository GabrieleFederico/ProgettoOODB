package interfacceDAO;

import java.util.ArrayList;
import classiEntit�.Consegne;
import classiEntit�.Utente;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utente utente);

}

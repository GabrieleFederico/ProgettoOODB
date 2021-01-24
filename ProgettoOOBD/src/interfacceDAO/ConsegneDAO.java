package interfacceDAO;

import java.util.ArrayList;
import classiEntità.Consegne;
import classiEntità.Rider;
import classiEntità.Utente;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utente utente);
	public ArrayList<Consegne> getConsegneByRider(Rider rider);

}

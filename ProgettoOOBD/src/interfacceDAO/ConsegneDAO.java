package interfacceDAO;

import java.util.ArrayList;
import classiEntitą.Consegne;
import classiEntitą.Rider;
import classiEntitą.Utente;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utente utente);
	public ArrayList<Consegne> getConsegneByRider(Rider rider);

}

package interfacceDAO;

import java.util.ArrayList;

import classiEntitą.Consegne;
import classiEntitą.Riders;

public interface RidersDAO {

	public Riders getRiderByEmail(String email, String password);
	public void inserisciRider(Riders rider);
}

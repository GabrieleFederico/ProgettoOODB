package interfacceDAO;

import java.util.ArrayList;

import classiEntit�.Consegne;
import classiEntit�.Riders;

public interface RidersDAO {

	public Riders getRiderByEmail(String email, String password);
	public void inserisciRider(String nome, String cognome, String email, String mezzo, String password);
}

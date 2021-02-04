package interfacceDAO;

import java.util.ArrayList;

import classiEntitą.Consegne;
import classiEntitą.Rider;

public interface RiderDAO {

	public Rider getRiderByEmail(String email, String password);
	public void inserisciRider(String nome, String cognome, String email, String mezzo, String password);
	public ArrayList<Consegne> getOrdiniByRider(Rider rider);
}

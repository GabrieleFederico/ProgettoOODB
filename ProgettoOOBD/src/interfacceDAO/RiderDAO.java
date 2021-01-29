package interfacceDAO;

import java.util.ArrayList;
import classiEntità.Rider;

public interface RiderDAO {

	public ArrayList<Rider> getAllRider();
	public ArrayList<Rider> getRiderByMezzo(String mezzo);
	public void inserisciRider(String nome, String cognome, String email, String mezzo, String password);
}

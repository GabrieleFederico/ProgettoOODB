package interfacceDAO;

import java.util.ArrayList;
import classiEntitą.Rider;

public interface RiderDAO {

	public ArrayList<Rider> getAllRider();
	public ArrayList<Rider> getRiderByMezzo(String mezzo);
}

package interfacceDAO;

import java.util.ArrayList;
import classiEntit�.Rider;

public interface RiderDAO {

	public ArrayList<Rider> getAllRider();
	public ArrayList<Rider> getRiderByMezzo(String mezzo);
}

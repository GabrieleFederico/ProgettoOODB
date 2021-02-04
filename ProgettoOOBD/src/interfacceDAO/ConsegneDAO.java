package interfacceDAO;

import java.util.ArrayList;
import classiEntitą.Consegne;
import classiEntitą.Rider;
import classiEntitą.Utente;
import controllers.ControllerConsegne;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utente utente);
	public ArrayList<Consegne> getConsegneByRider(Rider rider);
	public void creaConsegna(String indirizzoP, Utente utente, String mezzo, String orario);
	public ArrayList<Consegne> getConsegneByMezzo(String mezzo);
	public void assegnaConsegnaRider(String CodR, String CodC, ControllerConsegne cc);
	public void ordineConsegnato(String CodC);

}

package interfacceDAO;

import java.util.ArrayList;
import classiEntità.Consegne;
import classiEntità.Riders;
import classiEntità.Utenti;
import controllers.ControllerConsegne;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utenti utente);
	public ArrayList<Consegne> getConsegneByRider(Riders rider);
	public void creaConsegna(String indirizzoP, Utenti utente, String mezzo, String orario);
	public ArrayList<Consegne> getConsegneByMezzo(String mezzo);
	public void assegnaConsegnaRider(String CodR, String CodC, ControllerConsegne cc);
	public void ordineConsegnato(String CodC);

}

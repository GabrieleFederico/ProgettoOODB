package interfacceDAO;

import java.util.ArrayList;
import classiEntitą.Consegne;
import classiEntitą.Riders;
import classiEntitą.Utenti;
import controllers.ControllerConsegneRider;

public interface ConsegneDAO {

	public ArrayList<Consegne> getConsegneByUtente(Utenti utente);
	public ArrayList<Consegne> getConsegneByRider(Riders rider);
	public void creaConsegna(String indirizzoP, Utenti utente, String mezzo, String orario);
	public ArrayList<Consegne> getConsegneByMezzo(String mezzo);
	public void assegnaConsegnaRider(String CodR, String CodC, ControllerConsegneRider cc);
	public void ordineConsegnato(String CodC);
	public ArrayList<Consegne> getOrdiniByRider(Riders rider);

}

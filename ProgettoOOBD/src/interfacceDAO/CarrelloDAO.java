package interfacceDAO;

import java.util.ArrayList;

import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Ristoranti;
import classiEntit‡.Utenti;

public interface CarrelloDAO {
	
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utenti utente, double prezzo, Ristoranti ristorante);
	public Carrello getCarrelloByUtente(Utenti utente);
	public Ristoranti rimuoviProdottoDalCarrello(Carrello carrello, int indice);
	public boolean esisteRistoranteNelCarrello(Ristoranti rist);
	public ArrayList<Double> getArrayListPrezzi(Carrello carrello);
	public void cambiaQuantit‡Carrello(int nuovoValore, Carrello carrello, String nomeProdotto);
	public Carrello getCarrelloByOrdine(Consegne ordine);
	public void archiviaCarrello(Carrello carrello, Ristoranti r);
}

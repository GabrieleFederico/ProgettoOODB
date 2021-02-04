package interfacceDAO;

import java.util.ArrayList;

import classiEntit‡.Carrello;
import classiEntit‡.Consegne;
import classiEntit‡.Ristorante;
import classiEntit‡.Utente;

public interface CarrelloDAO {
	
	public void aggiungiProdottoAlCarrello(String nomep, int quantit‡, Utente utente, double prezzo, Ristorante ristorante);
	public Carrello getCarrelloByUtente(Utente utente);
	public Ristorante rimuoviProdottoDalCarrello(Carrello carrello, int indice);
	public boolean esisteRistoranteNelCarrello(Ristorante rist);
	public ArrayList<Double> getArrayListPrezzi(Carrello carrello);
	public void cambiaQuantit‡Carrello(int nuovoValore, Carrello carrello, String nomeProdotto);
	public Carrello getCarrelloByOrdine(Consegne ordine);
	public void archiviaCarrello(Carrello carrello, Ristorante r);
}

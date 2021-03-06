package interfacceDAO;

import java.util.ArrayList;

import classiEntitą.Carrello;
import classiEntitą.Consegne;
import classiEntitą.Ristoranti;
import classiEntitą.Utenti;

public interface CarrelloDAO {
	
	public void aggiungiProdottoAlCarrello(String nomep, int quantitą, Utenti utente, double prezzo, Ristoranti ristorante);
	public Carrello getCarrelloByUtente(Utenti utente);
	public Ristoranti rimuoviProdottoDalCarrello(Carrello carrello, int indice);
	public boolean esisteRistoranteNelCarrello(Ristoranti rist);
	public ArrayList<Double> getArrayListPrezzi(Carrello carrello);
	public void cambiaQuantitąCarrello(int nuovoValore, Carrello carrello, String nomeProdotto);
	public Carrello getCarrelloByOrdine(Consegne ordine);
	public void archiviaCarrello(Carrello carrello, Ristoranti r);
}

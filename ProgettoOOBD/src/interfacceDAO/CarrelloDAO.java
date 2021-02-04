package interfacceDAO;

import java.util.ArrayList;

import classiEntitą.Carrello;
import classiEntitą.Consegne;
import classiEntitą.Ristorante;
import classiEntitą.Utente;

public interface CarrelloDAO {
	
	public void aggiungiProdottoAlCarrello(String nomep, int quantitą, Utente utente, double prezzo, Ristorante ristorante);
	public Carrello getCarrelloByUtente(Utente utente);
	public Ristorante rimuoviProdottoDalCarrello(Carrello carrello, int indice);
	public boolean esisteRistoranteNelCarrello(Ristorante rist);
	public ArrayList<Double> getArrayListPrezzi(Carrello carrello);
	public void cambiaQuantitąCarrello(int nuovoValore, Carrello carrello, String nomeProdotto);
	public Carrello getCarrelloByOrdine(Consegne ordine);
	public void archiviaCarrello(Carrello carrello, Ristorante r);
}

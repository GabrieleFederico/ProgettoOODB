package classiEntit‡;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> Prodotti;
	private ArrayList<Integer> Quantit‡Prodotti;
	private Utente Proprietario;
	
	public Carrello(Utente proprietario) {
		this.Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotto>();
		Quantit‡Prodotti = new ArrayList<Integer>();
	}

	public ArrayList<Prodotto> getProdotti() {
		return Prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Integer> getQuantit‡Prodotti() {
		return Quantit‡Prodotti;
	}

	public void setQuantit‡Prodotti(ArrayList<Integer> quantit‡Prodotti) {
		Quantit‡Prodotti = quantit‡Prodotti;
	}

	public Utente getProprietario() {
		return Proprietario;
	}
	
	public void setProprietario(Utente proprietario) {
		Proprietario = proprietario;
	}
	
}

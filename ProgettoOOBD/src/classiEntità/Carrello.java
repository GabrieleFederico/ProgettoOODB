package classiEntit‡;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> Prodotti;
	private ArrayList<Integer> Quantit‡Prodotti;
	private ArrayList<Double> Prezzi;
	private Utente Proprietario;
	private ArrayList<Ristorante> provenienzaProdotti;
	
	public Carrello(Utente proprietario) {
		this.Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotto>();
		Quantit‡Prodotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristorante>();
	}
	public Carrello() {
		Prodotti = new ArrayList<Prodotto>();
		Quantit‡Prodotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristorante>();
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

	public ArrayList<Double> getPrezzi() {
		return Prezzi;
	}

	public void setPrezzi(ArrayList<Double> prezzi) {
		Prezzi = prezzi;
	}

	public ArrayList<Ristorante> getProvenienzaProdotti() {
		return provenienzaProdotti;
	}

	public void setProvenienzaProdotti(ArrayList<Ristorante> provenienzaProdotti) {
		this.provenienzaProdotti = provenienzaProdotti;
	}
	
}

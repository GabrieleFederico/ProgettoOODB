package classiEntit‡;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotti> Prodotti;
	private ArrayList<Integer> Quantit‡Prodotti;
	private ArrayList<Double> Prezzi;
	private Utenti Proprietario;
	private ArrayList<Ristoranti> provenienzaProdotti;
	
	public Carrello(Utenti proprietario) {
		Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotti>();
		Quantit‡Prodotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristoranti>();
	}
	
	public Carrello() {
		Prezzi = new ArrayList<Double>();
		Prodotti = new ArrayList<Prodotti>();
		Quantit‡Prodotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristoranti>();
	}

	public ArrayList<Prodotti> getProdotti() {
		return Prodotti;
	}

	public void setProdotti(ArrayList<Prodotti> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Integer> getQuantit‡Prodotti() {
		return Quantit‡Prodotti;
	}

	public void setQuantit‡Prodotti(ArrayList<Integer> quantit‡Prodotti) {
		Quantit‡Prodotti = quantit‡Prodotti;
	}

	public Utenti getProprietario() {
		return Proprietario;
	}
	
	public void setProprietario(Utenti proprietario) {
		Proprietario = proprietario;
	}

	public ArrayList<Double> getPrezzi() {
		return Prezzi;
	}

	public void setPrezzi(ArrayList<Double> prezzi) {
		Prezzi = prezzi;
	}

	public ArrayList<Ristoranti> getProvenienzaProdotti() {
		return provenienzaProdotti;
	}

	public void setProvenienzaProdotti(ArrayList<Ristoranti> provenienzaProdotti) {
		this.provenienzaProdotti = provenienzaProdotti;
	}

	
}

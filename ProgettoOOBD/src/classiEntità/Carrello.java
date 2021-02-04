package classiEntitą;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> Prodotti;
	private ArrayList<Integer> QuantitąProdotti;
	private ArrayList<Double> Prezzi;
	private Utente Proprietario;
	private ArrayList<Ristorante> provenienzaProdotti;
	
	public Carrello(Utente proprietario) {
		this.Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotto>();
		QuantitąProdotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristorante>();
	}
	
	public Carrello() {
		Prezzi = new ArrayList<Double>();
		Prodotti = new ArrayList<Prodotto>();
		QuantitąProdotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristorante>();
	}

	public ArrayList<Prodotto> getProdotti() {
		return Prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Integer> getQuantitąProdotti() {
		return QuantitąProdotti;
	}

	public void setQuantitąProdotti(ArrayList<Integer> quantitąProdotti) {
		QuantitąProdotti = quantitąProdotti;
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

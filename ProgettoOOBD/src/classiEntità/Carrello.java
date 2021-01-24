package classiEntitą;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> Prodotti;
	private ArrayList<Integer> QuantitąProdotti;
	private ArrayList<Double> Prezzi;
	private Utente Proprietario;
	private Ristorante provenienzaProdotti;
	
	public Carrello(Utente proprietario) {
		this.Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotto>();
		QuantitąProdotti = new ArrayList<Integer>();
	}
	public Carrello() {
		Prodotti = new ArrayList<Prodotto>();
		QuantitąProdotti = new ArrayList<Integer>();
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

	public Ristorante getProvenienzaProdotti() {
		return provenienzaProdotti;
	}

	public void setProvenienzaProdotti(Ristorante provenienzaProdotti) {
		this.provenienzaProdotti = provenienzaProdotti;
	}
	
	
	
	
	
}

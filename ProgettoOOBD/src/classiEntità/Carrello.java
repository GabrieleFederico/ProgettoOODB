package classiEntitą;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotti> Prodotti;
	private ArrayList<Integer> QuantitąProdotti;
	private ArrayList<Double> Prezzi;
	private Utenti Proprietario;
	private ArrayList<Ristoranti> provenienzaProdotti;
	
	public Carrello(Utenti proprietario) {
		Proprietario = proprietario;
		Prodotti = new ArrayList<Prodotti>();
		QuantitąProdotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristoranti>();
	}
	
	public Carrello() {
		Prezzi = new ArrayList<Double>();
		Prodotti = new ArrayList<Prodotti>();
		QuantitąProdotti = new ArrayList<Integer>();
		provenienzaProdotti = new ArrayList<Ristoranti>();
	}

	public ArrayList<Prodotti> getProdotti() {
		return Prodotti;
	}

	public void setProdotti(ArrayList<Prodotti> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Integer> getQuantitąProdotti() {
		return QuantitąProdotti;
	}

	public void setQuantitąProdotti(ArrayList<Integer> quantitąProdotti) {
		QuantitąProdotti = quantitąProdotti;
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

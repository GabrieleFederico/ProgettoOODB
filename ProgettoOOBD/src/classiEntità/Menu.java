package classiEntità;

import java.util.ArrayList;

public class Menu {
	
	private Ristorante Ristorante;
	private ArrayList<Prodotto> Prodotti;
	private ArrayList<Double> Prezzi;
	
	public Ristorante getRistorante() {
		return Ristorante;
	}
	public void setRistorante(Ristorante ristorante) {
		Ristorante = ristorante;
	}
	
	public ArrayList<Prodotto> getProdotti() {
		return Prodotti;
	}
	public void setProdotti(ArrayList<Prodotto> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Double> getPrezzi() {
		return Prezzi;
	}
	public void setPrezzi(ArrayList<Double> prezzi) {
		Prezzi = prezzi;
	}
	
	
	
}

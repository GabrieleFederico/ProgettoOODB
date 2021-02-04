package classiEntità;

import java.util.ArrayList;

public class Menù {
	
	private Ristoranti Ristorante;
	private ArrayList<Prodotti> Prodotti;
	private ArrayList<Double> Prezzi;
	
	public Ristoranti getRistorante() {
		return Ristorante;
	}
	public void setRistorante(Ristoranti ristorante) {
		Ristorante = ristorante;
	}
	
	public ArrayList<Prodotti> getProdotti() {
		return Prodotti;
	}
	public void setProdotti(ArrayList<Prodotti> prodotti) {
		Prodotti = prodotti;
	}
	
	public ArrayList<Double> getPrezzi() {
		return Prezzi;
	}
	public void setPrezzi(ArrayList<Double> prezzi) {
		Prezzi = prezzi;
	}
	
	
	
}

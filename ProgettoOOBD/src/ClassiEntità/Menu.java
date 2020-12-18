package ClassiEntità;

import java.util.ArrayList;

public class Menu {
	
	private Ristorante Ristorante;
	private ArrayList<Prodotto> Prodotti = new ArrayList<Prodotto>();
	private float Prezzo;
	
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
	
	public float getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(float prezzo) {
		Prezzo = prezzo;
	}
	
	
	
}

package classiEntità;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<Prodotto> Prodotti;
	private Utente Proprietario;
	
	public Carrello(Utente proprietario) {
		this.Proprietario = proprietario;
	}

	public ArrayList<Prodotto> getProdotti() {
		return Prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		Prodotti = prodotti;
	}

	public Utente getProprietario() {
		return Proprietario;
	}
	public void setProprietario(Utente proprietario) {
		Proprietario = proprietario;
	}
	
	
	
}

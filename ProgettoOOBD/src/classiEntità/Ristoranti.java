package classiEntit�;

import java.util.LinkedList;

public class Ristoranti {

	private String Nome;
	private String Indirizzo;
	private Men� Menu;
	private LinkedList<Riders> RiderDelRistorante;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	
	public Men� getMenu() {
		return Menu;
	}
	public void setMenu(Men� menu) {
		Menu = menu;
	}
	
	public LinkedList<Riders> getRiderDelRistorante() {
		return RiderDelRistorante;
	}
	public void setRiderDelRistorante(LinkedList<Riders> riderDelRistorante) {
		RiderDelRistorante = riderDelRistorante;
	}
	
	
	
}

package classiEntità;

import java.util.LinkedList;

public class Ristoranti {

	private String Nome;
	private String Indirizzo;
	private Menù Menu;
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
	
	public Menù getMenu() {
		return Menu;
	}
	public void setMenu(Menù menu) {
		Menu = menu;
	}
	
	public LinkedList<Riders> getRiderDelRistorante() {
		return RiderDelRistorante;
	}
	public void setRiderDelRistorante(LinkedList<Riders> riderDelRistorante) {
		RiderDelRistorante = riderDelRistorante;
	}
	
	
	
}

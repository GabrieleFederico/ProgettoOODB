package ClassiEntitą;

import java.util.LinkedList;

public class Ristorante {

	private String Nome;
	private String CodN;
	private String Indirizzo;
	private Menu Menu;
	private LinkedList<Rider> RiderDelRistorante;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCodN() {
		return CodN;
	}
	public void setCodN(String codN) {
		CodN = codN;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	
	public Menu getMenu() {
		return Menu;
	}
	public void setMenu(Menu menu) {
		Menu = menu;
	}
	
	public LinkedList<Rider> getRiderDelRistorante() {
		return RiderDelRistorante;
	}
	public void setRiderDelRistorante(LinkedList<Rider> riderDelRistorante) {
		RiderDelRistorante = riderDelRistorante;
	}
	
	
	
}

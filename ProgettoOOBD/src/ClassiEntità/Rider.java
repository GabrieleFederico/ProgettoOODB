package ClassiEntitą;

import java.util.ArrayList;
import java.util.LinkedList;

public class Rider {

	
	private String CodR;
	private String Nome;
	private String Cognome;
	private ArrayList<Ristorante> Ristoranti = new ArrayList<Ristorante>();
	private LinkedList<Consegne> ConsegneDaFare = new LinkedList<Consegne>();
	private enum Mezzo{
		Automobile,
		Bici,
		Moto
	}
	
	public String getCodR() {
		return CodR;
	}
	public void setCodR(String codR) {
		CodR = codR;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	
	public ArrayList<Ristorante> getRistoranti() {
		return Ristoranti;
	}
	public void setRistoranti(ArrayList<Ristorante> ristoranti) {
		Ristoranti = ristoranti;
	}
	
	public LinkedList<Consegne> getConsegneDaFare() {
		return ConsegneDaFare;
	}
	public void setConsegneDaFare(LinkedList<Consegne> consegnedafare) {
		ConsegneDaFare = consegnedafare;
	}
	
	
}

package classiEntità;

import java.util.LinkedList;

public class Riders {

	private String CodR;
	private String Nome;
	private String Cognome;
	private String Mezzo;
	private String Email;
	private String Password;
	private LinkedList<Consegne> ConsegneDaFare;
	

	public Riders(String nome, String cognome, String email, String mezzo, String password) {
		
		Nome = nome;
		Cognome = cognome;
		Mezzo = mezzo;
		Email = email;
		Password = password;
	}
	
	public Riders() {
		
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
	
	public String getMezzo() {
		return Mezzo;
	}
	public void setMezzo(String mezzo) {
		Mezzo = mezzo;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public LinkedList<Consegne> getConsegneDaFare() {
		return ConsegneDaFare;
	}
	public void setConsegneDaFare(LinkedList<Consegne> consegnedafare) {
		ConsegneDaFare = consegnedafare;
	}

	
	
}

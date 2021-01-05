package classiEntitą;

import java.util.ArrayList;
import java.util.Date;

public class Utente {
	
	private String email; 
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	private String Password;
	private ArrayList<Consegne> OrdiniEffettuati;
	
	
	public Utente(String email,  String password, String nome, String cognome, String indirizzo) {
		this.email = email;
		Password = password;
		Nome = nome;
		Cognome = cognome;
		Indirizzo = indirizzo;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}

	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public ArrayList<Consegne> getOrdiniEffettuati() {
		return OrdiniEffettuati;
	}
	public void setOrdiniEffettuate(ArrayList<Consegne> ordiniEffettuati) {
		OrdiniEffettuati = ordiniEffettuati;
	}

	
	
}

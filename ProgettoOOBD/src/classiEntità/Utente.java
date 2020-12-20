package classiEntità;

import java.util.ArrayList;
import java.util.Date;

public class Utente {
	
	private String email; 
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	private Date Data;
	private String Password;
	private ArrayList<Consegne> OrdiniEffettuate;
	
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
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public ArrayList<Consegne> getOrdiniEffettuate() {
		return OrdiniEffettuate;
	}
	public void setOrdiniEffettuate(ArrayList<Consegne> ordiniEffettuate) {
		OrdiniEffettuate = ordiniEffettuate;
	}

	
	
}

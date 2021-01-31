package classiEntità;

import java.sql.Time;

public class ConsegneSenzaRider {

	private String CodC;
	private Time Orario;
	private String IndirizzoP;
	private String IndirizzoA;
	private String NomeUtente;
	private String CognomeUtente;
	private String EmailUtente;
	private String Mezzo;
		
	public String getCodC() {
		return CodC;
	}
	public void setCodC(String codC) {
		CodC = codC;
	}
	
	public Time getOrario() {
		return Orario;
	}
	public void setOrario(Time orario) {
		Orario = orario;
	}
	
	public String getIndirizzoP() {
		return IndirizzoP;
	}
	public void setIndirizzoP(String indirizzoP) {
		IndirizzoP = indirizzoP;
	}
	
	public String getIndirizzoA() {
		return IndirizzoA;
	}
	public void setIndirizzoA(String indirizzoA) {
		IndirizzoA = indirizzoA;
	}
	
	public String getNomeUtente() {
		return NomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}
	public String getCognomeUtente() {
		return CognomeUtente;
	}
	public void setCognomeUtente(String cognomeUtente) {
		CognomeUtente = cognomeUtente;
	}
	
	public String getEmailUtente() {
		return EmailUtente;
	}
	public void setEmailUtente(String emailUtente) {
		EmailUtente = emailUtente;
	}
	public String getMezzo() {
		return Mezzo;
	}
	public void setMezzo(String mezzo) {
		Mezzo = mezzo;
	}
	
	
}

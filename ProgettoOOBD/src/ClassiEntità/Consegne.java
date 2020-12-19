package ClassiEntità;

import java.sql.Time;

public class Consegne {

	private String CodC;
	private Time Orario;
	private String IndirizzoP;
	private String IndirizzoA;
	private boolean Consegnato;
	private Carrello ComposizioneConsegna;
	
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
	
	public boolean isConsegnato() {
		return Consegnato;
	}
	public void setConsegnato(boolean consegnato) {
		Consegnato = consegnato;
	}
	
	public Carrello getComposizioneConsegna() {
		return ComposizioneConsegna;
	}
	public void setComposizioneConsegna(Carrello composizioneConsegna) {
		ComposizioneConsegna = composizioneConsegna;
	}
	
	
	
}

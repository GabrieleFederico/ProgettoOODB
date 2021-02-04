package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import classiEntità.Ristorante;
import classiEntità.Utente;
import interfacceGrafiche.JFrameHomeUtente;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHomeUtente fr;
	ControllorePrincipale C;
	
	public ControllerRicercaRistoranti(ControllorePrincipale c, Utente u) {
		C = c;
		fr = new JFrameHomeUtente(this, C, u);
		fr.setVisible(true);
	}
	
	public void ricerca (String ricerca, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		RistoranteDAOPostgres rp = new RistoranteDAOPostgres();
		ArrayList<Ristorante> risultatoRicerca = new ArrayList<Ristorante>();
		
		risultatoRicerca = rp.getRistoranteByNomeOrProdotto(ricerca);
		
		fr.aggiornaInterfacciaRistoranti(pannello, componentiNecessarie, risultatoRicerca, C);
			
	}


}	
	
	


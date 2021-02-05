package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import classiEntità.Ristoranti;
import classiEntità.Utenti;
import interfacceGrafiche.JFrameHomeUtente;
import postgresDAOImpl.RistorantiDAOPostgres;

public class ControllerRicercaRistoranti {
	
	JFrameHomeUtente fr;
	ControllerPrincipale C;
	RistorantiDAOPostgres ristoranteDao = new RistorantiDAOPostgres();
	
	public ControllerRicercaRistoranti(ControllerPrincipale c, Utenti u) {
		C = c;
		fr = new JFrameHomeUtente(this, C, u);
		fr.setVisible(true);
	}
	
	public void ricerca (String ricerca, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		
		ArrayList<Ristoranti> risultatoRicerca = new ArrayList<Ristoranti>();
		
		risultatoRicerca = ristoranteDao.getRistoranteByNomeOrProdotto(ricerca);
		
		fr.aggiornaInterfacciaRistoranti(pannello, componentiNecessarie, risultatoRicerca, C);
			
	}


}	
	
	


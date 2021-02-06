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
	RistorantiDAOPostgres ristoranteDao;
	
	public ControllerRicercaRistoranti(ControllerPrincipale c, Utenti u) {
		
		ristoranteDao = new RistorantiDAOPostgres();
		C = c;
		fr = new JFrameHomeUtente(this, C, u);
		fr.setVisible(true);
	}
	
	public ArrayList<Ristoranti> ricerca (String ricerca) {
		
		
		ArrayList<Ristoranti> risultatoRicerca = new ArrayList<Ristoranti>();
		
		risultatoRicerca = ristoranteDao.getRistoranteByNomeOrProdotto(ricerca);
		
		return risultatoRicerca;
			
	}


}	
	
	


package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import interfacceGrafiche.GestioneUI;
import interfacceGrafiche.JFrameRistorante;
import postgresDAOImpl.Men�DAOPostgres;
import postgresDAOImpl.RistoranteDAOPostgres;

public class ControllerRicercaProdotto {
	
	JFrameRistorante fr;
	GestioneUI gestore;
	
	public ControllerRicercaProdotto(String nomeRistorante) {
		
		try {
			fr = new JFrameRistorante(this, nomeRistorante);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fr.setVisible(true);
	}
	
	public void RicercaProdotto (String ricerca, JPanel pannello, int componentiNecessarie, String fasciaPrezzo) throws SQLException {
		
		Men�DAOPostgres mp = new  Men�DAOPostgres();
		ArrayList<String> risultatoRicerca = new ArrayList<String>();
		
		if(fasciaPrezzo == null)
			risultatoRicerca = mp.getProdottoByNomeProdottoAndRistorante(ricerca);
		else
			risultatoRicerca = mp.getProdottoByRicercaComplessa(ricerca, fasciaPrezzo);

		gestore = new GestioneUI();
		gestore.aggiornaInterfaccia(pannello, componentiNecessarie, risultatoRicerca);
		
	}

	public void getMenu(String nomeRistorante, JPanel pannello, int componentiNecessarie) throws SQLException {
		
		Men�DAOPostgres mp = new Men�DAOPostgres();
		ArrayList<String> men�Ristorante = new ArrayList<String>();
		
		men�Ristorante = mp.getMen�ByRistorante(nomeRistorante);
			
		gestore = new GestioneUI();
		gestore.aggiornaInterfaccia(pannello, componentiNecessarie, men�Ristorante);
		
	}


}

package Controllers;

import Interfacce.JFrameLogin;
import Interfacce.JFrameRegistrati;
import Controllers.ControllerLogin;


public class ControllerLogin {


	JFrameRegistrati fr;
	JFrameLogin fl;
	
	public static void main(String[] args) {
		ControllerLogin c = new ControllerLogin();
	}		
	
		public ControllerLogin() {
				
				fl = new JFrameLogin(this);
				fl.setVisible(true);
			}
		
		public void LoginRegistratiButton() {
			
			fr = new JFrameRegistrati(this);
			fl.setVisible(false);
			fr.setVisible(true);
		}

		public void RegistraCredenziali(String email, String pwd, String nome, String cognome, String indirizzo) {
			
			//Salvare questi dati nel DB
			//passare al DAO
			
			fl.setVisible(true);
			fr.setVisible(false);
			
		}
		
}

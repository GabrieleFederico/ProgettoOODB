package Controllers;

import Interfacce.JFrameLogin;
import Interfacce.JFrameRegistrati;

public class ControllerLogin {


		JFrameRegistrati fr;
		JFrameLogin fl;
		
		public static void main(String[] args) {
			ControllerLogin c = new ControllerLogin();
		}		
		
			public ControllerLogin() {
					
					fl = new JFrameLogin();
					fl.setVisible(true);
				}
				
		}



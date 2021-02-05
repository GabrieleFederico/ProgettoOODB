package interfacceGrafiche;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogMaxAttività extends JDialog {

	public JDialogMaxAttività() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 388, 212);
		getContentPane().setLayout(null);
		
		JLabel labelAttenzione = new JLabel("ATTENZIONE!");
		labelAttenzione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAttenzione.setBounds(125, 25, 147, 14);
		getContentPane().add(labelAttenzione);
		
		JLabel labelTesto = new JLabel("Possiede già il massimo numero di ordini.");
		labelTesto.setBounds(21, 64, 403, 14);
		getContentPane().add(labelTesto);
		
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		buttonOk.setBounds(125, 127, 101, 23);
		getContentPane().add(buttonOk);

	}
}

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
		
		JLabel LabelAttenzione = new JLabel("ATTENZIONE!");
		LabelAttenzione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelAttenzione.setBounds(125, 25, 147, 14);
		getContentPane().add(LabelAttenzione);
		
		JLabel LabelTesto = new JLabel("Possiede già il massimo numero di ordini.");
		LabelTesto.setBounds(21, 64, 403, 14);
		getContentPane().add(LabelTesto);
		
		JButton ButtonOk = new JButton("OK");
		ButtonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		ButtonOk.setBounds(125, 127, 101, 23);
		getContentPane().add(ButtonOk);

	}
}

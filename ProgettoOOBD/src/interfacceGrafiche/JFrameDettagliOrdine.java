package interfacceGrafiche;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import classiEntità.Carrello;
import classiEntità.Consegne;

public class JFrameDettagliOrdine extends JFrame {

	private JPanel contentPane;
	JScrollPane scrollPane;

	public JFrameDettagliOrdine(Carrello carrello) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pannelloScrollPane = new JPanel();
		pannelloScrollPane.setLayout(null);
		pannelloScrollPane.setPreferredSize(new Dimension(733, carrello.getProdotti().size()*50));
		
		scrollPane = new JScrollPane(pannelloScrollPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 733, 354);
		contentPane.add(scrollPane);
	}

}

package shakki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JMenu;

public class Tallenna extends JMenu {
	
	public Tallenna(String s) {
		super(s);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				File tiedosto = new File("Tallennus.txt");
		
				try {
					FileWriter kirjoittaja = new FileWriter(tiedosto);
					
					kirjoittaja.write(Shakki.annaTila());
					kirjoittaja.flush();
					
					kirjoittaja.close();
				} catch (IOException e) {
					
				}
				
			}
		});
		
	}
}

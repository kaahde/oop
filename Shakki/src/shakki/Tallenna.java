package shakki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JMenuItem;;

/**
 * Pelin valikon tallennuspainikkeen toiminnallisuuden sisaltava luokka
 * @author Kadir
 */
public class Tallenna extends JMenuItem {
	
	public Tallenna(String s) {
		super(s);
	
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FileWriter kirjoittaja = new FileWriter(Shakki.annaTiedosto());
					
					kirjoittaja.write(Shakki.annaTila());
					kirjoittaja.flush();
					
					kirjoittaja.close();
				} catch (IOException e) {
					
				}
				
			}
		});
		
	}
}

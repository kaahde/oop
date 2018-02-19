package shakki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JMenuItem;;

/**
 *  Pelin valikon latauspainikkeen toiminnallisuuden sisaltava luokka
 * @author Kadir
 */
public class Lataa extends JMenuItem {
	
	public Lataa(String s) {
		super(s);
		
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedReader lukija = new BufferedReader(new FileReader(Shakki.annaTiedosto()));
					
					for (int i = 0; i < Shakki.annaRuudut().size(); i++) {
						
						String rivi = lukija.readLine();
						
						if (rivi.equals("")) {
							Shakki.annaRuudut().get(i).asetaNappula(null);
						} else {
							
							if (rivi.equals("SOTILAS;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.SOTILAS, Varit.MUSTA));
							} else if (rivi.equals("SOTILAS;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.SOTILAS, Varit.VALKOINEN));
							} else if (rivi.equals("TORNI;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.TORNI, Varit.MUSTA));
							} else if (rivi.equals("TORNI;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.TORNI, Varit.VALKOINEN));
							} else if (rivi.equals("RATSU;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.RATSU, Varit.MUSTA));
							} else if (rivi.equals("RATSU;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.RATSU, Varit.VALKOINEN));
							} else if (rivi.equals("LAHETTI;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.LAHETTI, Varit.MUSTA));
							} else if (rivi.equals("LAHETTI;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.LAHETTI, Varit.VALKOINEN));
							} else if (rivi.equals("KUNINGATAR;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.KUNINGATAR, Varit.MUSTA));
							} else if (rivi.equals("KUNINGATAR;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.KUNINGATAR, Varit.VALKOINEN));
							} else if (rivi.equals("KUNINGAS;MUSTA")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.KUNINGAS, Varit.MUSTA));
							} else if (rivi.equals("KUNINGAS;VALKOINEN")) {
								Shakki.annaRuudut().get(i).asetaNappula(new Nappula(Nappulat.KUNINGAS, Varit.VALKOINEN));
							}
							
						}
					}
					
					lukija.close();
					Shakki.paivitaRuudut();
				} catch ( IOException e) {
					
				}
			}
		});
		
	}
	
	
}

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
					
					for (int i = 0; i < 2 * Shakki.annaRuudut().size(); i++) {
						
						String rivi = lukija.readLine();
						
						if (i % 2 == 0) {
							if (rivi.equals("")) {
								Shakki.annaRuudut().get(i/2).asetaNappula(null);
							} else {
								
								Shakkiruutu ruutu = Shakki.annaRuudut().get(i/2);
								
								if (rivi.equals("SOTILAS;MUSTA")) {
									ruutu.asetaNappula(new Sotilas(Varit.MUSTA));
								} else if (rivi.equals("SOTILAS;VALKOINEN")) {
									ruutu.asetaNappula(new Sotilas(Varit.VALKOINEN));
								} else if (rivi.equals("TORNI;MUSTA")) {
									ruutu.asetaNappula(new Torni(Varit.MUSTA));
								} else if (rivi.equals("TORNI;VALKOINEN")) {
									ruutu.asetaNappula(new Torni(Varit.VALKOINEN));
								} else if (rivi.equals("RATSU;MUSTA")) {
									ruutu.asetaNappula(new Ratsu(Varit.MUSTA));
								} else if (rivi.equals("RATSU;VALKOINEN")) {
									ruutu.asetaNappula(new Ratsu(Varit.VALKOINEN));
								} else if (rivi.equals("LAHETTI;MUSTA")) {
									ruutu.asetaNappula(new Lahetti(Varit.MUSTA));
								} else if (rivi.equals("LAHETTI;VALKOINEN")) {
									ruutu.asetaNappula(new Lahetti(Varit.VALKOINEN));
								} else if (rivi.equals("KUNINGATAR;MUSTA")) {
									ruutu.asetaNappula(new Kuningatar(Varit.MUSTA));
								} else if (rivi.equals("KUNINGATAR;VALKOINEN")) {
									ruutu.asetaNappula(new Kuningatar(Varit.VALKOINEN));
								} else if (rivi.equals("KUNINGAS;MUSTA")) {
									ruutu.asetaNappula(new Kuningas(Varit.MUSTA));
								} else if (rivi.equals("KUNINGAS;VALKOINEN")) {
									ruutu.asetaNappula(new Kuningas(Varit.VALKOINEN));
								}
								
							}
						} else {
							if (rivi.equals("1")) {
								Shakkiruutu ruutu = Shakki.annaRuudut().get(i/2);
								ruutu.annaNappula().ekaSiirtoOhi();
							}
						}
					}
					
					String rivi = lukija.readLine();
					
					 if (rivi.equals("true")) {
						if (!Shakki.onkoValkoisenVuoro()) {
							Shakki.paataVuoro();
						}
					} else if (rivi.equals("false")) {
						if (Shakki.onkoValkoisenVuoro()) {
							Shakki.paataVuoro();
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

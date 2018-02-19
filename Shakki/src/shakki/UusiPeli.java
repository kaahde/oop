package shakki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JMenuItem;;

/**
 * Valikon uuden pelin alustamisen toiminnalisuuden sisaltava luokka
 * @author Kadir
 */
public class UusiPeli extends JMenuItem {

	public UusiPeli(String s) {
		super(s);
		
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						
						Shakkiruutu ruutu = Shakki.annaRuudut().get(i*8 + j);
						
						if (i == 1) {
							ruutu.asetaNappula(new Sotilas(Varit.MUSTA));
						} else if (i == 6) {
							ruutu.asetaNappula(new Sotilas(Varit.VALKOINEN));
						} else if (i == 0 && j == 0 || i == 0 && j == 7) {
							ruutu.asetaNappula(new Torni(Varit.MUSTA));
						} else if (i == 7 && j == 0 || i == 7 && j == 7) {
							ruutu.asetaNappula(new Torni(Varit.VALKOINEN));
						} else if (i == 0 && j == 1 || i == 0 && j == 6) {
							ruutu.asetaNappula(new Ratsu(Varit.MUSTA));
						} else if (i == 7 && j == 1 || i == 7 && j == 6) {
							ruutu.asetaNappula(new Ratsu(Varit.VALKOINEN));
						} else if (i == 0 && j == 2 || i == 0 && j == 5) {
							ruutu.asetaNappula(new Lahetti(Varit.MUSTA));
						} else if (i == 7 && j == 2 || i == 7 && j == 5) {
							ruutu.asetaNappula(new Lahetti(Varit.VALKOINEN));
						} else if (i == 0 && j == 4) {
							ruutu.asetaNappula(new Kuningatar(Varit.MUSTA));
						} else if (i == 7 && j == 3) {
							ruutu.asetaNappula(new Kuningatar(Varit.VALKOINEN));
						} else if (i == 0 && j == 3) {
							ruutu.asetaNappula(new Kuningas(Varit.MUSTA));
						} else if (i == 7 && j == 4) {
							ruutu.asetaNappula(new Kuningas(Varit.VALKOINEN));
						} else {
							ruutu.asetaNappula(null);
						}
					}
				}
				
				Shakki.paivitaRuudut();
					
			}
			
		});
		
	}
	
	
}

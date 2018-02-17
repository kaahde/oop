package shakki;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Main-metodin sis�lt�v� luokka, jossa luodaan lis�ksi k�ytt�liittym�
 * @author Kadir
 */
public class Shakki extends JFrame {

	private Shakkiruutu ruutu;
	
	private static ArrayList<Shakkiruutu> ruudut = new ArrayList<Shakkiruutu>();
	private static File tiedosto = new File("res/Tallennus.txt");
	
	public static Nappula valittuNappula = null;
	public static Shakkiruutu valittuRuutu = null;
	public static boolean vuoroPelaamatta = true;
	
	/**
	 * Konstruktori
	 */
	public Shakki() {
		luoUI();
		
		setTitle("Shakki");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(540, 540);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar valikko = new JMenuBar();
		setJMenuBar(valikko);
		
		JMenu peli =  new JMenu("Peli");
		valikko.add(peli);
		
		
		Tallenna tallennus = new Tallenna("Tallenna peli");
		Lataa lataus = new Lataa("Lataa vanha peli");
		UusiPeli uusi = new UusiPeli("Uusi peli");
		peli.add(uusi);
		peli.add(tallennus);
		peli.add(lataus);
		
	}
	
	/**
	 * Palauttaa shakkilaudan ruudut ArrayListin�
	 * @return ArrayList, jossa on kaikki ruudut 
	 */
	public static ArrayList<Shakkiruutu> annaRuudut() {
		return ruudut;
	}
	
	
	/**
	 * Luo k�ytt�liittym�n ja alustaa shakkilaudan
	 */
	public void luoUI() {
		
		JPanel paneeli = new JPanel();
		getContentPane().add(paneeli);
		paneeli.setLayout(new GridLayout(8, 8));	
		
		// Luo shakkilaudan ruudukon
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				
				// Luo shakkilaudan ruudun
				ruutu = new Shakkiruutu(i, j);
				
				// Lis�� ruudun ArrayListiin
				ruudut.add(ruutu);
				
				// Alustaa nappulat
				if (i == 1) {
					ruutu.asetaNappula(new Nappula(Nappulat.SOTILAS, Varit.MUSTA));
				} else if (i == 6) {
					ruutu.asetaNappula(new Nappula(Nappulat.SOTILAS, Varit.VALKOINEN));
				} else if (i == 0 && j == 0 || i == 0 && j == 7) {
					ruutu.asetaNappula(new Nappula(Nappulat.TORNI, Varit.MUSTA));
				} else if (i == 7 && j == 0 || i == 7 && j == 7) {
					ruutu.asetaNappula(new Nappula(Nappulat.TORNI, Varit.VALKOINEN));
				} else if (i == 0 && j == 1 || i == 0 && j == 6) {
					ruutu.asetaNappula(new Nappula(Nappulat.RATSU, Varit.MUSTA));
				} else if (i == 7 && j == 1 || i == 7 && j == 6) {
					ruutu.asetaNappula(new Nappula(Nappulat.RATSU, Varit.VALKOINEN));
				} else if (i == 0 && j == 2 || i == 0 && j == 5) {
					ruutu.asetaNappula(new Nappula(Nappulat.LAHETTI, Varit.MUSTA));
				} else if (i == 7 && j == 2 || i == 7 && j == 5) {
					ruutu.asetaNappula(new Nappula(Nappulat.LAHETTI, Varit.VALKOINEN));
				} else if (i == 0 && j == 4) {
					ruutu.asetaNappula(new Nappula(Nappulat.KUNINGATAR, Varit.MUSTA));
				} else if (i == 7 && j == 3) {
					ruutu.asetaNappula(new Nappula(Nappulat.KUNINGATAR, Varit.VALKOINEN));
				} else if (i == 0 && j == 3) {
					ruutu.asetaNappula(new Nappula(Nappulat.KUNINGAS, Varit.MUSTA));
				} else if (i == 7 && j == 4) {
					ruutu.asetaNappula(new Nappula(Nappulat.KUNINGAS, Varit.VALKOINEN));
				} else {
					ruutu.asetaNappula(null);
				}
				
				// Lis�� nappuloiden kuvat ruudukkoon
				try {
					ruutu.setIcon(ruutu.annaNappula().annaKuva());
				} catch (Exception e) {
					ruutu.setIcon(null);
				}
				ruutu.setHorizontalAlignment(SwingConstants.CENTER);
				ruutu.setVerticalAlignment(SwingConstants.CENTER);
				
				// Muuttaa ruudun taustav�rin n�kyv�ksi ja lis�� ruudun paneeliin
				ruutu.setOpaque(true);
				paneeli.add(ruutu);
			}
		}

	}
	
	
	/**
	 * P�ivitt�� shakkilaudan ruudukon
	 */
	public static void paivitaRuudut() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Shakkiruutu r = ruudut.get(i * 8 + j);
				

				if (r.annaNappula() != null) {
					try {
						r.setIcon(r.annaNappula().annaKuva());
					} catch (Exception e) {
						r.setIcon(null);
					}
				} else {
					try {
						r.setIcon(null);
					} catch (Exception e) {
						r.setIcon(null);
					}
				}
			}
		}
	}
	
	/**
	 * Palauttaa pelin tilan tallennusta varten
	 * @return Merkkijono, jossa omilla riveill� ruuduissa sijaitsevat nappulat
	 */
	public static String annaTila() {
		String tila = "";
		
		for (Shakkiruutu r : ruudut) {
			if (r.annaNappula() != null) {
				tila += r.annaNappula().annaNimi() + ";" + r.annaNappula().annaVari() +"\n";
			} else {
				tila += "\n";
			}
		}
		
		return tila;
	}
	
	public static File annaTiedosto() {
		return tiedosto;
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Shakki().setVisible(true);
			}
		});
	}

}

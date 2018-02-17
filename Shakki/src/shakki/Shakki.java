package shakki;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Kadir
 *
 */
public class Shakki extends JFrame {

	private Shakkiruutu ruutu;
	
	private static ArrayList<Shakkiruutu> ruudut = new ArrayList<Shakkiruutu>();
	
	public static int valittujaNappuloita = 0;
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
		
		JMenuBar valikko = new JMenuBar();
		setJMenuBar(valikko);
		
		Tallenna tallennuspainike = new Tallenna("Tallenna");
		valikko.add(tallennuspainike);
	}
	
	/**
	 * Palauttaa ruudukon
	 * @return ArrayList, jossa on kaikki ruudut 
	 */
	public static ArrayList<Shakkiruutu> annaRuudut() {
		return ruudut;
	}
	
	
	/**
	 * Luo käyttöliittymän
	 */
	private void luoUI() {
		
		JPanel paneeli = new JPanel();
		getContentPane().add(paneeli);
		paneeli.setLayout(new GridLayout(8, 8));	
		
		// Luo shakkilaudan ruudukon
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				
				// Luo shakkilaudan ruudun
				ruutu = new Shakkiruutu(i, j);
				
				// Lisää ruudun ArrayListiin
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
				
				// Lisää nappuloiden kuvat ruudukkoon
				try {
					ruutu.setIcon(ruutu.annaNappula().annaKuva());
				} catch (Exception e) {
					ruutu.setIcon(null);
				}
				ruutu.setHorizontalAlignment(SwingConstants.CENTER);
				ruutu.setVerticalAlignment(SwingConstants.CENTER);
				
				// Muuttaa ruudun taustavärin näkyväksi ja lisää ruudun paneeliin
				ruutu.setOpaque(true);
				paneeli.add(ruutu);
			}
		}

	}
	
	
	/**
	 * Päivittää shakkilaudan ruudukon
	 */
	public static void paivitaRuudut() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Shakkiruutu r = ruudut.get(i * 8 + j);
				

				if (r.annaNappula() != null) {
					try {
						r.setIcon(r.annaNappula().annaKuva());
					} catch (Exception e) {
						r.setText("");
					}
				} else {
					try {
						r.setIcon(null);
					} catch (Exception e) {
						r.setText("");
					}
				}
			}
		}
	}
	
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

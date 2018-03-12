package shakki;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Main-metodin sisaltava luokka, jossa luodaan lisaksi kayttoliittyma
 * @author Kadir
 */
public class Shakki extends JFrame {

	private Shakkiruutu ruutu;
	private static Infolaatikko vuoroinfo;
	private static SotilaanPromootio promootio;
	
	private static ArrayList<Shakkiruutu> ruudut = new ArrayList<Shakkiruutu>();
	private static File tiedosto = new File("res/Tallennus.txt");
	private static Nappula valittuNappula = null;
	private static Shakkiruutu valittuRuutu = null;
	private static boolean valkoisenVuoro = true;
	
	
	/**
	 * Konstruktori
	 */
	public Shakki() {
		luoPelilauta();
		
		setTitle("Shakki");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		
		luoValikko();
		
	}
	
	/**
	 * Palauttaa shakkilaudan ruudut ArrayListina
	 * @return ArrayList, jossa on kaikki ruudut 
	 */
	public static ArrayList<Shakkiruutu> annaRuudut() {
		return ruudut;
	}
	
	
	/**
	 * Luo kayttoliittyman ja alustaa shakkilaudan
	 */
	public void luoPelilauta() {
		
		// Luo JPanel-olion, johon pelilauta yms. sisaltyy
		JPanel paneeli = new JPanel();
		getContentPane().add(paneeli);
		paneeli.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
		paneeli.setLayout(new BorderLayout());
		
		// Luo JPanel-olion pelilaudalle 
		JPanel pelilauta = new JPanel();
		pelilauta.setLayout(new GridLayout(8, 8));
		pelilauta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));;
		pelilauta.setBackground(Color.decode("#6d6856"));
		paneeli.add(pelilauta, BorderLayout.LINE_START);
		
		// Luo JPanel-olion muille asioille
		JPanel muutTiedot = new JPanel();
		muutTiedot.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		muutTiedot.setLayout(new BoxLayout(muutTiedot, BoxLayout.Y_AXIS));
		paneeli.add(muutTiedot, BorderLayout.LINE_END);
		
		// Luo tekstikentan, jossa nakyy kumman vuoro pelata
		vuoroinfo = new Infolaatikko("Valkoisen vuoro");
		muutTiedot.add(vuoroinfo);
		
		promootio = new SotilaanPromootio();
		promootio.setVisible(false);
		muutTiedot.add(promootio);
		
		// Luo shakkilaudan ruudukon
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				
				// Luo shakkilaudan ruudun
				ruutu = new Shakkiruutu(i, j);
				
				// Lisaa ruudun ArrayListiin
				ruudut.add(ruutu);
				
				// Alustaa nappulat
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
				
				// Lisaa nappuloiden kuvat ruudukkoon
				try {
					ruutu.setIcon(ruutu.annaNappula().annaKuva());
				} catch (Exception e) {
					ruutu.setIcon(null);
				}
				ruutu.setHorizontalAlignment(SwingConstants.CENTER);
				ruutu.setVerticalAlignment(SwingConstants.CENTER);
				
				// Muuttaa ruudun taustavarin nakyvaksi ja lisaa ruudun paneeliin
				ruutu.setOpaque(true);
				pelilauta.add(ruutu);
			}
		}

	}
	
	/**
	 * Luo käyttöliittymän valikon
	 */
	public void luoValikko() {
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
	 * Paivittaa shakkilaudan ruudukon
	 */
	public static void paivitaRuudut() {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Shakkiruutu r = ruudut.get(i * 8 + j);
				
				try {
					r.setIcon(r.annaNappula().annaKuva());
				} catch (NullPointerException e) {
					r.setIcon(null);
				}
				
			}
		}
	}
	
	/**
	 * Palauttaa pelin tilan tallennusta varten
	 * @return Merkkijono, jossa omilla riveilla ruuduissa sijaitsevat nappulat
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
		tila += onkoValkoisenVuoro();
		
		return tila;
	}
	
	/**
	 * Palauttaa tiedoston, johon pelin tila tallennetaan
	 * @return Tallennustiedosto
	 */
	public static File annaTiedosto() {
		return tiedosto;
	}
	
	/**
	 * Kertoo onko valkoisen pelaajan vuoro tehda siirto
	 * @return true, jos valkoisen vuoro; false, jos mustan vuoro
	 */
	public static boolean onkoValkoisenVuoro() {
		return valkoisenVuoro;
	}
	
	/**
	 * Vaihtaa vuorossa olevan pelaajan
	 */
	public static void paataVuoro() {
		valkoisenVuoro = !valkoisenVuoro;
		vuoroinfo.paivita();
	}
	
	/**
	 * Voittaa pelin
	 */
	public static void voitaPeli() {
		vuoroinfo.voitaPeli();
	}

	/**
	 * @return Valittu nappula
	 */
	public static Nappula annaValittuNappula() {
		return valittuNappula;
	}

	/**
	 * @param valittuNappula Nappula, joka asetetaan valituksi
	 */
	public static void asetaValittuNappula(Nappula valittuNappula) {
		Shakki.valittuNappula = valittuNappula;
	}
	
	/**
	 * @return Valittu ruutu
	 */
	public static Shakkiruutu annaValittuRuutu() {
		return valittuRuutu;
	}

	/**
	 * @param valittuRuutu Ruutu, joka asetetaan valituksi
	 */
	public static void asetaValittuRuutu(Shakkiruutu valittuRuutu) {
		Shakki.valittuRuutu = valittuRuutu;
	}
	
	
	/**
	 * Nayttaa sotilaan promootioikkunan
	 * @param vari
	 * @param sarake
	 * @param rivi
	 */
	public static void naytaPromootioIkkuna(Varit vari, int sarake, int rivi) {
		promootio.paivitaTiedot(vari, sarake, rivi);
		promootio.setVisible(true);
		
	}
	
	/**
	 * Piilottaa sotilaan promootioikkunan
	 */
	public static void piilotaPromootioIkkuna() {
		promootio.setVisible(false);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Shakki().setVisible(true);
			}
		});
	}

}

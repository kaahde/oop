package Nappulat;
import java.util.HashMap;

/*
 * Linnotus
 * jos siirto 40
 * jos 00torni ja kuningas alkuper‰isiss‰ paikoissaan eiv‰tk‰ ole liikkuneet(tee 'boolean liikkunut' ja lis‰‰ se siirraNappula metodiin)
 * jos matkan varrella ei muita
 * tee linnotus
 */

class Torni extends Nappula {
	private final String tyyppi = "torni";

	private static final int[] siirrot = { 1, 2, 3, 4, 5, 6, 7, 10, 20, 30, 40, 50, 60, 70, -1, -2, -3, -4, -5, -6, -7,
			-10, -20, -30, -40, -50, -60, -70 };

	// KONSTRUKTORI
	public Torni(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> pelilauta) {
		super(sijainti, pelaaja, pelilauta);
	}

	public String annaTyypinGen() {
		return "tornin";
	}

	public String annaTyyppi() {
		return tyyppi;
	}

	public void asetaSijainti(int s) {
		this.sijainti = s;
	}

	public boolean liiku(int uusi) {

		// Onko m‰‰r‰np‰‰ laudalla?
		if (uusi >= -70 && uusi <= 70) {
			boolean voiko = false;

			// Onko siirto sallittu kys. nappulalle
			for (int i = 0; i < siirrot.length; i++) {
				if (Torni.siirrot[i] - (uusi - this.sijainti) == 0) {
					voiko = true;
				}
			}
			if (voiko == false) {
				System.out.println("Ei ole laillinen siirto!!");
				return false;
			}
		} else {
			System.out.println("Et voi liikkua laudan ulkopuolelle!!");
			return false;
		}

		int etappi = uusi; // V‰lietapin sijainti
		int x = 0; // Yksi askel

		// M‰‰ritt‰‰ askeleen pituuden ja suunnan/ylˆsalas vai oikeevasen ja miinusta
		// vai plussaa
		if (uusi % 10 == 0) {
			if (uusi < 0) {
				x = -10;
			} else {
				x = 10;
			}
		} else {
			if (uusi < 0) {
				x = -1;
			} else {
				x = 1;
			}
		}

		// Onko v‰lietappien ruuduissa nappuloita?
		while (etappi != 0 & etappi != this.sijainti) {
			if (Shakkipeli.annaNappula(etappi, pelilauta).annaPelaajanTiimi() != "eioo" && etappi != uusi) {
				System.out.println("Torni ei voi liikkua muiden nappuloiden yli!!");
				return false;
			} else {
				etappi = etappi - x;
			}
		}

		// Onko m‰‰r‰np‰‰ tyhj‰?
		if (Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == "eioo") {
			// System.out.println(sijainti);
			System.out.println("Liikutit tornin ruudusta " + Shakkipeli.annaPositio(sijainti) + " ruutuun "
					+ Shakkipeli.annaPositio(uusi));
			Shakkipeli.siirraNappula(uusi, this, pelilauta);
			return true;
		}

		// Onko pelaajan oma nappula?
		if (Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi()
				.equals(Shakkipeli.annaNappula(sijainti, pelilauta).annaPelaajanTiimi())) {

			System.out.println(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi()
					+ Shakkipeli.annaNappula(sijainti, pelilauta).annaPelaajanTiimi());
			System.out.println("Et voi liikkua oman nappulasi p‰‰lle!!");
			return false;
		}

		// Onko vihollisen kuningas?
		else if (Shakkipeli.annaNappula(uusi, pelilauta).annaTyyppi() == "kuningas") {
			System.out.println("VOITIT PELIN!!");
			return false;
		}

		// J‰ljelle j‰‰: vihollinen, mutta ei kuningas
		else {
			System.out.println("Sˆit vastustajan " + Shakkipeli.annaNappula(uusi, pelilauta).annaTyypinGen() + "!!");
			Shakkipeli.siirraNappula(uusi, this, pelilauta);
			return true;
		}
	}// Metodi
}// Luokka
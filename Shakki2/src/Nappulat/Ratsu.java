package Nappulat;
import java.util.HashMap;

class Ratsu extends Nappula {
	private final String tyyppi = "ratsu";

	private static final int[] siirrot = { -8, -19, -21, -12, 12, 21, 19, 8 };

	// KONSTRUKTORI
	public Ratsu(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> pelilauta) {
		super(sijainti, pelaaja, pelilauta);
	}

	public String annaTyypinGen() {
		return "ratsun";
	}

	public String annaTyyppi() {
		return tyyppi;
	}

	public void asetaSijainti(int s) {
		this.sijainti = s;
	}

	public boolean liiku(int uusi) {

		// Onko määränpää laudalla?
		if (uusi >= -70 && uusi <= 70) {
			boolean voiko = false;

			// Onko siirto sallittu kys. nappulalle
			for (int i = 0; i < siirrot.length; i++) {
				if (Ratsu.siirrot[i] - (uusi - this.sijainti) == 0) {
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

		// Onko määränpää tyhjä?
		if (Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == "eioo") {
			// System.out.println(sijainti);
			System.out.println("Liikutit ratsun ruudusta " + Shakkipeli.annaPositio(sijainti) + " ruutuun "
					+ Shakkipeli.annaPositio(uusi));
			Shakkipeli.siirraNappula(uusi, this, pelilauta);
			return true;
		}

		// Onko pelaajan oma nappula?
		if (Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi()
				.equals(Shakkipeli.annaNappula(sijainti, pelilauta).annaPelaajanTiimi())) {
			System.out.println("Et voi liikkua oman nappulasi päälle!!");
			return false;
		}

		// Onko vihollisen kuningas?
		else if (Shakkipeli.annaNappula(uusi, pelilauta).annaTyyppi() == "kuningas") {
			System.out.println("VOITIT PELIN!!");
			return false;
		}

		// Jäljelle jää: vihollinen, mutta ei kuningas
		else {
			System.out.println("Söit vastustajan " + Shakkipeli.annaNappula(uusi, pelilauta).annaTyypinGen() + "!!");
			Shakkipeli.siirraNappula(uusi, this, pelilauta);
			return true;
		}
	}// Metodi
}// Luokka
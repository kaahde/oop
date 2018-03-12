package shakki;

import javax.swing.ImageIcon;

public class Torni extends Nappula {
	
	private final String nimi = "TORNI";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Torni(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/torni_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/torni_v.png");
		}
	}
	
	@Override
	public String annaNimi() {
		return nimi;
	}

	@Override
	public boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu) {
		
		if (!(loppu.annaSarake() == alku.annaSarake() ^ loppu.annaRivi() == alku.annaRivi())) {
			// Rivin tai sarakkeen taytyy pysya samana
			return false;
		}
		
		// Tarkistetaan onko lopun ja alun valissa nappuloita
		// Rivi pysyy samana
		if (loppu.annaRivi() == alku.annaRivi()) {
			int etaisyys = Math.abs(loppu.annaSarake() - alku.annaSarake());
			// Siirryttaessa oikealle
			if (loppu.annaSarake() > alku.annaSarake()) {
				for (int i = 1; i < etaisyys; i++) {
					if (Shakki.annaRuudut().get(alku.annaRivi() * 8 + i + alku.annaSarake()).annaNappula() != null) {
						return false;
					}
				}
			// Siirryttaessa vasemmalle
			} else {
				for (int i = 1; i < etaisyys; i++) {
					if (Shakki.annaRuudut().get(alku.annaRivi() * 8 - i + alku.annaSarake()).annaNappula() != null) {
						return false;
					}
				}
			}
		// Sarake pysyy samana
		} else if (loppu.annaSarake() == alku.annaSarake()) {
			int etaisyys = Math.abs(loppu.annaRivi() - alku.annaRivi());
			// Siirryttaessa alas
			if (loppu.annaRivi() > alku.annaRivi()) {
				for (int i = 1; i < etaisyys; i++) {
					if (Shakki.annaRuudut().get((alku.annaRivi() + i) * 8 + alku.annaSarake()).annaNappula() != null) {
						return false;
					}
				}
			// Siirryttaessa ylos
			} else {
				for (int i = 1; i < etaisyys; i++) {
					if (Shakki.annaRuudut().get((alku.annaRivi() - i) * 8 + alku.annaSarake()).annaNappula() != null) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}

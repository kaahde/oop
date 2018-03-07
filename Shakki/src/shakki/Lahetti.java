package shakki;

import javax.swing.ImageIcon;

public class Lahetti extends Nappula {
	
	private final String nimi = "LAHETTI";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Lahetti(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/lahetti_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/lahetti_v.png");
		}
	}
	
	@Override
	public String annaNimi() {
		return nimi;
	}

	@Override
	public boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu) {
		
		int etaisyys = 0;
	
		// Siirto ei voi onnistua ellei liikuta viistottain
		if (Math.abs(loppu.annaRivi() - alku.annaRivi()) != Math.abs(loppu.annaSarake() - alku.annaSarake())) {
			return false;
		} else {
			etaisyys = Math.abs(loppu.annaRivi() - alku.annaRivi());
		}
		
		// Tarkistetaan ettei reitilla ole muita nappuloita
		for (int i = 1; i < etaisyys; i++) {
			if (loppu.annaRivi() > alku.annaRivi() && loppu.annaSarake() > alku.annaSarake()) {
				if (Shakki.annaRuudut().get((alku.annaRivi() + i) * 8 + alku.annaSarake() + i).annaNappula() != null) {
					return false;
				}
			}
			if (loppu.annaRivi() < alku.annaRivi() && loppu.annaSarake() > alku.annaSarake()) {
				if (Shakki.annaRuudut().get((alku.annaRivi() - i) * 8 + alku.annaSarake() + i).annaNappula() != null) {
					return false;
				}
			}
			if (loppu.annaRivi() > alku.annaRivi() && loppu.annaSarake() < alku.annaSarake()) {
				if (Shakki.annaRuudut().get((alku.annaRivi() + i) * 8 + alku.annaSarake() - i).annaNappula() != null) {
					return false;
				}
			}
			if (loppu.annaRivi() < alku.annaRivi() && loppu.annaSarake() < alku.annaSarake()) {
				if (Shakki.annaRuudut().get((alku.annaRivi() - i) * 8 + alku.annaSarake() - i).annaNappula() != null) {
					return false;
				}
			}
		}
		
		return true;
	
	}
}

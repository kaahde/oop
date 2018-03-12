package shakki;

import javax.swing.ImageIcon;

public class Sotilas extends Nappula {
	private final String nimi = "SOTILAS";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Sotilas(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/sotilas_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/sotilas_v.png");
		}
	}
	
	@Override
	public String annaNimi() {
		return nimi;
	}

	@Override
	public boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu) {
		
		if (this.vari == Varit.VALKOINEN) {
			// Ensimmaisella siirrolla voi liikuttaa 1 tai 2 ruutua eteenpain
			if (loppu.annaSarake() == alku.annaSarake() && alku.annaRivi() == 6 && loppu.annaRivi() >= alku.annaRivi() - 2 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() == null) {
				// Ei voi hypata nappuloiden yli
				if (Shakki.annaRuudut().get((alku.annaRivi() - 1) * 8 + alku.annaSarake()).annaNappula() == null) {
					return true;
				}
			// Muilla siirroilla voi liikuttaa yhden ruudun eteenpain
			} else if (loppu.annaSarake() == alku.annaSarake() && loppu.annaRivi() >= alku.annaRivi() - 1 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() == null)  {
				if (loppu.annaRivi() == 0) {
					paadyssa(this.vari, loppu.annaSarake(), loppu.annaRivi());
				}
				return true;
			// Syodessa voi liikuttaa yhden ruudun eteenpain viistoon
			} else if ((loppu.annaSarake() == alku.annaSarake() + 1  || loppu.annaSarake() == alku.annaSarake() - 1) && loppu.annaRivi() >= alku.annaRivi() - 1 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() != null)  {
				if (loppu.annaRivi() == 0) {
					paadyssa(this.vari, loppu.annaSarake(), loppu.annaRivi());
				}
				return true;
			}
		} else if (this.vari == Varit.MUSTA) {
			// Ensimmaisella siirrolla voi liikuttaa 1 tai 2 ruutua eteenpain
			if (loppu.annaSarake() == alku.annaSarake() && alku.annaRivi() == 1 && loppu.annaRivi() <= alku.annaRivi() + 2 && loppu.annaRivi() > alku.annaRivi() && loppu.annaNappula() == null) {
				// Ei voi hypata nappuloiden yli
				if (Shakki.annaRuudut().get((alku.annaRivi() + 1) * 8 + alku.annaSarake()).annaNappula() == null) {
					return true;
				}
			// Muilla siirroilla voi liikuttaa yhden ruudun eteenpain
			} else if (loppu.annaSarake() == alku.annaSarake() && loppu.annaRivi() <= alku.annaRivi() + 1 && loppu.annaRivi() > alku.annaRivi() && loppu.annaNappula() == null)  {
				if (loppu.annaRivi() == 7) {
					paadyssa(this.vari, loppu.annaSarake(), loppu.annaRivi());
				}
				return true;
			// Syodessa voi liikkuta yhden ruudun eteenpain viistoon
			} else if ((loppu.annaSarake() == alku.annaSarake() + 1  || loppu.annaSarake() == alku.annaSarake() - 1) && loppu.annaRivi() <= alku.annaRivi() + 1 && loppu.annaRivi() > alku.annaRivi() && loppu.annaNappula() != null)  {
				if (loppu.annaRivi() == 7) {
					paadyssa(this.vari, loppu.annaSarake(), loppu.annaRivi());
				}
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Valittaa eteenpain tiedon sotilaaan paasemisesta laudan paatyyn
	 * @param v Pelaajan nappuloiden vari
	 * @param sarake Sotilaan sarake
	 * @param rivi Sotilaan rivi
	 */
	public void paadyssa(Varit v, int sarake, int rivi) {
		Shakki.naytaPromootioIkkuna(v, sarake, rivi);
	}
	
}

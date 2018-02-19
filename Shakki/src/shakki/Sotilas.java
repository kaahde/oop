package shakki;

import javax.swing.ImageIcon;

public class Sotilas extends Nappula {
	
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
	public boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu) {
		
		if (this.vari == Varit.VALKOINEN) {
			// Ensimmaisella siirrolla voi liikuttaa 1 tai 2 ruutua eteenpain
			if (loppu.annaSarake() == alku.annaSarake() && alku.annaRivi() == 6 && loppu.annaRivi() >= alku.annaRivi() - 2 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() == null) {
				return true;
			// Muilla siirroilla voi liikuttaa yhden ruudun eteenpain
			} else if (loppu.annaSarake() == alku.annaSarake() && loppu.annaRivi() >= alku.annaRivi() - 1 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() == null)  {
				return true;
			// Syodessa voi liikkuta yhden ruudun eteenpain viistoon
			} else if (loppu.annaSarake() == alku.annaSarake() + 1  || loppu.annaSarake() == alku.annaSarake() - 1 && loppu.annaRivi() >= alku.annaRivi() - 1 && loppu.annaRivi() < alku.annaRivi() && loppu.annaNappula() != null)  {
				return true;
			}
		} else if (this.vari == Varit.MUSTA) {
			if (loppu.annaRivi() == alku.annaRivi() && loppu.annaSarake() <= alku.annaSarake() + 1 && loppu.annaSarake() > alku.annaSarake())  {
				return true;
			}
		}
		
		return false;
	}
	
	
}

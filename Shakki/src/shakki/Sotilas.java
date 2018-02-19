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
}

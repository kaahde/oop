package shakki;

import javax.swing.ImageIcon;

public class Lahetti extends Nappula {
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
}

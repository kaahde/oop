package shakki;

import javax.swing.ImageIcon;

public class Torni extends Nappula {
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
}

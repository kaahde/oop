package shakki;

import javax.swing.ImageIcon;

public class Kuningatar extends Nappula {
	
	private final String nimi = "KUNINGATAR";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Kuningatar(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/kuningatar_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/kuningatar_v.png");
		}
	}
	
	@Override
	public String annaNimi() {
		return nimi;
	}

	@Override
	public boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu) {
		// TODO Auto-generated method stub
		return true;
	}
}

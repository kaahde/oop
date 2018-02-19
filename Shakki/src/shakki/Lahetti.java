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
		// TODO Auto-generated method stub
		return true;
	}
}

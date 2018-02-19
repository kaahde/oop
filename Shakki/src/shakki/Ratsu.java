package shakki;

import javax.swing.ImageIcon;

public class Ratsu extends Nappula {
	
	private final String nimi = "RATSU";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Ratsu(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/ratsu_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/ratsu_v.png");
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

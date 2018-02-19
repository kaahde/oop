package shakki;

import javax.swing.ImageIcon;

public class Kuningas extends Nappula {
	
	private final String nimi = "KUNINGAS";
	
	/**
	 * Konstruktori
	 * @param v Nappulan vari
	 */
	public Kuningas(Varit v) {
		super(v);
		if (v == Varit.MUSTA) {
			kuva = new ImageIcon("res/kuvat/kuningas_m.png");
		} else if ( v == Varit.VALKOINEN) {
			kuva = new ImageIcon("res/kuvat/kuningas_v.png");
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

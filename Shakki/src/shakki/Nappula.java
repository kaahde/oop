package shakki;

import javax.swing.ImageIcon;

/**
 * Shakkilaudan nappulaa mallintava luokka
 * @author Kadir
 */
public abstract class Nappula {
	
	protected Varit vari;
	protected ImageIcon kuva;
	protected int rivi;
	protected int sarake;
	
	/**
	 * Konstruktori
	 * @param vari Nappulan vari (Varit.MUSTA tai Varit.VALKOINEN)
	 */
	public Nappula(Varit vari) {
		this.vari = vari;
	}
	
	public abstract String annaNimi();

	public Varit annaVari() {
		return vari;
	}
	
	public ImageIcon annaKuva() {
		return kuva;
	}
	
	public abstract boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu);
}

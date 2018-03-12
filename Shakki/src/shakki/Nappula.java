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
	protected boolean ekaSiirto = true;
	
	/**
	 * Konstruktori
	 * @param vari Nappulan vari (Varit.MUSTA tai Varit.VALKOINEN)
	 */
	public Nappula(Varit vari) {
		this.vari = vari;
	}
	
	/**
	 * @return Nappulan nimi
	 */
	public abstract String annaNimi();

	
	/**
	 * @return Nappulan vari
	 */
	public Varit annaVari() {
		return vari;
	}
	
	/**
	 * @return Nappulan kuva
	 */
	public ImageIcon annaKuva() {
		return kuva;
	}
	
	/**
	 * Kertoo onko nappulan ensimmainen siirto tekematta
	 * @return Totuusarvo ensimmaisen siirrosta
	 */
	public boolean onkoEkaSiirto() {
		return ekaSiirto;
	}
	
	/**
	 * Merkitsee ensimmaisen siirron kaytetyksi
	 */
	public void ekaSiirtoOhi() {
		ekaSiirto = false;
	}
	
	/**
	 * Tarkistaa sallitaanko ehdotettu siirto
	 * @param alku Lahtoruutu
	 * @param loppu Kohderuutu
	 * @return Sallitaanko siirto
	 */
	public abstract boolean onkoSiirtoSallittu(Shakkiruutu alku, Shakkiruutu loppu);
}

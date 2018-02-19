package shakki;

import javax.swing.ImageIcon;

/**
 * Shakkilaudan nappulaa mallintava luokka
 * @author Kadir
 */
public class Nappula {
	private Nappulat nimi;
	private Varit vari;
	private ImageIcon kuva;
	
	/**
	 * Konstruktori, kuvat osoitteesta https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent
	 * @param nappula Nappulan nimi
	 * @param vari Nappulan vari
	 */
	public Nappula(Nappulat nappula, Varit vari) {
		if (nappula == Nappulat.SOTILAS && vari == Varit.MUSTA) {
			nimi = Nappulat.SOTILAS;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/sotilas_m.png");
		} else if (nappula == Nappulat.SOTILAS && vari == Varit.VALKOINEN) {
			nimi = Nappulat.SOTILAS;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/sotilas_v.png");
		} else if (nappula == Nappulat.TORNI && vari == Varit.MUSTA) {
			nimi = Nappulat.TORNI;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/torni_m.png");
		} else if (nappula == Nappulat.TORNI && vari == Varit.VALKOINEN) {
			nimi = Nappulat.TORNI;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/torni_v.png");
		} else if (nappula == Nappulat.RATSU && vari == Varit.MUSTA) {
			nimi = Nappulat.RATSU;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/ratsu_m.png");
		} else if (nappula == Nappulat.RATSU && vari == Varit.VALKOINEN) {
			nimi = Nappulat.RATSU;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/ratsu_v.png");
		} else if (nappula == Nappulat.LAHETTI && vari == Varit.MUSTA) {
			nimi = Nappulat.LAHETTI;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/lahetti_m.png");
		} else if (nappula == Nappulat.LAHETTI && vari == Varit.VALKOINEN) {
			nimi = Nappulat.LAHETTI;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/lahetti_v.png");
		} else if (nappula == Nappulat.KUNINGATAR && vari == Varit.MUSTA) {
			nimi = Nappulat.KUNINGATAR;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/kuningatar_m.png");
		} else if (nappula == Nappulat.KUNINGATAR && vari == Varit.VALKOINEN) {
			nimi = Nappulat.KUNINGATAR;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/kuningatar_v.png");
		} else if (nappula == Nappulat.KUNINGAS && vari == Varit.MUSTA) {
			nimi = Nappulat.KUNINGAS;
			this.vari = Varit.MUSTA;
			kuva = new ImageIcon("res/kuvat/kuningas_m.png");
		} else if (nappula == Nappulat.KUNINGAS && vari == Varit.VALKOINEN) {
			nimi = Nappulat.KUNINGAS;
			this.vari = Varit.VALKOINEN;
			kuva = new ImageIcon("res/kuvat/kuningas_v.png");
		} 
	}
	
	public Nappulat annaNimi() {
		return nimi;
	}
	
	public Varit annaVari() {
		return vari;
	}
	
	public ImageIcon annaKuva() {
		return kuva;
	}
}

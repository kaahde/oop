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
		
		// Normaali liikkuminen
		if (Math.abs(loppu.annaSarake()-alku.annaSarake()) <= 1 && Math.abs(loppu.annaRivi()-alku.annaRivi()) <= 1)  {
			return true;
		}
		
		// Linnoitus
		try {
			if (ekaSiirto && Math.abs(loppu.annaSarake() - alku.annaSarake()) == 2) {
				// Siirrytaan oikealle
				if (loppu.annaSarake() > alku.annaSarake()) {
					for (int i = 1; i <= 7 - alku.annaSarake(); i++) {
						// Ei onnistu, jos reitilla nappuloita
						if (i < 7 - alku.annaSarake() && Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).annaNappula() != null) {
							return false;
						// Rivin paassa pitaa olla oma torni, joka ei ole liikkunut
						} else if (i == 7 - alku.annaSarake() 
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).annaNappula().annaNimi() == "TORNI"
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).annaNappula().annaVari() == this.vari
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).annaNappula().onkoEkaSiirto()
								) 
						{	
							// Siirretaan tornia
							Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + 1).asetaNappula((Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).annaNappula()));
							Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() + i).asetaNappula(null);
							// Siirto onnistuu
							return true;
						}
					}
				} else {
					for (int i = 1; i <= alku.annaSarake(); i++) {
						if (i < alku.annaSarake() && Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).annaNappula() != null) {
							return false;
						} else if (i == alku.annaSarake() 
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).annaNappula().annaNimi() == "TORNI"
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).annaNappula().annaVari() == this.vari
								&& Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).annaNappula().onkoEkaSiirto()
								) 
						{
							Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - 1).asetaNappula((Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).annaNappula()));
							Shakki.annaRuudut().get(8 * alku.annaRivi() + alku.annaSarake() - i).asetaNappula(null);
							return true;
						}
					}
				}
				
				
				
				
				return false;
				
				
			}
		}
		catch (NullPointerException e) {
		}
		
		return false;
	}
}

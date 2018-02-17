package shakki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kadir
 *
 */
public class Shakkiruutu extends JButton {
	
	private int rivi;
	private int sarake;
	private Nappula nappula;
	private boolean valittu = false;
	private Color vari;
	
	/**
	 * Konstruktori shakkilaudan ruudulle
	 * @param rivi Ruudun rivi
	 * @param sarake Ruudun sarake
	 */
	public Shakkiruutu(int rivi, int sarake) {
		this.rivi = rivi;
		this.sarake = sarake;
		
		// Asettaa ruudun v�rin
		if (rivi % 2 == 1 && sarake % 2 == 0 || rivi % 2 == 0 && sarake % 2 == 1) {
			vari = Color.decode("#ba9e64");
			setBackground(vari);
		} else {
			vari = Color.decode("#efe5c2");
			setBackground(vari);
		}
		
		// Ruudun ulkon�k��n vaikuttavia asioita
		setSize(new Dimension(60, 60));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		// Nappuloiden siirt�minen
		int r = this.rivi;
		int s = this.sarake;
		
		addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (valittu == false && Shakki.valittujaNappuloita == 0) {
							valittu = true;
							Shakki.valittuRuutu = annaRuutu();
							Shakki.valittujaNappuloita = 1;
							Shakki.valittuNappula = nappula;
							setBackground(Color.GREEN);
						} else if (valittu == true && Shakki.valittujaNappuloita == 1){
							valittu = false;
							setBackground(vari);
							Shakki.valittujaNappuloita = 0;
							Shakki.valittuRuutu = null;
							Shakki.valittuNappula = null;
						} else if (valittu == false && Shakki.valittujaNappuloita == 1) {
							Shakki.annaRuudut().get(r * 8 + s).asetaNappula(Shakki.valittuNappula);
							Shakki.valittuRuutu.asetaNappula(null);
							Shakki.valittuRuutu.setBackground(Shakki.valittuRuutu.vari);
							
							Shakki.valittujaNappuloita = 0;
							Shakki.valittuNappula = null;
							Shakki.valittuRuutu = null;
							
							Shakki.paivitaRuudut();
						} 
						
					}
				}
		);
		
	}
	
	/**
	 * Palauttaa shakkilaudan ruudun rivin
	 * @return Rivi
	 */
	public int annaRivi() {
		return rivi;
	}
	
	/**
	 * Palauttaa shakkilaudan ruudun sarakkeen
	 * @return Sarake
	 */
	public int annaSarake() {
		return sarake;
	}
	
	
	/**
	 * Palauttaa ruudun nappulan
	 * @return Ruudussa oleva nappula
	 */
	public Nappula annaNappula() {
		return nappula;
	}
	
	/**
	 * Asettaa ruutuun nappulan
	 * @param n Uusi nappula
	 */
	public void asetaNappula(Nappula n) {
		nappula = n;
	}
	
	/**
	 * Palauttaa t�m�n shakkiruudun
	 * @return T�m� ruutu
	 */
	public Shakkiruutu annaRuutu() {
		return this;
	}
	
}

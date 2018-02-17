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
		
		// Asettaa ruudun värin
		if (rivi % 2 == 1 && sarake % 2 == 0 || rivi % 2 == 0 && sarake % 2 == 1) {
			vari = Color.decode("#ba9e64");
			setBackground(vari);
		} else {
			vari = Color.decode("#efe5c2");
			setBackground(vari);
		}
		
		// Ruudun ulkonäköön vaikuttavia asioita
		setSize(new Dimension(60, 60));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		// Nappuloiden siirtäminen
		int r = this.rivi;
		int s = this.sarake;
		
		addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// Valitaan uusi ruutu
						if (Shakki.valittuRuutu == null && Shakki.valittuNappula == null) {		
							if (nappula != null) {	
								valittu = true;
								Shakki.valittuRuutu = annaRuutu();
								Shakki.valittuNappula = nappula;
								setBackground(Color.GREEN);
							}
						} 
						// Klikataan jo valittua ruutua
						else if (valittu == true && Shakki.valittuRuutu != null){		
							valittu = false;
							setBackground(vari);
							Shakki.valittuRuutu = null;
							Shakki.valittuNappula = null;
						} 
						// Klikataan valitun ruudun jälkeen toista ruutua
						else if (valittu == false && Shakki.valittuRuutu != null && Shakki.valittuNappula != null) {
							try {
								// Nappulaa ei voi siirtää toisen oman nappulan päälle
								if (Shakki.valittuNappula.annaVari() != nappula.annaVari()) {
									Shakki.annaRuudut().get(r * 8 + s).asetaNappula(Shakki.valittuNappula);
									Shakki.valittuRuutu.asetaNappula(null);
									Shakki.valittuRuutu.setBackground(Shakki.valittuRuutu.vari);
									
									Shakki.valittuNappula = null;
									Shakki.valittuRuutu = null;
									
									Shakki.paivitaRuudut();
								}
								// Jos kohteena on tyhjä ruutu, siirtäminen onnistuu
							} catch (NullPointerException e) {
								Shakki.annaRuudut().get(r * 8 + s).asetaNappula(Shakki.valittuNappula);
								Shakki.valittuRuutu.asetaNappula(null);
								Shakki.valittuRuutu.setBackground(Shakki.valittuRuutu.vari);
								Shakki.valittuRuutu.valittu = false;
								
								Shakki.valittuNappula = null;
								Shakki.valittuRuutu = null;
								
								Shakki.paivitaRuudut();
							}
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
	 * Palauttaa tämän shakkiruudun
	 * @return Tämä ruutu
	 */
	public Shakkiruutu annaRuutu() {
		return this;
	}
	
}

package shakki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shakkilaudan yksittaista ruutua kuvaava luokka
 * @author Kadir
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
	public Shakkiruutu (int rivi, int sarake) {
		this.rivi = rivi;
		this.sarake = sarake;
		
		// Asettaa ruudun varin
		if (rivi % 2 == 1 && sarake % 2 == 0 || rivi % 2 == 0 && sarake % 2 == 1) {
			vari = Color.decode("#ba9e64");
			setBackground(vari);
		} else {
			vari = Color.decode("#efe5c2");
			setBackground(vari);
		}
		
		// Ruudun ulkonakoon vaikuttavia asioita
		setSize(new Dimension(60, 60));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		// Nappuloiden siirtaminen
		int r = this.rivi;
		int s = this.sarake;
		
		addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// Valitaan uusi ruutu
						if (Shakki.annaValittuRuutu() == null && Shakki.annaValittuNappula() == null) {		
							if (nappula != null) {	
								valittu = true;
								Shakki.asetaValittuRuutu(annaRuutu());
								Shakki.asetaValittuNappula(nappula);
								setBackground(Color.GREEN);
							}
						} 
						// Klikataan jo valittua ruutua
						else if (valittu == true && Shakki.annaValittuRuutu() != null){		
							valittu = false;
							setBackground(vari);
							Shakki.asetaValittuRuutu(null);
							Shakki.asetaValittuNappula(null);
						} 
						// Klikataan valitun ruudun jalkeen toista ruutua
						else if (valittu == false && Shakki.annaValittuRuutu() != null && Shakki.annaValittuNappula() != null) {
							if (Shakki.annaValittuNappula().onkoSiirtoSallittu(Shakki.annaValittuRuutu(),	 annaRuutu())) {
								try {
									// Nappulaa ei voi siirtaa toisen oman nappulan paalle
									if (Shakki.annaValittuNappula().annaVari() != nappula.annaVari()) {
										Shakki.annaRuudut().get(r * 8 + s).asetaNappula(Shakki.annaValittuNappula());
										Shakki.annaValittuRuutu().asetaNappula(null);
										Shakki.annaValittuRuutu().setBackground(Shakki.annaValittuRuutu().vari);
										Shakki.annaValittuRuutu().valittu = false;
										
										Shakki.asetaValittuNappula(null);
										Shakki.asetaValittuRuutu(null);
										
										Shakki.paivitaRuudut();
									}
									// Jos kohteena on tyhja ruutu, siirtaminen onnistuu
								} catch (NullPointerException e) {
									Shakki.annaRuudut().get(r * 8 + s).asetaNappula(Shakki.annaValittuNappula());
									Shakki.annaValittuRuutu().asetaNappula(null);
									Shakki.annaValittuRuutu().setBackground(Shakki.annaValittuRuutu().vari);
									Shakki.annaValittuRuutu().valittu = false;
									
									Shakki.asetaValittuNappula(null);
									Shakki.asetaValittuRuutu(null);
									
									Shakki.paivitaRuudut();
								}
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
	 * Palauttaa taman shakkiruudun
	 * @return Tama ruutu
	 */
	public Shakkiruutu annaRuutu() {
		return this;
	}
	
}

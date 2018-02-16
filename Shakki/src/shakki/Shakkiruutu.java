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
	public Shakkiruutu(int rivi, int sarake, Nappula nappula) {
		this.rivi = rivi;
		this.sarake = sarake;
		this.nappula = nappula;
		
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
		
		
		addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (valittu == false && Shakki.valittujaNappuloita <= 1) {
							valittu = true;
							Shakki.valittujaNappuloita++;
							Shakki.valittuNappula = nappula;
							setBackground(Color.GREEN);
						} else {
							valittu = false;
							setBackground(vari);
							Shakki.valittujaNappuloita--;
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
	
}

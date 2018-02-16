package shakki;

import javax.swing.*;
import java.awt.*;


/**
 * @author Kadir
 *
 */
public class Shakki extends JFrame {

	private JButton ruutu;
	public static int valittujaNappuloita = 0;
	public static Nappula valittuNappula;
	
	/**
	 * Konstruktori
	 */
	public Shakki() {
		luoUI();
		
		setTitle("Shakki");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(540, 540);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Luo käyttöliittymän
	 */
	private void luoUI() {
		JPanel paneeli = new JPanel();
		getContentPane().add(paneeli);
		paneeli.setLayout(new GridLayout(8, 8));
		
		// Luo shakkilaudan ruudukon
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				// Luo nappulat
				Nappula nappula = null;
				if (i == 1) {
					nappula = new Nappula(Nappulat.SOTILAS, Varit.MUSTA);
				} else if (i == 6) {
					nappula = new Nappula(Nappulat.SOTILAS, Varit.VALKOINEN);
				} else if (i == 0 && j == 0 || i == 0 && j == 7) {
					nappula = new Nappula(Nappulat.TORNI, Varit.MUSTA);
				} else if (i == 7 && j == 0 || i == 7 && j == 7) {
					nappula = new Nappula(Nappulat.TORNI, Varit.VALKOINEN);
				} else if (i == 0 && j == 1 || i == 0 && j == 6) {
					nappula = new Nappula(Nappulat.RATSU, Varit.MUSTA);
				} else if (i == 7 && j == 1 || i == 7 && j == 6) {
					nappula = new Nappula(Nappulat.RATSU, Varit.VALKOINEN);
				} else if (i == 0 && j == 2 || i == 0 && j == 5) {
					nappula = new Nappula(Nappulat.LAHETTI, Varit.MUSTA);
				} else if (i == 7 && j == 2 || i == 7 && j == 5) {
					nappula = new Nappula(Nappulat.LAHETTI, Varit.VALKOINEN);
				} else if (i == 0 && j == 4) {
					nappula = new Nappula(Nappulat.KUNINGATAR, Varit.MUSTA);
				} else if (i == 7 && j == 3) {
					nappula = new Nappula(Nappulat.KUNINGATAR, Varit.VALKOINEN);
				} else if (i == 0 && j == 3) {
					nappula = new Nappula(Nappulat.KUNINGAS, Varit.MUSTA);
				} else if (i == 7 && j == 4) {
					nappula = new Nappula(Nappulat.KUNINGAS, Varit.VALKOINEN);
				} 
				
				// Luo shakkilaudan ruudun
				ruutu = new Shakkiruutu(i, j, nappula);
				
				
				
				// Lisää nappulat ruudukkoon
				try {
					ruutu.setIcon(nappula.annaKuva());
				} catch (Exception e) {
					ruutu.setText("");
				}
				ruutu.setHorizontalAlignment(SwingConstants.CENTER);
				ruutu.setVerticalAlignment(SwingConstants.CENTER);
				
				// Muuttaa ruudun taustavärin näkyväksi ja lisää ruudun paneeliin
				ruutu.setOpaque(true);
				paneeli.add(ruutu);
			}
		}
	}
	
	
	public void pelaaVuoro() {
		
	}
	
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Shakki().setVisible(true);
			}
		});
	}

}

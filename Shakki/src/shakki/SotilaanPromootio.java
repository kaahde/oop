package shakki;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SotilaanPromootio extends JPanel {
	private int sarake;
	private int rivi;
	private Varit sotilaanVari;
	
	private JButton kuningatar;
	private JButton lahetti;
	private JButton ratsu;
	private JButton torni;	
	
	
	/**
	 * @param vari Nappulan vari
	 */
	public SotilaanPromootio() {
		
		// Paneelin asettelu
		setLayout(new GridLayout(5, 1));
		
		// Alustetaan tekstikentta ja painikkeet
		JTextArea teksti = new JTextArea("Valitse nappula:");
		teksti.setBackground(null);
		teksti.setHighlighter(null);
		kuningatar = new JButton(new ImageIcon("res/kuvat/kuningatar_m.png"));
		lahetti = new JButton(new ImageIcon("res/kuvat/lahetti_m.png"));
		ratsu = new JButton(new ImageIcon("res/kuvat/ratsu_m.png"));
		torni = new JButton(new ImageIcon("res/kuvat/torni_m.png"));
		
		
		// Lisataan painikkeiden toiminnalisuudet
		kuningatar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Shakki.annaRuudut().get(rivi * 8 + sarake).asetaNappula(new Kuningatar(sotilaanVari));
				Shakki.paivitaRuudut();
				Shakki.piilotaPromootioIkkuna();
			}
		});
		lahetti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Shakki.annaRuudut().get(rivi * 8 + sarake).asetaNappula(new Lahetti(sotilaanVari));
				Shakki.paivitaRuudut();
				Shakki.piilotaPromootioIkkuna();
			}
		});
		ratsu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Shakki.annaRuudut().get(rivi * 8 + sarake).asetaNappula(new Ratsu(sotilaanVari));
				Shakki.paivitaRuudut();
				Shakki.piilotaPromootioIkkuna();
			}
		});
		torni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Shakki.annaRuudut().get(rivi * 8 + sarake).asetaNappula(new Torni(sotilaanVari));
				Shakki.paivitaRuudut();
				Shakki.piilotaPromootioIkkuna();
			}
		});
		
		// Lisataan painikkeet paneeliin
		add(teksti);
		add(kuningatar);
		add(lahetti);
		add(ratsu);
		add(torni);
	}
	
	/**
	 * @param vari
	 * @param sarake
	 * @param rivi
	 */
	public void paivitaTiedot(Varit vari, int sarake, int rivi) {
		this.sotilaanVari = vari;
		this.sarake = sarake;
		this.rivi = rivi;
		
		// Painikkeiden kuvakkeet sotilaan varin mukaan
		if (vari == Varit.MUSTA) {	
			kuningatar.setIcon(new ImageIcon("res/kuvat/kuningatar_m.png"));
			lahetti.setIcon(new ImageIcon("res/kuvat/lahetti_m.png"));
			ratsu.setIcon(new ImageIcon("res/kuvat/ratsu_m.png"));
			torni.setIcon(new ImageIcon("res/kuvat/torni_m.png"));
			
		} else {
			kuningatar.setIcon(new ImageIcon("res/kuvat/kuningatar_v.png"));
			lahetti.setIcon(new ImageIcon("res/kuvat/lahetti_v.png"));
			ratsu.setIcon(new ImageIcon("res/kuvat/ratsu_v.png"));
			torni.setIcon(new ImageIcon("res/kuvat/torni_v.png"));
		}
	}
	
	
}

package shakki;

import java.awt.Dimension;

import javax.swing.JTextArea;

public class Infolaatikko extends JTextArea {

	public Infolaatikko(String s) {
		super(s);
		
		setHighlighter(null);
		setBackground(null);
	}
	
	public void paivita() {
		if (Shakki.onkoValkoisenVuoro()) {
			setText("Valkoisen vuoro");
		} else {
			setText("Mustan vuoro");
		}
	}
}

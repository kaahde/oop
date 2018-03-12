package shakki;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.text.StyleConstants.FontConstants;

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
	
	public void voitaPeli() {
		if (Shakki.onkoValkoisenVuoro()) {
			setText("Valkoinen voitti pelin!");
		} else {
			setText("Musta voitti pelin!");
		}
	}
}

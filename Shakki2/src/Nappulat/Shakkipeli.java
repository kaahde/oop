package Nappulat;
import java.util.HashMap;

public class Shakkipeli {
	public static void main(String args[]) {
		HashMap<Integer, Nappula> plauta = new HashMap<Integer, Nappula>();
		Pelaaja valkoinen = new Pelaaja("valkoinen", "musta");
		Pelaaja musta = new Pelaaja("musta", "valkoinen");
		Pelaaja eioo = new Pelaaja("eioo", "ooei");

		// Valkoisen nappulat
		// sotilaat
		Nappula s01 = new Sotilas(1, valkoinen, plauta);
		Nappula s11 = new Sotilas(11, valkoinen, plauta);
		Nappula s21 = new Sotilas(21, valkoinen, plauta);
		Nappula s31 = new Sotilas(31, valkoinen, plauta);
		Nappula s41 = new Sotilas(41, valkoinen, plauta);
		Nappula s51 = new Sotilas(51, valkoinen, plauta);
		Nappula s61 = new Sotilas(61, valkoinen, plauta);
		Nappula s71 = new Sotilas(71, valkoinen, plauta);
		// tornit, ratsut, lähetit
		Nappula s00 = new Torni(0, valkoinen, plauta);
		Nappula s70 = new Torni(70, valkoinen, plauta);
		Nappula s10 = new Ratsu(10, valkoinen, plauta);
		Nappula s60 = new Ratsu(60, valkoinen, plauta);
		Nappula s20 = new Lahetti(20, valkoinen, plauta);
		Nappula s50 = new Lahetti(50, valkoinen, plauta);
		// kuningas ja kuningatar
		Nappula s30 = new Kuningatar(30, valkoinen, plauta);
		Nappula s40 = new Kuningas(40, valkoinen, plauta);

		// Mustan nappulat
		// sotilaat
		Nappula s06 = new Sotilas(6, musta, plauta);
		Nappula s16 = new Sotilas(16, musta, plauta);
		Nappula s26 = new Sotilas(26, musta, plauta);
		Nappula s36 = new Sotilas(36, musta, plauta);
		Nappula s46 = new Sotilas(46, musta, plauta);
		Nappula s56 = new Sotilas(56, musta, plauta);
		Nappula s66 = new Sotilas(66, musta, plauta);
		Nappula s76 = new Sotilas(76, musta, plauta);
		// tornit, ratsut, lähetit
		Nappula s07 = new Torni(7, musta, plauta);
		Nappula s77 = new Torni(77, musta, plauta);
		Nappula s17 = new Ratsu(17, musta, plauta);
		Nappula s67 = new Ratsu(67, musta, plauta);
		Nappula s27 = new Lahetti(27, musta, plauta);
		Nappula s57 = new Lahetti(57, musta, plauta);
		// kuningas ja kuningatar
		Nappula s47 = new Kuningatar(47, musta, plauta);
		Nappula s37 = new Kuningas(37, musta, plauta);

		// "NOLLA" -nappula
		Nappula tyhja = new Tyhja(3, eioo, plauta);
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				asetaNappula((i * 10) + j, tyhja, plauta);
			}
		}

		// Valkoisen nappulat
		// sotilaat
		asetaNappula(01, s01, plauta);
		asetaNappula(11, s11, plauta);
		asetaNappula(21, s21, plauta);
		asetaNappula(31, s31, plauta);
		asetaNappula(41, s41, plauta);
		asetaNappula(51, s51, plauta);
		asetaNappula(61, s61, plauta);
		asetaNappula(71, s71, plauta);
		// tornit, ratsut, lähetit
		asetaNappula(0, s00, plauta);
		asetaNappula(70, s70, plauta);
		asetaNappula(10, s10, plauta);
		asetaNappula(60, s60, plauta);
		asetaNappula(20, s20, plauta);
		asetaNappula(50, s50, plauta);
		// kuningas ja kuningatar
		asetaNappula(30, s30, plauta);
		asetaNappula(40, s40, plauta);

		// Mustan nappulat
		// sotilaat
		asetaNappula(6, s06, plauta);
		asetaNappula(16, s16, plauta);
		asetaNappula(26, s26, plauta);
		asetaNappula(36, s36, plauta);
		asetaNappula(46, s46, plauta);
		asetaNappula(56, s56, plauta);
		asetaNappula(66, s66, plauta);
		asetaNappula(76, s76, plauta);
		// tornit, ratsut, lähetit
		asetaNappula(7, s07, plauta);
		asetaNappula(77, s77, plauta);
		asetaNappula(17, s17, plauta);
		asetaNappula(67, s67, plauta);
		asetaNappula(27, s27, plauta);
		asetaNappula(57, s57, plauta);
		// kuningas ja kuningatar
		asetaNappula(47, s47, plauta);
		asetaNappula(37, s37, plauta);

		// Tulostaa nappulat laudalta
		// System.out.println(plauta);
		
		//Siirtoja:
		s10.liiku(2);
		s10.liiku(21);
		s10.liiku(14);
		s10.liiku(26);
		s10.liiku(45);
		s10.liiku(37);

		System.out.println("WUHUU!!");
	}

	// Tästä alkaa vanha Pelilauta-luokka:

	// exception jos ei nappulaa
	public static Nappula annaNappula(int p, HashMap<Integer, Nappula> plauta) {
		if (plauta.containsKey(p)) {
			return plauta.get(p);

		} else {
			return plauta.get(-1);
		}
	}

	public static void asetaNappula(int sij, Nappula n, HashMap<Integer, Nappula> plauta) {
		plauta.put(sij, n);
		n.asetaSijainti(sij);
	}

	public static void siirraNappula(int sij, Nappula n, HashMap<Integer, Nappula> plauta) {
		int uudenTyhjanSij = n.annaSijainti();
		plauta.put(sij, n);
		n.asetaSijainti(sij);
		Pelaaja eioo = new Pelaaja("eioo", "ooei");
		Nappula tyhja = new Tyhja(uudenTyhjanSij, eioo, plauta);

		plauta.put(uudenTyhjanSij, tyhja);
	}

	public static String annaPositio(int s) {
		String a = "abcdefgh";
		// System.out.println(s);
		return Character.toString(a.charAt(s / 10)) + String.valueOf(s % 10 + 1);
	}

	public static void tulostaNappula(Nappula n) {
		System.out.println(n.annaTyyppi());
	}
}
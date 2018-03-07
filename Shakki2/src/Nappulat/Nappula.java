package Nappulat;
import java.util.HashMap;

public abstract class Nappula{

  protected int sijainti;
  protected String tyyppi;
  protected Pelaaja pelaaja;
  protected HashMap<Integer, Nappula> pelilauta;
  
  //KONSTRUKTORI
  public Nappula(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> pelilauta2){
    this.sijainti = sijainti;
    this.pelaaja = pelaaja;
    this.pelilauta = pelilauta2;
  }
  
  public String annaPelaajanTiimi(){
    return this.pelaaja.annaTiimi();
  }
   public String annaVihollinen() {
	   return this.pelaaja.annaVihollinen();
   }
  
  public abstract String annaTyyppi();
  public abstract String annaTyypinGen();
  public abstract boolean liiku(int sij);

  public int annaSijainti(){
    return sijainti;
  }
  
  public void asetaSijainti(int s){
    this.sijainti = s;
  }

}

      

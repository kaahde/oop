package Nappulat;
import java.util.HashMap;

class Tyhja extends Nappula{
  private final String tyyppi = "tyhj‰";
  //private static final int[] siirrot = {0};
  
  //KONSTRUKTORI
  public Tyhja(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> plauta){
	  super(sijainti, pelaaja, plauta);
  }
  
  public String annaTyypinGen(){
    return "tyhj‰n";
  }
  
  public String annaTyyppi(){
    return tyyppi;
  }
  
  public boolean liiku(int sij){
    System.out.println("Ei tyhj‰‰ voi liikuttaa!!");
    return false;
  }
}//Luokka
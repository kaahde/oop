package Nappulat;
import java.util.HashMap;

class Lahetti extends Nappula{
  private final String tyyppi = "lähetti";
  
  private static final int[] siirrot = {11,22,33,44,55,66,77,9,18,27,36,45,54,63,
		  -9,-18,-27,-36,-45,-54,-63,-11,-22,-33,-44,-55,-66,-77};
  
  //KONSTRUKTORI
  public Lahetti(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> pelilauta){
    super(sijainti,pelaaja,pelilauta);
  }
  
  public String annaTyypinGen(){
    return "lähetin";
  }
  
  public String annaTyyppi(){
    return tyyppi;
  }
  
  public void asetaSijainti(int s){
    this.sijainti = s;
  }
  
  public boolean liiku(int uusi){
	  
	  //Onko määränpää laudalla?
	if(uusi >= -70 && uusi <= 70) {
      boolean voiko = false;
      
   // Onko siirto sallittu kys. nappulalle
      for(int i = 0; i < siirrot.length; i++){                      
        if(Lahetti.siirrot[i] - (uusi - this.sijainti) == 0){         
          voiko = true;
        }
      }
      if(voiko == false){
        System.out.println("Ei ole laillinen siirto!!");
        return false;
      }
    }
    else{
      System.out.println("Et voi liikkua laudan ulkopuolelle!!");
      return false;
    }
    
    int etappi = uusi; //Välietapin sijainti
    int x = 0;         //Yksi askel
    
  //Määrittää askeleen pituuden ja suunnan/ylösalas vai oikeevasen ja miinusta vai plussaa
    if(uusi % 11 == 0){               
      if(uusi < 0){
        x=-9;
      }
      else{
        x=9;
      }
    }
    else{ 
      if(uusi < 0){
        x=-11;
      }
      else{
        x=11;
      }
    }
    
  //Onko välietappien ruuduissa nappuloita?
    while(etappi != 0 && etappi != this.sijainti){  
	   	if(Shakkipeli.annaNappula(etappi, pelilauta).annaPelaajanTiimi() != "eioo" && etappi != uusi){  
    		System.out.println("Lähetti ei voi liikkua muiden nappuloiden yli!!");                        
    		return false;
    	}
    	else{
    		etappi= etappi - x;
    	}
    }
    
  //Onko määränpää tyhjä?
    if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == "eioo"){                          
    	//System.out.println(sijainti);
		System.out.println("Liikutit lähetin ruudusta " + Shakkipeli.annaPositio(sijainti) +
				" ruutuun " + Shakkipeli.annaPositio(uusi));
		Shakkipeli.siirraNappula(uusi, this, pelilauta);
		return true;
    }

  //Onko pelaajan oma nappula?
    if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi().equals(
    		Shakkipeli.annaNappula(sijainti, pelilauta).annaPelaajanTiimi())){     
    	
    	System.out.println(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() +
    			Shakkipeli.annaNappula(sijainti, pelilauta).annaPelaajanTiimi());
    	System.out.println("Et voi liikkua oman nappulasi päälle!!");
    	return false;
    }
    
  //Onko vihollisen kuningas?
    else if(Shakkipeli.annaNappula(uusi, pelilauta).annaTyyppi() == "kuningas"){                 
    	System.out.println("VOITIT PELIN!!");
    	return false;
    }
    
  //Jäljelle jää: vihollinen, mutta ei kuningas
    else{                       
      System.out.println("Söit vastustajan " + Shakkipeli.annaNappula(uusi, pelilauta).annaTyypinGen() + "!!");
      Shakkipeli.siirraNappula(uusi, this, pelilauta);
      return true;
    }
  }//Metodi
}//Luokka

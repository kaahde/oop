package Nappulat;
import java.util.HashMap;
import java.util.stream.IntStream;

//Eik� mahdollisuutta korottaa nappulaa vihollisen p��dyss�
//Eik� estoa suoraan sy�miselle
//tai vaihtoa

class Sotilas extends Nappula{
  private final String tyyppi = "sotilas"; //Sotilas
  private final int alkuperainenSij = sijainti;
//Kaikki numerot riippuu vaan siit� mill� j�rjestyksell� pelilauta teh��n
  private static final int[] siirrotV = {1,11,-9,2};
  private static final int[] siirrotM = {-1,-11,9,-2};
  
  //KONSTRUKTORI
  public Sotilas(int sijainti, Pelaaja pelaaja, HashMap<Integer, Nappula> pelilauta){
    super(sijainti,pelaaja,pelilauta);
  }
  
  public String annaTyypinGen(){
    return "sotilaan";
  }
  
  public String annaTyyppi(){
    return tyyppi;
  }
  
  public void asetaSijainti(int s) {
	  this.sijainti = s;
  }
  
  public boolean liiku(int uusi){
	  
	//Onko m��r�np�� laudalla?
    if(uusi >= -70 && uusi < 70){
	  boolean voiko = false;
	  
	  // Onko siirto sallittu kys. nappulalle
      for(int i = 0; i < 4; i++){                     
        if((Sotilas.siirrotV[i] - (uusi- this.sijainti) == 0 && this.annaPelaajanTiimi() == "valkoinen" ) ||
        		(Sotilas.siirrotM[i] - (uusi - this.sijainti) == 0 && this.annaPelaajanTiimi() == "musta" )){
        	voiko = true;
        }
      }
      if(voiko == false){
        System.out.println("Ei ole laillinen siirto!!");
        return false;
      }
    }
    else{
    	System.out.println("Et voi liikkua laudan ulkopuolelle");
    	return false;
    }
    
    //P��dyttiink� vihollisen p��tyyn?
    int[] valkosenPaaty = {0,10,20,30,40,50,60,70};
    int[] mustanPaaty = {7,17,27,37,47,57,67,77};
    boolean vPaaty = IntStream.of(valkosenPaaty).anyMatch(alkio -> alkio == uusi);
    boolean mPaaty = IntStream.of(mustanPaaty).anyMatch(alkio -> alkio == uusi);
    if((this.annaPelaajanTiimi() == "valkoinen" && mPaaty == true) || (this.annaPelaajanTiimi() == "musta" && vPaaty == true)) {
    	if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == this.annaVihollinen() && 
    			Shakkipeli.annaNappula(uusi, pelilauta).annaTyyppi() == "kuningas") {
    		System.out.println("Voitit pelin!!");
    		return true;
    	}
    	else if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == this.annaVihollinen()){
    		System.out.println("S�it vihollisen " + Shakkipeli.annaNappula(uusi, pelilauta).annaTyypinGen() + "!!");
    		System.out.println("Sait sotilaan vastustajan p��tyyn, mihin haluat korottaa?");
    		return true;
    	}
    	else if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == "eioo") {
    		System.out.println("Liikutit sotilaan ruudusta " + Shakkipeli.annaPositio(sijainti) +
    				" ruutuun " + Shakkipeli.annaPositio(uusi));
    		System.out.println("Sait sotilaan vastustajan p��tyyn, mihin haluat korottaa?");
    		return true;
    	}
	}
    
    //M��ritt�� askeleen suunnan/yl�s vai alas
    if((uusi - sijainti == 2 || uusi - sijainti == -2) && sijainti == alkuperainenSij){              
        int x;
    	if(uusi - sijainti == 2){
          x = -1;
        }
        else{
          x = 1;
        }
    	
    //Onko matkanvarrella nappula?
    	if(Shakkipeli.annaNappula(uusi - sijainti - x, pelilauta).annaPelaajanTiimi() != "eioo"){  
    		System.out.println("Sotilas ei voi liikkua muiden nappuloiden yli!!");        
    		return false;
    	}
    }
    else if((uusi - sijainti == 2 || uusi - sijainti == -2) && sijainti != alkuperainenSij) {
    	System.out.println("Voit liikkua kaksi ruutua eteenp�in vain sotilaan ensimm�isell� siirrolla!!");
    	return false;
    }
    
  //Onko m��r�np�� tyhj�?
    if(Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi() == "eioo" && (uusi - sijainti == -1 ||  uusi - sijainti ==  1)){
		System.out.println("Liikutit sotilaan ruudusta " + Shakkipeli.annaPositio(sijainti) +
				" ruutuun " + Shakkipeli.annaPositio(uusi));
		Shakkipeli.siirraNappula(uusi, this, pelilauta);
		return true;
    }
    
    //Onko pelaajan oma nappula?
    if((Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi().equals("valkoinen") || 
    		Shakkipeli.annaNappula(uusi, pelilauta).annaPelaajanTiimi().equals("musta")) &&
    		(uusi - sijainti == -1 ||  uusi - sijainti ==  1)){
    	   	System.out.println("Sotilas voi sy�d� muita nappuloita vain vinoon!!");
    	return false;
    }
    
  //Onko vihollisen kuningas?
    else if (Shakkipeli.annaNappula(uusi, pelilauta).annaTyyppi() == "kuningas") {
		System.out.println("VOITIT PELIN!!");
		return false;
	}
    
  //J�ljelle j��: vihollinen, mutta ei kuningas
    else if(uusi - sijainti == -9 ||  uusi - sijainti ==  11 || uusi - sijainti == 9 ||  uusi - sijainti ==  -11) {             
      System.out.println("S�it vastustajan " + Shakkipeli.annaNappula(uusi, pelilauta).annaTyypinGen() + "!!");
      Shakkipeli.siirraNappula(uusi, this, pelilauta);
      return true;
    }
    
    else {
    	System.out.println("Sotilas kusi, n�in ei pit�isi k�yd�!!");
    	return false;
    }
  }//Metodi
}//Luokka
	
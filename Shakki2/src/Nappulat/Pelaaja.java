package Nappulat;
public class Pelaaja{

  private String tiimi = "";//valkoinen tai musta tai eioo
  private String vihollinen  = "";
  
  public Pelaaja(String t, String v){
    this.tiimi = t;
    this.vihollinen = v;
  }
  
  public String annaTiimi(){
    return tiimi;
  }
  
  public String annaVihollinen() {
	  return vihollinen;
  }
}
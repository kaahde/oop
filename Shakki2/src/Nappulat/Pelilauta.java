package Nappulat;
import java.util.HashMap;
public class Pelilauta{
  private static final Nappula tyhja = null;
HashMap<Integer,Nappula> pelilauta = new HashMap<Integer,Nappula>();
    
  public Pelilauta(){
    //HashMap<Integer,Nappula> pelilauta = new HashMap<Integer,Nappula>();
  }
  
  //exception jos ei nappulaa
  public Nappula annaNappula(int p){
    if(pelilauta.containsKey(p)){
      return pelilauta.get(p);
    }
    else{
      return pelilauta.get(-1);
    }     
  }
  
  public void asetaNappula(int sij, Nappula n){
    pelilauta.put(sij,n);
    pelilauta.put(n.annaSijainti(), tyhja);
    n.asetaSijainti(sij);
  }
  
  public String annaPositio(int s){
    String a = "abcdefh";
    return a.charAt(s/10) + String.valueOf(s % 10+1);
  }
  
  
}

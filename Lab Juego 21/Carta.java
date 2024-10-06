

public class Carta
{
   private String valores;
   private String palo;
   
   //setters
   public void setValores(String valores){
       this.valores = valores;
   }
   
   public void setPalos(String palos){
       this.palo = palos;
   }
   //getters
   public String getValores(){
       return valores;
   }
   
   public String getPalo(){
       return palo;
   }
   
   public Carta(String valores, String palos){
       this.valores = valores;
       this.palo = palos;
   }
   
}

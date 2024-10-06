
public class Mazo
{
    private Carta[] mazo;

    public void setMazo(Carta[] mazo){
        this.mazo = mazo;
    }

    public Carta[] getMazo(){
        return mazo;
    }

    //constructor que recibirá un array de la clase mazo(valores y palos)
    public Mazo(Carta[] mazo){
        this.mazo = mazo;
    }
    
    
    public void crearMazo(){
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] palo ={"corazones","picas","diamantes","trébol"};
        this.mazo = new Carta[52];
        for(int i=0; i < palo.length; i++){
            for(int j = 0; j < valores.length; j++){
                this.mazo[(i*13)+(j)] = new Carta(valores[j], palo[i]);
            }
        }
    }

    
    
}


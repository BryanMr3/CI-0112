
public class Robot
{
    //variables
    private String nombre;
    private int puntosVida;
    private int ataque;

    //constructor
    public Robot(String nombre, int puntosVida, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
    }

    //setters
    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public void setpuntosVida(int puntosVida){
        this.puntosVida = puntosVida;
    }

    public void setataque(int ataque){
        this.ataque = ataque;
    }

    //getters
    public String getnombre(){
        return nombre;
    }

    public int getpuntosVida(){
        return puntosVida;
    }

    public int getataque(){
        return ataque;
    }

    //Metodos
    public void atacar(Robot otroRobot){
        int daño = this.ataque;
        otroRobot.puntosVida -= ataque;
    }

    public boolean estaVivo(){
        return puntosVida > 0;
    }

    
}

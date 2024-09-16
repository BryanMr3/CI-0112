
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
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida){
        this.puntosVida = puntosVida;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    //getters
    public String getNombre(){
        return this.nombre;
    }

    public int getPuntosVida(){
        return this.puntosVida;
    }

    public int getAtaque(){
        return this.ataque;
    }

    //Metodos
    public void atacar(Robot otroRobot){
        int daño = this.ataque;
        otroRobot.setPuntosVida(otroRobot.getPuntosVida() - daño);
    }

    public boolean estaVivo(){
        return puntosVida > 0;
    }

    
}

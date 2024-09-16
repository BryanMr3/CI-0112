import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla{

    private Robot ganador;
    
    public void iniciarBatalla(){
        //Establecer el tamaño máximo del array
        
        Robot[] arrayRobots = new Robot[10];

        Scanner scanner = new Scanner(System.in);
        //establecer la cantidad de robots se quieren crear
        System.out.println("¿Cuántos robots desea crear?");
        int cantidadRobots = scanner.nextInt();
        while(cantidadRobots <= 1 || cantidadRobots > 10){
            System.out.println("Ingrese un mínimo de 2 robots y un máximo de 10");
            System.out.println("");
            System.out.println("¿Cuántos robots desea crear?");
            cantidadRobots = scanner.nextInt();
        }
        System.out.println("");
        scanner.nextLine(); 

        //para solicitar los atributos de cada robot y almacenarlos en cada posición del array, hasta un máximo de 10 robots
        for(int i = 0; i < cantidadRobots; i++){
            System.out.println("Ingrese el nombre del robot " + (i+1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese los puntos de vida del robot " +(i+1) +"(entre 50 y 100): ");

            int puntosVida = scanner.nextInt();
            while(puntosVida < 50 || puntosVida > 100){
                System.out.println("Ingrese un valor entre 50 y 100");
                puntosVida = scanner.nextInt();
            }

            System.out.println("Ingrese el daño del robot " + (i+1) + "(entre 10 y 20): ");
            int ataque = scanner.nextInt();
            while(ataque < 10 || ataque > 20){
                System.out.println("Ingrese un valor entre 10 y 20");
                ataque = scanner.nextInt();
            }

            scanner.nextLine();

            arrayRobots[i]= new Robot(nombre, puntosVida, ataque);

            System.out.println("");
        }

        System.out.println("Los robots han sido creados");
        System.out.println("Por favor, presione ENTER para comenzar el juego");
        scanner.nextLine();

        ganador = new Robot("variable para ganador", 0, 0);

        while(cantidadRobots > 1){

            //seleccionar al robot  que ataca, de manera aleatoria
            int indAtacante= (int)(Math.random() * (cantidadRobots));
            Robot robotAtaca = arrayRobots[indAtacante];

            //seleccionar el primer robot que se atacará, de manera aleatoria
            int indDefensor;
            do{
                indDefensor= (int)(Math.random() * (cantidadRobots) );
            }while(indAtacante == indDefensor || !arrayRobots[indDefensor].estaVivo());
            Robot robotDefensor = arrayRobots[indDefensor];

            if(robotAtaca.estaVivo()){
                robotAtaca.atacar(robotDefensor);
                System.out.println(robotAtaca.getNombre() + " ha hecho " + robotAtaca.getAtaque() +" de daño a " + robotDefensor.getNombre()
                    +". Su vida actual es:"  + robotDefensor.getPuntosVida());

                if(!robotDefensor.estaVivo()){

                    System.out.println(robotDefensor.getNombre() + "ha sido destruido");

                    for(int i = indDefensor; i < cantidadRobots - 1; i++){
                        arrayRobots[i] = arrayRobots[i+1];
                    }
                    cantidadRobots--;

                    if(indAtacante < cantidadRobots){
                        indAtacante--;
                    }
                }

            }
            System.out.println("Presione ENTER para continuar a la siguiente ronda...");
            scanner.nextLine(); // Espera la entrada del usuario
        }
        ganador = arrayRobots[0];
        mostrarGanador();
        
    }

    public void mostrarGanador() {
        if (ganador.getPuntosVida() > 0) {
            System.out.println("¡El ganador es " + ganador.getNombre() + "!");
            System.out.println("Puntos de vida restantes: " + ganador.getPuntosVida());
        } else {
            System.out.println("No se ha determinado un ganador.");
        }
    }

    public static void main(String[]args){
        JuegoBatalla juego = new JuegoBatalla();
        juego.iniciarBatalla();
    }    
}
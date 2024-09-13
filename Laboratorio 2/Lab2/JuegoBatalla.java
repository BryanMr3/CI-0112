import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla{

    public void iniciarBatalla(){

        //Establecer el tamaño máximo del array
        Robot[] arrayRobots = new Robot[10];
        Scanner scanner = new Scanner(System.in);

        //establecer la cantidad de robots se quieren crear
        System.out.println("¿Cuántos robots desea crear?");
        int cantidadRobots = scanner.nextInt();
        scanner.nextLine();

        //para solicitar los atributos de cada robot y almacenarlos en cada posición del array, hasta un máximo de 10 robots
        for(int i = 0; i < cantidadRobots; i++){
            System.out.println("Ingrese el nombre del robot " + (i+1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese los puntos de vida del robot " +(i+1) +"(entre 50 y 100): ");
            int puntosVida = scanner.nextInt();

            System.out.println("Ingrese las cantidad de ataque del robot " + (i+1) + "(entre 10 y 20): ");
            int ataque = scanner.nextInt();

            scanner.nextLine();

            arrayRobots[i]= new Robot(nombre, puntosVida, ataque);
            System.out.println("¡Robot creado!");
            System.out.println("");
        }

        //debo continuar con la verificacion de que no sean los mismos robots, además de continuar con la accion de que revise si esta vivo al enfrentarse
        while(cantidadRobots > 1){

            //generar indices aleatorios, para elegir la posicion del robot que ataque y el robot objetivo
            int indAtaca= (int)(Math.random() * (cantidadRobots));
            int indOtroRobot;

            //evitar que los indices sean iguales (evita que se el robot atacante y objetivo no sean el mismo robot)
            do{
                indOtroRobot = (int)(Math.random() * (cantidadRobots) );
            }while(indAtaca == indOtroRobot);

            Robot robotAtaca = arrayRobots[indAtaca];
            Robot otroRobot = arrayRobots[indOtroRobot];

            robotAtaca.atacar(otroRobot);
            System.out.println(otroRobot.getpuntosVida());

            System.out.println("La vida actual del robot " + otroRobot.getnombre() + " es: " + otroRobot.getpuntosVida());

            
        }

    }

    public static void main(String[]args){
        JuegoBatalla juego = new JuegoBatalla();
        juego.iniciarBatalla();
    }
}
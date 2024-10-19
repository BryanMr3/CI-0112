
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        JuegoControlador controlador = new JuegoControlador();
        boolean jugarDeNuevo;
        
        System.out.println("¡Bienvenido a los juegos Tic-Tac-Toe y Cuatro En Línea!");

        do {
            controlador.seleccionarJuego(); // Permite al usuario seleccionar el juego (1 o 2)
            controlador.jugar(); // Comienza el juego seleccionado y se ejecuta 

            System.out.println("¿Desea jugar de nuevo o cambiar de juego? (1 = SI, 2 = NO)");
            int respuesta = entrada.nextInt();
            jugarDeNuevo = (respuesta == 1); 
            
            //si se pide reiniciar el juego, muestra el mensaje
            if (jugarDeNuevo) {
                System.out.println("Reiniciando el juego...");
                
                //si la instancia de CuatroEnLinea tiene un objeto(juego anterior), crea una nueva instancia
                if (controlador.getCuatroEnLinea() != null) {
                    controlador.setCuatroEnLinea(new CuatroEnLinea()); //reinicia el juego
                }
            }
        } while (jugarDeNuevo);
        
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        entrada.close();
    }
}


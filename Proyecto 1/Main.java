
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

            if (jugarDeNuevo) {
                System.out.println("Reiniciando el juego...");
                if (controlador.getCuatroEnLinea() != null && controlador.getCuatroEnLinea().getJugadorActual() == 1) {
                    controlador.setCuatroEnLinea(new CuatroEnLinea());
                }
            }
        } while (jugarDeNuevo);
        
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        entrada.close();
    }
}


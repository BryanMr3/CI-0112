import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        JuegoControlador controlador = new JuegoControlador();
        boolean jugarDeNuevo = true;
        
        System.out.println("¡Bienvenido a los juegos Tic-Tac-Toe y Cuatro En Línea!");

        do {
            controlador.seleccionarJuego(); // Permite al usuario seleccionar el juego (1 o 2)
            controlador.jugar(); // Comienza el juego seleccionado y se ejecuta 

        } while (jugarDeNuevo);
        
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        entrada.close();
    }
}


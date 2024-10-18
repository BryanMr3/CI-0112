import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean jugarDeNuevo;
        
        System.out.println("¡Bienvenido al juego de Tic-Tac-Toe!");
        do{
        TicTacToe juego = new TicTacToe();
        juego.iniciarJuego();

        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese la fila (1, 2, 3): ");
            int fila = entrada.nextInt() - 1; // Se le resta para convertir índice de 0 a 2 y que coincida con los espacios en la tabla
            System.out.print("Ingrese la columna (1, 2, 3): ");
            int columna = entrada.nextInt()-1;

            // Realizar el movimiento
            if (juego.hacerMovimiento(fila, columna)) {
                // Si no hay ganador o empate el juego sigue  
                if (juego.esGanador()) {
                    juego.mostrarTablero();
                    System.out.println("¡Felicidades! El jugador " + juego.getJugadorActual() + " ha ganado.");
                    break;
                } 
                // Verificar si hay empate
                else if (juego.esEmpate()) {
                    juego.mostrarTablero();
                    System.out.println("El juego ha terminado en empate.");
                    break;
                }
                // Juego sigue si no se cumple lo anterior y cambia de turno
                juego.cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Intente de nuevo.");
            }
        }
       System.out.println("¡Eso fue divertido! ¿Desea jugar de nuevo? (1 = SI, 2 = NO)");
       int respuesta = entrada.nextInt();
       jugarDeNuevo = (respuesta == 1);
    } while (jugarDeNuevo);
    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
     entrada.close();
    }
}

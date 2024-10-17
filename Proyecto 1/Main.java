 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe juego = new TicTacToe();
        System.out.println("¡Bienvenido al juego de Tic-Tac-Toe!");
        juego.iniciarJuego();

        while (!juego.esJuegoTerminado()) {
            juego.mostrarTablero();
            System.out.println("Turno del jugador " + juego.getJugadorActual());
            System.out.print("Ingrese la fila (0, 1, 2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna (0, 1, 2): ");
            int columna = scanner.nextInt();

            // Realizar el movimiento
            if (juego.hacerMovimiento(fila, columna)) {
                // Verificar si hay un ganador
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
                // Cambiar el turno al siguiente jugador
                juego.cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Intente de nuevo.");
            }
        }

        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        scanner.close();
    }
}

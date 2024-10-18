 import java.util.Scanner;

public class TicTacToe {
    // Atributos
    private char[][] tablero;
    private static char jugadorActual;

    // Constructor
    public TicTacToe() {
        iniciarJuego();
    }
    
    //Getters y setters 
    public static char getJugadorActual(){
        return jugadorActual; 
    }

    // Métodos
    public void iniciarJuego() {
        tablero = new char[3][3]; 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '/'; // Se llena el tablero con '/'
            }
        }
        jugadorActual = 'X'; // Comienza el jugador 'X'
    }

    //Boolean para hacer que otros métodos sean más directos
    public boolean hacerMovimiento(int fila, int columna) {
        //Verifica si se sale de los límites superiores e inferiores, también si el espacio seleccionado está vacío
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '/') {
            tablero[fila][columna] = jugadorActual; //Si se cumple, se pone el símbolo del jugador actual en el espacio
            return true; //Válido y se ejecutó correctamente
        } else {
            System.out.println("Movimiento inválido. Intente de nuevo.");
            return false;
        }
    }

    //Se recorre el tablero para imprimirlo 
    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public boolean esJuegoTerminado() {
        return esGanador() || esEmpate(); //Si es alguno de estos dos, termina
    }

    
    public boolean esGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            // Recorre todas las filas con las diferentes opciones de columna y viveversa
            if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                return true;
            }
        }
        // Verificar diagonales
        if ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
            (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)) {
            return true;
        }
        return false;
    }

    
    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '/') {
                    return false; // Si hay por lo menos una celda vacía, no puede haber empate porque se puede seguir jugando
                }
            }
        }
        return !esGanador(); // Si no hay ganador y el tablero está lleno, es empate
    }


    public void cambiarJugador() {
        //Verifica si jugador actual es x. Si si es (true) lo cambia a "0", si no es, lo cambia a "X"
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
}

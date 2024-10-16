public class TicTacToe {
    // Atributos
    private char[][] tablero;
    private char jugadorActual;

    // Constructor
    public TicTacToe() {
        iniciarJuego();
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

    
    public boolean hacerMovimiento(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-') {
            tablero[fila][columna] = jugadorActual;
            return true;
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
        return esGanador() || esEmpate();
    }

    
    public boolean esGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
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
                if (tablero[i][j] == '-') {
                    return false; // Si hay una celda vacía, no hay empate
                }
            }
        }
        return !esGanador(); // Si no hay ganador y el tablero está lleno, es empate
    }


    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
}

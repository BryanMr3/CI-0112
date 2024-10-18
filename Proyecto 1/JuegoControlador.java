import java.util.Scanner;

public class JuegoControlador {
    private Scanner entrada; //Atributo global para entrada de usuario
    private CuatroEnLinea cuatroEnLinea; //Instancia clase CuatroEnLinea
    private TicTacToe ticTacToe; // Instancia clase TicTacToe
    private int juegoActual; //Referencia a CuatroEnLinea y TicTacToe

    // Constructor
    public JuegoControlador() {
        this.cuatroEnLinea = new CuatroEnLinea();
        this.ticTacToe = new TicTacToe();
        this.juegoActual = 0;
        this.entrada = new Scanner(System.in);
    }

    // Setters y Getters
    public void setCuatroEnLinea(CuatroEnLinea cuatroEnLinea) {
        this.cuatroEnLinea = cuatroEnLinea;
    }

    public void setTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public CuatroEnLinea getCuatroEnLinea() {
        return cuatroEnLinea;
    }

    public TicTacToe getTicTacToe() {
        return ticTacToe;
    }

    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
        System.out.println("============MENÚ PRINCIPAL============");
        System.out.println("Selecciona un juego para continuar:");
        System.out.println("1. Cuatro en línea");
        System.out.println("2. TicTacToe");
    }

    /*Método sin retorno y parámetros  
     Llama al método mostrarMenuPrincipal y procesa la entrada, para que el usuario seleccione un juego
     Según la seleccion del juego, se asigna el valor a la variable que referencia a alguno de los dos juegos.
     Si no selecciona un juego del menú, mostrará el mensaje del condicional "else" y reinicia la solicitud del juego
     */
    public void seleccionarJuego() {
        mostrarMenuPrincipal();
        int opcionJuego = entrada.nextInt();

        if (opcionJuego == 1) {
            this.juegoActual = 1;
            System.out.println("Iniciando partida Cuatro En Línea.... \n");
        } else if (opcionJuego == 2) {
            this.juegoActual = 2;
            System.out.println("Iniciando partida TicTacToe..... \n");
        } else {
            System.out.println("Selección no válida. Intenta de nuevo");
            seleccionarJuego();
        }
    }

    /*Método sin retorno y parámetros. 
     Procesa la entrada del usuario para realizar movimientos de los jugadores segun el juegoActual.
     */
    public void procesarEntradaUsuario() {
        if (juegoActual == 1) {
            // Lógica para CuatroEnLinea
            int columna = -1;
            boolean movimientoExitoso = false;

            while (true) {
                System.out.println("Jugador " + cuatroEnLinea.getJugadorActual() + ", es su turno. Seleccione una columna (0-6): ");
                columna = entrada.nextInt();

                movimientoExitoso = cuatroEnLinea.hacerMovimiento(columna);
                if (movimientoExitoso) {
                    break;
                } else {
                    System.out.println("Movimiento inválido. Intenta de nuevo.\n");
                }
            }
        } else if (juegoActual == 2) {
            // Lógica para TicTacToe
            int fila, columna;
            boolean movimientoExitoso = false;

            while (true) {
                System.out.println("Jugador " + ticTacToe.getJugadorActual() + ", ingrese la fila (1-3): ");
                fila = entrada.nextInt() - 1;
                System.out.println("Ingrese la columna (1-3): ");
                columna = entrada.nextInt() - 1;

                movimientoExitoso = ticTacToe.hacerMovimiento(fila, columna);
                if (movimientoExitoso) {
                    break;
                }
            }
        }
    }

    /*Metodo sin parametros y retorno.
     Contiene la logica para el flujo del juego, alternar turnos y mostrar el tablero actual en cada movimiento.
     Llama a metodos de la clase CuatroEnLinea y de JuegoControlador, para ejecutar el juego seleccionado.
     */
    public void jugar() {
        if (juegoActual == 1) {
            while (true) {
                cuatroEnLinea.mostrarTablero();
                procesarEntradaUsuario();

                if (cuatroEnLinea.esJuegoTerminado()) {
                    cuatroEnLinea.mostrarTablero();
                    if (cuatroEnLinea.esGanador()) {
                        System.out.println("¡Ha terminado el juego! El ganador es el jugador " + cuatroEnLinea.getJugadorActual());
                    } else {
                        System.out.println("¡El juego ha terminado en empate!");
                    }
                    break;
                }
                cuatroEnLinea.cambiarJugador();
            }
        } else if (juegoActual == 2) {
            ticTacToe.iniciarJuego();
            while (!ticTacToe.esJuegoTerminado()) {
                ticTacToe.mostrarTablero();
                procesarEntradaUsuario();

                if (ticTacToe.esGanador()) {
                    ticTacToe.mostrarTablero();
                    System.out.println("¡Felicidades! El jugador " + ticTacToe.getJugadorActual() + " ha ganado.");
                    break;
                } else if (ticTacToe.esEmpate()) {
                    ticTacToe.mostrarTablero();
                    System.out.println("El juego ha terminado en empate.");
                    break;
                }
                ticTacToe.cambiarJugador();
            }
        }

        // Preguntar si desea jugar de nuevo o cambiar de juego
        System.out.println("¿Desea jugar de nuevo o cambiar de juego? (1 = Jugar de nuevo, 2 = Cambiar de juego, 3 = Salir)");
        int respuesta = entrada.nextInt();

        if (respuesta == 1) {
            jugar(); // Repetir el mismo juego
        } else if (respuesta == 2) {
            seleccionarJuego();
            jugar(); // Cambiar de juego y empezar de nuevo
        } else {
            System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        }
    }
}

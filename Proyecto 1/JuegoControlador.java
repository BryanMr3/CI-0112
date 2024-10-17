
/*Clase que controla la interacción con el usuario, selección de juego 
 *Permite al usuario escoger entre dos juegos CuatroEnLinea y TicTacToe
 */
import java.util.Scanner; //importacion del Scanner

public class JuegoControlador
{
    private Scanner scanner; //atributo global para entrada de usuario
    private CuatroEnLinea cuatroEnLinea; // instancia clase CuatroEnLineaa
    private int juegoActual;//referencia a CuatroEnLinea y TicTacToe (1 o 2)

    //metodo constructor sin parametros. Inicializa los atributos.
    public JuegoControlador(){
        this.cuatroEnLinea = new CuatroEnLinea();//crear instancia clase CuatroEnLinea
        this.juegoActual = 0;//referencia a que no hay juego seleccionado
        this.scanner = new Scanner(System.in);//inicializar scanner
    }

    //setters
    public void setCuatroEnLinea(CuatroEnLinea cuatroEnLinea){
        this.cuatroEnLinea = cuatroEnLinea;
    }
    
    
    //agregar set tictactoe

    //getters
    public CuatroEnLinea getCuatroEnLinea(){
        return cuatroEnLinea;
    }

    //agregar get tictactoe

    /*Metodo sin retorno y parametros 
     *Muestra las opciones de juego del menú principal en consola 
     */
    public void mostrarMenuPrincipal(){
        System.out.println("============MENÚ PRINCIPAL============" );
        System.out.println("Selecciona un juego para continuar:");
        System.out.println("1.Juego 4 En Línea  ");
        System.out.println("2.Juego TicTacToe ");
    }
    
    /*Metodo sin retorno y parametros  
     *Llama al metodo mostrarMenuPrincipal y procesa la entrada, para que el usuario seleccione un juego
     *Segun la seleccion del juego, se asigna el valor a la variable que referencia a alguno de los dos juegos.
     *Si no selecciona un juego del menu, mostrará el mensaje del condicional "else" y reinicia la solicitud del juego
     */
    public void seleccionarJuego(){
        mostrarMenuPrincipal(); //mostrar el menú principal.
        int opcionJuego = scanner.nextInt(); //lee la opcion del juego.

        if(opcionJuego == 1){
            this.juegoActual = 1;//referencia CuatroEnLinea.
            System.out.println("Cargando partida Cuatro En Linea.... \n");
        }else if(opcionJuego == 2 ){
            this.juegoActual = 2;//referencia TicTacToe.
            System.out.println("Cargando partida TicTacToe..... \n");
        }else{
            System.out.println("Selección inválida. Intenta de nuevo"); //muestra este mensjae si la opción no se encuentra en el menú.
            seleccionarJuego(); //solicitar la selección de juego.
        }
    }
    
    /*Metodo sin retorno y parametros. 
     *Procesa la entrada del usuario para realizar movimientos de los jugadores segun el juegoActual.
     *
     */
    public void procesarEntradaUsuario(){
        int columna = -1; //columna no válida.
        boolean movimientoExitoso = false; //aun no hay movimiento exitoso.

        //lógica si el juego actual es CuatroEnLinea.
        if(juegoActual == 1){
            
            while(true){
                System.out.println("Jugador " + cuatroEnLinea.getJugadorActual() + ", es su turno. Seleccione una columna (0-6) " );
                columna = scanner.nextInt();//cambiar el valor inicial de columna.
                
                /*verifica si el movimiento es válido, llama al metodo de la clase CuatroEnLinea.
                 *que recibe por parametro la columna escogida .
                 */
                movimientoExitoso = cuatroEnLinea.hacerMovimiento(columna); 

                //verifica que el movimiento es exitoso, columna válida y vacía.
                if(movimientoExitoso){
                    break;//salir del bucle.
                }else{
                    System.out.println("Movimiento inválido. Intenta de nuevo. \n"); //si la columna no es valida y no está vacía.
                }
                
            }    
        }
    }
    
    /*Metodo sin parametros y retorno.
     *Contiene la logica para el flujo del juego, alternar turnos y mostrar el tablero actual en cada movimiento.
     *Llama a metodos de la clase CuatroEnLinea y de JuegoControlador, para ejecutar el juego seleccionado.
     */
    public void jugar(){
        //Lógica si el juegoActual es CuatroEnLinea.
        if(juegoActual == 1){ 
            //Bucle infinito. Sale hasta que se cumpla alguno de los eventos.
            while(true){ 
                cuatroEnLinea.mostrarTablero(); //Llama al metodo de la clase CuatroEnLinea para mostrar el tablero actual.
                procesarEntradaUsuario(); //Llama al metodo, para solicitar movimiento. 

                //verifica si hay empate o ganador después de cada movimiento.
                if(cuatroEnLinea.esJuegoTerminado()){
                    cuatroEnLinea.mostrarTablero();//muestra el tablero actual en cada movimiento.
                    
                    //evalua si hay un ganador, llama al metodo de la clase CuatroEnLinea.
                    if(cuatroEnLinea.esGanador()){ 
                        System.out.println("¡Ha terminado el juego!. El ganador es el jugador " + cuatroEnLinea.getJugadorActual()); //
                    } else{
                        System.out.println("¡El juego ha terminado!. Es un empate");
                    }  
                    break; //salir del bucle si alguien gana o hay empate.
                }    
                cuatroEnLinea.cambiarJugador();//alternar los turnos.

            }
        }
        //falta agregar logica para verificar si se quiere jugar de nuevo o cambiar de juego
        //falta agregar logica para juego tictactoe
    }

    
    
}

/*Esta es la clase principal, inicializa los juegos.
 * Crea una instancia de JuegoControlador y maneja el flujo principal de cada juego. Permite seleccionar un juego y comenzar a jugarlo.
 */
public class MainJuego
{
  public static void main(String[] args) {
        JuegoControlador controlador = new JuegoControlador();//se crea una instancia de la claseJuegoControlador
        controlador.seleccionarJuego();//metodo que permite seleccionar un juego del menu
        controlador.jugar();//metodo que permite jugar el juego seleccionado
    }  
}

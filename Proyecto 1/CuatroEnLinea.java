/*Esta clase contendrá los metodos y atributos que dan la estructura del juego Cuatro En Linea. Los metodos creados permiten crear un
 *tablero, realizar y mostrar movimientos, verificar estados del juego(gane, perdida, empate) para determinar al ganador. 
 * 
 */

public class CuatroEnLinea
{
    private int[][] tablero;
    private int jugadorActual;

    //método constructor
    public CuatroEnLinea(int[][] tablero, int jugadorActual){
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    public CuatroEnLinea() {
        iniciarJuego();
    }
    //setters
    public void setTablero (int[][] tablero){
        this.tablero = tablero;
    }

    public void setJugadorActual(int jugadorActual){
        this.jugadorActual = jugadorActual;
    }

    //getters
    public int[][] getTablero(){
        return tablero;
    }

    public int getJugadorActual(){
        return jugadorActual;
    }

    /*metodo sin parametros,ni retorno. Se inicializa el tablero,que contendrá 6 filas y 7 columnas. Despues con un bucle for, se asigna 
     * a cada posicion del tablero, un valor que indica un espacio disponible de jugada. */

    public void  iniciarJuego(){
        tablero = new int[6][7]; //inicializa el tablero 6 filas, 7 columnas 

        //bucle para asignar valores iniciales en cada posicion del tablero
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length ; j++){
                tablero[i][j] = 0; //representa los espacios disponibles para ficha, con el valor cero
            }
            System.out.println(); //dar estrtuctura al tablero
        }

        this.jugadorActual = 1; //establece al jugador actual, como  1, que representa al jugador 1
    }

    /*Metodo de tipo booleano,recibe un parametro de tipo entero que hace referencia al indica de la columna. Con el condicional if evalua
     * si está dentro de los limites de las columnas, si se cumple ejecuta el bucle for, que recorre cada fila de la columna para verificar
     * que hay espacio y guarda el movimiento del jugador en el espacio que está disponible, retornando true si se ejecuta el movimiento
     * y false si no hay espacio en la columna, además de false si el indice está fuera de los limites. 
     */
    public boolean hacerMovimiento(int columna){

        if(columna >= 0 && columna < 7){
            for(int i = 5; i >= 0; i--){ //
                if(tablero[i][columna]==0){
                    tablero[i][columna] = this.jugadorActual;
                    cambiarJugador();
                    return true; //Se ejecuta el movimiento
                }
            }
        } else{
            return false;//no hay espacio en la columna
        }
        return false;//el indice está fuera del rango de las columnas
    }

    /*metodo sin retorno y parametros, se espera alternar al jugador actual, cuando se llame al metodo se espera cambie de jugador, por medio
     * del condicional que, en if verifica si el jugador actual es 1, lo cambia a 2 y viceversa mediante el else 
     */
    public void cambiarJugador(){
        
        if(this.jugadorActual==1){
            this.jugadorActual = 2;
        }else{
            this.jugadorActual = 1;
        }
        
    }

    public void mostarTablero(){
    }

}

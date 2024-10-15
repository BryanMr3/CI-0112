/*Esta clase contendrá los metodos y atributos que dan la estructura del juego Cuatro En Linea. Los metodos creados permiten crear un
 *tablero, realizar y mostrar movimientos, verificar estados del juego(gane, perdida, empate) para determinar al ganador. 
 * 
 */

import java.util.Scanner;
public class CuatroEnLinea
{
    private int[][] tablero;
    private int jugadorActual;

    //método constructor
    public CuatroEnLinea(int[][] tablero, int jugadorActual){
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }
    
    //metodo constructos y sin parametros. llama al metodo iniciarJuego, que inicializaba el tablero y establecia el jugador actual
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

    /*Este metodo imprime el tablero, se utilizan dos bucles for para recorrer el array, el indice i representa las filas, el indice j 
     * representa las columnas. El print imprimirá cada fila y columna, de manera que se muestre el tablero completo en un inicio con los
     * valores del metodo iniciarJuego, pero cambiará segun los jugadores vayan llenando el tablero y se llame a este metodo. 
     */
    public void mostrarTablero(){
        System.out.println("Tablero actual: ");
        for(int i=0; i < tablero.length; i++){
            System.out.print("| "); //separar casillas
            for(int j=0; j < tablero[i].length;j++){
                System.out.print(tablero[i][j] + " | ");

            }
            System.out.println(); //dar espacio entra columnas
        }
        System.out.println();//espacio entre filas
    }

    /*metodo tipo booleano, para verificar si el juego termina. llama a dos metodos esGanador() y esEmpate() revisa con el condicional if
     * si se cumple alguno de los dos y retorna "true", si no, retorna "false" que indica que el juego deberia continuar.
     */
    public boolean esJuegoTerminado(){
        
        if(esGanador() || esEmpate()== true){
            return true;
        }else{
            return false;
        }
    
    }

    public boolean esGanador(){
        return true;
    }
    
    /*Verifica si el juego es empate. Con dos bucles for recorre cada posicion del arreglo para
     * revisar que se cumple la condicion del if de que existan espacios sin uso para ficha.
     * Retorna false, para indicar que no hay empate al tener celdas disponibles(valor cero) y
     * true para indicar que cada columna y fila está con valor diferente de cero(1 o 2)
     */
    public boolean esEmpate(){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length;j++){
                if(tablero[i][j] == 0){
                    return false;    
                }
            }
        }
        return true;
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

    public static void main(String[]args){
        //Esto es solo para probar los avances, pero más adelante se dedica una clase al flujo del juego
        
        Scanner scanner = new Scanner(System.in);
        CuatroEnLinea juego = new CuatroEnLinea();
        int columna;

        //interfaz
        System.out.println("¡Bienvenido al juego!");
        while(true){

            System.out.println("Jugador " + juego.getJugadorActual() + ", es su turno. Seleccione una columna (0-6) para agregar su ficha:" );
            juego.mostrarTablero();
            columna = scanner.nextInt();

            if(juego.hacerMovimiento(columna)){
                System.out.println("¡Movimiento realizado! \n" );
                juego.mostrarTablero();
            }else{
                System.out.println("¡Movimiento inválido! \n");
                juego.mostrarTablero();
            }
            
            if(juego.esEmpate()){
                System.out.println("El juego ha terminado, es un empate");
                break;
            }
            System.out.println();
        }

    }
}

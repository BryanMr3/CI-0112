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
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length ; j++){
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
                if(this.tablero[i][columna]==0){
                    tablero[i][columna] = this.jugadorActual;
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
        for(int i=0; i < this.tablero.length; i++){
            System.out.print("| "); //separar casillas
            for(int j=0; j < this.tablero[i].length;j++){
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
    
    /*Metodo booleano, verifica si hay un ganador. Evalua si alguno de los escenarios que representan que algun jugador ganó se cumple.
     * Se manejan datos que contienen al jugador actual y el estado del tablero. mediante los bucles for, recorre el arreglo para verificar
     * si alguna de las combinaciones de gane se cumplen. Se espera obtener un retorno "true" si hay cuatro posiciones consecutivas en alguna
     * de las direcciones que contengan el movimiento del mismo jugador y "false"si no se cumple.
     */
    public boolean esGanador(){
        int jugador = this.getJugadorActual(); //referencia al jugador actual
        
        //verificar si hay ganador ebn horizontal.. bucle for con "j", condicion se limita a 4 para asegurar verificar en 4 espacios consecutivos 
        for(int i=0; i < this.tablero.length; i++){
            for(int j=0; j < this.tablero.length-3;j++){
                //verificacion horizontal.. evalua si en una fila(i) hay 4 columnas (j) con el mismo valor de forma consecutiva 
                if(this.tablero[i][j]==jugador && this.tablero[i][j+1]==jugador && 
                this.tablero[i][j+2] ==jugador && this.tablero[i][j+3]==jugador){

                    return true; //representa una victoria

                }

            }
        }
        
        //verificar si hay ganador en vertical.. bucle for con "i", condicion se limita a 3 para asegurar evaluar en 4 espacios
        for(int i=0; i < this.tablero.length-3; i++){ 
            for(int j=0; j < this.tablero.length;j++){
                //verificacion vertical.. evalua si en una columna(j) hay 4 filas (i) con el mismo valor de forma consecutiva.
                if(this.tablero[i][j]==jugador && this.tablero[i+1][j]==jugador && 
                this.tablero[i+2][j] ==jugador && this.tablero[i+3][j]==jugador){

                    return true; // representa una victoria

                }

            }
        }
        
        /*verificar si hay ganador en diagonal de izquierda a derecha (\). 
         *columna y fila limitadas a 3 y 4, para evitar desbordamiento*/
        for(int i=0; i < this.tablero.length-3; i++){
            for(int j=0; j < this.tablero.length-3;j++){
                /* logica para verificar si hay un mismo valor de jugador.
                 * acceder a posiciones en diagonal de derecha a izquierda
                */
                if(this.tablero[i][j]==jugador && this.tablero[i+1][j+1]==jugador && 
                this.tablero[i+2][j+2] ==jugador && this.tablero[i+3][j+3]==jugador){
                    return true;
                }

            }
        }
        
        /*verificar si hay ganador en diagonal de izquierda a derecha(/).
         *condición de ambos bucles limitadas a 3 y 4, para evitar desbordamiento de índice.
        */
        for(int i=3; i < this.tablero.length; i++){
            for(int j=0; j < this.tablero.length-3;j++){
                /* logica para verificar si hay un mismo valor de jugador en 4 posiciones consecutivas.
                 * accede a posiciones en diagonal de izquierda a derecha */
                if(this.tablero[i][j]==jugador && this.tablero[i-1][j+1]==jugador && 
                this.tablero[i-2][j+2] ==jugador && this.tablero[i-3][j+3]==jugador){
                    return true;
                }

            }
        }
        
        return false;
    }

    /*Verifica si el juego es empate. Con dos bucles for recorre cada posicion del arreglo para
     * revisar que se cumple la condicion del if de que existan espacios sin uso para ficha.
     * Retorna false, para indicar que no hay empate al tener celdas disponibles(valor cero) y
     * true para indicar que cada columna y fila está con valor diferente de cero(1 o 2)
     */
    public boolean esEmpate(){

        for(int i=0; i < this.tablero.length; i++){
            for(int j=0; j < this.tablero[i].length;j++){
                if(this.tablero[i][j] == 0){
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
                //verificar si ha terminado el juego, llamando al metodo
                if(juego.esJuegoTerminado()){
                    juego.mostrarTablero();
                    if(juego.esGanador()){
                        System.out.println("El juego ha terminado, el ganador es el jugador: " + juego.getJugadorActual());
                    }else{
                        System.out.println("El juego ha terminado en empate");
                    }
                    break;
                } 
                juego.cambiarJugador(); 
            }

            else{
                System.out.println("¡Movimiento inválido!. Intenta de nuevo \n");
            }
            
        }
        scanner.close();
    }

}

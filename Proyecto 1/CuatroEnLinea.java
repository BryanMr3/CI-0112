/*Esta clase contiene los metodos y atributos que dan la estructura del juego Cuatro En Linea. Los metodos permiten crear un
 *tablero, realizar y mostrar movimientos, verificar estados del juego(gane, perdida, empate).  
 */


public class CuatroEnLinea
{
    private int[][] tablero; //
    private int jugadorActual; //

    //método constructor
    public CuatroEnLinea(int[][] tablero, int jugadorActual){
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    //metodo constructor, sin parametros. Llama al metodo iniciarJuego
    public CuatroEnLinea() {
        iniciarJuego();//inicializar el tablero y establecer jugador actual
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
     * a cada posicion del tablero, un valor que indica un espacio disponible de jugada.
    */
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

    /*Metodo booleano, recibe un parametro de tipo entero que hace referencia al indice de la columna.
     *Evalua si la columna es válida para realizar el movimiento y llena la columna con el valor que corresponde a jugadorActual
     *Retorna verdadero si se realiza el movimiento, retorna false si no hay espacio en la columna o si está fuera del rango de columnas  
     */
    public boolean hacerMovimiento(int columna){
        //condicional que verifica que el valor de columna esté dentro del rango de 0 a 6, llena columnas si se cumple la condición
        if(columna >= 0 && columna < 7){
            //bucle para llenar la columna, en dirección de abajo hacía arriba, inicia desde la fila más alta
            for(int i = 5; i >= 0; i--){ //
                //condicional que verifica si la columna seleccionada está vacía(tiene valor de cero)
                if(this.tablero[i][columna]==0){
                    tablero[i][columna] = this.jugadorActual; //llenar la columna con el jugadorActual (1 o 2)
                    return true; //Se realiza el movimiento
                }
            }
        } else{
            return false;//no hay espacio en la columna
        }
        return false;//el indice está fuera del rango de las columnas
    }

    /* Metodo sin parametros, ni retorno. 
     * Imprime el tablero(cada fila y columna), con dos bucles for que recorren el array array  
     */
    public void mostrarTablero(){
        System.out.println("                "+"Tablero actual: "); //mensaje del tablero actual
        
        //bucle que reccorre las filas(i)
        for(int i=0; i < this.tablero.length; i++){
            System.out.print("          | "); //separar cada columna
            //bucle que recorre las columnas(j)
            for(int j=0; j < this.tablero[i].length;j++){
                System.out.print(tablero[i][j] + " | ");//imprimir fila y columna con los valores que haya en cada posicion
            }
            System.out.println(); //dividir cada columna
        }
        System.out.println();//dividir cada fila
    }

    /*Metodo tipo booleano,sin parametros y con retorno. 
     *Verifica si el juego termina.
     *Retorna true si hay un empate o hay un ganador
     *Retorna false si hay ganador y empate, el juego continúa.
     */
    public boolean esJuegoTerminado(){
        //condicional que verifica si hay empate o ganador
        if(esGanador() || esEmpate()== true){
            return true; //hay ganador o empate
        }else{
            return false; //el juego continúa
        }

    }
    
    /*Metodo booleano,sin parametros. 
     *Verifica si hay un ganador despues de cada movimiento, evaluando cada escenario posible que representa que algun jugador gana.
     *Retorna true en los casos que se cumplan, indicando que hay ganador
     *Retorna false si ningun caso se cumple
     */
    public boolean esGanador(){
        int jugador = this.getJugadorActual(); //referencia al jugador actual
        
        //bucle que verifica si hay ganador en horizontal.. Evalua si hay 4 fichas consecutivas en horizontal. 
        for(int i=0; i < this.tablero.length; i++){
            /*bucle que recorre las columnas, se limita el indice "j" a (tablero.length - 3) 
             *para evaluar en 4 espacios cosnecutivos dentro de los limites.
             */ 
            for(int j=0; j < this.tablero.length - 3;j++){
                //condicional que evalua si en la fila (i) hay un mismo valor en 4 columnas consecutivas.(j,j+1,j+2,j+3).
                if(this.tablero[i][j]==jugador && this.tablero[i][j+1]==jugador && 
                this.tablero[i][j+2] ==jugador && this.tablero[i][j+3]==jugador){
                    return true; //hay 4 fichas consecutivas en horizontal con un mismo valor en horizontal.
                }

            }
        }
        
        /*Bucle que verifica si hay ganador en vertical.. Evalua si hay 4 fichas consecutivas en vertical
         *Bucle que recorre filas(i), se limita el indice "i" a (tablero.length - 3) para asegurar evaluar en 4 espacios dentro de limites.
         */
        for(int i=0; i < this.tablero.length - 3; i++){ 
            for(int j=0; j < this.tablero.length;j++){
                //verificacion vertical.. evalua si en columna (j) hay 4 filas (i,i+1,i+2,i+3) con el mismo valor de forma consecutiva.
                if(this.tablero[i][j]==jugador && this.tablero[i+1][j]==jugador && 
                this.tablero[i+2][j] ==jugador && this.tablero[i+3][j]==jugador){
                    return true; //hay 4 fichas consecutivas en vertical con mismo valor en vertical
                }

            }
        }
        
        /*Verificar si hay ganador en diagonal de izquierda a derecha (\). 
         *Se limita indice "i" y "j" a (tablero.length-3) para evaluar en 4 espacios consecutivos dentro de los limites
         */
        for(int i=0; i < this.tablero.length-3; i++){
            for(int j=0; j < this.tablero.length-3;j++){
                /* logica para verificar si hay un mismo valor de jugador.
                 * acceder a posiciones en diagonal de derecha a izquierda
                */
                if(this.tablero[i][j]==jugador && this.tablero[i+1][j+1]==jugador && 
                this.tablero[i+2][j+2] ==jugador && this.tablero[i+3][j+3]==jugador){
                    return true;//hay 4 fichas consecutivas en diagonal \ con un mismo valor
                }

            }
        }
        
        /*Verificar ganador en diagonal de izquierda a derecha(/).
         *Se limita indice "i" a comenzar en 3 para evitar un desbordamiento de indice
        */
        for(int i=3; i < this.tablero.length; i++){
            for(int j=0; j < this.tablero.length-3;j++){
                /* se limita el indice "i" a (tablero.length - 3) para asegurar evaluar en 4 espacios dentro de limites
                 * accede a posiciones en diagonal de izquierda a derecha.*/
                if(this.tablero[i][j]==jugador && this.tablero[i-1][j+1]==jugador && 
                this.tablero[i-2][j+2] ==jugador && this.tablero[i-3][j+3]==jugador){
                    return true;//hay 4 fichas consecutivas en diagonal / con un mismo valor
                }

            }
        }
        
        return false;//ninguno de los casos se ha cumplido
    }

    /*Metodo booleano, sin parametros
     * Verifica si el juego es empate.
     * Retorna false si hay espacios disponibles
     * Retorna true si todos los espacios están llenos
     */
    public boolean esEmpate(){
        //bucle que verifica en cada posicion si hay espacios disponibles
        for(int i=0; i < this.tablero.length; i++){
            for(int j=0; j < this.tablero[i].length;j++){
                //condicional que verifica si en cada posicion hay espacios disponibles,(valores de 0).
                if(this.tablero[i][j] == 0){
                    return false;//hay espacios disponibles, no hay empate     
                }
            }
        }
        return true;//todos los espacios están llenos con valores diferentes de 0, hay empate
    }

    /*Metodo sin retorno y parametros.
     * Alterna al jugador actual con cambio de valor en atributo jugadorActual.
     */
    public void cambiarJugador(){
        //condicional que verifica el jugadorActual, cambia el valor segun el caso que se presenta.
        if(this.jugadorActual==1){
            this.jugadorActual = 2;//jugadorActual cambia a jugador 2.
        }else{
            this.jugadorActual = 1; //si jugadorActual es 2, cambia a jugador 1.
        }

    }

}

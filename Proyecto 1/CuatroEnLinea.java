
public class CuatroEnLinea
{
    private int[][] tablero;
    private int jugadorActual;
    
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
    
    //método constructor
    public CuatroEnLinea(){
        iniciarJuego();
    }

    //metodo que inicializa el tablero de tamaño y establece el jugador actual
    public void  iniciarJuego(){
        tablero = new int[6][7];
        
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length ; j++){
                tablero[i][j] = 0;
                System.out.print(tablero[i][j]+ (" "));
            }
            System.out.println();
        }
    }
    
    public static void main(String[]args){
        CuatroEnLinea tablero = new CuatroEnLinea();
    }
    
}
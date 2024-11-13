
import java.util.Scanner;

public class MainDeque{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque colaDoble = new Deque(); 
        
        //Bucle para solicitar dato, encolarlo al frente(de momento, ya que faltan otros metodos), y mostrar la cola actual.
        while (true) {
            System.out.println("\n" + "inserte el elemento de la cola" );
            int data = scanner.nextInt();//guardar valor ingresado como nodo
            colaDoble.pushFront(data); //encolar el valor ingresado
            System.out.println("cola actual:"); 
            colaDoble.printDeque();//mostrar cola actual

            
            //En un futuro se puede implementar una manera de detener el programa
        }
    }
}
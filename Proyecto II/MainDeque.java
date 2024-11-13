
import java.util.Scanner;

public class MainDeque{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque colaDoble = new Deque(); 
        
        //Bucle para solicitar dato, encolarlo al frente(de momento, ya que faltan otros metodos), y mostrar la cola actual.
        while (true) {
            System.out.println("\n" + "En que extremo desea agregar el elemento? 1: Frente / 2: Final");
            int position = scanner.nextInt();

            if(position == 1){
                System.out.println("Ingrese el valor que quiere agregar al frente");
                int data = scanner.nextInt();
                colaDoble.pushFront(data);
                System.out.println("Cola actual:");
                
            }if (position == 2) {
                System.out.println("Ingrese el valor que quiere agregar al final");
                int data = scanner.nextInt();
                colaDoble.pushBack(data);
                System.out.println("Cola actual:");
                
            }
            
            colaDoble.printDeque();


            //En un futuro se puede implementar una manera de detener el programa
        }
    }
}
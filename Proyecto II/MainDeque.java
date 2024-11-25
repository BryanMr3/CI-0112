
import java.util.Scanner;

public class MainDeque{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque colaDoble = new Deque(); 
        
        for(int i = 0; i<5; i++){
         //Bucle para solicitar 5 datos, encolarlos al frente(de momento, ya que faltan otros metodos), y mostrar la cola actual.
      
            System.out.println("\n" + "En que extremo desea agregar el elemento? 1: Frente / 2: Final");
             int position = scanner.nextInt();

             if(position == 1){
             System.out.println("Ingrese el valor que quiere agregar al frente");
             int data = scanner.nextInt();
             colaDoble.pushFront(data);
             System.out.println("Cola actual:");
             
            }
            if (position == 2) {
                System.out.println("Ingrese el valor que quiere agregar al final");
                int data = scanner.nextInt();
                colaDoble.pushBack(data);
                System.out.println("Cola actual:");
             
            }
            colaDoble.printDeque();
            System.out.println();

            System.out.println("Desea desencolar el primer elemento? 1:Sí / 2:No");
            int delete = scanner.nextInt();

            if (delete== 1) {
                colaDoble.popFront();
                System.out.println("Cola actual:");
                colaDoble.printDeque();   
            }else{
                System.out.println("Desea desencolar el último elemento? 1:Sí / 2:No");
                int deleteLast = scanner.nextInt();
                if (deleteLast == 1) {
                    colaDoble.popBack();
                    System.out.println("Cola actual:");
                    colaDoble.printDeque();  
                }     
            }
            System.out.println();

            //Buscar elemento en el Deque
            System.out.println("¿Cuál elemento desea buscar?");
            int missing = scanner.nextInt();

            if(colaDoble.searchDuque(missing) == true){
                System.out.println("El elemento se encuentra en la cola");
            }

            if(colaDoble.searchDuque(missing) == false){
                System.out.println("El elemento no se encuentra en la cola");
            }
        }
    }    
}

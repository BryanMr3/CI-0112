import java.util.Scanner;
public class JuegoBatalla{
    
    public void iniciarBatalla(){

    }
    
    
    
    
    
    public static void main(String[]args){
        
        //instancia del arreglo de robots
        Robot[] robots = new Robot[10];
        Scanner scanner = new Scanner(System.in);
        
        
        //para solicitar los atributos de cada robot
        for(int i = 0; i < 10; i++){
            System.out.println("Ingrese el nombre del robot " + (i+1) + ": ");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingrese los puntos de vida del robot " +(i+1) +"(entre 50 y 100): ");
            int puntosVida = scanner.nextInt();
        
            System.out.println("Ingrese las cantidad de ataque del robot " + (i+1) + "(entre 10 y 20): ");
            int ataque = scanner.nextInt();
            
            scanner.nextLine();
            
            robots[i]= new Robot(nombre, puntosVida, ataque);
            System.out.println("Robot creado");
        }
        
        
    

        

    }
}


/**
 *Esta clase contiene ejercicios sobre el tema de recursividad.
 */
public class EjerciciosRecursivos
{
    
    public static int sumarDigitos(int numero){
        
        //caso base
        if(numero == 0){
            return 0; 
        }else{
            return sumarDigitos(numero/10) + numero % 10;
        }
        
    }
    
    public static int potencia(int x, int n){
        if( n == 0){
            return 1;
        }else{
            return;
        }
        
        
        
    }
    
    public static String invertirCadena(String cadena){
   
    }
    
    
    
    
    public static void main(String[]args){
        int numero = 345;
        int potencia = potencia(1,3);
        int resultado = sumarDigitos(numero);
        System.out.println("la suma del número es: "+ resultado);
        System.out.println("la potencia del número es : "+ potencia);
    }
    
}

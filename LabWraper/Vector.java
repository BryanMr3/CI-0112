//crea posible la clase random
import java.util.Random;
public class Vector
{
    //declarar atributo
    private int[] vector;

    //Constructor que recibirá un array de enteros
    public Vector(int[]vector){
        this.vector = vector;
    }

    //setter para modificar el array
    public void setVector(int[] vector){
        this.vector = vector;
    }

    //imprimir los valores dentro del vector
    public void impValores(){
        for(int i = 0; i < vector.length; i++){
            System.out.print(vector[i] + " "); //imprime el valor dentro del indice
        }
        System.out.print("\n");//salto de línea
    }

    //cambiar los valores que existen en el vector creado en main
    public void cambiarValores(){
        //crea un objeto tipo Random
        Random randomGen = new Random();

        //generar un nuevo número y almacenarlo en cada posicion del array(cada iteracion)
        for(int i = 0; i < vector.length; i++){
            int nuevoNum = randomGen.nextInt(6);
            vector[i] = nuevoNum;
        }

    }

    //metodo para ordenar valores(Ordenamiento seleccion)
    public void ordenarNum(){

        for(int i = 0; i < vector.length; i++){
            int posicionMenor = i;
            int valorMenor = vector[i];

            for (int j = i + 1; j < vector.length; j++){

                if(valorMenor > vector[j]){ 

                    posicionMenor = j;
                    valorMenor = vector[j];//donde está y el valor
                }

                int aux = vector[i];  
                vector[i] = vector[posicionMenor];
                vector[posicionMenor] = aux;                
            }

        }
    }

    public int busquedaSecuencial(int numeroEncontrar){
        int indice = 0;

        for(int i=0; i < vector.length; i++){
            if(vector[i]== numeroEncontrar){
                indice = i; 
                System.out.println("El número está en el índice: " + indice);
            }else{
                System.out.println("El número no se encuentra en el índice: " + i);
            }

        }

        return indice;
    }

    public void paresImpares(){
        int impares = 0;
        int pares = 0;

        for(int i = 0; i < vector.length; i ++){
            if(vector[i] % 2 == 0){
                pares += 1;
            }else{
                impares += 1; 
            }
        }

        System.out.println("La cantidad de números pares es: " + pares);
        System.out.println("La cantidad de números impares es: " + impares);

    }

    public void restaMayorMenor(){
        int numMayor = vector[0];
        int numMenor = vector[0];
        
        for(int i=0; i < vector.length; i++){

            if(vector[i] > numMayor){
                numMayor = vector[i];
            }
            
            if(vector[i] < numMenor){
                numMenor = vector[i]; 
            }
        
        }

        int resta = numMayor - numMenor;
        System.out.println("La resta entre el número mayor: "+ numMayor + " y el número menor: " +
            numMenor + " es: " + resta);

    }
}
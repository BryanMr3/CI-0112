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
            int nuevoNum = randomGen.nextInt(101);
            vector[i] = nuevoNum;
        }

    }

    //metodo para ordenar valores(Ordenamiento seleccion)
    public void ordenarNum(){

        for(int i = 0; i < vector.length; i++){
            int posicionMenor = i;
            int valorMenor = this.vector[i];

            for (int j = i +1; i < vector.length; j++){
                if(valorMenor < vector[j]){ 
                    valorMenor = this.vector[j];
                    posicionMenor = j; //donde está y el valor
                }
                int aux = valorMenor;// modificar el menor en posicion i que verifica
                
            }

                        
        }
    }
}    
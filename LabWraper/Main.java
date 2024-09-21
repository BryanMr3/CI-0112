

public class Main
{
    public static void main(String args[]) {
        //declarar un array con valores
        int[] vectorNativo = {2,3,5,2};
        
        //Se crea el objeto que recibe el vector declarado
        Vector vectorObj = new Vector(vectorNativo);
        
        //llamar al metodo para imprimir los valores del vector creado
        vectorObj.impValores();
        vectorObj.cambiarValores();
        vectorObj.impValores();//este imprime los nuevos valores del array 
        vectorObj.ordenarNum();
        vectorObj.impValores();
    }

    
    
}

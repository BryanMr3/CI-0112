import java.util.Scanner;
class MainTree{

    public static void main (String [] args){

        Tree binaTree = new Tree();

        Scanner AS = new Scanner(System.in);
        System.out.print("Introduzca el elemento que quiere agregar al árbol: ");
        int element1 = AS.nextInt();
        System.out.println();

       binaTree.insertar(element1);
       System.out.println();

       System.out.print("Introduzca el elemento que quiere buscar en el árbol: ");
       int element2 = AS.nextInt();
       System.out.println();

       binaTree.buscarRecursivo(element2);
       System.out.println();

       System.out.print("Introduzca el elemento que quiere buscar en el árbol: ");
       int element3 = AS.nextInt();
       System.out.println();

       binaTree.Eliminar(element3);
       System.out.println();

    }
}

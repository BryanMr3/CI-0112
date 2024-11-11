/**
 * Clase con autoreferencia a objetos de tipo int de esta misma clase
 * Esta clase permite representar un nodo y enlaces a otros nodos en la estructura de cola doble
 */

public class Node{
    private int data; //valor que contiene el nodo
    private Node after;//referencia al siguiente nodo 
    private Node before; //referencia al nodo previo

    /**
     * Método constructor, con un solo párametro.
     * Recibe como párametro un valor de tipo entero que se almacena en el nodo
     */

    public Node(int data){
        this.data = data; //Almacena el valor del párametro "data" 
        this.before = null;
        this.after = null;
    }

    //Setters, para modificar valores de los nodos.
    public void setData(int data){
        this.data = data;
    }

    public void setAfter(Node after ){
        this.after = after;
    }
    
    public void setBefore(Node before){
        this.before = before;
    }

    //Getters, para obtener valores de los nodos.
    public int getData(){
        return data;
    }

    public Node getAfter(){
        return after;
    }

    public Node getBefore(){
        return before;
    }
}
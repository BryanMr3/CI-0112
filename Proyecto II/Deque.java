import java.util.Scanner;

/** 
 * Esta clase contiene métodos y la estructura a implementar para la cola doble
 * Contiene los metodos de encolar, desencolar por ambos extremos según el funcionamiento de la cola doble.
 * 
 */
public class Deque{

    private Node first; //referencia al primer elemento de la cola
    private Node last; //referencia al último elemento de la cola
    private int large;
    
    //Metodo constructor
    public Deque(){
        this.first = null;
        this.last = null;
        this.large = 0;
    }

    //setters
    public void setFirst(Node first){
        this.first = first;
    }
    
    public void setLast(Node last){
        this.last = last;
    }

    //getters
    public Node getFirst(){
        return first;
    }

    public Node getLast(){
        return last;
    }

    /**
     * Método booleano que verifica si la cola está vacía.
     * Condicional if que verifica si la cola está vacía al frente y final.
     * Retorna verdadero si la cola está vacía. 
     * Retorna falso si la cola no está vacía.
     */
    public boolean isEmpty(){
        if(this.first == null && this.last == null){
        return true; //Cola vacia
        }
        return false; //Cola no vacía
    }

    /**
     * Metodo sin retorno, con parametro entero relacionado al valor contenido en cada nodo
     */
    public void pushFront(int data){
        Node node1 = new Node(data);//crea un nodo
        /**
         * Condicional if, verifica si la cola está vacía.
         * Si está vacía, el node1 será el primer nodo de la cola
         * Si ya hay un nodo, entonces crea uno nuevo y actualiza posiciones
         */
        if(isEmpty()){
            this.first = node1; //es primer elemento de la cola
            this.last = node1; //es último elemento de la cola
            node1.setBefore(null); //no hay nodo anterior a este
            node1.setAfter(null); //no hay nodo previo a este
        }else{
            Node node2 = new Node(data); 
            node2.setBefore(null); //no hay un nodo previo al nuevo nodo
            node2.setAfter(node1); //se enlaza los nodos, el nodo posterior del nuevo, es el nodo que ya existía.
            node1.setBefore(node2); //actualiza el nodo previo del nodo antiguo, lo enlaza con el nuevo nodo
            this.first = node2; //actualiza el nuevo primer nodo de la cola 
        }
    }

    public void printDeque(){
        Node currentNode = this.first; //nodo actual es el nodo contenido en atributo first
        
        if (isEmpty()) {
            System.out.println("no hay elementos en la cola");
        }else{
            while (currentNode != null) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getAfter();
                
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque colaDoble = new Deque(); 
        
        while (true) {
            System.out.println("inserte el elemento de la cola");
            int data = scanner.nextInt();
            colaDoble.pushFront(data);
            System.out.println("cola actual:");
            colaDoble.printDeque();
        }
         
    }
    

}
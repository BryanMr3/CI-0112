
/** 
 * Esta clase contiene métodos y la estructura a implementar para la cola doble
 * Contiene los metodos de encolar, desencolar por ambos extremos según el funcionamiento de la cola doble.
 * 
 */
public class Deque{

    private Node first; //referencia al primer elemento de la cola
    private Node last; //referencia al último elemento de la cola
    
    
    //Metodo constructor
    public Deque(){
        this.first = null;
        this.last = null;
        
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
            node1.setAfter(this.first); //enlazar nodo nuevo con nodo viejo por derecha
            this.first.setBefore(node1); //enlazar nodo viejo con nodo nuevo por izquierda  
            this.first = node1;//Asignar el nuevo nodo como primero
            
        }
    }

    /**
     * Método que agrega un nodo al final de la cola, sin retorno y recibe un parametro de tipo entero.
     * 
     */
    public void pushBack(int data){
        Node node1 = new Node(data);

        if(isEmpty()){
            this.first = node1; //es primer elemento de la cola
            this.last = node1; //es último elemento de la cola
            node1.setBefore(null); //no hay nodo anterior a este
            node1.setAfter(null); //no hay nodo previo a este
        }else{
            node1.setBefore(this.last); //enlazar nodo nuevo con nodo viejo por izquierda 
            this.last.setAfter(node1); //enlazar nodo viejo con nodo nuevo por derecha
            this.last = node1;//Asignar el nuevo nodo como primero
        }
    }

    public void popFront(){
        if (!isEmpty()) {
           if (this.first==this.last) {
                this.first = null;
                this.last = null;
            }else{
                Node currentFirst = this.first;
                currentFirst = currentFirst.getAfter();
                currentFirst.setBefore(null);
                this.first = currentFirst;
            } 
        }       
        
    }

    public void popBack(){
        if (!isEmpty()) {
            if (this.first == this.last ) {
                this.first = null;
                this.last = null;
            }else{
                Node currentLast = this.last;
                currentLast = currentLast.getBefore();
                currentLast.setAfter(null);
                this.last = currentLast;
            }
        }

    }
        
     /*Método para buscar elementos en el Queue*/

    public boolean searchDuque(int value){
        
        Node search1 = this.first;

        while (search1 != null) {

            if (search1.getData() == value) {
                return true;
            }

            search1 = search1.getAfter();
        }

        return false;
    }

    /**
     * Método para imprimir la cola actual.
     */
    public String printDeque(){
        Node currentNode = this.first; //nodo actual es el nodo contenido en atributo first
        StringBuilder sb = new StringBuilder(); //construir una cadena
        /**
         *Verifica si la cola está vacía, muestra que no hay elementos en la cola si está vacia
         *Si no, imprime los nodos actuales, asi como actualizar el nodo anterior que estén enlazados
         */
        if (isEmpty()) {
            sb.append("La cola está vacía");
        }else{
            //Mientras haya un nodo con valor diferente de nulo se ejecuta el bucle
            while (currentNode != null) {
                sb.append(currentNode.getData());//imprimir nodo actual
               
                if(currentNode.getAfter() != null){
                    sb.append(" <-> "); //enlace visual entre nodos, no aparece en enlace null
                }

                currentNode = currentNode.getAfter();//actualizar a nodo siguiente
            }
        }
        return sb.toString();
    }
}


/** 
 * Esta clase contiene métodos y la estructura a implementar para la cola doble
 * Contiene los metodos de encolar, desencolar por ambos extremos según el funcionamiento de la cola doble.
 * Contiene los métodos de búsqueda, imprimir cola.
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
            this.first = node1; // es primer elemento de la cola
            this.last = node1; // es último elemento de la cola
            node1.setBefore(null); // no hay nodo anterior a este
            node1.setAfter(null); // no hay nodo previo a este
        }else{ 
            node1.setAfter(this.first); // enlazar nodo nuevo con nodo viejo por derecha
            this.first.setBefore(node1); // enlazar nodo viejo con nodo nuevo por izquierda  
            this.first = node1;// Asignar el nuevo nodo como primero
            
        }
    }

    /**
     * Método que agrega un nodo al final de la cola, sin retorno y recibe un parametro de tipo entero.
     * Contiene un condicional if, que agrega elementos al frente de la cola, según haya o no nodos antes
     */
    public void pushBack(int data){
        Node node1 = new Node(data);

        if(isEmpty()){
            this.first = node1; // es primer elemento de la cola
            this.last = node1; // es último elemento de la cola
            node1.setBefore(null); // no hay nodo anterior a este
            node1.setAfter(null); // no hay nodo previo a este
        }else{
            node1.setBefore(this.last); // enlazar nodo nuevo con nodo viejo por izquierda 
            this.last.setAfter(node1); // enlazar nodo viejo con nodo nuevo por derecha
            this.last = node1;// Asignar el nuevo nodo como primero
        }
    }

    public void popFront(){
        if (!isEmpty()) {
           if (this.first==this.last) { //verifica si solo hay un único número
                this.first = null; //Primer nodo eliminado
                this.last = null; //Segundo nodo eliminado(es el mismo nodo)
            }else{
                Node currentFirst = this.first; //Guarda el nodo actual de la cola(no el valor, la referencia)
                currentFirst = currentFirst.getAfter(); //Cambia al nodo siguiente como nodo actual
                currentFirst.setBefore(null); //Elimina el enlace con el nodo actual anterior 
                this.first = currentFirst; //El nodo que era el siguiente, ahora es el actual primero(elimina el actual anterior)
            } 
        }       
        
    }

    /**
     * Método sin retorno. Este método desencola por detrás al último nodo que se encuentre en la cola.
     * Condicional mayor, permite que el condicional anidado se ejecute al no estar vacía la cola.
     * Condicional if anidado, pregunta si solo hay un elemento en la cola, los enlaces last y first cambian a nulos para desencolar.
     * Si hay más de un elemento, entonces encuentra al último de la cola, para cambiar de último nodo actual y lo enlaza con null
     * Establece al nuevo último nodo, eliminando el antiguo último nodo
     */
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
        
    /**
     * Método para buscar elementos en el Queue
     * Recibe por parametro un entero, que es el valor a buscar
     * Retorna true, si el nodo se ecneutra en la cola.
     * Retorna false, si el nodo no se encuentra en la cola.
     */

    public boolean searchDeque(int value){
        Node search = this.first;

        /** 
         * Bucle while, mientras exista un nodo en la cola, recorre cada nodo de la cola desde el primer nodo hasta el últim y pregunta si el valor contenido en search es igual al que se recibe por parametro,
         * se ejecuta hasta llegar al final de la cola, al menos que lo encuentre antes. 
         * Retorna true si el número está en la cola
         * Retorna false si no se encuentr el valor en la cola
         */
        while (search != null) {
            if (search.getData() == value) { 
                return true; // El número e
            }
            search = search.getAfter(); // Pasa al siguiente nodo(referencia)
        }
        return false;
    }

    /**
     * Método para imprimir la cola actual, retorna una cad
     */
    public String printDeque(){
        Node currentNode = this.first; // nodo actual es el nodo contenido en atributo first
        StringBuilder sb = new StringBuilder(); // construir una cadena
        
        while (currentNode != null) {
            sb.append(currentNode.getData());// imprimir nodo actual
               
            if(currentNode.getAfter() != null){
                sb.append("  <->  "); // enlace visual entre nodos, no aparece en enlace null    
            }   
            currentNode = currentNode.getAfter();// actualizar a nodo siguiente
            }
        return sb.toString(); //Retorna la cadena de la cola
    }

}

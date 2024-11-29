
public class Tree {
    NodeTree root;

    public Tree(){
        root = null;
    }

    public boolean insertar(int elemt){ 

        root = insertarRecursivo(root, elemt);
        return true; 
    }

    public NodeTree insertarRecursivo(NodeTree n,int value){

        
        if(n == null){
            System.out.println("¡El elemento " + value + " fue insertado!");
            return new NodeTree(value);
        }

        if(value == n.getKey()){
            System.out.println("¡El elemento " + value + " ya existe en el árbol!");
            return n;
        }

        if(value < n.getKey()){
            n.setRight(insertarRecursivo(n.getRight(), value));
            System.out.println("¡El elemento " + value + " se ha insertado exitosamente!");
        }

        if(value > n.getKey()){
            n.setLeft(insertarRecursivo(n.getLeft(), value));
            System.out.println("¡El elemento " + value + " se ha insertado exitosamente!");
        }

        return n;
    }

    public NodeTree encontrar (NodeTree n, int value){ 

        if(n == null){
            System.out.println("¡El elemento " + value + " no existe en el árbol!");
            return new NodeTree(value);
        }else{

            if(value < n.getKey()){
                n.setRight(encontrar(n.getRight(), value));
            }else{
                if(value > n.getKey()){
                    n.setLeft(encontrar(n.getLeft(), value));
                }
            }

        }

        if(value == n.getKey()){
            System.out.println("¡El elemento " + value + " si existe en el árbol!");
            return n;
        }

        return n;
   }

   public boolean buscarRecursivo(int value){

    root = encontrar(root, value);
    return true;
}

public boolean Eliminar(int elemt){ 

    root = eliminarRecursivo(root, elemt);
    return true; 
}

public NodeTree eliminarRecursivo(NodeTree n,int value){

    
    if(n == null){
        System.out.println("¡El elemento " + value + " no existe en el árbol!");
        return new NodeTree(value);
    }

    if(value == n.getKey()){
        System.out.println("¡El elemento " + value + " fue eliminado del árbol!");
        return n;
    }

    if(value < n.getKey()){
        n.setRight(eliminarRecursivo(null, value));
    }

    if(value > n.getKey()){
        n.setLeft(eliminarRecursivo(null, value));
    }

    return n;
}
}

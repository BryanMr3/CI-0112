public class NodeTree{

    public Node rigth;
    public Node left;
    public int key;

    public void Node(int key){

        this.rigth = null;
        this.left = null;
        this.key = key;
    }

    //Métodos setter//

    public void setRigth(int data){

        this.right = data;
    }

    public void setLeft(int data){
        this.left = data;
    }

    public void setKey(int data){
        this.key = data;
    }

    //Métodos getters//

    public Node getRigth(){
        return rigth;
    }

    public Node getLeft(){
        return left;
    }

    public int getKey(){
        return key;
    }
}
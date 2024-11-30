public class NodeTree {

    public NodeTree right;
    public NodeTree left;
    public int key;

    // Constructor
    public NodeTree(int key){
        this.right = null;
        this.left = null;
        this.key = key;
    }

    // Setters//
    public void setRight(NodeTree node){
        this.right = node;
    }

    public void setLeft(NodeTree node){
        this.left = node;
    }

    public void setKey(int key){
        this.key = key;
    }

    //Getters//
    public NodeTree getRight(){
        return right;
    }

    public NodeTree getLeft(){
        return left;
    }

    public int getKey(){
        return key;
    }
}

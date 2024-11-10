private static class Node{
    int value;
    Node before;
    Node after;

    Node(int value) {
        this.value = value;
        this.after = null;
        this.before = null;
    }
}
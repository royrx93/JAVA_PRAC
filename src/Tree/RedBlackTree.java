package Tree;

public class RedBlackTree {
    private final int RED = 0;
    private final int BLACK =1;

    private class Node{
        private int key;
        private int color;
        private Node left = null;
        private Node right = null;
        private Node parent =null;

        public Node(int key){
            this.key = key;
        }
    }

    private Node root;

    public RedBlackTree(){
        this.root =null;
    }

    public void insert(int key){

    }
}

package Tree;

/**
 * AVL Tree: self balance binary search tree
 *           where the difference between heights of left and right subtrees
 *           cannot be more than one for all nodes
 *
 * Left Rotation
 * Right Rotation
 *      T1, T2 and T3 are subtrees of the tree
 *      rooted with y (on the left side) or x (on
 *      the right side)
 *      y                               x
 *     / \     Right Rotation          /  \
 *    x   T3   - - - - - - - >        T1   y
 *   / \       < - - - - - - -            / \
 *  T1  T2     Left Rotation            T2  T3
 *      Keys in both of the above trees follow the following order
 *      keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
 *      So BST property is not violated anywhere.
 *
 * Insertion:
 *      1. Standard BST insertion: insert new node w
 *      2. Start form w, travel up and find the first unbalanced node.
 *      3. Re-balance the tree by performing appropriate rotations on the subtree rooted with z.
 *      There can be 4 possible cases that needs to be handled
 *      as x, y and z can be arranged in 4 ways. Following are the possible 4 arrangements:
 *          a) y is left child of z and x is left child of y (Left Left Case)
 *              T1, T2, T3 and T4 are subtrees.
 *          z                                      y
 *         / \                                   /   \
 *        y   T4      Right Rotate (z)          x      z
 *       / \          - - - - - - - - ->      /  \    /  \
 *      x   T3                               T1  T2  T3  T4
 *     / \
 *   T1   T2
 *
 *          b) y is left child of z and x is right child of y (Left Right Case)
 *            z                               z                           x
 *           / \                            /   \                        /  \
 *          y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
 *        / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
 *      T1   x                          y    T3                    T1  T2 T3  T4
 *          / \                        / \
 *        T2   T3                    T1   T2
 *
 *          c) y is right child of z and x is right child of y (Right Right Case)
 *           z                                y
 *          /  \                            /   \
 *         T1   y     Left Rotate(z)       z      x
 *            /  \   - - - - - - - ->    / \    / \
 *          T2   x                     T1  T2 T3  T4
 *             / \
 *            T3  T4
 *
 *          d) y is right child of z and x is left child of y (Right Left Case)
 *          z                            z                            x
 *         / \                          / \                          /  \
 *       T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
 *           / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
 *          x   T4                      T2   y                  T1  T2  T3  T4
 *         / \                              /  \
 *       T2   T3                           T3   T4
 *
 *  Reference: https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class AVLTree {
    private class Node{
        private int key;
        private int height;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key, Node left, Node right, Node parent){
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.height = 0;
        }
    }

    public Node root;

    public AVLTree(){
        root = null;
    }

    /**
     *  add key to avl tree
     * @param key
     */
    public void insert(int key){
        if(root == null){
            root = new Node(key, null ,null,null);
        }
        else{
            root = insert(root, key);
            root.parent = null;
        }
    }

    /**
     * add key to avl tree and return balanced root
     * @param root
     * @param key
     * @return
     */
    private Node insert(Node root, int key){


        return root;
    }

    /**
     * LL rotation
     * @param root  unbalanced root
     * @return      balanced root
     */
    private Node LLRotation(Node root){

        return root;
    }

    private Node LRRotation(Node root){

        return root;
    }

    private Node RLRotation(Node root){

        return root;
    }

    private Node RRRotation(Node root){

        return root;
    }

    private int max(int a, int b){
        return a > b ? a:b;
    }

    private int height(Node node){
        return (node != null) ? node.height:0;
    }

    /**
     * traversal nodes
     */
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node root){

    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root){

    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root){

    }

    /**
     * search key
     * @param key
     * @return
     */
    public int search(int key){

        return -1;
    }

    private Node search(Node root, int key){

        return  root;
    }

    /**
     * remove the element from the avl tree
     * @param value
     * @return
     */
    public boolean remove(int value){

        return false;
    }

    private Node remove(Node root, int value){

        return root;
    }

    /**
     * find the smallest(leftest) node
     * @param node
     * @return
     */
    private Node findMin(Node node){
        if(node == null){
            return null;
        }
        while( node.left !=null ){
            node = node.left;
        }
        return node;
    }

    /**
     * find the largest(rightest) node
     * @param node
     * @return
     */
    private Node findMax(Node node){
        if(node == null){
            return null;
        }
        while( node.right !=null ){
            node = node.right;
        }
        return node;
    }




}

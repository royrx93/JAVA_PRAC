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
 *        y                               x
 *       / \     Right Rotation          /  \
 *      x   T3   - - - - - - - >        T1   y
 *     / \       < - - - - - - -            / \
 *    T1  T2     Left Rotation            T2  T3
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
    private final int NOT_EXIST = -31415926;
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
            this.height = 1;
        }
    }

    public Node root;

    public AVLTree(){
        root = null;
    }

    private int max(int a, int b){
        return (a > b) ? a:b;
    }

    private int height(Node node){
        return (node != null) ? node.height:0;
    }

    /**
     * get the balance factor
     * factor range f:
     *      -1<= f <= 1 : balance
     *      f < -1: right-skewed, right node needed rotation
     *      f > 1: left-skewed, left node needed rotation
     *
     * @param node
     * @return
     */
    private int getBalance(Node node){
        return (node == null)? 0: (height(node.left) - height(node.right));
        /**
         * if(node == null){
         *      return 0;
         * }
         * return height(node.left) - height(node.right);
         */
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

    /**
     *  add key to avl tree
     * @param key
     */
    public void insert(int key){
        root = insert(root, key);
        root.parent = null;
    }

    /**
     * left rotation
     * @param x
     * @return
     */
    private Node leftRotation(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        y.parent = x.parent;
        x.parent = y;

        x.height = 1 + max(height(x.left),height(x.right));
        y.height = 1 + max(height(y.left),height(y.right));

        return y;
    }

    /**
     * right rotation
     * @param y
     * @return
     */
    private Node rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        x.parent = y.parent;
        y.parent = x;

        y.height = 1 + max(height(y.left),height(y.right));
        x.height = 1 + max(height(x.left),height(x.right));

        return x;
    }

    /**
     * add key to avl tree and return balanced root
     * @param root
     * @param key
     * @return
     */
    private Node insert(Node root, int key){
        /** standard BST insertion*/
        if( root == null){
            root = new Node(key, null ,null,null);
        }

        if( root.key < key){
            // right node
            root.right = insert(root.right,key);
        }
        else if(root.key > key){
            //left node
            root.left = insert(root.left, key);
        }
        else{
            //root.height = 1 + max(height(root.right), height(root.left));
            return root;
        }

        root.height = 1 + max(height(root.right), height(root.left));

        //balance
        int balance = getBalance(root);
        System.out.println("balance factor: "+ balance);
        if( balance < -1 || balance > 1){
            System.out.println("un-balanced");
        }

        System.out.println(root.key);

        /**
         * from GfGs, good
         // Left Left Case
        if(balance >1 && key < root.left.key){
            return rightRotation(root);
        }
         // Right Right Case
        if(balance <-1 && key > root.right.key){
            return leftRotation(root);
        }
         // Left Right Case
        if(balance >1 && key > root.left.key){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
         // Right Left Case
        if(balance < -1 && key < root.right.key){
            root.right = rightRotation(root.right);
            return  leftRotation(root);
        }
        */

        /**
         * combine GfGs' if statement NOT GOOD
         *  in this combination, if the execute statement did not return,
         *      the other if statement may be executed in the same time as root be rotated twice
         */

        /**
        if(balance >1 && key < root.left.key){
            System.out.println("LL"+root.key);
            root= rightRotation(root);
        }

        if(balance <-1 && key > root.right.key){

            return leftRotation(root);
            //System.out.println("RR"+ root.key);
            //root = leftRotation(root);
        }

        if(balance >1 && key > root.left.key){
            System.out.println("LR"+root.key);
            root.left = leftRotation(root.left);
            root = rightRotation(root);
        }

        if(balance < -1 && key < root.right.key){
            System.out.println("RL"+root.key);
            root.right = rightRotation(root.right);
            root = leftRotation(root);
        }
        */

        /**
         * balance decides which side of the ancestor node was skewed.
         *  comparing the key with the corresponding side's key can tell us which case this skew is.
         */

        //own version; good
        //right-skewed
        if(balance < -1){
            //RR
            if(root.right != null && key > root.right.key){
                System.out.println("RR"+ root.key);
                root = leftRotation(root);

            }
            //RL
            else if( root.right != null && key < root.right.key){
                System.out.println("RL"+root.key);
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }

        }
        //left-skewed
        else if( balance > 1){
            //LL
            if(root.left != null && key < root.left.key){
                System.out.println("LL"+root.key);
                root= rightRotation(root);
            }
            //LR
            else if(root.left != null && key > root.left.key){
                System.out.println("LR"+root.key);
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        }

        /**
        //From java interview guideline
        if(root == null){
            root = new Node(key,null,null,null);
        }else if(key < root.key) {
            //go left
            root.left = insert(root.left, key);
            root.left.parent = root;

            //balance
            if (height(root.left) - height(root.right) == 2) {
                if (key < root.left.key) {
                    root = LLRotation(root);
                } else {
                    root = LRRotation(root);
                }
            }

        }else if(key> root.key){
            //go right
            root.right = insert(root.right, key);
            root.right.parent = root;
            if(height(root.right) - height(root.left) == 2){
                if(key < root.right.key){
                    root = RLRotation(root);
                }else{
                    root = RRRotation(root);
                }
            }
        }
        root.height = 1 + max(height(root.left), height(root.right));
        */

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

    /**
     * traversal nodes
     */
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node node){
        if(node !=null){
            System.out.print( node.key+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print( node.key+" ");
            inOrder((node.right));
        }
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print( node.key+" ");
        }
    }
    public void travelUp(){
        travelUp(root);
    }

    private void travelUp(Node root){
        if(root != null){
            System.out.print("[ "+root.key+" ,height: "+ height(root)+" to: ");
            if(root.left !=null){
                System.out.print("（left: "+root.left.key+")");
            }
            if(root.right!=null){
                System.out.print(" (right: "+root.right.key +")");
            }
            System.out.print("]");

            if(root.left!=null){
                travelUp(root.left);
            }
            if(root.right!=null){
                travelUp(root.right);
            }

        }
    }

    /**
     * search key
     * @param key
     * @return
     */
    public int search(int key){
        Node searched = search(root, key);
        return (searched == null)? NOT_EXIST : searched.key;
    }

    private Node search(Node root, int key){
        Node curr = root;
        while(curr != null){
            if( key > curr.key){
                curr = curr.right;
            }else if(key < curr.key){
                curr = curr.left;
            }else{
                return curr;
            }
        }
        return null;
    }

    /**
     * remove the element from the avl tree
     * @param value
     * @return
     */
    public boolean remove(int value){
        Node removed = search(root, value);
        if(removed == null){
            System.out.println("did not find the node");
            return false;
        }
        remove(root,removed);
        return true;
    }

    private Node remove(Node root, Node removed){
        if(root == null || removed == null){
            System.out.println("empty root");
            //throw new RuntimeException("empty tree");
            return root;
        }

        // standard bst remove
        if(removed.key < root.key){
            //left sub tree
            root.left = remove(root.left, removed);
        }
        else if(removed.key > root.key){
            //right sub tree
            root.right = remove(root.right, removed);
        }else{
            //this node is the node need removed.
            // two child
            if( root.left != null && root.right != null){
                if(height(root.left) > height(root.right)){
                    Node temp = findMax(root.left);
                    root.key = temp.key;
                    root.left = remove(root.left, temp);
                    root.left.parent =root;
                }else{
                    Node temp = findMin(root.right);
                    root.key = temp.key;
                    root.right = remove(root.right, temp);
                    root.right.parent = root;
                }

            }else{
                // one child or none child
                Node temp = root;
                root = (root.left == null)? root.right : root.left;
                if(root !=null){
                    root.parent = temp.parent;
                }
                temp = null;
            }
        }

        if(root == null){
            return root;
        }
        root.height = max(height(root.left), height(root.right)) + 1;

        //balance
        int balance = getBalance(root);
        //RR
        if(balance < -1 && removed.key > root.right.key){
            return leftRotation(root);
        }
        //RL
        if(balance < -1 && removed.key < root.right.key ){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        //LL
        if(balance > 1 && removed.key < root.left.key){
            return rightRotation(root);
        }
        //LR
        if(balance > 1 && removed.key > root.left.key){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }





        return root;
    }

}

package Tree;

public class AVLTreeTest {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        int[] array = {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        for(int i=0; i<array.length; i++){
            System.out.println("insert: "+ array[i]);
            tree.insert(array[i]);
            print1(tree);
            System.out.println(" ");
        }
        print(tree);
        System.out.println("find element 12 in AVL tree: "+ tree.search(12));
        System.out.println("find element 20 in AVL tree: "+ tree.search(20));

    }
    public static void print1(AVLTree tree){
        System.out.println("traversal: ");
        tree.travelUp();
    }
    public static void print(AVLTree tree){
        System.out.println("--------");
        System.out.println("inOrder: ");
        tree.inOrder();
        System.out.println("preOrder: ");
        tree.preOrder();
        System.out.println("postOrder: ");
        tree.postOrder();
        System.out.println("---------");
        tree.travelUp();

    }
}

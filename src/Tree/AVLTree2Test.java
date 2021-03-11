package Tree;

//FROM https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
public class AVLTree2Test {
    public static void main(String[] args) {
      AVLTree2 tree = new AVLTree2();

        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);

      int[] array = {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
      for(int i=0; i<array.length; i++){
        System.out.println("insert: "+ array[i]);
        tree.root = tree.insert(tree.root,array[i]);
        //print1(tree);
        System.out.println(" ");
      }

      print(tree);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
//        System.out.println("Preorder traversal" +
//                " of constructed tree is : ");
//        tree.preOrder(tree.root);
    }
  public static void print(AVLTree2 tree){
    System.out.println("--------");
    System.out.println("inOrder: ");
    tree.inOrder();
    System.out.println("preOrder: ");
    tree.preOrder();
    System.out.println("postOrder: ");
    tree.postOrder();
    System.out.println("---------");
    //tree.travelUp();

  }
}

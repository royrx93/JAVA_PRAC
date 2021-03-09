package Tree;

public class BinarySearchTreeTest {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);
        bst.insert(10);
        bst.insert(2);
        bst.insert(9);
        bst.insert(5);
        bst.insert(1);
        bst.insert(4);
        bst.insert(7);

        System.out.println("------- inorder traversal all the elements in the bst----");
        bst.inOrder(bst.getRoot());

        System.out.println("------- preorder traversal all the elements in the bst----");
        bst.preOrder(bst.getRoot());

        System.out.println("------- postorder traversal all the elements in the bst----");
        bst.postOrder(bst.getRoot());

        bst.delete(8);
        System.out.println("after deleting 8: ");
        bst.inOrder(bst.getRoot());

    }

}

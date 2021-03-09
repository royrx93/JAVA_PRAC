package Tree;

import org.w3c.dom.CDATASection;

import java.util.PrimitiveIterator;

/**
 * Degree: number of child nodes of each node.
 *
 * COMPLETE BINARY TREE
 * leaf Node can only be on the last or the second last level.
 * The leaf Nodes on the last level are all on the left side of the tree.
 * The leaf node on the second last level are all on the right side of the tree.
 * If the degree of the node is 1, it only has a left node.
 * The complete binary tree has the MINIMUM HEIGHT in the binary trees with the same number of nodes
 * The full tree must be a complete tree, but complete may not be a full tree
 *
 * The SEQUENCE STRUCTURE is only suitable for complete tree,
 * as in other binary tree there will be many spaces wasted.
 *
 * Tree:
 *                              A
 *                           /    \
 *                          B      C
 *                        /  |    |  \
 *                      D   E     F   G
 *                  /  |   | \
 *                 H   I   J
 * Traversal:
 *      PreOrder:    Root-> Left -> Right
 *               A-> B-> D-> H-> I-> E-> J-> C-> F-> G
 *      InOrder:    Left -> Root -> Right
 *               H-> D-> I-> B-> J-> E-> A-> F-> C-> G
 *      PostOrder   Left -> Right -> Root
 *               H-> I-> D-> J-> E-> B-> F-> G-> C-> A
 *      LevelOrder:     go through each level from top to bottom
 *               A-> B-> C-> D-> E-> F-> G-> H-> I-> J
 *
 *  Binary Search Tree:
 *      1. If left node is not empty,
 *          then the value on the LEFT node must be SMALLER than the root node.
 *      2. If right node is not empty,
 *          then the value on the RIGHT node must be LARGER than the root node.
 *      3. ALl the subtree of each node must be a BST.
 *      4. THere are no nodes with same value.
 *      LEFT < ROOT < RIGHT
 *
 *  BST searching:
 *      1. If root value is equal to the searching element,
 *          then return the root node, else->2 or 3.
 *      2. If root value is smaller than the searching element, go to right node.
 *      3. If root value is larger than the searching element, to to left node.
 *      4. There is no node with the equal value.
 *
 *      Time Complexity: O(log2(n))
 *
 * BST Adding:
 *      Need to searching for the suitable space first.
 *
 * DST Deleting：
 *      Leaf Node:
 *          Deleting do not affect the structure of the BST.
 *
 *      Deleted Node has a left or right sub-tree:
 *          Move the left or right sub-tree's root node to replace the deleted node.
 *
 *      Deleted node has a left subtree and a right subtree:
 *          1. Find the largest node in the left subtree(the rightest node in the left subtree)
 *          OR
 *          2. Find the smallest node in the right subtree(the leftest node in the right subtree)
 *          TO replace the deleted node
 *
 */
public class BinarySearchTree {

    private class Node{
        // public element?
        public int data; // Object?
        public Node left;
        public Node parent;
        public Node right;

        public Node(int value){
            this.data = value;
            left = null;
            right = null;
            parent = null;
        }

        public Node(int value, Node root){
            data = value;
            parent = root;
            left = null;
            right = null;
        }





    }



}

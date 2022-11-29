package binarytrees;

/**
 * Write a function that takes in a Binary Tree and inverts it. In Other words,
 * the function should swap every left node in the tree for its corresponding right node
 */

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null || (tree.left == null && tree.right == null)) {
            return;
        }

        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

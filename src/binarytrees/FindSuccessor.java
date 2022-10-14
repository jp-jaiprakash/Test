package binarytrees;

public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if(node.right != null)
            return findTheFarthest(node.right);

        return findTheParent(node);

    }

    private BinaryTree findTheParent(BinaryTree node) {
        BinaryTree currentNode = node.parent;

        while (currentNode.parent != null && currentNode.right == node){
                currentNode = currentNode.parent;
        }

        return currentNode.parent;
    }

    private BinaryTree findTheFarthest(BinaryTree tree) {
        if (tree.left == null)
            return tree;

        return findTheFarthest(tree.left);
    }
}
